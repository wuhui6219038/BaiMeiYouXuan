package com.baimeiyx.www.ui.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baimeiyx.www.base.ui.BaseUserFragment;
import com.baimeiyx.www.service.model.CustomerExpectResult;
import com.baimeiyx.www.utils.ActivityUtils;
import com.baimeiyx.www.utils.BarUtils;
import com.baimeiyx.www.utils.ImageUtils;
import com.baimeiyx.www.utils.myUtils.NumFormatterUtils;
import com.baimeiyx.www.utils.myUtils.SvgUtils;
import com.baimeiyx.www.utils.myUtils.WeightUtils;
import com.baimeiyx.www.widget.HealthPageCardView;
import com.baimeiyx.www.widget.StepView;
import com.baimeiyx.www.widget.circleprogress.ArcProgress;
import com.baimeiyx.www.widget.circleprogress.DonutProgress;
import com.example.mrw.baimeiyouxuan.R;

import butterknife.BindView;
import butterknife.OnClick;

public class HomeFragment extends BaseUserFragment<CustomerExpectResult> implements HealthPageCardView.ItemClickListener {


    @BindView(R.id.ll_bg)
    FrameLayout llBg;
    @BindView(R.id.arc_progress)
    ArcProgress arcProgress;
    @BindView(R.id.stepview)
    StepView stepview;
    @BindView(R.id.tv_search_info)
    TextView tvSearchInfo;
    @BindView(R.id.donut_target_progress)
    DonutProgress donutTargetProgress;
    @BindView(R.id.donut_progress)
    DonutProgress donutProgress;
    @BindView(R.id.health_1)
    HealthPageCardView health_1;
    @BindView(R.id.health_2)
    HealthPageCardView health_2;
    @BindView(R.id.health_3)
    HealthPageCardView health_3;
    private static final String TAG = "HomeFragment";
    private static final String[] STEPTILTE = {"S", "A", "B", "C", "F"};


    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    protected int getViewId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void _init(Bundle savedInstanceState) {
        _init();
    }

    private void _init() {

        ImageUtils.loadBackgroudByUrl(getActivity(), llBg, "https://www.baimeiyx.com/wx-app/cover.png");

        stepview.setStepsTitle(STEPTILTE);
        _initView();
        getCustomerExpect();
    }


    private void _initView() {
        health_1.setItemClickListener(this);
        health_2.setItemClickListener(this);
        health_3.setItemClickListener(this);
    }


    @Override
    public void onStart() {
        super.onStart();

    }


    @Override
    protected void onDataSuccessChanged(CustomerExpectResult baseResult) {
        _initStepView(baseResult);
    }

    private void _initStepView(CustomerExpectResult baseResult) {

        //将客户体重保存
        spUtils.putString(SP_CUSTOMEREXPECT, gson.toJson(baseResult));
        double targetWeight = baseResult.getData().getData().getTargetWeight();
        double newWeight = baseResult.getData().getData().getNewWeight();
        double initialWeight = baseResult.getData().getData().getInitialWeight();
        //已经减肥的质量
        double differenceWeight = newWeight - initialWeight;
        //当前处于的level
        double weightLevel = (initialWeight - newWeight) / (initialWeight - targetWeight) * 100;
        if (weightLevel < 0) {
            weightLevel = 0;
        } else if (weightLevel > 100) {
            weightLevel = 100;
        }
        donutTargetProgress.setText(targetWeight + "");
        arcProgress.setTextValue(NumFormatterUtils.getFormatNum(Math.abs(differenceWeight)));
        arcProgress.setProgress((float) weightLevel);
        arcProgress.setBottomText(WeightUtils.getTargetStatus(differenceWeight));

        //设置进度
        donutProgress.setProgress((float) weightLevel);
        //设置level
        int level = 5 - (int) Math.round(weightLevel / 20);
        stepview.setCheckPos(level >= 5 ? 4 : level);
    }

    @Override
    protected void setToolbar() {
        toolbar.setBackgroundColor(getResources().getColor(R.color.colorBarHome));
        BarUtils.setColor(mActivity, getResources().getColor(R.color.colorBarHome), 0);
        ivBack.setVisibility(View.GONE);
    }


    @Override
    public void onItemClick(int subButtonType) {
        if (subButtonType == getResources().getInteger(R.integer.recode_weight)) {
            ActivityUtils.launchActivity(mActivity, mActivity.getPackageName(), mActivity.getPackageName() + ".ui.WeightRecordActivity");


        } else if (subButtonType == getResources().getInteger(R.integer.weight_loss_tool)) {
            ActivityUtils.launchActivity(mActivity, mActivity.getPackageName(), mActivity.getPackageName() + ".ui.LossToolActivity");

        } else if (subButtonType == getResources().getInteger(R.integer.foods)) {
            ActivityUtils.launchActivity(mActivity, mActivity.getPackageName(), mActivity.getPackageName() + ".ui.HealthFoodsActivity");

        } else if (subButtonType == getResources().getInteger(R.integer.baimei_shop)) {
        } else if (subButtonType == getResources().getInteger(R.integer.super_fight_group)) {

        } else if (subButtonType == getResources().getInteger(R.integer.brand_flash)) {

        }
    }

    @OnClick(R.id.tv_search_info)
    public void doClick(View view) {
        ActivityUtils.launchActivity(mActivity, mActivity.getPackageName(), mActivity.getPackageName() + ".ui.HealthFoodsActivity");

    }
}
