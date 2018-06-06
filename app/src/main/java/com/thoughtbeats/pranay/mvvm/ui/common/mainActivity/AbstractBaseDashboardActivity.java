package com.thoughtbeats.pranay.mvvm.ui.common.mainActivity;

import com.thoughtbeats.pranay.mvvm.base.activity.AbstractBaseMVPActivity;
import com.thoughtbeats.pranay.mvvm.base.presenter.BasePresenter;
import com.thoughtbeats.pranay.mvvm.base.viewmodel.AbstractViewModel;

public abstract class AbstractBaseDashboardActivity<P extends BasePresenter,
        VM extends AbstractViewModel<P>> extends AbstractBaseMVPActivity<P,VM>
{

    public interface UiInteraction
    {
        MainNavigationController getDashboardNavigationController();

        void setToolbarTitle(String title);

        void closeDrawer();

    }

}

