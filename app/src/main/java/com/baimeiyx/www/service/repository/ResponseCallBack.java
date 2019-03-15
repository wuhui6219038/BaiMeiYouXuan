package com.baimeiyx.www.service.repository;

import android.arch.lifecycle.MutableLiveData;

import com.baimeiyx.www.service.model.BaseResult;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 如果想对请求返回的结果做别的操作请直接继承 {@link ResponseCallBackAdapter}
 * 不需要修改这里面什么
 *
 * @param <T>
 * @author mr.w
 */
@Deprecated
public class ResponseCallBack<T extends BaseResult> implements Callback<T> {
    private MutableLiveData mutableLiveDataObserver;
    private BaseResult baseResult;
    private ResponseCallBackAdapter<T> adapter;

    public ResponseCallBack(MutableLiveData<T> mutableLiveDataObserver) {
        this.mutableLiveDataObserver = mutableLiveDataObserver;
        baseResult = new BaseResult();
    }

    public void setAdapter(ResponseCallBackAdapter<T> adapter) {
        this.adapter = adapter;
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        mutableLiveDataObserver.setValue(response.body());
        if (!isNull(adapter)) {
            adapter.onResponse(call, response);
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        baseResult.setOk(false);
        baseResult.setThrowable(t);
        baseResult.setExcetion(true);
        mutableLiveDataObserver.setValue(baseResult);
        if (!isNull(adapter)) {
            adapter.onFailure(call, t);
        }
    }

    private boolean isNull(Object obj) {
        return obj == null;
    }
}


