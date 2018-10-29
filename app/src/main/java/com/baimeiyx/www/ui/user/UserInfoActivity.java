package com.baimeiyx.www.ui.user;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.mrw.baimeiyouxuan.R;
import com.baimeiyx.www.base.ui.BaseActivity;
import com.baimeiyx.www.base.ui.BaseFragment;
import com.baimeiyx.www.utils.myUtils.FragmentUtils;

public class UserInfoActivity extends BaseActivity {
    public static final String FRAGMENT_TYPE = "fragmentType";
    private static final String TAG = "UserInfoActivity";
    private String fragmentType;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userinfo);
        fragmentType = getIntent().getExtras().getString(FRAGMENT_TYPE);
        _init();
    }

    private void _init() {
        BaseFragment fragment=null;
        if (fragmentType.equals(LoginFragment.class.getName())) {
            fragment = LoginFragment.newInstance();
        } else if (fragmentType.equals(UserInfoFragment.class.getName())) {
            fragment = UserInfoFragment.newInstance();
        }else if(fragmentType.equals(WalletFragment.class.getName())){
            fragment = WalletFragment.newInstance();
        }
        FragmentUtils.showFragmentReplace(getSupportFragmentManager(), R.id.user_contain, fragment);


    }
}
