package com.baimeiyx.www.base;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.os.Bundle;

import com.baimeiyx.www.utils.LogUtils;


public class AppViewModel extends ViewModel {
    private MutableLiveData<Bundle> mData;
    private static final String TAG = "AppViewModel";

    public AppViewModel() {
        LogUtils.e(TAG, "测试");
        mData = new MutableLiveData<>();
    }

    public MutableLiveData<Bundle> getObserver() {
        return mData;
    }

    //传递参数
    public void postData(Bundle data) {
        mData.setValue(data);
    }

}
