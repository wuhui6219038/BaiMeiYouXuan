package com.baimeiyx.www.view.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.baimeiyx.www.base.ui.BaseUserFragment;
import com.baimeiyx.www.constant.Constant;
import com.baimeiyx.www.service.model.BaseResult;
import com.baimeiyx.www.service.model.CustomerExpectResult;
import com.baimeiyx.www.service.repository.DataManager;
import com.baimeiyx.www.service.rxjava.DialogSubscribe;
import com.baimeiyx.www.service.rxjava.RetryExceptionObservable;
import com.baimeiyx.www.service.rxjava.RxJavaUtils;
import com.baimeiyx.www.utils.BarUtils;
import com.baimeiyx.www.utils.TimeUtils;
import com.bigkoo.pickerview.builder.OptionsPickerBuilder;
import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.OptionsPickerView;
import com.bigkoo.pickerview.view.TimePickerView;
import com.example.mrw.baimeiyouxuan.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 信息晚上
 */
public class WeightSettingFragment extends BaseUserFragment {
    @BindView(R.id.tv_sex)
    TextView tvSex;
    @BindView(R.id.tv_height)
    TextView tvHeight;
    @BindView(R.id.tv_age)
    TextView tvAge;
    @BindView(R.id.tv_init_weight)
    TextView tvInitWeight;
    @BindView(R.id.tv_target_weight)
    TextView tvTargetWeight;
    @BindView(R.id.tv_target_date)
    TextView tvTargetDate;
    @BindView(R.id.tv_waistline)
    TextView tvWaistline;
    @BindView(R.id.tv_hip_circumference)
    TextView tvHipCircumference;
    @BindView(R.id.btn_save)
    TextView btnSave;
    private TimePickerView pvTime;
    private OptionsPickerView optionsPicker;
    List<String> sex = new ArrayList<>();
    //点击的textview
    private TextView mTv;

    public static WeightSettingFragment newInstance() {

        Bundle args = new Bundle();

        WeightSettingFragment fragment = new WeightSettingFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getViewId() {
        return R.layout.fragment_weight_setting;
    }

    @Override
    protected void _init(Bundle savedInstanceState) {

        _initOptionsPicker();
    }

    private void _initDatePicker(Date defDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(defDate);
        pvTime = new TimePickerBuilder(mActivity, new OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {
                tvTargetDate.setText(TimeUtils.date2String(date, TimeUtils.DEFAULT_PATTERN5));
            }
        }).setDate(calendar).build();

    }

    private void _initOptionsPicker() {
        optionsPicker = new OptionsPickerBuilder(mActivity, new OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                tvSex.setText(sex.get(options1));
            }
        }).build();
        //1男2女
        sex.add("女");
        sex.add("男");
        optionsPicker.setNPicker(sex, null, null);
    }

    @Override
    public void onStart() {
        super.onStart();
        getCustomerExpect();
    }


    private void _initValue(CustomerExpectResult customerExpectResult) {
        CustomerExpectResult.DataBeanX.DataBean data = customerExpectResult.getData().getData();
        tvSex.setText(data.getSex() == null ? "女" : data.getSex().equals("1") ? "男" : "女");
        tvHeight.setText(data.getStature() + "");
        tvAge.setText(data.getAge() + "");
        tvInitWeight.setText(data.getInitialWeight() + "");
        tvTargetWeight.setText(data.getTargetWeight() + "");
        tvTargetDate.setText(TimeUtils.millis2String(data.getTargetWeightTime(), TimeUtils.DEFAULT_PATTERN5));
        tvWaistline.setText(data.getWaistLine() + "");
        tvHipCircumference.setText(data.getHipLine() + "");
        _initDatePicker(TimeUtils.millis2Date(data.getTargetWeightTime()));
    }

    @Override
    protected void setToolbar() {
        tvTitle.setText(getResources().getString(R.string.title_complete_userinfo));
        toolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        BarUtils.setColor(mActivity, getResources().getColor(R.color.colorPrimary), 0);
    }

    private String defValue;
    private String dialogTitle;

    @OnClick({R.id.ll_sex, R.id.ll_height, R.id.ll_age, R.id.ll_init_weight, R.id.ll_target_weight, R.id.ll_target_date, R.id.ll_waistline, R.id.ll_hip_circumference, R.id.btn_save})
    public void onViewClicked(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.ll_height:
                mTv = tvHeight;
                defValue = tvHeight.getText().toString();
                dialogTitle = getResources().getString(R.string.text_height);
                break;
            case R.id.ll_age:
                mTv = tvAge;
                defValue = tvAge.getText().toString();
                dialogTitle = getResources().getString(R.string.text_age);
                break;
            case R.id.ll_init_weight:
                mTv = tvInitWeight;
                defValue = tvInitWeight.getText().toString();
                dialogTitle = getResources().getString(R.string.text_original_weight);
                break;
            case R.id.ll_target_weight:
                mTv = tvTargetWeight;
                defValue = tvTargetWeight.getText().toString();
                dialogTitle = getResources().getString(R.string.text_target_weight_2);
                break;
            case R.id.ll_waistline:
                mTv = tvWaistline;
                defValue = tvWaistline.getText().toString();
                dialogTitle = getResources().getString(R.string.text_waistline);
                break;
            case R.id.ll_hip_circumference:
                mTv = tvHipCircumference;
                defValue = tvHipCircumference.getText().toString();
                dialogTitle = getResources().getString(R.string.text_hip_circumference);
                break;
            case R.id.ll_target_date:
                pvTime.show();
                break;
            case R.id.ll_sex:
                optionsPicker.show();
                break;
            case R.id.btn_save:
                commitUpdate();
                break;
        }
        if (id != R.id.ll_target_date && id != R.id.ll_sex && id != R.id.btn_save) {
            showInputDiaLog(defValue, dialogTitle);
        }

    }

    private void commitUpdate() {
        Map<String, String> map = new HashMap<>();
        map.put("initialWeight", tvInitWeight.getText().toString());
        map.put("initialWeightTime", TimeUtils.getNowTimeString(TimeUtils.DEFAULT_PATTERN));
        map.put("waistLine", tvWaistline.getText().toString());
        map.put("hipLine", tvHipCircumference.getText().toString());
        map.put("stature", tvHeight.getText().toString());
        map.put("age", tvAge.getText().toString());
        map.put("sex", tvAge.getText().equals("男") ? "1" : "2");
        map.put("targetWeight", tvTargetWeight.getText().toString());
        map.put("targetWeightTime", tvTargetDate.getText().toString() + " 00:00:00");

        DataManager.getBaiMeiApiService().doUpdateWeight(spUtils.getString(Constant.SP_SESSION_ID), map)
                .retryWhen(new RetryExceptionObservable())
                .compose(RxJavaUtils.rxSchedulerHelper())
                .subscribe(new DialogSubscribe<BaseResult>(mActivity) {
                    @Override
                    public void dataSuccess(BaseResult data) {
                        onDataSuccessChanged(data);
                    }
                });
//        mDataViewModel.doUpdateWeight(map).observe(this, this);
    }

    @Override
    protected void onDataSuccessChanged(BaseResult baseResult) {
        if (baseResult instanceof CustomerExpectResult) {
            _initValue((CustomerExpectResult) baseResult);
        } else {
            getFragmentManager().popBackStack();
        }
    }

}
