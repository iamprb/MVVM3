//package com.thoughtbeats.pranay.mvvm.ui.common;
//
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.support.v4.app.DialogFragment;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
////import android.view.ViewGroup;
//
//public class CustomListAlertDialogFragment<T extends RecyclerView.Adapter> extends DialogFragment {
//
//    private CustomListDialogBinding dialogBinding;
//    private String alertTitle;
//    private T adapter;
//
//    public static <T extends RecyclerView.Adapter> CustomListAlertDialogFragment getInstance(final String alertTitle,
//                                                                                             T adapter) {
//        final CustomListAlertDialogFragment customAlertDialogFragment = new CustomListAlertDialogFragment();
//        customAlertDialogFragment.alertTitle = alertTitle;
//        customAlertDialogFragment.adapter = adapter;
//        return customAlertDialogFragment;
//    }
//
//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setStyle(STYLE_NO_TITLE, 0);
//    }
//
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        dialogBinding = CustomListDialogBinding.inflate(inflater, container, false);
//        return dialogBinding.getRoot();
//    }
//
//    @Override
//    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
////
////        dialogBinding.setAlertTitle(alertTitle);
////        dialogBinding.rvList.setLayoutManager(new LinearLayoutManager(getActivity()));
////        dialogBinding.rvList.setAdapter(adapter);
//    }
//
//    @Override
//    public boolean isCancelable() {
//        return false;
//    }
//
//    public interface OnItemClickListener {
//        void onItemClick(int position);
//    }
//}
//
