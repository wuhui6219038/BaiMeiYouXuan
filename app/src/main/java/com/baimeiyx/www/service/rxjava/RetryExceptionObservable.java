package com.baimeiyx.www.service.rxjava;

import com.baimeiyx.www.service.excetion.ServerException;
import com.baimeiyx.www.utils.LogUtils;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;

/**
 * 网络出问题的时候处理
 */
public class RetryExceptionObservable implements Function<Observable<Throwable>, ObservableSource<Observable>> {

    private static final String TAG = "RetryExceptionObservabl";
    /**
     * 是否需要重复请求
     */
    private boolean needRepeat = true;
    /**
     * 最大重复请求次数
     */
    private int maxCount = 3;
    /**
     * 每次请求的时间间隔 单位是秒
     */
    private int delay = 2;

    @Override
    public ObservableSource<Observable> apply(Observable<Throwable> throwableFlowable) throws Exception {

        if (needRepeat) {
            return throwableFlowable.zipWith(Observable.range(1, maxCount), new BiFunction<Throwable, Integer, Observable>() {
                @Override
                public Observable apply(Throwable throwable, Integer count) {

                    LogUtils.e(TAG, "正在尝试的错误：" + throwable + " 第" + count + "次");
                    if (count == maxCount || throwable instanceof ServerException) {
                        LogUtils.e(TAG, "多次请求还是失败了");
                        return Observable.error(throwable);
                    } else {
                        return Observable.timer(delay, TimeUnit.SECONDS);
                    }


                }
            }).flatMap(new Function<Observable, ObservableSource<Observable>>() {
                @Override
                public ObservableSource<Observable> apply(Observable observable) throws Exception {
                    return observable;
                }
            });
        } else {
            return throwableFlowable.flatMap(new Function<Throwable, ObservableSource<Observable>>() {
                @Override
                public ObservableSource<Observable> apply(Throwable throwable) throws Exception {
                    LogUtils.e(TAG, "apply: ");
                    return Observable.error(throwable);
                }
            });
        }
    }
}
