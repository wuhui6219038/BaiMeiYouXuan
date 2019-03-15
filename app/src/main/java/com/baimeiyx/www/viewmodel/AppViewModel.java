package com.baimeiyx.www.viewmodel;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.os.Bundle;
import android.util.Log;

import com.baimeiyx.www.utils.LogUtils;

/**
 * 全局事件
 */

public class AppViewModel extends ViewModel {
    private MutableLiveData<Bundle> mData;
    private MutableLiveData<String> mSingleData;
    private static final String TAG = "AppViewModel";

    public AppViewModel() {
        mData = new MutableLiveData<>();
        mSingleData = new MutableLiveData<>();
    }

    public MutableLiveData<Bundle> getMutliObserver() {
        return mData;
    }

    public MutableLiveData<String> getSingleObserver() {
        Log.e(TAG, "getSingleObserver: "+mSingleData );
        return mSingleData;
    }

    //传递参数
    public void postData(Bundle data) {
        mData.setValue(data);
    }

    //清空所有的观察者
    public void removeAllObservers(LifecycleOwner owner) {

        mData.removeObservers(owner);
        mSingleData.removeObservers(owner);
        if (mSingleData.hasObservers()) {
            Log.e(TAG, "mSingleData: 当前有存活的观察者" + mSingleData);

        }
        if (mData.hasActiveObservers()) {
            Log.e(TAG, "mData: 当前有存活的观察者" + mData);
        }
    }
}
