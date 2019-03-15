package com.baimeiyx.www.base.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.baimeiyx.www.viewmodel.AppViewModel;
import com.example.mrw.baimeiyouxuan.R;
import com.baimeiyx.www.utils.LogUtils;

import butterknife.Unbinder;

public class BaseActivity extends AppCompatActivity {

    public static AppViewModel appViewModel;
    private static final String TAG = "BaseActivity";
    //标题
    public static final String KEY_TITLE = "title";
    protected Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        appViewModel = ViewModelProviders.of(this).get(AppViewModel.class);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        appViewModel.removeAllObservers(this);
        if (unbinder != null) {
            unbinder.unbind();
        }
    }

    public void doBack(View view) {
        onBackPressed();
    }

    @Override
    public void onBackPressed() {
        int stackNum = getSupportFragmentManager().getBackStackEntryCount();
        int fragmentNum = getSupportFragmentManager().getFragments().size();
        for (int index = 0; index < stackNum; index++) {
            String name = getSupportFragmentManager().getBackStackEntryAt(index).getName();
            LogUtils.e(TAG, "栈堆" + name);
        }
        for (int index = 0; index < fragmentNum; index++) {
            String name = getSupportFragmentManager().getFragments().get(index).getClass().getName();
            LogUtils.e(TAG, "列表中" + name);
        }
        LogUtils.e(TAG, "onBackPressed  栈中的数据" + stackNum + "  现在有的fragment" + fragmentNum);
        if (stackNum > 1) {
            getSupportFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        }


    }
}
