package com.thoughtbeats.pranay.mvvm.ui.common.mainActivity;

import android.app.Activity;
import android.content.Context;
import android.databinding.ViewDataBinding;

import com.thoughtbeats.pranay.mvvm.base.fragment.AbstractBaseDialogDataBindingFragment;
import com.thoughtbeats.pranay.mvvm.base.presenter.BasePresenter;
import com.thoughtbeats.pranay.mvvm.base.viewmodel.AbstractViewModel;

public abstract class AbstractBaseDashboardFragment<P extends BasePresenter,
        VM extends AbstractViewModel<P>, T extends ViewDataBinding>
        extends AbstractBaseDialogDataBindingFragment<P, VM, T> {

    private AbstractBaseDashboardActivity.UiInteraction uiInteraction;

    public AbstractBaseDashboardActivity.UiInteraction getUiInteraction() {
        return uiInteraction;
    }

    protected void setToolbarTitle(String title) {
        uiInteraction.setToolbarTitle(title);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        attach(context);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        attach(activity);
    }

    private void attach(Context activityOrContext) {
        uiInteraction = (AbstractBaseDashboardActivity.UiInteraction) activityOrContext;
        if (uiInteraction == null) {
            throw new NullPointerException("Please extends " + AbstractBaseDashboardActivity.UiInteraction.class.getName() + " interface to your calling activity");
        }
    }
}

