package com.baimeiyx.www.viewmodel;


import android.arch.lifecycle.MutableLiveData;

import com.baimeiyx.www.service.model.BaseResult;
import com.baimeiyx.www.service.model.CustomWeightLogResult;
import com.baimeiyx.www.service.model.LoginResult;
import com.baimeiyx.www.service.model.UserInfoResult;

@Deprecated

public class DataViewModel extends BaseViewModel {
    private MutableLiveData<LoginResult> loginInfo;
    private MutableLiveData<UserInfoResult> userInfo;
    private MutableLiveData<BaseResult> revenceDetailResultMutableLiveData;
    private MutableLiveData<BaseResult> baseResultMutableLiveData;
    private MutableLiveData<CustomWeightLogResult> customWeightLogResultMutableLiveData;


//    public MutableLiveData<LoginResult> doLogin(String username, String psd) {
//        loginInfo = dataRepository.doLogin(username, psd);
//        return loginInfo;
//
//    }

//    public MutableLiveData<CustomerExpectResult> getCustomerExpect() {
//        return dataRepository.getCustomerExpect();
//    }

//    public MutableLiveData<UserInfoResult> getUserInfo(String customer, String sessionId) {
//        userInfo = dataRepository.getUserInfo(customer, sessionId);
//        return userInfo;
//
//    }

//    public MutableLiveData<BaseResult> getRelevanceDetail(String sessionId, String startTime, String endTime, int page, String behaviorType) {
//        revenceDetailResultMutableLiveData = dataRepository.getRelevanceDetail(sessionId, startTime, endTime, page, behaviorType);
//        return revenceDetailResultMutableLiveData;
//    }

//    public MutableLiveData<CustomWeightLogResult> getCustomerWList() {
//        customWeightLogResultMutableLiveData = dataRepository.getCustomerWList();
//        return customWeightLogResultMutableLiveData;
//    }

//    public MutableLiveData<BaseResult> doUpdateUserInfo(String path, String path2, String sessionId, Map<String, String> params) {
//        baseResultMutableLiveData = dataRepository.doUpdateUserInfo(path, path2, sessionId, params);
//        return baseResultMutableLiveData;
//    }
//
//    public MutableLiveData<BaseResult> doUpdateWeight(Map<String, String> params) {
//        baseResultMutableLiveData = dataRepository.doUpdateWeight(params);
//        return baseResultMutableLiveData;
//    }

//    public MutableLiveData<BaseResult> doUpdateEveryDayWeight(String customerW) {
//        baseResultMutableLiveData = dataRepository.doUpdateEveryDayWeight(customerW);
//        return baseResultMutableLiveData;
//    }

}
