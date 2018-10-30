package com.baimeiyx.www.base.callback;

import android.arch.lifecycle.Observer;

import com.baimeiyx.www.module.http.result.BaseResult;


public interface LifecycleOnserver<T extends BaseResult> extends Observer<T> {
}
