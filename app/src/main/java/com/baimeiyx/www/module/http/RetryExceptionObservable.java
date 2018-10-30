package com.baimeiyx.www.module.http;

import com.baimeiyx.www.utils.LogUtils;

import org.reactivestreams.Publisher;

import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;

/**
 * 网络出问题的时候处理
 */
public class RetryExceptionObservable implements Function<Flowable<Throwable>, Publisher<Flowable>> {

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
    public Publisher<Flowable> apply(Flowable<Throwable> throwableFlowable) throws Exception {

        if (needRepeat) {
            return throwableFlowable.zipWith(Flowable.range(1, maxCount), new BiFunction<Throwable, Integer, Flowable>() {
                @Override
                public Flowable apply(Throwable throwable, Integer count) {
                    if (count == maxCount) {
                        throwableFlowable.error(throwable);
                        LogUtils.e(TAG, "多次请求还是失败了");
                    } else {
                        return Flowable.timer(delay, TimeUnit.SECONDS);
                    }
                    return null;
                }
            }).flatMap(new Function<Flowable, Publisher<Flowable>>() {
                @Override
                public Publisher<Flowable> apply(Flowable observable) throws Exception {
                    return observable;
                }
            });
        } else {
            return throwableFlowable.flatMap(new Function<Throwable, Publisher<Flowable>>() {
                @Override
                public Publisher<Flowable> apply(Throwable throwable) throws Exception {
                    LogUtils.e(TAG, "apply: " );
                    return Flowable.error(throwable);
                }
            });
        }
    }
}
