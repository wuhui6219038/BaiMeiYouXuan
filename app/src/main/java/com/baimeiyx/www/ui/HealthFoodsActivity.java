package com.baimeiyx.www.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.baimeiyx.www.base.ui.BaseActivity;
import com.baimeiyx.www.ui.fragment.HealthFoodsFragment;
import com.baimeiyx.www.ui.fragment.MainLossToolFragment;
import com.baimeiyx.www.utils.myUtils.FragmentUtils;
import com.example.mrw.baimeiyouxuan.R;

public class HealthFoodsActivity extends BaseActivity {
    private static final String TAG = "LossToolActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contain);
        FragmentUtils.showFragmentReplace(getSupportFragmentManager(), R.id.contain, HealthFoodsFragment.newInstance());
    }


}

