package com.ganeo.appli.zentrip.di.module;

import android.app.Application;

import com.ganeo.appli.zentrip.BuildConfig;
import com.ganeo.appli.zentrip.retrofit.interceptor.LiveDataCallAdapterFactory;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetModule {


    @Provides
    @Singleton
    public Cache provideHttpCache(Application application) {
        long cacheSize = 10 * 1024 * 1024L;
        Cache cache = new Cache(application.getCacheDir(), cacheSize);
        return cache;
    }


    @Provides
    @Singleton
    public Gson provideGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        return gsonBuilder.create();
    }


    public Retrofit provideRetrofit(Gson gson, OkHttpClient okHttpClient) {

        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(new LiveDataCallAdapterFactory())
                .baseUrl(BuildConfig.HOST)
                .client(okHttpClient)
                .build();
    }

    public OkHttpClient provideOkhttpClient(Cache cache) {
        OkHttpClient.Builder client = (new OkHttpClient.Builder().addNetworkInterceptor(provideSimpleInterceptor())
                .addInterceptor(provideHttpLoggingInterceptor()).retryOnConnectionFailure(true));
        client.cache(cache);
        return client.build();
    }


    public OkHttpClient provideOAuthOkhttpClient(Cache cache) {
        OkHttpClient.Builder client = (new OkHttpClient.Builder().addNetworkInterceptor(provideOAuthInterceptor())
                .addInterceptor(provideHttpLoggingInterceptor()).retryOnConnectionFailure(true));
        client.cache(cache);
        return client.build();
    }


    public Interceptor provideHttpLoggingInterceptor() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        if (BuildConfig.DEBUG) {
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        } else {
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.NONE);
        }
        return httpLoggingInterceptor;
    }

    public Interceptor provideSimpleInterceptor() {
        return chain -> {
            Request.Builder builder = chain.request().newBuilder();
            // set client Id et mot de passe
            String plainCredentials = "Y2xpZW50SFRBOjEyMzQ1Ng==";
            builder.header("Authorization", "Basic " + plainCredentials);
            return chain.proceed(builder.build());
        };
    }


    public Interceptor provideOAuthInterceptor() {
        //TODO
        return chain -> {
            Request originalRequest = chain.request();
            Request.Builder builder = originalRequest.newBuilder().header("Authorization", "prefsManager.getTokenType()" + " " + "prefsManager.getToken()").
                    method(originalRequest.method(), originalRequest.body());
            okhttp3.Response response = chain.proceed(builder.build());

            if (response.code() == 401) {
                //TODO  SessionUtils.logout(context);
            }
            return response;
        };
    }
}