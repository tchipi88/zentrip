package com.ganeo.appli.zentrip.viewmodel;

import com.ganeo.appli.zentrip.repository.ZentripRepository;

import javax.inject.Inject;

import androidx.lifecycle.ViewModel;

public class BookingListViewModel extends ViewModel {
    ZentripRepository zentripRepository;

    @Inject
    public BookingListViewModel(ZentripRepository zentripRepository) {
        this.zentripRepository = zentripRepository;
    }

}
