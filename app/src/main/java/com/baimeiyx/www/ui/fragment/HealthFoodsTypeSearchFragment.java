package com.baimeiyx.www.ui.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.baimeiyx.www.base.ui.BaseUserFragment;
import com.baimeiyx.www.constant.Constant;
import com.baimeiyx.www.service.model.BaseResult;
import com.baimeiyx.www.service.model.FoodsDetailResult;
import com.baimeiyx.www.service.model.FoodsElementSortResult;
import com.baimeiyx.www.service.repository.DataManager;
import com.baimeiyx.www.service.rxjava.DialogSubscribe;
import com.baimeiyx.www.service.rxjava.RetryExceptionObservable;
import com.baimeiyx.www.service.rxjava.RxJavaUtils;
import com.baimeiyx.www.ui.adapter.AdapterHealthFoodsDetail;
import com.baimeiyx.www.ui.dialog.FoodsElementPopWindow;
import com.baimeiyx.www.utils.BarUtils;
import com.baimeiyx.www.utils.myUtils.FragmentUtils;
import com.example.mrw.baimeiyouxuan.R;

import java.util.List;

import butterknife.BindView;
import butterknife.OnCheckedChanged;

import static com.baimeiyx.www.ui.fragment.HealthFoodsDetailFragment.FOODSELEMENTID;

public class HealthFoodsTypeSearchFragment extends BaseUserFragment<BaseResult> {
    private static final String TAG = "HealthFoodsDetailFragme";
    public static final String FOODID = "foodId";
    public static final String FOODNAME = "foodName";
    @BindView(R.id.cb_food_type)
    CheckBox cbFoodType;
    @BindView(R.id.rc_foods_detail)
    RecyclerView rcFoodsDetail;
    @BindView(R.id.srl_food)
    SwipeRefreshLayout srlFood;
    private int currentPage = 1;
    private int foodCategoryId;
    private String foodName;
    private AdapterHealthFoodsDetail adapterHealthFoodsDetail;
    private FoodsElementPopWindow popWindow;
    private String searchFoodsTypeName, searchFoodsTypeSysId;
    private int networkType = 0;

    public static HealthFoodsTypeSearchFragment newInstance(Bundle args) {
        HealthFoodsTypeSearchFragment fragment = new HealthFoodsTypeSearchFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected void setToolbar() {
        tvTitle.setText("分类查询");
        tvTitle.setTextColor(Color.BLACK);
        toolbar.setBackgroundColor(Color.WHITE);
        ivBack.setImageDrawable(getResources().getDrawable(R.drawable.ic_back_blcak));
        BarUtils.setColor(mActivity, Color.WHITE, 0);
    }

    @Override
    protected int getViewId() {
        return R.layout.fragment_health_foods_type_search;
    }

    @Override
    protected void _init(Bundle savedInstanceState) {
        foodCategoryId = getArguments().getInt(FOODID);
        foodName = getArguments().getString(FOODNAME);
        _initSwipeRefresh(srlFood);
        _initAdapter();
        _initRv();
        _initPopWindow();
    }

    private void _initRv() {
        rcFoodsDetail.setAdapter(adapterHealthFoodsDetail);
        rcFoodsDetail.setLayoutManager(new LinearLayoutManager(mActivity));
    }

    private void _initAdapter() {
        adapterHealthFoodsDetail = new AdapterHealthFoodsDetail(getContext(), R.layout.item_foods_detail);
        adapterHealthFoodsDetail.setOnItemClickListener((adapter, view, position) -> {
            Log.e(TAG, "_initAdapter:点击item " + position);
            Bundle bundle = new Bundle();
            bundle.putInt(FOODSELEMENTID, ((FoodsDetailResult.PageBean.ListBean) adapter.getItem(position)).getId());
            FragmentUtils.showFragmentAddStack(getFragmentManager(), R.id.contain, HealthFoodsDetailFragment.newInstance(bundle));
        });

        adapterHealthFoodsDetail.setOnLoadMoreListener(() ->
        {
            currentPage++;
            getData();
        }, rcFoodsDetail);
    }

    private void _initPopWindow() {
        popWindow = new FoodsElementPopWindow(mActivity);
        popWindow.setListenser(new FoodsElementPopWindow.OnPopWindowistenser() {
            @Override
            public void onItemClick(FoodsElementSortResult.PageBean bean) {
                networkType = 1;
                searchFoodsTypeName = bean.getName();
                cbFoodType.setText(searchFoodsTypeName);
                searchFoodsTypeSysId = bean.getId();
                currentPage = 1;
                getCategoryByElementList();
            }

            @Override
            public void onDismiss() {
                cbFoodType.setChecked(false);
            }
        });
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

    private void getFoodsNameByList() {
        // Log.e(TAG, "getCategoryByElementList: " + searchFoodsTypeName + "  " + searchFoodsTypeSysId + " " + foodCategoryId);
        DataManager.getBaiMeiApiService().getFoodsDetailByName(spUtils.getString(SP_SESSION_ID), Constant.LIMIT, currentPage, foodName)
                .retryWhen(new RetryExceptionObservable())
                .compose(RxJavaUtils.rxSchedulerHelper())
                .subscribe(new DialogSubscribe<FoodsDetailResult>(mActivity) {
                    @Override
                    public void dataSuccess(FoodsDetailResult data) {
                        onDataSuccessChanged(data);
                    }
                });
    }

    private void getFoodsElement() {
        DataManager.getBaiMeiApiService().getFoodsSort(spUtils.getString(SP_SESSION_ID), "gudao-element")
                .retryWhen(new RetryExceptionObservable())
                .compose(RxJavaUtils.rxSchedulerHelper())
                .subscribe(new DialogSubscribe<FoodsElementSortResult>(mActivity) {
                    @Override
                    public void dataSuccess(FoodsElementSortResult data) {
                        onDataSuccessChanged(data);
                    }
                });
    }

    private void getCategoryByElementList() {
        DataManager.getBaiMeiApiService().getCategoryByElementList(spUtils.getString(SP_SESSION_ID), Constant.LIMIT, currentPage, searchFoodsTypeName, searchFoodsTypeSysId, foodCategoryId)
                .retryWhen(new RetryExceptionObservable())
                .compose(RxJavaUtils.rxSchedulerHelper())
                .subscribe(new DialogSubscribe<FoodsDetailResult>(mActivity) {
                    @Override
                    public void dataSuccess(FoodsDetailResult data) {
                        onDataSuccessChanged(data);
                    }
                });
    }


    private void getData() {
        Log.e(TAG, "getData: " + networkType);
        if (networkType == 0) {
            getDataList();
        } else {
            getCategoryByElementList();
        }
    }

    private void getDataList() {
        if (foodName != null) {
            getFoodsNameByList();
            cbFoodType.setVisibility(View.GONE);
        } else {
            getFoodsDetail();
        }
    }

    @Override
    protected void swipeRefresh() {
        currentPage = 1;
        getData();
    }

    @Override
    protected void onDataSuccessChanged(BaseResult baseResult) {
        srlFood.setRefreshing(false);
        if (baseResult instanceof FoodsDetailResult) {
            FoodsDetailResult.PageBean pageBean = ((FoodsDetailResult) baseResult).getPage();
            if (currentPage == 1) {
                if (pageBean == null || pageBean.getList().size() == 0) {
                    adapterHealthFoodsDetail.setEmptyView(R.layout.view_empty);
                } else
                    adapterHealthFoodsDetail.setNewData(pageBean.getList());
            } else {
                if (pageBean == null || pageBean.getList().size() == 0) {
                    adapterHealthFoodsDetail.setEnableLoadMore(false);
                } else {
                    adapterHealthFoodsDetail.addData(pageBean.getList());
                }
            }
        } else {
            List<FoodsElementSortResult.PageBean> datas = ((FoodsElementSortResult) baseResult).getPage();
            popWindow.setData(datas);
            popWindow.showAsDropDown(cbFoodType, 0, 0, Gravity.BOTTOM);

        }
    }

    @Override
    public void onStart() {
        super.onStart();
        currentPage = 1;
        getDataList();
    }

    @OnCheckedChanged(R.id.cb_food_type)
    public void onCheckChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            getFoodsElement();
        } else {
            if (popWindow.isShowing()) {
                popWindow.dismiss();
            }
        }

    }
}
