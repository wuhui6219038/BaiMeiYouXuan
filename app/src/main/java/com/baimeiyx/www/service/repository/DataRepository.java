package com.baimeiyx.www.service.repository;

import android.arch.lifecycle.MutableLiveData;

import com.baimeiyx.www.constant.Constant;
import com.baimeiyx.www.service.model.BaseResult;
import com.baimeiyx.www.service.model.CustomWeightLogResult;
import com.baimeiyx.www.service.model.CustomerExpectResult;
import com.baimeiyx.www.service.model.LoginResult;
import com.baimeiyx.www.service.model.UserInfoResult;
import com.baimeiyx.www.utils.SPUtils;

import java.util.Map;

@Deprecated
public class DataRepository {

    private static final String TAG = "DataRepository";
    private static BaiMeiApiService baiMeiApiManager;
    private MutableLiveData<LoginResult> loginInfo;
    private MutableLiveData<UserInfoResult> userInfo;
    private MutableLiveData<BaseResult> revenceDetailResultMutableLiveData;
    private MutableLiveData<BaseResult> baseResultMutableLiveData;
    private MutableLiveData<CustomerExpectResult> customerExpectResultMutableLiveData;
    private MutableLiveData<CustomWeightLogResult> customWeightLogResultMutableLiveData;
    private SPUtils spUtils;

    public DataRepository() {
        spUtils = new SPUtils(Constant.SP_PRESONAL);
        loginInfo = new MutableLiveData<>();
        userInfo = new MutableLiveData<>();
        baiMeiApiManager = DataManager.getBaiMeiApiService();
        revenceDetailResultMutableLiveData = new MutableLiveData<>();
        baseResultMutableLiveData = new MutableLiveData<>();
        customerExpectResultMutableLiveData = new MutableLiveData<>();
        customWeightLogResultMutableLiveData = new MutableLiveData<>();
    }

//    public MutableLiveData<LoginResult> doLogin(String username, String psd) {
//        baiMeiApiManager.doLogin(username, psd)
//                .enqueue(new ResponseCallBack(loginInfo));
//        return loginInfo;
//    }

//    public MutableLiveData<UserInfoResult> getUserInfo(String customer, String sessionId) {
//        baiMeiApiManager.getUserInfo(customer, sessionId)
//                .enqueue(new ResponseCallBack(userInfo));
//        return userInfo;
//    }

//    public MutableLiveData<BaseResult> getRelevanceDetail(String sessionId, String startTime, String endTime, int page, String behaviorType) {
//        baiMeiApiManager.getRelevanceDetail(sessionId, startTime, endTime, Constant.LIMIT, page, behaviorType)
//                .enqueue(new ResponseCallBack(revenceDetailResultMutableLiveData));
//        return revenceDetailResultMutableLiveData;
//    }

//    public MutableLiveData<CustomerExpectResult> getCustomerExpect() {
//        baiMeiApiManager.getCustomerExpect(spUtils.getString(Constant.SP_SESSION_ID))
//                .enqueue(new ResponseCallBack(customerExpectResultMutableLiveData));
//        return customerExpectResultMutableLiveData;
//    }

//    public MutableLiveData<CustomWeightLogResult> getCustomerWList() {
//        baiMeiApiManager.getCustomerWList(spUtils.getString(Constant.SP_SESSION_ID), "1", "60")
//                .enqueue(new ResponseCallBack(customWeightLogResultMutableLiveData));
//        return customWeightLogResultMutableLiveData;
//    }
//
//    public MutableLiveData<BaseResult> doUpdateUserInfo(String path, String path2, String sessionId, Map<String, String> params) {
//        baiMeiApiManager.doUpdateMessage(path, path2, sessionId, params)
//                .enqueue(new ResponseCallBack(baseResultMutableLiveData));
//        return baseResultMutableLiveData;
//    }


//    public MutableLiveData<BaseResult> doUpdateWeight(Map<String, String> params) {
//        baiMeiApiManager.doUpdateWeight(spUtils.getString(Constant.SP_SESSION_ID), params)
//                .enqueue(new ResponseCallBack(baseResultMutableLiveData));
//        return baseResultMutableLiveData;
//    }

//    public MutableLiveData<BaseResult> doUpdateEveryDayWeight(String customerW) {
//        baiMeiApiManager.doUpdateEveryDayWeight(spUtils.getString(Constant.SP_SESSION_ID), customerW)
//                .enqueue(new ResponseCallBack(baseResultMutableLiveData));
//        return baseResultMutableLiveData;
//    }


}
