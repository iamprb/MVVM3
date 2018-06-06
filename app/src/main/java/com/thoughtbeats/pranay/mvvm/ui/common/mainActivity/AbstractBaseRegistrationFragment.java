package com.thoughtbeats.pranay.mvvm.ui.common.mainActivity;

import android.app.Activity;
import android.content.Context;
import android.databinding.ViewDataBinding;

import com.thoughtbeats.pranay.mvvm.base.fragment.AbstractBaseDataBindingFragment;
import com.thoughtbeats.pranay.mvvm.base.presenter.BasePresenter;
import com.thoughtbeats.pranay.mvvm.base.viewmodel.AbstractViewModel;

public abstract class AbstractBaseRegistrationFragment<P extends BasePresenter,
        VM extends AbstractViewModel<P>, T extends ViewDataBinding>
        extends AbstractBaseDataBindingFragment<P, VM, T> {

    private AbstractBaseMainActivity.UiInteraction uiInteraction;

    public AbstractBaseMainActivity.UiInteraction getUiInteraction() {
        return uiInteraction;
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
        uiInteraction = (AbstractBaseMainActivity.UiInteraction) activityOrContext;
        if (uiInteraction == null) {
            throw new NullPointerException("Please extends " + AbstractBaseMainActivity.UiInteraction.class.getName() + " interface to your calling activity");
        }
    }

}