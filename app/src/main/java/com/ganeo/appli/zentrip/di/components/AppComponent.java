package com.ganeo.appli.zentrip.di.components;


import android.app.Application;

import com.ganeo.appli.zentrip.ZentripApplication;
import com.ganeo.appli.zentrip.di.builder.ActivityBuilderModule;
import com.ganeo.appli.zentrip.di.module.AppModule;
import com.ganeo.appli.zentrip.di.module.DaoModule;
import com.ganeo.appli.zentrip.di.module.NetModule;
import com.ganeo.appli.zentrip.di.module.RepositoryModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(
        modules = {AndroidSupportInjectionModule.class,
                AppModule.class,
                ActivityBuilderModule.class,
                RepositoryModule.class,
                NetModule.class,
                DaoModule.class}
)
public interface AppComponent {


    void inject(ZentripApplication htaApplication);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }


}