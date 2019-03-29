package com.baimeiyx.www.ui.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.baimeiyx.www.base.ui.BaseFragment;
import com.baimeiyx.www.utils.BarUtils;
import com.baimeiyx.www.utils.myUtils.FragmentUtils;
import com.baimeiyx.www.utils.myUtils.SvgUtils;
import com.baimeiyx.www.widget.Ruler;
import com.example.mrw.baimeiyouxuan.R;

import butterknife.BindView;
import butterknife.OnClick;

import static com.baimeiyx.www.ui.fragment.LossTooSettingWeightFragment.AGE;
import static com.baimeiyx.www.ui.fragment.LossTooSettingWeightFragment.HEIGHT;
import static com.baimeiyx.www.ui.fragment.LossTooSettingWeightFragment.SEX;

public class LossToolCalculateFragment extends BaseFragment {
    /**
     * 背景色
     */
    public static final String BGCOLOR = "bgColor";
    public static final String TITLE = "title";
    @BindView(R.id.rb_man)
    RadioButton rbMan;
    @BindView(R.id.rb_woman)
    RadioButton rbWoman;
    @BindView(R.id.ll_content)
    LinearLayout llContent;
    @BindView(R.id.tv_next)
    TextView tvNext;
    @BindView(R.id.tv_height)
    TextView tvHeight;
    @BindView(R.id.rv_height)
    Ruler rvHeight;
    @BindView(R.id.text_age)
    TextView textAge;
    @BindView(R.id.tv_age)
    TextView tvAge;
    @BindView(R.id.rv_age)
    Ruler rvAge;
    private int backgroudId;
    private String title;
    private int sex;
    private float height;
    private int age;
    private Bundle data;

    public static LossToolCalculateFragment newInstance(Bundle args) {

        LossToolCalculateFragment fragment = new LossToolCalculateFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void setToolbar() {
        toolbar.setBackgroundColor(backgroudId);
        BarUtils.setColor(mActivity, backgroudId, 0);
        llContent.setBackgroundColor(backgroudId);
        tvNext.setTextColor(backgroudId);
        tvTitle.setText(title);
    }

    @Override
    protected int getViewId() {
        return R.layout.fragment_loss_tool_calculate;
    }

    @Override
    protected void _init(Bundle savedInstanceState) {
        SvgUtils.setIcon(mActivity, rbMan, "iconfont.ttf");
        SvgUtils.setIcon(mActivity, rbWoman, "iconfont.ttf");
        data = getArguments();
        backgroudId = data.getInt(BGCOLOR);
        title = data.getString(TITLE);
        _initValue();

    }

    private void _initValue() {
        tvAge.setText((int) rvAge.getDefaultChooseValue() + "岁");
        tvHeight.setText(rvHeight.getDefaultChooseValue() + "厘米");
        rvAge.setOnValueChangeListener(new Ruler.OnValueChangeListener() {
            @Override
            public void onValueChange(double size) {
                tvAge.setText((int) size + "岁");
            }
        });
        rvHeight.setOnValueChangeListener(new Ruler.OnValueChangeListener() {
            @Override
            public void onValueChange(double size) {
                tvHeight.setText(size + "厘米");
            }
        });
    }

    @OnClick(R.id.tv_next)
    public void doClick(View view) {
        sex = rbWoman.isChecked() ? 0 : 1;
        age = (int) rvAge.getDefaultChooseValue();
        height = rvHeight.getDefaultChooseValue();
        data.putInt(SEX, sex);
        data.putFloat(HEIGHT, height);
        data.putInt(AGE, age);
        FragmentUtils.showFragmentAddStack(getFragmentManager(), R.id.contain, LossTooSettingWeightFragment.newInstance(data));
    }

}
