package com.baimeiyx.www.module.http.api;


import com.baimeiyx.www.module.http.result.BaseResult;
import com.baimeiyx.www.module.http.result.CustomerExpectResult;
import com.baimeiyx.www.module.http.result.LoginResult;
import com.baimeiyx.www.module.http.result.RevenceDetailResult;
import com.baimeiyx.www.module.http.result.UserInfoResult;

import java.util.Map;

import io.reactivex.Flowable;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface BaiMeiApiService {
    /**
     * 主url
     */
    /**
     * url的名称
     */
    String URLNAME = "urlName";
    /**
     * 主url的名称
     */
    String URL_MAIN = "mainurl";
    String HOST_MAIN = "https://www.baimeiyx.com/gudao-parent-api/api/";

    /**
     * {@link com.baimeiyx.www.module.http.interceptor.InterceptorUrl}
     * 配置url，便于处理多个url
     *
     * @param username
     * @param password
     * @return
     */
    @GET("login/doLogin.htm")
    Flowable<Response<LoginResult>> doObservableLogin(@Query("account") String username, @Query("password") String password);

    @GET("health/getCustomerExpectWList")
    default Call<CustomerExpectResult> getCustomerExpect(@Query("MAYI_POS_API_MSID") String MAYI_POS_API_MSID) {
        return null;
    }

    @Headers({URLNAME + ":" + URL_MAIN})
    @GET("login/doLogin.htm")
    Call<LoginResult> doLogin(@Query("account") String username, @Query("password") String password);

    @GET("{customer}")
    Call<UserInfoResult> getUserInfo(@Path("customer") String customer, @Query("MAYI_POS_API_MSID") String MAYI_POS_API_MSID);

    @POST("customerRelevanceDetail")
    @FormUrlEncoded
    Call<RevenceDetailResult> getRelevanceDetail(@Field("MAYI_POS_API_MSID") String seesionId, @Field("startTime") String startTime, @Field("endTime") String endTime, @Field("limit") int limit, @Field("page") int page, @Field("behaviorType") String behaviorType);

    @POST("{path}/{path2}")
    @FormUrlEncoded
    Call<BaseResult> doUpdateMessage(@Path("path") String path, @Path("path2") String path2, @Field("MAYI_POS_API_MSID") String seesionId, @FieldMap Map<String, String> params);

}
