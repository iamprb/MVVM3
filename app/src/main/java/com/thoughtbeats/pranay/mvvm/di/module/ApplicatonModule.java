package com.thoughtbeats.pranay.mvvm.di.module;

import com.thoughtbeats.pranay.mvvm.Network.NetworkService;
import com.thoughtbeats.pranay.mvvm.Network.Support.LiveDataCallAdapterFactory;
import com.thoughtbeats.pranay.mvvm.di.common.ApplicationScope;
import com.thoughtbeats.pranay.mvvm.di.module.viewModel.MainViewModelModule;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(includes = {
        ViewModelModule.class,
        MainViewModelModule.class
})
public class ApplicatonModule {

    public static final String DB_NAME = "GrowerConnect.db";

    @ApplicationScope
    @Provides
    NetworkService provideGrowerService() {
        return new Retrofit.Builder()
                //.baseUrl("https://anantham.syngenta.com:86/MobileService.svc/") // production
                .baseUrl("http://52.163.249.131:8883/MobileService.svc/")   // QA
//                .baseUrl("http://10.34.156.44:8887/MobileService.svc/") // Local instance
//                .baseUrl("http://10.34.156.44:8887/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(new LiveDataCallAdapterFactory())
                .build()
                .create(NetworkService.class);
    }

}
