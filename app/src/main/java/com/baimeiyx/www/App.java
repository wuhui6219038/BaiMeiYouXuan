package com.baimeiyx.www;

import android.app.Application;
import android.util.Log;

import com.baimeiyx.www.service.repository.DataManager;
import com.baimeiyx.www.utils.FileUtils;
import com.baimeiyx.www.utils.Utils;
import com.baimeiyx.www.utils.myUtils.AreaUtils;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;


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
    }

    private void _initJson() {
        try {
            jsonData = AreaUtils.parseJson("area.json");
            jsonData2 = AreaUtils.parseJson("area2.json");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
