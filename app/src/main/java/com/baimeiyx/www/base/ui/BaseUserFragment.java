package com.baimeiyx.www.base.ui;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;

import com.baimeiyx.www.constant.Constant;
import com.baimeiyx.www.service.excetion.ExceptionEngine;
import com.baimeiyx.www.service.model.CustomerExpectResult;
import com.baimeiyx.www.service.repository.DataManager;
import com.baimeiyx.www.service.repository.DataRepository;
import com.baimeiyx.www.service.model.BaseResult;
import com.baimeiyx.www.service.rxjava.DialogSubscribe;
import com.baimeiyx.www.service.rxjava.RetryExceptionObservable;
import com.baimeiyx.www.service.rxjava.RxJavaUtils;
import com.baimeiyx.www.utils.LogUtils;
import com.baimeiyx.www.utils.myUtils.DialogUtils;
import com.baimeiyx.www.viewmodel.DataViewModel;
import com.baimeiyx.www.utils.ToastUtils;
import com.example.mrw.baimeiyouxuan.R;
import com.qmuiteam.qmui.widget.dialog.QMUITipDialog;

public abstract class BaseUserFragment<T extends BaseResult> extends BaseFragment {
    //    protected DataViewModel mDataViewModel;
//    protected DataRepository dataRepository;
    private static final String TAG = "BaseUserFragment";

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        mDataViewModel = ViewModelProviders.of(this).get(DataViewModel.class);
//        dataRepository = new DataRepository();
//        mDataViewModel.setDataRepository(dataRepository);
    }

    protected void _initSwipeRefresh(SwipeRefreshLayout swipeRefreshLayout) {
        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright, android.R.color.holo_green_light,
                android.R.color.holo_orange_light, android.R.color.holo_red_light);
        swipeRefreshLayout.setOnRefreshListener(() -> {
            swipeRefresh();
        });
    }

    protected void getCustomerExpect() {
        DataManager.getBaiMeiApiService().getCustomerExpect(spUtils.getString(SP_SESSION_ID))
                .retryWhen(new RetryExceptionObservable())
                .compose(RxJavaUtils.rxSchedulerHelper())
                .subscribe(new DialogSubscribe<CustomerExpectResult>(mActivity) {
                    @Override
                    public void dataSuccess(CustomerExpectResult data) {
                        onDataSuccessChanged((T) data);
                    }
                });
    }


    /**
     * 接口获取数据成功
     * "
     *
     * @param baseResult
     */
    protected abstract void onDataSuccessChanged(T baseResult);

    /**
     * 下拉刷新
     */
    protected void swipeRefresh() {

    }
}
