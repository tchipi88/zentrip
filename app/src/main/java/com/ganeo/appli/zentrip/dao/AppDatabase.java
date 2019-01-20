package com.ganeo.appli.zentrip.dao;

import android.content.Context;

import com.ganeo.appli.zentrip.model.Booking;
import com.ganeo.appli.zentrip.model.Car;
import com.ganeo.appli.zentrip.model.Driver;
import com.ganeo.appli.zentrip.model.Tarif;
import com.ganeo.appli.zentrip.model.Town;
import com.ganeo.appli.zentrip.model.Trip;
import com.ganeo.appli.zentrip.utils.ZentripConstant;

import java.util.concurrent.Executors;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Booking.class, Car.class, Driver.class,
        Tarif.class, Town.class, Trip.class}, version = 1)
@TypeConverters({Converters.class})
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase INSTANCE;
    private static RoomDatabase.Callback dbCallback = new RoomDatabase.Callback() {
        public void onCreate(SupportSQLiteDatabase db) {
            super.onCreate(db);
            Executors.newSingleThreadScheduledExecutor().execute(new Runnable() {
                @Override
                public void run() {
                    INSTANCE.zentripDao().insertAll(Town.populateData());
                    INSTANCE.zentripDao().insertAll(Car.populateData());
                    INSTANCE.zentripDao().insertAll(Driver.populateData());
                }
            });
        }

        public void onOpen(SupportSQLiteDatabase db) {

        }
    };

    public static AppDatabase getAppDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, ZentripConstant.DATABASE_NAME)
                            // allow queries on the main thread.
                            // Don't do this on a real app! See PersistenceBasicSample for an example.
                            .allowMainThreadQueries()
                            .addCallback(dbCallback)
                            .build();
        }
        return INSTANCE;
    }

    public abstract ZentripDao zentripDao();
}