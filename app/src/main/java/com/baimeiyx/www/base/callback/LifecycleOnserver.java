package com.baimeiyx.www.base.callback;

import android.arch.lifecycle.Observer;
import android.support.v4.database.DatabaseUtilsCompat;

import com.baimeiyx.www.http.result.BaseResult;

public interface LifecycleOnserver<T extends BaseResult> extends Observer<T> {
}
