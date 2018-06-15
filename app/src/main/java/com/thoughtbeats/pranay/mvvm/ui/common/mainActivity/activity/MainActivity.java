package com.thoughtbeats.pranay.mvvm.ui.common.mainActivity.activity;

import android.os.Bundle;

import com.thoughtbeats.pranay.mvvm.R;
import com.thoughtbeats.pranay.mvvm.base.activity.AbstractBaseNormalActivity;
import com.thoughtbeats.pranay.mvvm.base.fragment.FragmentUiTransaction;
import com.thoughtbeats.pranay.mvvm.ui.common.mainActivity.AbstractBaseMainActivity;
import com.thoughtbeats.pranay.mvvm.ui.common.mainActivity.MainNavigationController;


import javax.inject.Inject;

public class MainActivity extends AbstractBaseNormalActivity implements AbstractBaseMainActivity.UiInteraction {
    @Inject
    MainNavigationController navigationController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigationController.navigateToMainFragment();
        

    }


    @Override
    public MainNavigationController getNavigationController() {
        return navigationController;
    }

    @Override
    public void onBackPressed() {
        FragmentUiTransaction fragmentBackPress = (FragmentUiTransaction) getSupportFragmentManager().getFragments().get
                (getSupportFragmentManager().getFragments().size() - 1);

        if (!fragmentBackPress.onFragmentBackPress()) {
            if (getSupportFragmentManager().getBackStackEntryCount() == 1) {
                finish();

            } else {
                super.onBackPressed();
            }
        }
    }
}
