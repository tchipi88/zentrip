package com.ganeo.appli.zentrip.viewmodel;

import com.ganeo.appli.zentrip.model.Booking;
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


    private MutableLiveData<Booking> bookingMutableLiveData = new MutableLiveData<>();
    private MutableLiveData<Car> carMutableLiveData = new MutableLiveData<>();
    private MutableLiveData<Driver> driverMutableLiveData = new MutableLiveData<>();


    private MutableLiveData<Boolean> loading = new MutableLiveData<>();
    private MutableLiveData<Boolean> error = new MutableLiveData<>();
    private MutableLiveData<Boolean> removeFooter = new MutableLiveData<>();
    private MutableLiveData<Boolean> updateFooter = new MutableLiveData<>();


    @Inject
    public BookingViewModel(ZentripRepository zentripRepository) {
        this.zentripRepository = zentripRepository;
    }

    public void setBooking(Booking booking) {
        this.bookingMutableLiveData.setValue(booking);
    }

    public MutableLiveData<Booking> getBookingObservable() {
        return bookingMutableLiveData;
    }

    public void setCar(Car booking) {
        this.carMutableLiveData.setValue(booking);
    }

    public MutableLiveData<Car> getCarObservable() {
        return carMutableLiveData;
    }

    public void setDriver(Driver booking) {
        this.driverMutableLiveData.setValue(booking);
    }

    public MutableLiveData<Driver> getDriverObservable() {
        return driverMutableLiveData;
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

    public LiveData<List<Booking>> loadBookings(int currentPage, int pageSize) {
        loading.setValue(Boolean.TRUE);
        return zentripRepository.loadBookings(currentPage, pageSize);
    }


    public void addBooking(Booking booking){
        zentripRepository.addBooking(booking);
    }

}
