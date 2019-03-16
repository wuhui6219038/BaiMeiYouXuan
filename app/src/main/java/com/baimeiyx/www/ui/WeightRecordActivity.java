package com.baimeiyx.www.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.baimeiyx.www.base.ui.BaseActivity;
import com.baimeiyx.www.utils.BarUtils;
import com.baimeiyx.www.utils.myUtils.FragmentUtils;
import com.baimeiyx.www.ui.fragment.WeightMainFragment;
import com.example.mrw.baimeiyouxuan.R;

import butterknife.ButterKnife;

/**
 * 体重历史记录
 */
public class WeightRecordActivity extends BaseActivity {

    private static final String TAG = "WeightRecordActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contain);
        unbinder = ButterKnife.bind(this);
        FragmentUtils.showFragmentReplace(getSupportFragmentManager(), R.id.contain, WeightMainFragment.newInstance());
        _init();
    }

    private void _init() {
        BarUtils.setColor(this, getResources().getColor(R.color.colorBarWeightRecord), 0);
    }


}
