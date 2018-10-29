package com.baimeiyx.www;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;

import com.baimeiyx.www.ui.user.AccountFragment;
import com.baimeiyx.www.base.ui.BaseActivity;
import com.baimeiyx.www.ui.home.HomeFragment;
import com.baimeiyx.www.utils.BarUtils;
import com.baimeiyx.www.utils.myUtils.FragmentUtils;
import com.example.mrw.baimeiyouxuan.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {


    @BindView(R.id.navigation)
    BottomNavigationView navigation;
    private MenuItem menuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);
        if (savedInstanceState == null) {

            FragmentUtils.showFragmentReplace(getSupportFragmentManager(), R.id.container, HomeFragment.newInstance());
            setBar(R.color.colorBarHome, 0);
        }
        _init();

    }

    private void _init() {
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

    private void setBar(int color, int alpha) {
        BarUtils.setColor(this, getResources().getColor(color), alpha);

    }


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            if (menuItem != item) {
                menuItem = item;

                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        FragmentUtils.showFragmentReplace(getSupportFragmentManager(), R.id.container, HomeFragment.newInstance());
                        return true;
                    case R.id.navigation_shop:
                        return true;
                    case R.id.navigation_account:
                        FragmentUtils.showFragmentReplace(getSupportFragmentManager(), R.id.container, AccountFragment.newInstance());
                        return true;
                }
                return false;
            }
            return false;
        }
    };


}
