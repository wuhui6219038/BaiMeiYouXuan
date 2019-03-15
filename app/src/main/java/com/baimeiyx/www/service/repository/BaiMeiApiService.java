package com.baimeiyx.www.service.repository;


import com.baimeiyx.www.service.model.BaseResult;
import com.baimeiyx.www.service.model.CustomWeightLogResult;
import com.baimeiyx.www.service.model.CustomerExpectResult;
import com.baimeiyx.www.service.model.LoginResult;
import com.baimeiyx.www.service.model.OrderListResult;
import com.baimeiyx.www.service.model.RevenceDetailResult;
import com.baimeiyx.www.service.model.ShopAddressResult;
import com.baimeiyx.www.service.model.UserInfoResult;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
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
     * {@link com.baimeiyx.www.service.interceptor.InterceptorUrl}
     * 配置url，便于处理多个url
     *
     * @param username
     * @param password
     * @return
     */
    @GET("login/doLogin.htm")
    Observable<LoginResult> doObservableLogin(@Query("account") String username, @Query("password") String password);

    @GET("health/getCustomerExpectWList")
    Observable<CustomerExpectResult> getCustomerExpect(@Query("MAYI_POS_API_MSID") String MAYI_POS_API_MSID);

    /**
     * 获取体重日志
     *
     * @param MAYI_POS_API_MSID
     * @param page
     * @param limit
     * @return
     */
    @GET("health/getCustomerWList")
    Observable<CustomWeightLogResult> getCustomerWList(@Query("MAYI_POS_API_MSID") String MAYI_POS_API_MSID, @Query("page") String page, @Query("limit") String limit);

    @GET("{customer}")
    Observable<UserInfoResult> getUserInfo(@Path("customer") String customer, @Query("MAYI_POS_API_MSID") String MAYI_POS_API_MSID);

    @POST("customerRelevanceDetail")
    @FormUrlEncoded
    Observable<RevenceDetailResult> getRelevanceDetail(@Field("MAYI_POS_API_MSID") String seesionId, @Field("startTime") String startTime, @Field("endTime") String endTime, @Field("limit") int limit, @Field("page") int page, @Field("behaviorType") String behaviorType);

    /**
     * 更新个人信息
     *
     * @param path
     * @param path2
     * @param seesionId
     * @param params
     * @return
     */
    @POST("{path}/{path2}")
    @FormUrlEncoded
    Observable<BaseResult> doUpdateUserInfo(@Path("path") String path, @Path("path2") String path2, @Field("MAYI_POS_API_MSID") String seesionId, @FieldMap Map<String, String> params);
//

    /**
     * 设置体重
     *
     * @param seesionId
     * @param params
     * @return
     */
    @POST("health/set_target_weight")
    @FormUrlEncoded
    Observable<BaseResult> doUpdateWeight(@Field("MAYI_POS_API_MSID") String seesionId, @FieldMap Map<String, String> params);

    /**
     * 修改每日体重
     *
     * @param seesionId
     * @return
     */
    @POST("health/everyDayWeight")
    @FormUrlEncoded
    Observable<BaseResult> doUpdateEveryDayWeight(@Field("MAYI_POS_API_MSID") String seesionId, @Field("customerW") String customerW);

    /**
     * 获取订单详情
     *
     * @param seesionId
     * @param statusA
     * @param limit
     * @param page
     * @return
     */
    @POST("torder/getAllTOrderList")
    @FormUrlEncoded
    Observable<OrderListResult> getAllTOrderList(@Field("MAYI_POS_API_MSID") String seesionId, @Field("statusA") int statusA, @Field("limit") int limit, @Field("page") int page);

    @POST("tReceivingInfo/getTReceivingInfolist")
    @FormUrlEncoded
    Observable<ShopAddressResult> getAllShopAddress(@Field("MAYI_POS_API_MSID") String seesionId, @Field("limit") int limit, @Field("page") int page);

    @POST("tReceivingInfo/save")
    @FormUrlEncoded
    Observable<BaseResult> doSava(@Field("MAYI_POS_API_MSID") String seesionId, @FieldMap() Map<String, Object> params);

    /**
     * 删除地址
     * @param seesionId
     * @param id
     * @return
     */
    @POST("tReceivingInfo/delete")
    @FormUrlEncoded
    Observable<BaseResult> doDelShopAddress(@Field("MAYI_POS_API_MSID") String seesionId, @Field("id") int id);

    /**
     * 设置默认地址
     * @param seesionId
     * @param id
     * @return
     */
    @POST("tReceivingInfo/setDefaultAddress")
    @FormUrlEncoded
    Observable<BaseResult> setDefaultAddress(@Field("MAYI_POS_API_MSID") String seesionId, @Field("id") int id);

//
//    @GET("health/getCustomerExpectWList")
//    Call<CustomerExpectResult> getCustomerExpect(@Query("MAYI_POS_API_MSID") String MAYI_POS_API_MSID);

//    /**
//     * 获取体重日志
//     *
//     * @param MAYI_POS_API_MSID
//     * @param page
//     * @param limit
//     * @return
//     */
//    @GET("health/getCustomerWList")
//    Call<CustomWeightLogResult> getCustomerWList(@Query("MAYI_POS_API_MSID") String MAYI_POS_API_MSID, @Query("page") String page, @Query("limit") String limit);

//    @Headers({URLNAME + ":" + URL_MAIN})
//    @GET("login/doLogin.htm")
//    Call<LoginResult> doLogin(@Query("account") String username, @Query("password") String password);

//    @GET("{customer}")
//    Call<UserInfoResult> getUserInfo(@Path("customer") String customer, @Query("MAYI_POS_API_MSID") String MAYI_POS_API_MSID);

//    @POST("customerRelevanceDetail")
//    @FormUrlEncoded
//    Call<RevenceDetailResult> getRelevanceDetail(@Field("MAYI_POS_API_MSID") String seesionId, @Field("startTime") String startTime, @Field("endTime") String endTime, @Field("limit") int limit, @Field("page") int page, @Field("behaviorType") String behaviorType);

//    /**
//     * 更新个人信息
//     *
//     * @param path
//     * @param path2
//     * @param seesionId
//     * @param params
//     * @return
//     */
//    @POST("{path}/{path2}")
//    @FormUrlEncoded
//    Call<BaseResult> doUpdateMessage(@Path("path") String path, @Path("path2") String path2, @Field("MAYI_POS_API_MSID") String seesionId, @FieldMap Map<String, String> params);

//    /**
//     * 设置体重
//     *
//     * @param seesionId
//     * @param params
//     * @return
//     */
//    @POST("health/set_target_weight")
//    @FormUrlEncoded
//    Call<BaseResult> doUpdateWeight(@Field("MAYI_POS_API_MSID") String seesionId, @FieldMap Map<String, String> params);

//    /**
//     * 修改每日体重
//     *
//     * @param seesionId
//     * @return
//     */
//    @POST("health/everyDayWeight")
//    @FormUrlEncoded
//    Call<BaseResult> doUpdateEveryDayWeight(@Field("MAYI_POS_API_MSID") String seesionId, @Field("customerW") String customerW);

}
