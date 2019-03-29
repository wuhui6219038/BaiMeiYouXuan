package com.baimeiyx.www.ui.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.baimeiyx.www.base.ui.BaseFragment;
import com.baimeiyx.www.service.model.FoodElementDetailResult;
import com.baimeiyx.www.ui.adapter.AdapterFoodsElementDetails;
import com.baimeiyx.www.utils.BarUtils;
import com.example.mrw.baimeiyouxuan.R;

import butterknife.BindView;

public class HealthFoodsElementDetailFragment extends BaseFragment {
    public static final String DATA = "data";
    @BindView(R.id.rc_element)
    RecyclerView rcElement;
    private AdapterFoodsElementDetails adapterFoodsElementDetails;
    private FoodElementDetailResult.PageBean pageBean;

    public static HealthFoodsElementDetailFragment newInstance(Bundle args) {


        HealthFoodsElementDetailFragment fragment = new HealthFoodsElementDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void setToolbar() {
        tvTitle.setText(getResources().getString(R.string.app_name));
        tvTitle.setTextColor(Color.BLACK);
        toolbar.setBackgroundColor(Color.WHITE);
        BarUtils.setColor(mActivity, Color.WHITE, 0);
    }

    @Override
    protected int getViewId() {
        return R.layout.fragment_health_foods_element_details;
    }

    @Override
    protected void _init(Bundle savedInstanceState) {
        pageBean = (FoodElementDetailResult.PageBean) getArguments().getSerializable(DATA);
        adapterFoodsElementDetails = new AdapterFoodsElementDetails(R.layout.item_foods_element_detail);
        rcElement.setLayoutManager(new LinearLayoutManager(mActivity));
        rcElement.setAdapter(adapterFoodsElementDetails);
        adapterFoodsElementDetails.setNewData(pageBean.getNutrientList());
    }


}
