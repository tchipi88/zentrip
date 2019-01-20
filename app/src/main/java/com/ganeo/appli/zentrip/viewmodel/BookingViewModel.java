package com.ganeo.appli.zentrip.viewmodel;

import com.ganeo.appli.zentrip.model.Car;
import com.ganeo.appli.zentrip.model.Driver;
import com.ganeo.appli.zentrip.repository.ZentripRepository;

import java.util.List;

import javax.inject.Inject;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class BookingViewModel extends ViewModel {


    ZentripRepository zentripRepository;

    private MutableLiveData<String> dateDebut = new MutableLiveData<>();
    private MutableLiveData<String> dateFin = new MutableLiveData<>();

    private MutableLiveData<Boolean> loading = new MutableLiveData<>();
    private MutableLiveData<Boolean> error = new MutableLiveData<>();
    private MutableLiveData<Boolean> removeFooter = new MutableLiveData<>();
    private MutableLiveData<Boolean> updateFooter = new MutableLiveData<>();


    @Inject
    public BookingViewModel(ZentripRepository zentripRepository) {
        this.zentripRepository = zentripRepository;
    }


    public MutableLiveData<Boolean> getLoading() {
        return loading;
    }

    public MutableLiveData<Boolean> getError() {
        return error;
    }


    public MutableLiveData<Boolean> getRemoveFooter() {
        return removeFooter;
    }

    public MutableLiveData<Boolean> getUpdateFooter() {
        return updateFooter;
    }


    public LiveData<List<Car>> loadCars(int currentPage, int pageSize) {
        loading.setValue(Boolean.TRUE);
        return zentripRepository.loadCars(currentPage, pageSize);
    }

    public LiveData<List<Driver>> loadDrivers(int currentPage, int pageSize) {
        loading.setValue(Boolean.TRUE);
        return zentripRepository.loadDrivers(currentPage, pageSize);
    }


}
