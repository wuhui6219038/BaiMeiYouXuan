package com.baimeiyx.www.base.ui;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.baimeiyx.www.module.DataRepository;
import com.baimeiyx.www.module.http.result.BaseResult;
import com.baimeiyx.www.ui.user.UserViewModel;
import com.baimeiyx.www.utils.ToastUtils;

public abstract class BaseUserFragment<T extends BaseResult> extends BaseFragment implements Observer<T> {
    protected UserViewModel mUserViewModel;
    protected DataRepository dataRepository;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mUserViewModel = ViewModelProviders.of(this).get(UserViewModel.class);
        dataRepository = new DataRepository();
        mUserViewModel.setDataRepository(dataRepository);
    }

    @Override
    public void onChanged(@Nullable T baseResult) {
        if (baseResult.isOk()) {
            onDataSuccessChanged(baseResult);
        } else {
            ToastUtils.showShortToast(baseResult.getMessage() + baseResult.getComment() == null ? "" : "(" + baseResult.getComment() + ")");
        }
    }

    /**
     * 接口获取数据成功
     * "
     *
     * @param baseResult
     */
    protected abstract void onDataSuccessChanged(T baseResult);
}
