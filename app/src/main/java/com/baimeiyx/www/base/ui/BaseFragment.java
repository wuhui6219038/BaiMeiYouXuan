package com.baimeiyx.www.base.ui;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.baimeiyx.www.base.AppViewModel;
import com.baimeiyx.www.base.callback.FragmentInteraction;
import com.baimeiyx.www.constant.Config;
import com.baimeiyx.www.constant.Constant;
import com.example.mrw.baimeiyouxuan.R;
import com.google.gson.Gson;
import com.tbruyelle.rxpermissions2.RxPermissions;
import com.baimeiyx.www.ui.user.LoginFragment;
import com.baimeiyx.www.ui.user.UserInfoActivity;
import com.baimeiyx.www.utils.ActivityUtils;
import com.baimeiyx.www.utils.LogUtils;
import com.baimeiyx.www.utils.SPUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment extends Fragment implements Constant, Config {

    @BindView(R.id.tv_title)
    protected TextView tvTitle;
    @BindView(R.id.toolbar)
    protected Toolbar toolbar;
    @BindView(R.id.iv_back)
    protected ImageView ivBack;
    protected String packageName;
    protected SPUtils spUtils;
    protected Gson gson;
    private static final String TAG = "BaseFragment";
    protected Unbinder unbind;
    protected FragmentActivity mActivity;
    protected RxPermissions rxPermissions;
    protected FragmentInteraction fragmentInteraction;
    //全局通知
    protected AppViewModel appViewModel;
    protected View rootView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(getViewId(), container, false);
        unbind = ButterKnife.bind(this, rootView);
        _init(savedInstanceState);
        return rootView;
    }

    @Override

    public void onAttach(Context context) {
        super.onAttach(context);
        gson = new Gson();
        if (context instanceof Activity) {
            this.mActivity = (FragmentActivity) context;
            rxPermissions = new RxPermissions(mActivity);
            packageName = mActivity.getPackageName();
            LogUtils.e(TAG, packageName);
            spUtils = new SPUtils(SP_PRESONAL);
        }
        if (context instanceof FragmentInteraction) {
            fragmentInteraction = (FragmentInteraction) context;
        }


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        appViewModel = ViewModelProviders.of(mActivity).get(AppViewModel.class);
    }

    @Override
    public void onStart() {
        super.onStart();
        LogUtils.e(TAG, "onStart  " + getClass().getName());
        setToolbar();
    }

    @Override
    public void onStop() {
        super.onStop();
        LogUtils.e(TAG, "onStop  " + getClass().getName());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LogUtils.e(TAG, "onDestroy  " + getClass().getName());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unbind != null)
            unbind.unbind();
    }


    protected void needLogin(boolean login) {
        if (login) {
            Bundle bundle = new Bundle();
            bundle.putString(UserInfoActivity.FRAGMENT_TYPE, LoginFragment.class.getName());
            ActivityUtils.launchActivity(mActivity, packageName, packageName + ".ui.user.UserInfoActivity", bundle);
        }
    }

    /**
     * 设置toolbar相关的信息
     */
    protected abstract void setToolbar();

    /**
     * 获取当前页面的布局
     *
     * @return
     */
    protected abstract int getViewId();

    /**
     * 初始化
     */
    protected abstract void _init(Bundle savedInstanceState);
}
