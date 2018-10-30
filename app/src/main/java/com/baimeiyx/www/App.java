package com.baimeiyx.www;

import android.app.Application;

import com.baimeiyx.www.module.http.DataManager;
import com.baimeiyx.www.utils.Utils;


public class App extends Application {
    public static App INSTANCE;


    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
        Utils.init(this);
        DataManager._init();
    }
}
