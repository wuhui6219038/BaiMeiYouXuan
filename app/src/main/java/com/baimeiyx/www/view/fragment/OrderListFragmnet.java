package com.baimeiyx.www.view.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;

import com.baimeiyx.www.base.ui.BaseUserFragment;
import com.baimeiyx.www.service.model.OrderListResult;
import com.baimeiyx.www.service.repository.DataManager;
import com.baimeiyx.www.service.rxjava.DialogSubscribe;
import com.baimeiyx.www.service.rxjava.RetryExceptionObservable;
import com.baimeiyx.www.service.rxjava.RxJavaUtils;
import com.baimeiyx.www.utils.BarUtils;
import com.example.mrw.baimeiyouxuan.R;

import butterknife.BindView;

public class OrderListFragmnet extends BaseUserFragment<OrderListResult> {
    private final static String[] TABS = {"待付款", "待发货", "待收货", "待评论", "已完成"};
    private int mPage = 1;
    private int mStatus = 1;

    public static OrderListFragmnet newInstance() {

        Bundle args = new Bundle();

        OrderListFragmnet fragment = new OrderListFragmnet();
        fragment.setArguments(args);
        return fragment;
    }

    @BindView(R.id.tablayout)
    TabLayout tablayout;
    @BindView(R.id.rv_order_list)
    RecyclerView rvOrderList;
    @BindView(R.id.main_srl)
    SwipeRefreshLayout mainSrl;

    @Override
    protected int getViewId() {
        return R.layout.fragment_order_list;
    }

    @Override
    protected void _init(Bundle savedInstanceState) {
        _initTab();
        _initSwipeRefresh(mainSrl);
    }

    private void _initTab() {
        for (String strTab : TABS) {
            tablayout.addTab(tablayout.newTab().setText(strTab));
        }
        tablayout.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mPage = 1;
                mStatus = tab.getPosition() + 1;
                getData(mPage, mStatus);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    protected void swipeRefresh() {
        mPage = 1;
        getData(mPage, mStatus);
    }

    /**
     * @param page   当前页面
     * @param status 订单的状态
     */
    private void getData(int page, int status) {
        DataManager.getBaiMeiApiService().getAllTOrderList(spUtils.getString(SP_SESSION_ID), status, LIMIT, page)
                .retryWhen(new RetryExceptionObservable())
                .compose(RxJavaUtils.rxSchedulerHelper())
                .subscribe(new DialogSubscribe<OrderListResult>(mActivity) {
                    @Override
                    public void dataSuccess(OrderListResult data) {
                        onDataSuccessChanged(data);
                    }
                });
    }

    protected void onDataSuccessChanged(OrderListResult baseResult) {

    }

    @Override
    protected void setToolbar() {
        tvTitle.setText(getResources().getString(R.string.title_order_list));
        toolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        BarUtils.setColor(mActivity, getResources().getColor(R.color.colorPrimary), 0);
    }


}
