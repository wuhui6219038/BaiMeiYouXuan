package com.baimeiyx.www.ui.fragment;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.CheckBox;

import com.baimeiyx.www.base.ui.BaseUserFragment;
import com.baimeiyx.www.constant.Constant;
import com.baimeiyx.www.service.model.FoodsDetailResult;
import com.baimeiyx.www.service.repository.DataManager;
import com.baimeiyx.www.service.rxjava.DialogSubscribe;
import com.baimeiyx.www.service.rxjava.RetryExceptionObservable;
import com.baimeiyx.www.service.rxjava.RxJavaUtils;
import com.baimeiyx.www.ui.adapter.AdapterHealthFoodsDetail;
import com.example.mrw.baimeiyouxuan.R;

import butterknife.BindView;

public class HealthFoodsDetailFragment extends BaseUserFragment<FoodsDetailResult> {
    private static final String TAG = "HealthFoodsDetailFragme";
    public static final String FOODID = "foodId";
    @BindView(R.id.cb_food_type)
    CheckBox cbFoodType;
    @BindView(R.id.rc_foods_detail)
    RecyclerView rcFoodsDetail;
    @BindView(R.id.srl_food)
    SwipeRefreshLayout srlFood;
    private int currentPage=1;
    private int foodCategoryId;
    private AdapterHealthFoodsDetail adapterHealthFoodsDetail;

    public static HealthFoodsDetailFragment newInstance(Bundle args) {
        HealthFoodsDetailFragment fragment = new HealthFoodsDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected void setToolbar() {
        tvTitle.setText("分类查询");
    }

    @Override
    protected int getViewId() {
        return R.layout.fragment_health_foods_deital;
    }

    @Override
    protected void _init(Bundle savedInstanceState) {
        foodCategoryId = getArguments().getInt(FOODID);
        _initSwipeRefresh(srlFood);
        _initAdapter();
        _initRv();
    }

    private void _initAdapter() {
        adapterHealthFoodsDetail = new AdapterHealthFoodsDetail(getContext(), R.layout.item_foods_detail);
        adapterHealthFoodsDetail.setOnItemClickListener((adapter, view, position) -> {
            Log.e(TAG, "_initAdapter:点击item " + position);
        });
        adapterHealthFoodsDetail.setOnItemChildClickListener((adapter, view, position) -> {
            Log.e(TAG, "点击图片的_initAdapter: " + position);
        });
        adapterHealthFoodsDetail.setOnLoadMoreListener(() ->
        {
            currentPage++;
            getFoodsDetail();
        }, rcFoodsDetail);
    }

    private void _initRv() {
        rcFoodsDetail.setAdapter(adapterHealthFoodsDetail);
        rcFoodsDetail.setLayoutManager(new LinearLayoutManager(mActivity));
    }

    @Override
    protected void onDataSuccessChanged(FoodsDetailResult baseResult) {
        srlFood.setRefreshing(false);

        if (currentPage == 1) {
            adapterHealthFoodsDetail.setNewData(baseResult.getPage().getList());
        } else {
            if (baseResult.getPage() == null || baseResult.getPage().getList().size() == 0) {
                adapterHealthFoodsDetail.setEnableLoadMore(false);
            } else {
                adapterHealthFoodsDetail.addData(baseResult.getPage().getList());
            }
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        getFoodsDetail();
    }

    private void getFoodsDetail() {
        DataManager.getBaiMeiApiService().getFoodsDetail(spUtils.getString(SP_SESSION_ID), Constant.LIMIT, currentPage, foodCategoryId)
                .retryWhen(new RetryExceptionObservable())
                .compose(RxJavaUtils.rxSchedulerHelper())
                .subscribe(new DialogSubscribe<FoodsDetailResult>(mActivity) {
                    @Override
                    public void dataSuccess(FoodsDetailResult data) {
                        onDataSuccessChanged(data);
                    }
                });
    }

    @Override
    protected void swipeRefresh() {
        currentPage = 1;
    }
}
