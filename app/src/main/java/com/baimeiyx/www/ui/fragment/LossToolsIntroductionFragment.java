package com.baimeiyx.www.ui.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baimeiyx.www.base.ui.BaseFragment;
import com.baimeiyx.www.utils.BarUtils;
import com.baimeiyx.www.utils.myUtils.FragmentUtils;
import com.example.mrw.baimeiyouxuan.R;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 减肥工具的介绍
 */
public class LossToolsIntroductionFragment extends BaseFragment {
    public static final String LOSSTOOLTYPE = "lossTool";
    /**
     * 一分钟了解自己
     */
    public static final int LOSSTOOLTYPE_1 = 1;
    /**
     * BMI
     */
    public static final int LOSSTOOLTYPE_2 = 2;
    /**
     * 体重计算
     */
    public static final int LOSSTOOLTYPE_3 = 3;
    /**
     * 基础新陈代谢
     */
    public static final int LOSSTOOLTYPE_4 = 4;
    /**
     * 健康体重范围
     */
    public static final int LOSSTOOLTYPE_5 = 5;
    /**
     * 燃脂运动计算
     */
    public static final int LOSSTOOLTYPE_6 = 6;
    @BindView(R.id.iv_banner)
    ImageView ivBanner;

    @BindView(R.id.tv_sub_title)
    TextView tvSubTitle;
    @BindView(R.id.tv_introduce)
    TextView tvIntroduce;
    @BindView(R.id.tv_detail)
    TextView tvDetail;
    @BindView(R.id.ll_content)
    LinearLayout llContent;
    @BindView(R.id.btn_calculate)
    Button btnCalculate;
    private int lossToolType;
    private String title, subTitle, introduce, detail;
    private int bannerId, backgroudId;

    public static LossToolsIntroductionFragment newInstance(Bundle args) {

        LossToolsIntroductionFragment fragment = new LossToolsIntroductionFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void setToolbar() {
        tvTitle.setText(title);
        toolbar.setBackgroundColor(backgroudId);
        BarUtils.setColor(mActivity, backgroudId, 0);
        llContent.setBackgroundColor(backgroudId);
        btnCalculate.setTextColor(backgroudId);
    }

    @Override
    protected int getViewId() {
        return R.layout.fragment_loss_tool_introduce;
    }

    @Override
    protected void _init(Bundle savedInstanceState) {
        lossToolType = getArguments().getInt(LOSSTOOLTYPE);
        switch (lossToolType) {
            case R.drawable.ic_loss_tool_1:
                title = getString(R.string.title_loss_tool_introduce_1);
                subTitle = getString(R.string.text_loss_tool_subTitle_1);
                introduce = getString(R.string.text_loss_tool_introduce_1);
                detail = getString(R.string.text_loss_tool_detail_1);
                bannerId = R.drawable.ic_loss_tool_1;
                backgroudId = Color.parseColor("#f8ad6c");
                break;
            case R.drawable.ic_loss_tool_2:
                title = getString(R.string.title_loss_tool_introduce_2);
                subTitle = getString(R.string.text_loss_tool_subTitle_2);
                introduce = getString(R.string.text_loss_tool_introduce_2);
                detail = getString(R.string.text_loss_tool_detail_2);
                bannerId = R.drawable.ic_loss_tool_2;
                backgroudId = Color.parseColor("#85b8fa");
                break;
            case R.drawable.ic_loss_tool_3:
                title = getString(R.string.title_loss_tool_introduce_3);
                subTitle = getString(R.string.text_loss_tool_subTitle_3);
                introduce = getString(R.string.text_loss_tool_introduce_3);
                detail = getString(R.string.text_loss_tool_detail_3);
                bannerId = R.drawable.ic_loss_tool_3;
                backgroudId = Color.parseColor("#ff87bd");

                break;
            case R.drawable.ic_loss_tool_4:
                title = getString(R.string.title_loss_tool_introduce_4);
                subTitle = getString(R.string.text_loss_tool_subTitle_4);
                introduce = getString(R.string.text_loss_tool_introduce_4);
                detail = getString(R.string.text_loss_tool_detail_4);
                bannerId = R.drawable.ic_loss_tool_4;
                backgroudId = Color.parseColor("#75ea88");

                break;
            case R.drawable.ic_loss_tool_5:
                title = getString(R.string.title_loss_tool_introduce_5);
                subTitle = getString(R.string.text_loss_tool_subTitle_5);
                introduce = getString(R.string.text_loss_tool_introduce_5);
                detail = getString(R.string.text_loss_tool_detail_5);
                bannerId = R.drawable.ic_loss_tool_5;
                backgroudId = Color.parseColor("#9f8ae9");
                break;
            case R.drawable.ic_loss_tool_6:
                title = getString(R.string.title_loss_tool_introduce_6);
                subTitle = getString(R.string.text_loss_tool_subTitle_6);
                introduce = getString(R.string.text_loss_tool_introduce_6);
                detail = getString(R.string.text_loss_tool_detail_6);
                bannerId = R.drawable.ic_loss_tool_6;
                backgroudId = Color.parseColor("#6acbeb");

                break;


        }
        tvSubTitle.setText(subTitle);
        tvDetail.setText(detail);
        tvIntroduce.setText(introduce);
        ivBanner.setImageDrawable(getResources().getDrawable(bannerId));
    }


    @OnClick(R.id.btn_calculate)
    public void onViewClicked() {
        Bundle data = new Bundle();
        data.putInt(LossToolCalculateFragment.BGCOLOR,backgroudId);
        data.putString(LossToolCalculateFragment.TITLE,subTitle);
        FragmentUtils.showFragmentAddStack(getFragmentManager(), R.id.contain, LossToolCalculateFragment.newInstance(data));
    }
}
