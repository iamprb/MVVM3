package com.thoughtbeats.pranay.mvvm.di.component;


import android.app.Application;

import com.thoughtbeats.pranay.mvvm.ThoughtBeatApplication;
import com.thoughtbeats.pranay.mvvm.di.activity.ActivityModule;
import com.thoughtbeats.pranay.mvvm.di.common.ApplicationScope;
import com.thoughtbeats.pranay.mvvm.di.module.ApplicatonModule;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

@ApplicationScope
@Component(modules = {
        AndroidInjectionModule.class,
        ApplicatonModule.class,
        ActivityModule.class
})
public interface ApplicationComponent {
    void inject(ThoughtBeatApplication application);

    @Component.Builder
    interface Builder{
        @BindsInstance
        Builder application(Application application);

        ApplicationComponent build();
    }
}
