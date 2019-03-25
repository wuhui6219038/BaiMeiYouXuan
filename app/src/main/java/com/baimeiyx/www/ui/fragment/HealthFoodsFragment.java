package com.baimeiyx.www.ui.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;

import com.baimeiyx.www.base.ui.BaseUserFragment;
import com.baimeiyx.www.constant.Constant;
import com.baimeiyx.www.service.model.BaseResult;
import com.baimeiyx.www.service.model.FoodsResult;
import com.baimeiyx.www.service.repository.DataManager;
import com.baimeiyx.www.service.rxjava.DialogSubscribe;
import com.baimeiyx.www.service.rxjava.RetryExceptionObservable;
import com.baimeiyx.www.service.rxjava.RxJavaUtils;
import com.baimeiyx.www.ui.adapter.AdapterHealthFoods;
import com.baimeiyx.www.utils.BarUtils;
import com.baimeiyx.www.utils.ImageUtils;
import com.baimeiyx.www.utils.myUtils.FragmentUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.mrw.baimeiyouxuan.R;

import butterknife.BindView;

import static com.baimeiyx.www.ui.fragment.HealthFoodsDetailFragment.FOODID;

public class HealthFoodsFragment extends BaseUserFragment<FoodsResult> {
    private static final String TAG = "HealthFoodsFragment";
    @BindView(R.id.iv_bg)
    ImageView ivBg;
    @BindView(R.id.et_search_info)
    EditText etSearchInfo;
    @BindView(R.id.rc_foods)
    RecyclerView rcFoods;
    private static final String BG_URL = "https://obs-7bff.obs.cn-north-1.myhwclouds.com/11111_small_app/shiwuku_banner.jpg";
    @BindView(R.id.srl_food)
    SwipeRefreshLayout srlFood;
    private AdapterHealthFoods adapterHealthFoods;
    private int currentPage = 1;

    public static HealthFoodsFragment newInstance() {

        HealthFoodsFragment fragment = new HealthFoodsFragment();
        return fragment;
    }


    @Override
    protected void setToolbar() {
        tvTitle.setText("百媚健康食物库");
        tvTitle.setTextColor(Color.BLACK);
        toolbar.setBackgroundColor(Color.WHITE);
        BarUtils.setColor(mActivity, Color.WHITE, 0);
    }

    @Override
    protected int getViewId() {
        return R.layout.fragment_health_foods;
    }

    @Override
    protected void _init(Bundle savedInstanceState) {
        ImageUtils.loadImgSrcByUrl(getContext(), ivBg, BG_URL);
        _initSwipeRefresh(srlFood);
        setRv();
    }

    private void setRv() {
        adapterHealthFoods = new AdapterHealthFoods(mActivity, R.layout.item_health_foods);
        adapterHealthFoods.setOnItemClickListener((adapter, view, position) -> {
            FoodsResult.PageBean.ListBean foodBean = (FoodsResult.PageBean.ListBean) adapter.getData().get(position);
            Bundle data = new Bundle();
            data.putInt(FOODID, foodBean.getId());
            FragmentUtils.showFragmentAddStack(getFragmentManager(), R.id.contain, HealthFoodsDetailFragment.newInstance(data));
        });
        adapterHealthFoods.setOnLoadMoreListener(() ->
        {
            currentPage++;
            getFoods();
        }, rcFoods);
        new GridLayoutManager(getContext(), 3);
        rcFoods.setLayoutManager(new GridLayoutManager(getContext(), 3));
        rcFoods.setAdapter(adapterHealthFoods);
    }

    @Override
    protected void onDataSuccessChanged(FoodsResult baseResult) {
        srlFood.setRefreshing(false);

        if (currentPage == 1) {
            adapterHealthFoods.setNewData(baseResult.getPage().getList());
        } else {
            if (baseResult.getPage() == null || baseResult.getPage().getList().size() == 0) {
                adapterHealthFoods.setEnableLoadMore(false);
            } else {
                adapterHealthFoods.addData(baseResult.getPage().getList());
            }
        }

    }

    @Override
    public void onStart() {
        super.onStart();
        getFoods();
    }

    private void getFoods() {
        DataManager.getBaiMeiApiService().getFoods(spUtils.getString(SP_SESSION_ID), Constant.LIMIT, currentPage)
                .retryWhen(new RetryExceptionObservable())
                .compose(RxJavaUtils.rxSchedulerHelper())
                .subscribe(new DialogSubscribe<FoodsResult>(mActivity) {
                    @Override
                    public void dataSuccess(FoodsResult data) {
                        onDataSuccessChanged(data);
                    }
                });
    }

    @Override
    protected void swipeRefresh() {
        currentPage = 1;
        getFoods();
    }
}
