package com.baimeiyx.www.ui.fragment;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baimeiyx.www.base.ui.BaseFragment;
import com.baimeiyx.www.utils.BarUtils;
import com.baimeiyx.www.utils.myUtils.NumFormatterUtils;
import com.baimeiyx.www.utils.myUtils.SvgUtils;
import com.baimeiyx.www.widget.BMILevelVIew;
import com.baimeiyx.www.widget.Sun;
import com.baimeiyx.www.widget.circleprogress.DonutProgress;
import com.example.mrw.baimeiyouxuan.R;
import com.qmuiteam.qmui.widget.roundwidget.QMUIRoundButton;
import com.qmuiteam.qmui.widget.roundwidget.QMUIRoundButtonDrawable;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static com.baimeiyx.www.ui.fragment.LossTooSettingWeightFragment.AGE;
import static com.baimeiyx.www.ui.fragment.LossTooSettingWeightFragment.HEIGHT;
import static com.baimeiyx.www.ui.fragment.LossTooSettingWeightFragment.SEX;
import static com.baimeiyx.www.ui.fragment.LossTooSettingWeightFragment.WEIGHT;
import static com.baimeiyx.www.ui.fragment.LossToolsIntroductionFragment.LOSSTOOLTYPE;

public class LossToolsAnalyseFragment extends BaseFragment {
    public static final String BGCOLOR = "bgColor";
    @BindView(R.id.tv_analyse_title)
    TextView tvAnalyseTitle;
    @BindView(R.id.tv_analyse_sub_title)
    TextView tvAnalyseSubTitle;
    @BindView(R.id.BMI)
    BMILevelVIew BMI;
    @BindView(R.id.ll_analyse)
    LinearLayout llAnalyse;
    @BindView(R.id.ll_manyi)
    LinearLayout llManyi;
    @BindView(R.id.tv_say)
    TextView tvSay;
    @BindView(R.id.btn_more)
    QMUIRoundButton btnMore;
    @BindView(R.id.btn_share)
    QMUIRoundButton btnShare;
    @BindView(R.id.donut_progress)
    DonutProgress donutProgress;
    @BindView(R.id.sun)
    Sun sun;
    @BindView(R.id.iv_water)
    ImageView ivWater;
    private int backgroudId;
    private float weight, stature;
    private int type, age, sex;
    private Bundle data;
    private float BMIValue;

    public static LossToolsAnalyseFragment newInstance(Bundle args) {

        LossToolsAnalyseFragment fragment = new LossToolsAnalyseFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void setToolbar() {
        toolbar.setBackgroundColor(backgroudId);
        BarUtils.setColor(mActivity, backgroudId, 0);
        llAnalyse.setBackgroundColor(backgroudId);
        tvTitle.setText("测试结果");

    }

    @Override
    protected int getViewId() {
        return R.layout.fragment_loss_tool_analyse_result;
    }

    @Override
    protected void _init(Bundle savedInstanceState) {
        data = getArguments();
        backgroudId = data.getInt(BGCOLOR);
        stature = data.getFloat(HEIGHT);
        age = data.getInt(AGE);
        sex = data.getInt(SEX);
        weight = data.getFloat(WEIGHT);
        _initView();
        _initPage();

    }

    private void _initView() {
        String str3 = "<h1>&#58915;</h1>给好友也测一下吧";
        btnShare.setText(Html.fromHtml(str3));
        tvSay.setTextColor(backgroudId);
        btnShare.setTextColor(backgroudId);
        ((QMUIRoundButtonDrawable) btnMore.getBackground()).setBgData(ColorStateList.valueOf(backgroudId));
        ((QMUIRoundButtonDrawable) btnMore.getBackground()).setStrokeData(2, ColorStateList.valueOf(backgroudId));
        ((QMUIRoundButtonDrawable) btnShare.getBackground()).setStrokeData(2, ColorStateList.valueOf(backgroudId));
        SvgUtils.setIcon(mActivity, btnShare, "iconfont.ttf");

    }


    private void _initPage() {
        type = data.getInt(LOSSTOOLTYPE);
        String title = null, subTitle = null;
        switch (type) {
            case R.drawable.ic_loss_tool_1:
            case R.drawable.ic_loss_tool_2:
                _initBMI();
                title = getResources().getString(R.string.text_loss_tool_analyse_1, NumFormatterUtils.getFormatNum(BMIValue));
                subTitle = getResources().getString(R.string.text_loss_tool_analyse_sub_1);
                break;
            case R.drawable.ic_loss_tool_3:
                _initWeight();
                title = getResources().getString(R.string.text_loss_tool_analyse_2);
                ivWater.setVisibility(View.VISIBLE);
                break;
            case R.drawable.ic_loss_tool_4:
                _initBMR();
                title = getResources().getString(R.string.text_loss_tool_analyse_3);
                ivWater.setVisibility(View.VISIBLE);
                break;
            case R.drawable.ic_loss_tool_5:
                _initHealthWeight();
                title = getResources().getString(R.string.text_loss_tool_analyse_4);
                ivWater.setVisibility(View.VISIBLE);
                break;
            case R.drawable.ic_loss_tool_6:
                _initHeartBeat();
                ivWater.setVisibility(View.VISIBLE);
                title = getResources().getString(R.string.text_loss_tool_analyse_5);
                break;
        }
        if (TextUtils.isEmpty(subTitle)) {
            tvAnalyseSubTitle.setVisibility(View.GONE);
        } else {
            tvAnalyseSubTitle.setText(subTitle);
        }
        tvAnalyseTitle.setText(title);


    }

    private void _initBMI() {
        BMI.setVisibility(View.VISIBLE);
        BMIValue = (weight / (stature / 100 * stature / 100) * 10) / 10;
        //笑脸个数
        int smailCount = BMIValue < 18.5 ? 3 : BMIValue < 24 ? 4 : BMIValue < 28 ? 1 : 0;
        float pec = BMIValue < 18.5 ? 22.5f : BMIValue < 24 ? 67.4f : BMIValue < 28 ? 112.5f : 157.5f;
        int msgId = BMIValue < 18.5 ? R.string.text_loss_tool_analyse_say3 : BMIValue < 24 ? R.string.text_loss_tool_analyse_say : R.string.text_loss_tool_analyse_say2;
        BMI.setRotateDegress(pec);
        tvSay.setText(getResources().getString(msgId));
        _initManYi(smailCount, 4);

    }

    private void _initWeight() {
        donutProgress.setVisibility(View.VISIBLE);
        float weightNum;
        if (sex == 0) {
            //女
            weightNum = (stature - 70) * 0.6f;
        } else {
            weightNum = (stature - 80) * 0.7f;
        }
        _initDonutProgress(weightNum);
        int smailCount = weightNum < 40 ? 1 : weightNum <= 50 ? 2 : weightNum <= 60 ? 3 : weightNum <= 70 ? 4 : weightNum <= 100 ? 5 : 0;
        _initManYi(smailCount, 5);
    }

    private void _initBMR() {
        sun.setVisibility(View.VISIBLE);
        float calorieNumbers;
        if (sex == 0) {
            //女
            calorieNumbers = 655 + (9.6f * weight) + (1.7f * stature) - (4.7f * age);
        } else {
            calorieNumbers = 66 + (13.7f * weight) + (5.0f * stature) - (6.8f * age);
        }
        sun.setText(NumFormatterUtils.getFormatNum(calorieNumbers));
        sun.setButtomText("大卡");


    }

    private void _initHealthWeight() {
        donutProgress.setVisibility(View.VISIBLE);
        int weightNum = (int) ((stature - 70) * 0.6);
        donutProgress.setInnerTopText("kg");
        donutProgress.setText(weightNum + "~" + (weightNum + 10));
        donutProgress.setInnerBottomText("1KG=2斤");
        donutProgress.setProgress(weightNum);
        int smailCount = weightNum < 40 ? 1 : weightNum <= 50 ? 2 : weightNum <= 60 ? 3 : weightNum <= 70 ? 4 : weightNum <= 100 ? 5 : 0;
        _initManYi(smailCount, 5);
    }

    private void _initHeartBeat() {
        sun.setVisibility(View.VISIBLE);
        int heatRateMax = (int) ((220 - age) * 0.8);
        int heatRateMin = (int) ((220 - age) * 0.6);
        sun.setText(heatRateMin + "~" + heatRateMax);
        sun.setButtomText("次/分钟");
    }

    private void _initDonutProgress(float weightNum) {
        donutProgress.setInnerBottomText("1KG=2斤");
        donutProgress.setText(NumFormatterUtils.getFormatNum(weightNum));
        donutProgress.setProgress(weight / weightNum * 100);
    }

    private void _initManYi(int smailCount, int total) {
        for (int i = 0; i < total; i++) {
            ImageView imageView = new ImageView(mActivity);
            if (i < smailCount) {
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_xiaolianmanyifuwu_2));
            } else {
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_xiaolianmanyifuwu));
            }
            llManyi.addView(imageView);
        }
    }


}
