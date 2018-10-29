package com.baimeiyx.www.http;

import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.baimeiyx.www.constant.Constant;
import com.baimeiyx.www.http.DataManager;
import com.baimeiyx.www.http.api.BaiMeiApiService;
import com.baimeiyx.www.http.result.BaseResult;
import com.baimeiyx.www.http.result.LoginResult;
import com.baimeiyx.www.http.result.RevenceDetailResult;
import com.baimeiyx.www.http.result.UserInfoResult;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataRepository {
    private static final String TAG = "DataRepository";
    private BaiMeiApiService baiMeiApiManager;
    private MutableLiveData<LoginResult> loginInfo;
    private MutableLiveData<UserInfoResult> userInfo;
    private MutableLiveData<BaseResult> revenceDetailResultMutableLiveData;
    private MutableLiveData<BaseResult> baseResultMutableLiveData;

    public DataRepository() {
        loginInfo = new MutableLiveData<>();
        userInfo = new MutableLiveData<>();
        baiMeiApiManager = DataManager.getBaiMeiApiService();
        revenceDetailResultMutableLiveData = new MutableLiveData<>();
        baseResultMutableLiveData = new MutableLiveData<>();
    }

    public MutableLiveData<LoginResult> doLogin(String username, String psd) {
        baiMeiApiManager.doLogin(username, psd)
                .enqueue(new Callback<LoginResult>() {
                    @Override
                    public void onResponse(Call<LoginResult> call, Response<LoginResult> response) {
                        loginInfo.setValue(response.body());
                    }

                    @Override
                    public void onFailure(Call<LoginResult> call, Throwable t) {
                        t.printStackTrace();
                    }
                });
        return loginInfo;
    }

    public MutableLiveData<UserInfoResult> getUserInfo(String customer, String sessionId) {
        baiMeiApiManager.getUserInfo(customer, sessionId)
                .enqueue(new Callback<UserInfoResult>() {
                    @Override
                    public void onResponse(Call<UserInfoResult> call, Response<UserInfoResult> response) {
                        userInfo.setValue(response.body());
                    }

                    @Override
                    public void onFailure(Call<UserInfoResult> call, Throwable t) {
                        t.printStackTrace();
                    }
                });
        return userInfo;
    }

    public MutableLiveData<BaseResult> getRelevanceDetail(String sessionId, String startTime, String endTime, int page, String behaviorType) {
        baiMeiApiManager.getRelevanceDetail(sessionId, startTime, endTime, Constant.LIMIT, page, behaviorType)
                .enqueue(new Callback<RevenceDetailResult>() {
                    @Override
                    public void onResponse(Call<RevenceDetailResult> call, Response<RevenceDetailResult> response) {
                        revenceDetailResultMutableLiveData.setValue(response.body());
                    }

                    @Override
                    public void onFailure(Call<RevenceDetailResult> call, Throwable t) {
                        t.printStackTrace();

                    }
                });
        return revenceDetailResultMutableLiveData;
    }

    public MutableLiveData<BaseResult> doUpdateUserInfo(String path, String path2, String sessionId, Map<String, String> params) {
        baiMeiApiManager.doUpdateMessage(path, path2, sessionId, params)
                .enqueue(new Callback<BaseResult>() {
                    @Override
                    public void onResponse(Call<BaseResult> call, Response<BaseResult> response) {
                        baseResultMutableLiveData.setValue(response.body());
                    }

                    @Override
                    public void onFailure(Call<BaseResult> call, Throwable t) {
                        t.printStackTrace();
                    }
                });
        return baseResultMutableLiveData;
    }


}
