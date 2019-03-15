package com.baimeiyx.www.service.interceptor;

import android.util.Log;

import com.baimeiyx.www.service.excetion.ExceptionEngine;
import com.baimeiyx.www.service.excetion.ServerException;
import com.baimeiyx.www.service.repository.BaiMeiApiService;
import com.baimeiyx.www.utils.LogUtils;
import com.baimeiyx.www.utils.NetworkUtils;

import java.io.IOException;
import java.util.List;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 用来匹配多个url
 */
public class InterceptorUrl implements Interceptor {
    private static final String TAG = "InterceptorUrl";

    @Override
    public Response intercept(Chain chain) throws IOException {
        if (NetworkUtils.isConnected()) {
            Request oriRequest = chain.request();
            HttpUrl url = oriRequest.url();
            Request.Builder builder = oriRequest.newBuilder();
            List<String> urlNames = oriRequest.headers(BaiMeiApiService.URLNAME);
            if (urlNames == null || urlNames.isEmpty()) {
                LogUtils.e(TAG, "intercept: 没匹配到url使用的是默认的url");
                return chain.proceed(oriRequest);
            } else {
                builder.removeHeader(BaiMeiApiService.URLNAME);
                String urlName = urlNames.get(0);
                Log.e(TAG, "intercept: " + urlName);
                HttpUrl httpUrl = null;
                //url处理
                if (urlName.equals(BaiMeiApiService.URL_MAIN)) {
                    httpUrl = HttpUrl.parse(BaiMeiApiService.HOST_MAIN);
                    Log.e(TAG, "intercept: 匹配到url");
                } else {
                }
                HttpUrl newHttpUrl = url.newBuilder()
                        .scheme(httpUrl.scheme())
                        .host(httpUrl.host())
                        .port(httpUrl.port()).build();
                Request newRequest = builder.url(newHttpUrl).build();
                return chain.proceed(newRequest);
            }
        } else {
            Log.e(TAG, "intercept: ");
            throw new ServerException(ExceptionEngine.ERROR.NETWORD_ERROR, "没有网络大佬～");
        }
    }

}
