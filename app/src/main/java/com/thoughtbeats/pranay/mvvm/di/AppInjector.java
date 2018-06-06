package com.thoughtbeats.pranay.mvvm.di;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import com.thoughtbeats.pranay.mvvm.ThoughtBeatApplication;
import com.thoughtbeats.pranay.mvvm.base.fragment.InjectableFragment;
import com.thoughtbeats.pranay.mvvm.di.component.DaggerApplicationComponent;

import dagger.android.AndroidInjection;
import dagger.android.support.AndroidSupportInjection;
import dagger.android.support.HasSupportFragmentInjector;

public class AppInjector {
    public static void initialize(ThoughtBeatApplication thoughtBeatApplication) {
        DaggerApplicationComponent
                .builder()
                .application(thoughtBeatApplication)
                .build()
                .inject(thoughtBeatApplication);

        thoughtBeatApplication.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle bundle) {
                injectActivity(activity);
            }

            @Override
            public void onActivityStarted(Activity activity) {
                // empty method
            }

            @Override
            public void onActivityResumed(Activity activity) {
                // empty method
            }

            @Override
            public void onActivityPaused(Activity activity) {
                // empty method
            }

            @Override
            public void onActivityStopped(Activity activity) {
                // empty method
            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                // empty method
            }

            @Override
            public void onActivityDestroyed(Activity activity) {
                // empty method
            }
        });
    }

    private static void injectActivity(Activity activity) {
        if (activity instanceof HasSupportFragmentInjector) {
            AndroidInjection.inject(activity);
        }

        if (activity instanceof FragmentActivity) {
            ((FragmentActivity) activity).getSupportFragmentManager()
                    .registerFragmentLifecycleCallbacks(
                            new FragmentManager.FragmentLifecycleCallbacks() {
                                @Override
                                public void onFragmentCreated(FragmentManager fm, Fragment f, Bundle savedInstanceState) {
                                    if (f instanceof InjectableFragment) {
                                        AndroidSupportInjection.inject(f);
                                    }
                                }
                            }, true);
        }
    }
}
