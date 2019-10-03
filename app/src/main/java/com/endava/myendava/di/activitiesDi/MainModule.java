package com.endava.myendava.di.activitiesDi;

import com.endava.myendava.activities.MainActivity;

import dagger.Module;

@Module
public class MainModule {

    private final MainActivity mActivity;

    public MainModule(MainActivity activity) {
        mActivity = activity;
    }
}
