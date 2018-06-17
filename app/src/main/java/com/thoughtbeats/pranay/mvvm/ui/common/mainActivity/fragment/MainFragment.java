package com.thoughtbeats.pranay.mvvm.ui.common.mainActivity.fragment;

import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.thoughtbeats.pranay.mvvm.R;
import com.thoughtbeats.pranay.mvvm.ui.common.mainActivity.AbstractBaseMainActivity;
import com.thoughtbeats.pranay.mvvm.ui.common.mainActivity.AbstractBaseRegistrationFragment;
import com.thoughtbeats.pranay.mvvm.ui.common.mainActivity.contract.MainFragmentContract;
import com.thoughtbeats.pranay.mvvm.viewModel.MainViewModel;
import com.thoughtbeats.pranay.mvvm.databinding.MainFragmentBinding;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class MainFragment extends AbstractBaseRegistrationFragment<MainFragmentContract.Presenter,MainViewModel,MainFragmentBinding> {

    String rxString="";
    Observable<String> androidOSObservable =
            Observable.just("Jelly bean", "Kitkat", "Lolipop","Marshmellow", "Oreo", "Android P");




    @Override
    protected Class<MainViewModel> getViewModel() {
        return MainViewModel.class;
    }

    @Override
    protected int getLayout() {
        return R.layout.main_fragment;
    }


    public static MainFragment getInstance(){
        return new MainFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //RX Java part
        Observer<String> androidOsObeserver = getAndroidOsObserver();

        androidOSObservable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(androidOsObeserver);


    }



    public void setRxObject(String s){
        Toast.makeText(getContext(), "Name: "+s, Toast.LENGTH_SHORT).show();
        rxString= rxString.concat(s+"\n");
        getBinding().tvRxJava.setText(rxString+" ");


    }


    private Observer<String> getAndroidOsObserver() {
        return new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                Toast.makeText(getContext(), "Subscribed", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNext(String s) {
                setRxObject(s);
            }

            @Override
            public void onError(Throwable e) {
                Toast.makeText(getContext(), "Error here", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onComplete() {
                Toast.makeText(getContext(),"Completed",Toast.LENGTH_SHORT).show();
            }
        };


    }
    private Observable<String> getAndroidOSObservable() {
        return Observable.just("Ant", "Bee", "Cat", "Dog", "Fox");
    }

}
