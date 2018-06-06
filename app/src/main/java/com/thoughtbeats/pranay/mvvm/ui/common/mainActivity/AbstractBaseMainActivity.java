package com.thoughtbeats.pranay.mvvm.ui.common.mainActivity;

import com.thoughtbeats.pranay.mvvm.base.activity.AbstractBaseNormalActivity;

public class AbstractBaseMainActivity extends AbstractBaseNormalActivity {

    public interface UiInteraction {
        MainNavigationController getNavigationController();
    }
}