package com.thoughtbeats.pranay.mvvm.ui.common.mainActivity;

import com.thoughtbeats.pranay.mvvm.R;
import com.thoughtbeats.pranay.mvvm.base.activity.AbstractNavigationController;
import com.thoughtbeats.pranay.mvvm.ui.common.mainActivity.activity.MainActivity;
import com.thoughtbeats.pranay.mvvm.ui.common.mainActivity.fragment.MainFragment;

import javax.inject.Inject;

public class MainNavigationController extends AbstractNavigationController {

    @Inject
    public MainNavigationController(MainActivity mainActivity) {
        super(mainActivity);
    }
    @Override
    protected int provideContainerId() {
        return R.id.container;
    }

    public void navigateToFirstFragment(){
        changeFragment(MainFragment.getInstance(),true);
        updateFragment();
    }
}
