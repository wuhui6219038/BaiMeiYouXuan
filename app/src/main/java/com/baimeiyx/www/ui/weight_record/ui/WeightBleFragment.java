package com.baimeiyx.www.ui.weight_record.ui;

import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.baimeiyx.www.base.ui.BaseSimpleFragment;
import com.example.mrw.baimeiyouxuan.R;
import com.baimeiyx.www.utils.ConstUtils;

import butterknife.BindView;

public class WeightBleFragment extends BaseSimpleFragment {
    private static final String TAG = "WeightBleFragment";
    public static final String BUNDLE_WEIGHT = "weight";
    public static final String BUNDLE_FAT = "fat";
    public static final String BUNDLE_WATER = "water";
    public static final String BUNDLE_MUSCLE = "muscle";
    public static final String BUNDLE_CALORIES = "calories";
    @BindView(R.id.tv_weight)
    TextView tvWeight;
    @BindView(R.id.tv_fat_num)
    TextView tvFatNum;
    @BindView(R.id.tv_fat_level)
    TextView tvFatLevel;
    @BindView(R.id.tv_water_num)
    TextView tvWaterNum;
    @BindView(R.id.tv_water_level)
    TextView tvWaterLevel;
    @BindView(R.id.tv_muscle_num)
    TextView tvMuscleNum;
    @BindView(R.id.tv_muscle_level)
    TextView tvMuscleLevel;
    @BindView(R.id.tv_calories_num)
    TextView tvCaloriesNum;
    @BindView(R.id.tv_calories_level)
    TextView tvCaloriesLevel;

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
    protected void _init(Bundle savedInstanceState) {

    }

    @Override
    public void onStart() {
        super.onStart();
        _init();
    }

    private void _init() {
        appViewModel.getObserver().observe(mActivity, new Observer<Bundle>() {
            @Override
            public void onChanged(@Nullable Bundle bundle) {
                setWeight(bundle);
            }
        });
    }

    private void setWeight(Bundle data) {
        String weightNum = data.getString(BUNDLE_WEIGHT, ConstUtils.NUM_FORMAT_1);
        String fatNum = data.getString(BUNDLE_FAT, ConstUtils.NUM_FORMAT_1);
        String waterNum = data.getString(BUNDLE_WATER, ConstUtils.NUM_FORMAT_1);
        String muscleNum = data.getString(BUNDLE_MUSCLE, ConstUtils.NUM_FORMAT_1);
        String caloriesNum = data.getString(BUNDLE_CALORIES, ConstUtils.NUM_FORMAT_1);
        tvWeight.setText(weightNum);
        tvFatNum.setText(fatNum);
        tvWaterNum.setText(waterNum);
        tvMuscleNum.setText(muscleNum);
        tvCaloriesNum.setText(caloriesNum);
    }


    @Override
    protected void setToolbar() {
        tvTitle.setText(getString(R.string.title_weight_record));
        toolbar.setBackgroundColor(getResources().getColor(R.color.colorBarWeightRecord));
    }

    @Override
    public void onStop() {
        super.onStop();
        appViewModel.getObserver().removeObservers(mActivity);
    }


}
