package com.ganeo.appli.zentrip;

import android.app.Activity;
import android.app.Application;
import android.os.StrictMode;

import com.ganeo.appli.zentrip.di.components.DaggerAppComponent;
import com.ganeo.appli.zentrip.exception.ZentripExceptionHandler;

import javax.inject.Inject;

import androidx.fragment.app.Fragment;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import dagger.android.support.HasSupportFragmentInjector;

/**
 * Created by tchipi on 27/02/17.
 */

public class ZentripApplication extends Application implements HasActivityInjector, HasSupportFragmentInjector {


    public static ZentripApplication mInstance;
    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;
    @Inject
    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;

    public static synchronized ZentripApplication getInstance() {
        return mInstance;
    }

    @Override
    public DispatchingAndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentDispatchingAndroidInjector;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        setUpFabric();
        setUpStrictMode();
        setUpGoogleAnalytics();

        Thread.setDefaultUncaughtExceptionHandler(new ZentripExceptionHandler(this));

        initializeComponent();


    }

    private void initializeComponent() {
        DaggerAppComponent.builder()
                .application(this)
                .build()
                .inject(this);
    }

    protected void setUpFabric() {
        /*Crashlytics crashlyticsKit = new Crashlytics.Builder().core(new CrashlyticsCore.Builder().disabled(BuildConfig.DEBUG).build()).build();
        Fabric.with(this, crashlyticsKit);*/
    }


    protected void setUpStrictMode() {
        if (BuildConfig.DEBUG) {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                    .detectAll()
                    .penaltyLog()
                    .build());
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                    .detectLeakedClosableObjects()
                    .detectLeakedRegistrationObjects()
                    .detectLeakedSqlLiteObjects()
                    .penaltyLog()
                    .build());
        }
    }

    protected void setUpGoogleAnalytics() {
        /*GoogleAnalytics analytics = GoogleAnalytics.getInstance(this);
        if (BuildConfig.DEBUG) {
            analytics.getLogger().setLogLevel(Logger.LogLevel.VERBOSE);
            analytics.setDryRun(true);
        }
        GoogleAnalyticsManager_.getInstance_(this).init(analytics, R.xml.analytics);
*/
    }


}



