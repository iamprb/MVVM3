package com.thoughtbeats.pranay.mvvm.base.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.thoughtbeats.pranay.mvvm.base.presenter.BasePresenter;
import com.thoughtbeats.pranay.mvvm.base.viewmodel.AbstractViewModel;
import com.thoughtbeats.pranay.mvvm.ui.common.mainActivity.AbstractBaseDashboardActivity;

public abstract class AbstractBaseDialogDataBindingFragment<P extends BasePresenter, VM extends AbstractViewModel<P>, T extends ViewDataBinding>
        extends AbstractBaseDialogFragment<P, VM> {

    private T binding;

    private AbstractBaseDashboardActivity.UiInteraction uiInteraction;

    @NonNull
    @Override
    public final View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, getLayout(), container, false);
        return binding.getRoot();
    }

    public AbstractBaseDashboardActivity.UiInteraction getUiInteraction() {
        return uiInteraction;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);

        // request a window without the title
        if (dialog.getWindow() != null)
            dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        return dialog;
    }

    @Override
    public void onResume() {
        Window window = getDialog().getWindow();
        if (window != null) {

            int width = (int) (getResources().getDisplayMetrics().widthPixels * 0.70);
            int height = (int) (getResources().getDisplayMetrics().heightPixels * 0.70);
            WindowManager.LayoutParams params = window.getAttributes();
            params.dimAmount = 0f;
            params.gravity = Gravity.TOP | Gravity.END;
            params.width = width;
            params.height = height;
            params.y = getToolBarHeight();
            window.setBackgroundDrawableResource(android.R.color.white);
            window.setAttributes(params);
        }
        super.onResume();

    }

    public int getToolBarHeight() {

        final TypedArray styledAttributes = getContext().getTheme().obtainStyledAttributes(
                new int[]{android.R.attr.actionBarSize});
        int toolBarHeight = (int) styledAttributes.getDimension(0, 0);
        styledAttributes.recycle();
        return toolBarHeight;
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

    public T getBinding() {
        if (binding == null) {
            throw new ExceptionInInitializerError("Please try this method after onCreateView() lifecycle call");
        }
        return binding;
    }

    private void attach(Context activityOrContext) {
        uiInteraction = (AbstractBaseDashboardActivity.UiInteraction) activityOrContext;
        if (uiInteraction == null) {
            throw new NullPointerException("Please extends " + AbstractBaseDashboardActivity.UiInteraction.class.getName() + " interface to your calling activity");
        }
    }
}
