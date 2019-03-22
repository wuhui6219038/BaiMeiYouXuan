package com.baimeiyx.www.ui.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baimeiyx.www.base.ui.BaseFragment;
import com.baimeiyx.www.service.model.QingNiuBean;
import com.baimeiyx.www.utils.BarUtils;
import com.baimeiyx.www.utils.ToastUtils;
import com.baimeiyx.www.utils.myUtils.NumFormatterUtils;
import com.baimeiyx.www.widget.CiecleLoading;
import com.baimeiyx.www.widget.LineLevelView;
import com.baimeiyx.www.widget.qingniu.QingNiuUtils;
import com.example.mrw.baimeiyouxuan.R;

import java.util.Random;

import butterknife.BindView;
import butterknife.OnClick;

public class WeightBleFragment extends BaseFragment {
    private static final String TAG = "WeightBleFragment";
    public static final String BUNDLE_WEIGHT = "weight";
    public static final String BUNDLE_FAT = "fat";
    public static final String BUNDLE_WATER = "water";
    public static final String BUNDLE_MUSCLE = "muscle";
    public static final String BUNDLE_CALORIES = "calories";
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_status)
    TextView tvStatus;
    @BindView(R.id.iv_refresh)
    ImageView ivRefresh;
    @BindView(R.id.tv_health_score)
    TextView tvHealthScore;
    @BindView(R.id.tv_health_score2)
    TextView tvHealthScore2;
    @BindView(R.id.cl_load)
    CiecleLoading clLoad;
    @BindView(R.id.btn_record)
    Button btnRecord;
    @BindView(R.id.ll_ble_result)
    LinearLayout llBleResult;
    @BindView(R.id.ll_score)
    LinearLayout llScore;


    ImageView ivType;
    TextView title;
    TextView tvValue;
    TextView tvValueUnit;
    CheckBox btnShowMore;
    TextView tvDistanceText;
    TextView tvResult;
    TextView tvResultInfo;
    LinearLayout llLevelInfo;
    LineLevelView lineLevelView;
    private Handler handler;
    private QingNiuUtils qingNiuUtils;

    public static WeightBleFragment newInstance() {

        Bundle args = new Bundle();
        WeightBleFragment fragment = new WeightBleFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected int getViewId() {
        return R.layout.fragment_blue_tooth_detail;
    }

    @Override
    protected void setToolbar() {
        toolbar.setBackgroundColor(getResources().getColor(R.color.colorBarWeightRecord));
        BarUtils.setColor(mActivity, getResources().getColor(R.color.colorBarWeightRecord), 0);
    }


    @Override
    protected void _init(Bundle savedInstanceState) {
        qingNiuUtils = new QingNiuUtils();
        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (msg.what == 1) {
                    readValue();
                } else {
                    clLoad.setText(NumFormatterUtils.getFormatNum(new Random().nextDouble() * 150.5 + 1));
                }
            }
        };
    }

    private void addHealthItem() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.item_qingniu_result, null, false);

        _initItem(view);
    }


    private void _initItem(View view) {
        lineLevelView = view.findViewById(R.id.linelevelview);
        ivType = view.findViewById(R.id.iv_type);
        title = view.findViewById(R.id.title);
        tvValue = view.findViewById(R.id.tv_value);
        tvValueUnit = view.findViewById(R.id.tv_value_unit);
        tvDistanceText = view.findViewById(R.id.tv_distance_text);
        tvResult = view.findViewById(R.id.tv_result);
        tvResultInfo = view.findViewById(R.id.tv_result_info);
        llLevelInfo = view.findViewById(R.id.ll_level_info);
        btnShowMore = view.findViewById(R.id.btn_show_more);
        _initItemValue(18.4f);
        llBleResult.addView(view, llBleResult.getChildCount());

    }

    private void _initItemValue(float value) {
        QingNiuBean qingNiuBean = qingNiuUtils.getBMI(value, 1);
        lineLevelView.setValue(qingNiuBean);
        tvValue.setText(value + "");
        tvValueUnit.setText(qingNiuBean.getUnit());
        tvDistanceText.setText(qingNiuBean.getOffsetInfo());
        tvResult.setText(qingNiuBean.getLevelMsg());
        tvResultInfo.setText(qingNiuBean.getInfo());
        ivType.setImageDrawable(getResources().getDrawable(qingNiuBean.getTypeImg()));
        tvTitle.setText(qingNiuBean.getTypeName());
        if (qingNiuBean.getStatusImgId() != 0) {
            tvResult.setBackground(getResources().getDrawable(qingNiuBean.getStatusImgId()));
            tvResult.setTextColor(getResources().getColor(qingNiuBean.getStatusTextColor()));

        }
        btnShowMore.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                llLevelInfo.setVisibility(View.VISIBLE);
            } else {
                llLevelInfo.setVisibility(View.GONE);
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        test();
    }

    private void test() {
        handler.sendEmptyMessageDelayed(1, 1000);
        sendValue();
        addHealthItem();
    }

    Runnable runnable;

    private void sendValue() {
        runnable = new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub  
                //要做的事情，这里再次调用此Runnable对象，以实现每两秒实现一次的定时器操作  

                handler.sendEmptyMessage(2);
                handler.postDelayed(this, 500);
            }
        };

        handler.postDelayed(runnable, 500);

    }

    private void readValue() {
        tvStatus.setText("正在测量");
        llScore.setVisibility(View.GONE);
        clLoad.setVisibility(View.VISIBLE);
        clLoad.start();


    }

    @Override
    public void onPause() {
        super.onPause();
        handler.removeCallbacks(runnable);
    }

    @OnClick({R.id.iv_refresh, R.id.btn_record})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_refresh:
                ToastUtils.showShortToast("请上称");
                break;
            case R.id.btn_record:
                break;
        }
    }
//


}
