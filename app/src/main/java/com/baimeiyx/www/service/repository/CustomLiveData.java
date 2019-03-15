package com.baimeiyx.www.service.repository;

import android.arch.lifecycle.LiveData;
@Deprecated
public class CustomLiveData<T> extends LiveData<T> {
    @Override
    protected void postValue(T value) {
        super.postValue(value);
    }

    @Override
    protected void setValue(T value) {
        super.setValue(value);
    }


}
