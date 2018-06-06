package com.thoughtbeats.pranay.mvvm.base.fragment;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.View;

import com.thoughtbeats.pranay.mvvm.base.presenter.BasePresenter;
import com.thoughtbeats.pranay.mvvm.base.viewmodel.AbstractViewModel;

import javax.inject.Inject;

public abstract class AbstractBaseDialogFragment<P extends BasePresenter, VM extends AbstractViewModel<P>>
        extends DialogFragment implements InjectableFragment, FragmentUiTransaction {

    @Inject
    ViewModelProvider.Factory viewModelFactory;
    private P presenter;
    private VM viewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(getViewModel());
        presenter = viewModel.getPresenter();
    }

    @Override
    public boolean onFragmentBackPress() {
        return false;
    }

    @Override
    public boolean onFragmentInteractionRequired() {
        return false;
    }

    public P getPresenter() {
        return presenter;
    }

    protected abstract Class<VM> getViewModel();

    protected abstract @LayoutRes
    int getLayout();

}

