package com.baimeiyx.www.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.baimeiyx.www.base.ui.BaseActivity;
import com.baimeiyx.www.utils.BarUtils;
import com.baimeiyx.www.utils.myUtils.FragmentUtils;
import com.baimeiyx.www.ui.fragment.MainLossToolFragment;
import com.example.mrw.baimeiyouxuan.R;

import butterknife.ButterKnife;

public class LossToolActivity extends BaseActivity {
    private static final String TAG = "LossToolActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contain);
        unbinder = ButterKnife.bind(this);
        FragmentUtils.showFragmentReplace(getSupportFragmentManager(), R.id.contain, MainLossToolFragment.newInstance());
        _init();
    }

    private void _init() {
        BarUtils.setColor(this, getResources().getColor(android.R.color.white), 0);

    }
}
