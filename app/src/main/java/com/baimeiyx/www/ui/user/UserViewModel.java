package com.baimeiyx.www.ui.user;


import android.arch.lifecycle.MutableLiveData;

import com.baimeiyx.www.base.BaseViewModel;
import com.baimeiyx.www.module.http.result.BaseResult;
import com.baimeiyx.www.module.http.result.LoginResult;
import com.baimeiyx.www.module.http.result.UserInfoResult;

import java.util.Map;


public class UserViewModel extends BaseViewModel {
    private MutableLiveData<LoginResult> loginInfo;
    private MutableLiveData<UserInfoResult> userInfo;
    private MutableLiveData<BaseResult> revenceDetailResultMutableLiveData;
    private MutableLiveData<BaseResult> baseResultMutableLiveData;


    public MutableLiveData<LoginResult> doLogin(String username, String psd) {
        loginInfo = dataRepository.doLogin(username, psd);
        return loginInfo;

    }

    public MutableLiveData<UserInfoResult> getUserInfo(String customer, String sessionId) {
        userInfo = dataRepository.getUserInfo(customer, sessionId);
        return userInfo;

    }

    public MutableLiveData<BaseResult> getRelevanceDetail(String sessionId, String startTime, String endTime, int page, String behaviorType) {
        revenceDetailResultMutableLiveData = dataRepository.getRelevanceDetail(sessionId, startTime, endTime, page, behaviorType);
        return revenceDetailResultMutableLiveData;
    }

    public MutableLiveData<BaseResult> doUpdateUserInfo(String path, String path2, String sessionId, Map<String, String> params) {
        baseResultMutableLiveData = dataRepository.doUpdateUserInfo(path, path2, sessionId, params);
        return baseResultMutableLiveData;
    }
}
