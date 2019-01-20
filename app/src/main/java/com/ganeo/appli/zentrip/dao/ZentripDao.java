package com.ganeo.appli.zentrip.dao;


import com.ganeo.appli.zentrip.model.Booking;
import com.ganeo.appli.zentrip.model.Car;
import com.ganeo.appli.zentrip.model.Driver;
import com.ganeo.appli.zentrip.model.Tarif;
import com.ganeo.appli.zentrip.model.Town;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface ZentripDao {

    @Insert
    void insertAll(Car... cars);

    @Insert
    void insertAll(Town... towns);

    @Insert
    void insertAll(Tarif... tarifs);

    @Insert
    void insertAll(Driver... drivers);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Booking booking);


    @Query("SELECT * FROM Town WHERE nom like :villeIn ")
    List<Town> getTowns(String villeIn);


    @Query("SELECT * FROM Driver  limit :size  offset :page")
    LiveData<List<Driver>> findAllDrivers(Integer page, Integer size);

    @Query("SELECT * FROM Car  limit :size  offset :page")
    LiveData<List<Car>> findAllCars(Integer page, Integer size);
}
