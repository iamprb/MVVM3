package com.thoughtbeats.pranay.mvvm.ui.common;

public interface RecyclerViewItemClickListener<T> {

    void onRecyclerItemClick(final T data, final int position);
}