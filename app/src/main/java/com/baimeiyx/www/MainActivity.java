package com.baimeiyx.www;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.util.Log;
import android.view.MenuItem;


import com.baimeiyx.www.base.ui.BaseActivity;
import com.baimeiyx.www.constant.Constant;
import com.baimeiyx.www.view.fragment.LoginFragment;
import com.baimeiyx.www.view.UserInfoActivity;
import com.baimeiyx.www.utils.ActivityUtils;
import com.example.mrw.baimeiyouxuan.R;
import com.baimeiyx.www.view.fragment.HomeFragment;
import com.baimeiyx.www.view.fragment.ShopMainFragment;
import com.baimeiyx.www.view.fragment.AccountFragment;
import com.baimeiyx.www.utils.EmptyUtils;
import com.baimeiyx.www.utils.SPUtils;
import com.baimeiyx.www.utils.myUtils.FragmentUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    private static final String TAG = "MainActivity";
    @BindView(R.id.navigation)
    BottomNavigationView navigation;
    private MenuItem menuItem;
    private String strSession;
    private boolean clickHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);
    }


    private void _init() {
        Log.e(TAG, "_init: ");
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        strSession = new SPUtils(Constant.SP_PRESONAL).getString(Constant.SP_SESSION_ID);
        int itemId = menuItem == null ? 0 : menuItem.getItemId();
        //进入或者点击首页但没有登录
        if (menuItem == null) {
            navigation.setSelectedItemId(R.id.navigation_home);
        } else if (strSession == null) {
            navigation.setSelectedItemId(itemId);
        } else {
            //登录了 可以直接显示页面
            if (clickHome) {
                clickHome = false;
                navigation.setSelectedItemId(R.id.navigation_home);
            }
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        _init();
    }


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            if (menuItem != item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        if (EmptyUtils.isEmpty(strSession)) {
                            Bundle bundle = new Bundle();
                            bundle.putString(UserInfoActivity.FRAGMENT_TYPE, LoginFragment.class.getName());
                            ActivityUtils.launchActivity(MainActivity.this,UserInfoActivity.class, bundle);
                            clickHome = true;
                        } else {
                            menuItem = item;
                            FragmentUtils.showFragmentReplace(getSupportFragmentManager(), R.id.container, HomeFragment.newInstance());
                        }
                        break;
                    case R.id.navigation_shop:
                        FragmentUtils.showFragmentReplace(getSupportFragmentManager(), R.id.container, ShopMainFragment.newInstance());
                        menuItem = item;
                        break;
                    case R.id.navigation_account:
                        menuItem = item;
                        FragmentUtils.showFragmentReplace(getSupportFragmentManager(), R.id.container, AccountFragment.newInstance());
                        break;
                }
            }
            return true;
        }
    };


}
