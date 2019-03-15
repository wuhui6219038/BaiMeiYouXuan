package com.baimeiyx.www.service.repository;

import com.baimeiyx.www.service.model.BaseResult;

import retrofit2.Call;
import retrofit2.Response;

/**
 * 请求相应适配器
 */
@Deprecated
public abstract class ResponseCallBackAdapter<T extends BaseResult> {
    //请求成功
    public abstract void onResponse(Call<T> call, Response<T> response);

    //请求失败
    public abstract void onFailure(Call<T> call, Throwable t);

}
