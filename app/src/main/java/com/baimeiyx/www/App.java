package com.baimeiyx.www;

import android.app.Application;
import android.util.Log;

import com.baimeiyx.www.constant.Config;
import com.baimeiyx.www.service.repository.DataManager;
import com.baimeiyx.www.utils.FileUtils;
import com.baimeiyx.www.utils.Utils;
import com.baimeiyx.www.utils.myUtils.AreaUtils;
import com.example.mrw.baimeiyouxuan.BuildConfig;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.qingniu.qnble.utils.QNLogUtils;
import com.yolanda.health.qnblesdk.listener.QNResultCallback;
import com.yolanda.health.qnblesdk.out.QNBleApi;

import java.io.IOException;

import me.jessyan.autosize.AutoSize;
import me.jessyan.autosize.AutoSizeConfig;


public class App extends Application {
    public static App INSTANCE;
    public static JsonObject jsonData;
    public static JsonObject jsonData2;
    private static final String TAG = "App";

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
        Utils.init(this);
        DataManager._init();
        _initJson();
        _initQianNiu();
    }

    private void _initJson() {
        try {
            jsonData = AreaUtils.parseJson("area.json");
            jsonData2 = AreaUtils.parseJson("area2.json");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void _initQianNiu() {
        String encryptPath = "file:///android_asset/amw20190318.qn";
        QNLogUtils.setLogEnable(BuildConfig.DEBUG);//设置日志打印开关，默认关闭
        QNLogUtils.setWriteEnable(true);//设置日志写入文件开关，默认关闭
        QNBleApi mQNBleApi = QNBleApi.getInstance(this);
        mQNBleApi.initSdk(Config.QIANNIU_APPID, encryptPath, new QNResultCallback() {
            @Override
            public void onResult(int code, String msg) {
                Log.d("BaseApplication", "初始化文件" + msg);
            }
        });
    }
}
