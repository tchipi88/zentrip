package com.ganeo.appli.zentrip.di.module;

import android.app.Application;

import com.ganeo.appli.zentrip.dao.AppDatabase;
import com.ganeo.appli.zentrip.dao.ZentripDao;

import javax.inject.Singleton;

import androidx.room.Room;
import dagger.Module;
import dagger.Provides;

import static com.ganeo.appli.zentrip.utils.ZentripConstant.DATABASE_NAME;

@Module
public class DaoModule {

    @Provides
    @Singleton
    public ZentripDao provideDao(Application app) {
        AppDatabase db = Room.databaseBuilder(app,
                AppDatabase.class, DATABASE_NAME).build();
        return db.zentripDao();
    }

}