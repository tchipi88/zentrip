package com.ganeo.appli.zentrip.di.module;


import com.ganeo.appli.zentrip.viewmodel.BookingListViewModel;
import com.ganeo.appli.zentrip.viewmodel.BookingViewModel;
import com.ganeo.appli.zentrip.viewmodel.ViewModelFactory;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;


@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(BookingViewModel.class)
    @SuppressWarnings("unused")
    abstract ViewModel bindsSearchViewModel(BookingViewModel bookingViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(BookingListViewModel.class)
    @SuppressWarnings("unused")
    abstract ViewModel bindsBookingsViewModel(BookingListViewModel bookingListViewModel);


    @Binds
    @SuppressWarnings("unused")
    abstract ViewModelProvider.Factory bindsViewModelFactory(ViewModelFactory viewModelFactory);
}
