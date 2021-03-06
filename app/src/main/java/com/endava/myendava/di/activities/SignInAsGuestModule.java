package com.endava.myendava.di.activities;

import com.endava.myendava.activities.SignInAsGuestActivity;

import dagger.Module;

@Module
public class SignInAsGuestModule {

    private final SignInAsGuestActivity mActivity;

    public SignInAsGuestModule(SignInAsGuestActivity activity) {
        mActivity = activity;
    }
}
