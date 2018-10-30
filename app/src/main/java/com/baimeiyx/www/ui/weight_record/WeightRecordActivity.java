package com.baimeiyx.www.ui.weight_record;

import android.os.Bundle;
import android.support.annotation.Nullable;


import com.baimeiyx.www.base.callback.FragmentInteraction;
import com.baimeiyx.www.base.ui.BaseActivity;
import com.example.mrw.baimeiyouxuan.R;
import com.baimeiyx.www.ui.weight_record.ui.MainFragment;
import com.baimeiyx.www.utils.BarUtils;
import com.baimeiyx.www.utils.myUtils.FragmentUtils;

import butterknife.ButterKnife;

/**
 * 体重历史记录
 */
public class WeightRecordActivity extends BaseActivity implements FragmentInteraction {

    private static final String TAG = "WeightRecordActivity";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actvity_weight_record);
        unbinder = ButterKnife.bind(this);
        FragmentUtils.showFragmentReplace(getSupportFragmentManager(), R.id.wr_container, MainFragment.newInstance());
        _init();
    }

    private void _init() {
        BarUtils.setColor(this, getResources().getColor(R.color.colorBarWeightRecord), 0);
    }

    @Override
    public void fragmentToAcProcess(Bundle data, int action) {

    }

    @Override
    public void fragmentToAcProcess(String data) {
//        tvTitle.setText(data);
    }


}
