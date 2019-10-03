package com.endava.myendava.di.FragmentsDi;

import com.endava.myendava.fragments.GuestInfoFragment;

import dagger.Module;

@Module
public class GuestInfoModule {

    private final GuestInfoFragment mFragment;

    public GuestInfoModule(GuestInfoFragment fragment) {
        mFragment = fragment;
    }

}
