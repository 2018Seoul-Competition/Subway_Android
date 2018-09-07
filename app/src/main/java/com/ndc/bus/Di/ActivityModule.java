package com.ndc.bus.Di;

import com.ndc.bus.Activity.MainActivity;
import com.ndc.bus.Activity.StationActivity;
import com.ndc.bus.Activity.TestActivity;

import dagger.Module;

import dagger.android.ContributesAndroidInjector;

@Module
abstract class ActivityModule {
    @ActivityScope
    @ContributesAndroidInjector
    abstract public MainActivity contributeMainActivityInjector();

    @ContributesAndroidInjector
    @ActivityScope
    abstract public TestActivity contributeTestActivityInjector();

    @ActivityScope
    @ContributesAndroidInjector
    abstract public StationActivity contributeStationActivityInjector();
}
