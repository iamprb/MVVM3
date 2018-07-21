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

    public static final String DB_NAME = "DB name";

    @ApplicationScope
    @Provides
    NetworkService provideGrowerService() {
        return new Retrofit.Builder()
                  .baseUrl("Your HTTP URL here")   // QA

                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(new LiveDataCallAdapterFactory())
                .build()
                .create(NetworkService.class);
    }

}
