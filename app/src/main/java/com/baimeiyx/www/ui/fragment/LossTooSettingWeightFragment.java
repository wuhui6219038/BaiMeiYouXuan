package com.baimeiyx.www.ui.fragment;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.baimeiyx.www.base.ui.BaseFragment;
import com.baimeiyx.www.utils.BarUtils;
import com.baimeiyx.www.utils.myUtils.SvgUtils;
import com.baimeiyx.www.widget.Ruler;
import com.example.mrw.baimeiyouxuan.R;

import butterknife.BindView;

public class LossTooSettingWeightFragment extends BaseFragment {
    /**
     * 背景色
     */
    public static final String BGCOLOR = "bgColor";
    public static final String TITLE = "title";
    @BindView(R.id.ll_content)
    LinearLayout llContent;
    @BindView(R.id.tv_submit)
    TextView tvSubMit;
    @BindView(R.id.tv_weight)
    TextView tvWeight;
    @BindView(R.id.rv_weight)
    Ruler rvWeight;
    private int backgroudId;
    private String title;

    public static LossTooSettingWeightFragment newInstance(Bundle args) {

        LossTooSettingWeightFragment fragment = new LossTooSettingWeightFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void setToolbar() {
        toolbar.setBackgroundColor(backgroudId);
        BarUtils.setColor(mActivity, backgroudId, 0);
        llContent.setBackgroundColor(backgroudId);
        tvSubMit.setTextColor(backgroudId);
        tvTitle.setText(title);
    }

    @Override
    protected int getViewId() {
        return R.layout.fragment_loss_tool_weight;
    }

    @Override
    protected void _init(Bundle savedInstanceState) {
        backgroudId = getArguments().getInt(BGCOLOR);
        title = getArguments().getString(TITLE);
        _initValue();

    }

    private void _initValue() {
        tvWeight.setText((int) rvWeight.getDefaultChooseValue() + "Kg");
        rvWeight.setOnValueChangeListener(new Ruler.OnValueChangeListener() {
            @Override
            public void onValueChange(double size) {
                tvWeight.setText(size + "Kg");
            }
        });

    }

}
