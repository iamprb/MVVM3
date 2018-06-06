package com.thoughtbeats.pranay.mvvm.base.activity;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.thoughtbeats.pranay.mvvm.base.presenter.BasePresenter;
import com.thoughtbeats.pranay.mvvm.base.viewmodel.AbstractViewModel;

import javax.inject.Inject;

public abstract class AbstractBaseMVPActivity <P extends BasePresenter, VM extends AbstractViewModel<P>>
        extends AbstractBaseNormalActivity {

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    private P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        VM viewModel = ViewModelProviders.of(this, viewModelFactory).get(getViewModel());

        presenter = viewModel.getPresenter();
    }

    public P getPresenter() {
        return presenter;
    }

    protected abstract Class<VM> getViewModel();
}
