package com.baimeiyx.www.base.ui;

import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.mrw.baimeiyouxuan.R;
import com.baimeiyx.www.utils.LogUtils;

import butterknife.Unbinder;

public class BaseActivity extends AppCompatActivity {
    private static final String TAG = "BaseActivity";
    //标题
    public static final String KEY_TITLE = "title";
    protected Unbinder unbinder;


    @Override
    protected void onDestroy() {
        super.onDestroy();
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
