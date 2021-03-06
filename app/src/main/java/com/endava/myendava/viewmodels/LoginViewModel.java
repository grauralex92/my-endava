package com.endava.myendava.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.endava.myendava.models.LoginResult;
import com.endava.myendava.repositories.LoginRepository;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class LoginViewModel extends ViewModel {

    private final LoginRepository mRepo;
    private final CompositeDisposable mCompositeDisposable = new CompositeDisposable();
    private MutableLiveData<Boolean> mLoginSuccess = new MutableLiveData<>();
    private MutableLiveData<Boolean> mIsLoading = new MutableLiveData<>();
    private MutableLiveData<String> mError = new MutableLiveData<>();

    @Inject
    public LoginViewModel(LoginRepository mRepo) {
        this.mRepo = mRepo;
    }

    public void login(String email) {
        mIsLoading.setValue(true);
        Disposable observable = mRepo.login(email)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleSuccess, this::handleError);
        mCompositeDisposable.add(observable);
    }

    public MutableLiveData<Boolean> getLoginSuccess() {
        return mLoginSuccess;
    }

    public LiveData<Boolean> isLoading() {
        return mIsLoading;
    }

    public LiveData<String> getError() {
        return mError;
    }

    private void handleError(Throwable throwable) {
        mError.setValue(throwable.getLocalizedMessage());
        mIsLoading.setValue(false);
    }

    private void handleSuccess(LoginResult isEmailValid) {
        mLoginSuccess.setValue(isEmailValid.isSuccess());
        mIsLoading.setValue(false);
        mError.setValue(null);
    }

    @Override
    public void onCleared() {
        mCompositeDisposable.dispose();
    }
}
