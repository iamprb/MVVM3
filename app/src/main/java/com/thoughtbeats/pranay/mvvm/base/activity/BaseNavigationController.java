package com.thoughtbeats.pranay.mvvm.base.activity;

import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;



abstract class BaseNavigationController {

    private FragmentManager fragmentManager;

    protected BaseNavigationController(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }
//
//    public <T extends RecyclerView.Adapter> void showPopup(final String alertTitle, T adapter) {
//        CustomListAlertDialogFragment customListAlertDialogFragment =
//                CustomListAlertDialogFragment.getInstance(alertTitle, adapter);
//        customListAlertDialogFragment.show(getFragmentManager(), customListAlertDialogFragment.getClass()
//                .getSimpleName());
//    }
//
//    public void dismissPopup() {
//        DialogFragment dialogFragment = (DialogFragment) getFragmentManager().findFragmentByTag
//                (CustomListAlertDialogFragment.class.getSimpleName());
//        if (dialogFragment != null) {
//            dialogFragment.dismiss();
//        }
//    }
//
//    public void showProgressDialog() {
//        DialogFragment dialogFragment = CustomProgressDialog.getInstance();
//        dialogFragment.show(getFragmentManager(), CustomProgressDialog.class.getSimpleName());
//    }
//
//    public void hideProgressDialog() {
//        DialogFragment dialogFragment = (DialogFragment) getFragmentManager().findFragmentByTag
//                (CustomProgressDialog.class.getSimpleName());
//        if (dialogFragment != null) {
//            dialogFragment.dismiss();
//        }
//    }

    protected FragmentManager getFragmentManager() {
        return fragmentManager;
    }
//}
}
