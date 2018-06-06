package com.thoughtbeats.pranay.mvvm.base.viewmodel;

import android.arch.lifecycle.ViewModel;

import com.thoughtbeats.pranay.mvvm.base.presenter.BasePresenter;

public abstract class AbstractViewModel<P extends BasePresenter> extends ViewModel {

    public abstract P getPresenter();
}
