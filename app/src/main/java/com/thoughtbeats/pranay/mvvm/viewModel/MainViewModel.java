package com.thoughtbeats.pranay.mvvm.viewModel;

import com.thoughtbeats.pranay.mvvm.base.viewmodel.AbstractViewModel;
import com.thoughtbeats.pranay.mvvm.ui.common.mainActivity.contract.MainFragmentContract;

public class MainViewModel extends AbstractViewModel<MainFragmentContract.Presenter>
implements MainFragmentContract.Presenter{
    @Override
    public MainFragmentContract.Presenter getPresenter() {
        return this;
    }
}
