package com.thoughtbeats.pranay.mvvm.base.activity;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.thoughtbeats.pranay.mvvm.ui.common.mainActivity.MainNavigationController;

import javax.inject.Inject;

public abstract class AbstractNavigationController extends BaseNavigationController {
    private AppCompatActivity activity;
    private Fragment fragmentToChange;
    private boolean isBackStack;



    protected AbstractNavigationController(AppCompatActivity activity) {
        super(activity.getSupportFragmentManager());
        this.activity = activity;
    }

    protected void changeFragment(final Fragment fragment, final boolean addToBackStack) {
        this.fragmentToChange = fragment;
        this.isBackStack = addToBackStack;
    }

    protected void updateFragment() {
        if (this.fragmentToChange == null) {
            return;
        }
        final String backStackName = this.fragmentToChange.getClass().getSimpleName();

        final boolean isPop = getFragmentManager().popBackStackImmediate(backStackName, 0);
        if (!isPop /*&& getFragmentManager().findFragmentByTag(backStackName) == null*/) {
            final FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            fragmentTransaction.replace(provideContainerId(), this.fragmentToChange, backStackName);
            if (this.isBackStack) {
                fragmentTransaction.addToBackStack(backStackName);
            }
            fragmentTransaction.commit();
        }
        this.fragmentToChange = null;
        this.isBackStack = false;
    }


    protected abstract @IdRes
    int provideContainerId();

    public AppCompatActivity getActivity() {
        return activity;
    }
}

