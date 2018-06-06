package com.thoughtbeats.pranay.mvvm.di.fragment;

import com.thoughtbeats.pranay.mvvm.ui.common.mainActivity.fragment.MainFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
@Module
public abstract class MainFragmentModule {
    @ContributesAndroidInjector
    public abstract MainFragment contributeMainFragment();
}
