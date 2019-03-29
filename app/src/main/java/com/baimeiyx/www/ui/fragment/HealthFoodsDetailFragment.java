package com.baimeiyx.www.ui.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baimeiyx.www.base.ui.BaseUserFragment;
import com.baimeiyx.www.service.model.FoodElementDetailResult;
import com.baimeiyx.www.service.repository.DataManager;
import com.baimeiyx.www.service.rxjava.DialogSubscribe;
import com.baimeiyx.www.service.rxjava.RetryExceptionObservable;
import com.baimeiyx.www.service.rxjava.RxJavaUtils;
import com.baimeiyx.www.ui.ShowImgActivity;
import com.baimeiyx.www.utils.ActivityUtils;
import com.baimeiyx.www.utils.BarUtils;
import com.baimeiyx.www.utils.ImageUtils;
import com.baimeiyx.www.utils.myUtils.FragmentUtils;
import com.baimeiyx.www.utils.myUtils.NumFormatterUtils;
import com.baimeiyx.www.widget.circleprogress.DonutProgress;
import com.example.mrw.baimeiyouxuan.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;

import static com.baimeiyx.www.ui.fragment.HealthFoodsElementDetailFragment.DATA;

public class HealthFoodsDetailFragment extends BaseUserFragment<FoodElementDetailResult> {
    public static final String FOODSELEMENTID = "foodsElementFoods";
    @BindView(R.id.iv_foods_detail_img)
    ImageView ivFoodsDetailImg;
    @BindView(R.id.tv_foods_detail_title)
    TextView tvFoodsDetailTitle;
    @BindView(R.id.tv_foods_detail_nutrientElement)
    TextView tvFoodsDetailNutrientElement;
    @BindView(R.id.ll_element)
    LinearLayout llElement;
    @BindView(R.id.tv_num)
    TextView tvNum;
    @BindView(R.id.tv_unit)
    TextView tvUnit;
    @BindView(R.id.dp_pr)
    DonutProgress dpPr;
    @BindView(R.id.dp_fat)
    DonutProgress dpFat;
    @BindView(R.id.dp_water)
    DonutProgress dpWater;
    @BindView(R.id.tv_baiming_recommend)
    TextView tvBaimingRecommend;
    @BindView(R.id.tv_pr_quality)
    TextView tvPrQuality;
    @BindView(R.id.tv_pr_info)
    TextView tvPrInfo;
    @BindView(R.id.tv_fat_quality)
    TextView tvFatQuality;
    @BindView(R.id.tv_fat_info)
    TextView tvFatInfo;
    @BindView(R.id.tv_water_quality)
    TextView tvWaterQuality;
    @BindView(R.id.tv_water_info)
    TextView tvWaterInfo;
    private int id;
    private float heatQuantity;
    private String imgUrl;
    private FoodElementDetailResult.PageBean pageBean;

    public static HealthFoodsDetailFragment newInstance(Bundle args) {


        HealthFoodsDetailFragment fragment = new HealthFoodsDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected void setToolbar() {
        tvTitle.setText("食物详情");
        tvTitle.setTextColor(Color.BLACK);
        toolbar.setBackgroundColor(Color.WHITE);
        BarUtils.setColor(mActivity, Color.WHITE, 0);
    }

    @Override
    protected int getViewId() {
        return R.layout.fragment_foods_detail;
    }

    @Override
    protected void _init(Bundle savedInstanceState) {
        id = getArguments().getInt(FOODSELEMENTID);
        ivFoodsDetailImg.setOnClickListener((view) -> {
            Bundle data = new Bundle();
            data.putString(ShowImgActivity.IMGURL, imgUrl);
            ActivityUtils.launchActivity(mActivity, mActivity.getPackageName(), mActivity.getPackageName() + ".ui.ShowImgActivity", data);

        });
    }

    private void getElementDetail() {
        DataManager.getBaiMeiApiService().getCategoryByElementDetail(spUtils.getString(SP_SESSION_ID), id)
                .retryWhen(new RetryExceptionObservable())
                .compose(RxJavaUtils.rxSchedulerHelper())
                .subscribe(new DialogSubscribe<FoodElementDetailResult>(mActivity) {
                    @Override
                    public void dataSuccess(FoodElementDetailResult data) {
                        onDataSuccessChanged(data);
                    }
                });
    }

    @Override
    protected void onDataSuccessChanged(FoodElementDetailResult baseResult) {
        pageBean = baseResult.getPage();

        imgUrl = pageBean.getFoodImg();
        ImageUtils.loadImgSrcByUrlCorner(mActivity, ivFoodsDetailImg, pageBean.getFoodImg());
        heatQuantity = Float.parseFloat(pageBean.getHeatQuantity());
        tvFoodsDetailTitle.setText(pageBean.getFoodName());
        tvFoodsDetailNutrientElement.setText(heatQuantity + "");
        tvBaimingRecommend.setText(pageBean.getCommentX());

        _initNutrient(pageBean.getNutrientContent());
        _initElementDetail(pageBean);
    }

    private void _initNutrient(String nutrientContent) {
        List<String> nutrients = new ArrayList<>();
        nutrients.addAll(Arrays.asList(nutrientContent.split(",")));
        llElement.removeAllViewsInLayout();
        for (String nutrient : nutrients) {
            if (!TextUtils.isEmpty(nutrient)) {
                TextView tv = (TextView) getLayoutInflater().inflate(R.layout.item_foods_element, llElement, false);
                tv.setText(nutrient);
                llElement.addView(tv);
            }
        }
    }

    private void _initElementDetail(FoodElementDetailResult.PageBean pageBean) {
        tvNum.setText(heatQuantity + "");
        tvUnit.setText("千卡");
        tvFatQuality.setText(pageBean.getFats());
        tvPrQuality.setText(pageBean.getProteins());
        tvWaterQuality.setText(pageBean.getCarbohydrates());
        float pr = Float.parseFloat(pageBean.getProteins());
        float fat = Float.parseFloat(pageBean.getFats());
        float water = Float.parseFloat(pageBean.getCarbohydrates());
        tvPrInfo.setText((pr <= 30 ? "低" : (pr <= 60 ? "中" : "高")) + "蛋白");
        tvFatInfo.setText((fat <= 30 ? "低" : (fat <= 60 ? "中" : "高") + "脂肪"));

        dpPr.setDonut_progress(NumFormatterUtils.getFormatNum(pr));
        dpFat.setDonut_progress(NumFormatterUtils.getFormatNum(fat));
        dpWater.setDonut_progress(NumFormatterUtils.getFormatNum(water));
        dpPr.setInnerBottomText(NumFormatterUtils.getFormatNum(pr) + "%");
        dpFat.setInnerBottomText(NumFormatterUtils.getFormatNum(fat) + "%");
        dpWater.setInnerBottomText(NumFormatterUtils.getFormatNum(water) + "%");

    }

    @Override
    public void onStart() {
        super.onStart();
        getElementDetail();
    }

    @OnCheckedChanged(R.id.cb_change_unit)
    public void onChange(CompoundButton button, boolean isChecked) {
        if (isChecked) {
            tvNum.setText(NumFormatterUtils.getFormatNum(heatQuantity));
            tvUnit.setText("千卡");
        } else {
            tvNum.setText(NumFormatterUtils.getFormatNum(heatQuantity * 4.186));
            tvUnit.setText("千焦");
        }
    }

    @OnClick({R.id.tv_more})
    public void onClick(View view) {
        Bundle data = new Bundle();
        data.putSerializable(DATA, pageBean);
        FragmentUtils.showFragmentAddStack(getFragmentManager(), R.id.contain, HealthFoodsElementDetailFragment.newInstance(data));
    }
}
