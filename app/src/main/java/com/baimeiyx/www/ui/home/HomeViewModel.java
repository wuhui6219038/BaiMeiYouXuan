package com.baimeiyx.www.ui.home;


import android.arch.lifecycle.MutableLiveData;

import com.baimeiyx.www.base.BaseViewModel;
import com.baimeiyx.www.module.http.result.CustomerExpectResult;

public class HomeViewModel extends BaseViewModel {

    public MutableLiveData<CustomerExpectResult> getCustomerExpect() {
        return dataRepository.getCustomerExpect();
    }

}
