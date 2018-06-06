package com.thoughtbeats.pranay.mvvm.di.activity;

import com.thoughtbeats.pranay.mvvm.di.fragment.MainFragmentModule;
import com.thoughtbeats.pranay.mvvm.ui.common.mainActivity.activity.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityModule {



    @ContributesAndroidInjector(modules =
            MainFragmentModule.class
    )
    public abstract MainActivity contributeDashboardActivity();
}

