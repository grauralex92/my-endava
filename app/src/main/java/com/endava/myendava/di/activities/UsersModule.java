package com.endava.myendava.di.activities;

import com.endava.myendava.activities.UsersActivity;
import com.endava.myendava.repositories.UsersRepository;
import com.endava.myendava.rest.RetrofitClient;
import com.endava.myendava.viewmodels.UsersViewModel;

import dagger.Module;
import dagger.Provides;

@Module
public class UsersModule {

    private final UsersActivity mActivity;

    public UsersModule(UsersActivity activity) {
        mActivity = activity;
    }

    @Provides
    UsersViewModel provideUsersViewModel() {
        return new UsersViewModel(new UsersRepository(new RetrofitClient()));
    }
}
