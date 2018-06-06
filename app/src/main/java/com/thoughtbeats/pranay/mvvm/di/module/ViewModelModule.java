package com.thoughtbeats.pranay.mvvm.di.module;

import android.arch.lifecycle.ViewModelProvider;

import com.thoughtbeats.pranay.mvvm.base.viewmodel.BaseViewModelFactory;

import dagger.Binds;
import dagger.Module;

@Module()
public abstract class ViewModelModule {

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(BaseViewModelFactory factory);


}
