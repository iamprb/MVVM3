package com.thoughtbeats.pranay.mvvm.di.module.viewModel;

import android.arch.lifecycle.ViewModel;

import com.thoughtbeats.pranay.mvvm.di.common.ViewModelKey;
import com.thoughtbeats.pranay.mvvm.viewModel.MainViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
@Module()
public abstract class MainViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel.class)
    public abstract ViewModel bindAboutUsViewModel (MainViewModel aboutUsViewModel);
}

