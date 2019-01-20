package com.ganeo.appli.zentrip.repository;

import com.ganeo.appli.zentrip.dao.ZentripDao;
import com.ganeo.appli.zentrip.model.Car;
import com.ganeo.appli.zentrip.model.Driver;

import java.util.List;
import java.util.concurrent.Executor;

import javax.inject.Inject;

import androidx.lifecycle.LiveData;

public class ZentripRepository {


    final private ZentripDao dao;
    final private Executor executor;

    @Inject
    public ZentripRepository(ZentripDao dao, Executor executor) {
        this.dao = dao;
        this.executor = executor;
    }

    public LiveData<List<Driver>> loadDrivers(int currentPage, int pageSize) {
        return dao.findAllDrivers(currentPage, pageSize);
    }

    public LiveData<List<Car>> loadCars(int currentPage, int pageSize) {
        return dao.findAllCars(currentPage, pageSize);
    }
}
