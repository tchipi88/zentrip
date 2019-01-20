package com.ganeo.appli.zentrip.di.builder;


import com.ganeo.appli.zentrip.fragment.AccountFragment;
import com.ganeo.appli.zentrip.fragment.BookingCarFragment;
import com.ganeo.appli.zentrip.fragment.BookingConfirmationFragment;
import com.ganeo.appli.zentrip.fragment.BookingDriverFragment;
import com.ganeo.appli.zentrip.fragment.BookingFragment;
import com.ganeo.appli.zentrip.fragment.BookingListFragment;
import com.ganeo.appli.zentrip.fragment.LoginFragment;
import com.ganeo.appli.zentrip.fragment.MoreFragment;
import com.ganeo.appli.zentrip.fragment.SignUpFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentBuilderModule {

    @ContributesAndroidInjector
    abstract BookingListFragment bookingListFragment();

    @ContributesAndroidInjector
    abstract BookingFragment searchFragment();

    @ContributesAndroidInjector
    abstract BookingCarFragment bookingCarFragment();

    @ContributesAndroidInjector
    abstract BookingDriverFragment bookingDriverFragment();

    @ContributesAndroidInjector
    abstract BookingConfirmationFragment bookingConfirmationFragment();

    @ContributesAndroidInjector
    abstract MoreFragment moreFragment();

    @ContributesAndroidInjector
    abstract AccountFragment accountFragment();

    @ContributesAndroidInjector
    abstract LoginFragment loginFragment();

    @ContributesAndroidInjector
    abstract SignUpFragment signUpFragment();
}
