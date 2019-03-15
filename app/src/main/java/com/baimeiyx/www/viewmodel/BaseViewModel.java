package com.baimeiyx.www.viewmodel;

import android.arch.lifecycle.ViewModel;

import com.baimeiyx.www.service.repository.DataRepository;

/**
 * 基类viewModel
 */
public class BaseViewModel extends ViewModel {
    protected DataRepository dataRepository;

    public void setDataRepository(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }
}
