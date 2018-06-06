package com.thoughtbeats.pranay.mvvm.ui.common.mainActivity.fragment;

import android.databinding.ViewDataBinding;

import com.thoughtbeats.pranay.mvvm.R;
import com.thoughtbeats.pranay.mvvm.ui.common.mainActivity.AbstractBaseMainActivity;
import com.thoughtbeats.pranay.mvvm.ui.common.mainActivity.AbstractBaseRegistrationFragment;
import com.thoughtbeats.pranay.mvvm.ui.common.mainActivity.contract.MainFragmentContract;
import com.thoughtbeats.pranay.mvvm.viewModel.MainViewModel;

public class MainFragment extends AbstractBaseRegistrationFragment<MainFragmentContract.Presenter,MainViewModel,ViewDataBinding> {
    @Override
    protected Class<MainViewModel> getViewModel() {
        return MainViewModel.class;
    }

    @Override
    protected int getLayout() {
        return R.layout.main_fragment;
    }

    public static MainFragment getInstance(){
        return new MainFragment();
    }
}
