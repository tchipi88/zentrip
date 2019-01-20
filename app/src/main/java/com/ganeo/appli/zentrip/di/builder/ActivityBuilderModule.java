package com.ganeo.appli.zentrip.di.builder;


import com.ganeo.appli.zentrip.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = FragmentBuilderModule.class)
    abstract MainActivity mainActivity();

}
