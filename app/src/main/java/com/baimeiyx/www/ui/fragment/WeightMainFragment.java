package com.baimeiyx.www.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baimeiyx.www.base.ui.BaseUserFragment;
import com.baimeiyx.www.ui.dialog.DialogInputFragment;
import com.baimeiyx.www.ui.dialog.DialogRecodeWidget;
import com.baimeiyx.www.widget.circleprogress.DonutProgress;
import com.baimeiyx.www.service.model.CustomerExpectResult;
import com.baimeiyx.www.utils.BarUtils;
import com.baimeiyx.www.utils.TimeUtils;
import com.baimeiyx.www.utils.myUtils.FragmentUtils;
import com.baimeiyx.www.utils.myUtils.NumFormatterUtils;
import com.baimeiyx.www.utils.myUtils.WeightUtils;
import com.example.mrw.baimeiyouxuan.R;

import butterknife.BindView;
import butterknife.OnClick;

public class WeightMainFragment extends BaseUserFragment<CustomerExpectResult> {
    @BindView(R.id.donut_progress)
    DonutProgress donutProgress;
    @BindView(R.id.btn_weight_record)
    Button btnWeightRecord;
    @BindView(R.id.tv_new_weight)
    TextView tvNewWeight;
    @BindView(R.id.tv_new_date)
    TextView tvNewDate;
    @BindView(R.id.ll_lastest_weight)
    LinearLayout llLastestWeight;
    @BindView(R.id.tv_init_weight)
    TextView tvInitWeight;
    @BindView(R.id.tv_date_init)
    TextView tvDateInit;
    @BindView(R.id.tv_target_weight)
    TextView tvTargetWeight;
    @BindView(R.id.tv_target_date)
    TextView tvTargetDate;

    public static WeightMainFragment newInstance() {
        Bundle args = new Bundle();
        WeightMainFragment fragment = new WeightMainFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected int getViewId() {
        return R.layout.fragment_weight_record_main;
    }

    @Override
    protected void _init(Bundle savedInstanceState) {

    }

    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getCustomerExpect();
    }

    private void _initData(CustomerExpectResult customerExpectResult) {
        CustomerExpectResult.DataBeanX.DataBean data = customerExpectResult.getData().getData();
        double newWeight = data.getNewWeight();
        double initialWeight = data.getInitialWeight();
        double targetWeight = data.getTargetWeight();


        //最新
        tvNewWeight.setText(NumFormatterUtils.getFormatNum(newWeight));
        tvNewDate.setText(TimeUtils.millis2String(data.getNewWeightTime(), TimeUtils.DEFAULT_PATTERN4));
        //初始
        tvInitWeight.setText(NumFormatterUtils.getFormatNum(initialWeight));
        tvDateInit.setText(TimeUtils.millis2String(data.getInitialWeightTime(), TimeUtils.DEFAULT_PATTERN4));
        //目标
        tvTargetWeight.setText(NumFormatterUtils.getFormatNum(targetWeight));
        tvTargetDate.setText(TimeUtils.millis2String(data.getTargetWeightTime(), TimeUtils.DEFAULT_PATTERN4));

        //设置圆圈
        double differenceWeight = newWeight - initialWeight;
        double weightLevel = (initialWeight - newWeight) / (initialWeight - targetWeight) * 100;
        donutProgress.setInnerTopText(WeightUtils.getTargetStatus(differenceWeight));
        donutProgress.setText(NumFormatterUtils.getFormatNum(Math.abs(differenceWeight)));
        donutProgress.setInnerBottomText(getResources().getString(R.string.text_target_weight, targetWeight + ""));
        Log.e("_initData: ", weightLevel + "");
//        donutProgress.setProgress((float) weightLevel);
    }

    @Override
    protected void setToolbar() {
        tvTitle.setText(getString(R.string.title_weight_record));
        toolbar.setBackgroundColor(getResources().getColor(R.color.colorBarWeightRecord));
        BarUtils.setColor(mActivity, getResources().getColor(R.color.colorBarWeightRecord), 0);
    }

    private DialogRecodeWidget dialog;

    @OnClick({R.id.btn_weight_record, R.id.ll_lastest_weight, R.id.ll_init_weight, R.id.ll_target_weight})
    public void doClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.btn_weight_record:
                dialog = DialogRecodeWidget.newInstance(new Bundle());
                dialog.setOnCliclListenser(new DialogRecodeWidget.OnCliclListenser() {
                    @Override
                    public void onClick(int type) {
                        FragmentUtils.showFragmentAddStack(getFragmentManager(), R.id.contain, WeightBleFragment.newInstance());

                    }
                });
                dialog.show(getChildFragmentManager(), DialogRecodeWidget.class.getName());

                break;
            case R.id.ll_lastest_weight:
                FragmentUtils.showFragmentAddStack(getFragmentManager(), R.id.contain, WeightLogFragment.newInstance());
                break;
            case R.id.ll_init_weight:
            case R.id.ll_target_weight:
                FragmentUtils.showFragmentAddStack(getFragmentManager(), R.id.contain, WeightSettingFragment.newInstance());
                break;
        }
    }


    @Override
    protected void onDataSuccessChanged(CustomerExpectResult baseResult) {
        _initData(baseResult);
    }
}
