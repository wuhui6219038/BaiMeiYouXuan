package com.baimeiyx.www.ui.weight_record.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mrw.baimeiyouxuan.R;
import com.baimeiyx.www.base.ui.BaseSimpleFragment;
import com.baimeiyx.www.utils.myUtils.FragmentUtils;
import com.baimeiyx.www.view.circleprogress.DonutProgress;

import butterknife.BindView;
import butterknife.OnClick;

public class MainFragment extends BaseSimpleFragment {
    @BindView(R.id.donut_progress)
    DonutProgress donutProgress;
    @BindView(R.id.btn_weight_record)
    Button btnWeightRecord;


    public static MainFragment newInstance() {
        Bundle args = new Bundle();
        MainFragment fragment = new MainFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected int getViewId() {
        return R.layout.fragment_main_weight_record;
    }

    @Override
    protected void _init(Bundle savedInstanceState) {

    }

    @Override
    protected void setToolbar() {
        tvTitle.setText(getString(R.string.title_weight_record));
        toolbar.setBackgroundColor(getResources().getColor(R.color.colorBarWeightRecord));
    }


    @OnClick({R.id.btn_weight_record, R.id.ll_lastest_weight})
    public void doClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.btn_weight_record:

                FragmentUtils.showFragmentAddStack(getFragmentManager(), R.id.wr_container, WeightRecordDetailFragment.newInstance());
                break;
            case R.id.ll_lastest_weight:
                FragmentUtils.showFragmentAddStack(getFragmentManager(), R.id.wr_container, WeightLogFragment.newInstance());
                break;
        }
    }

}
