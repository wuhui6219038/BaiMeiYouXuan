package com.baimeiyx.www.base;

import android.arch.lifecycle.ViewModel;

import com.baimeiyx.www.module.DataRepository;


public class BaseViewModel extends ViewModel {
    protected DataRepository dataRepository;
    public void setDataRepository(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }
}
