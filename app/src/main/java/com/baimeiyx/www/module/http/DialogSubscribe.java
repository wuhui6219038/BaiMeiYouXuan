package com.baimeiyx.www.module.http;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/**
 * 重新封装一个带弹出框的观察者
 */
public class DialogSubscribe implements Subscriber {

    @Override
    public void onSubscribe(Subscription s) {
        s.cancel();
    }

    @Override
    public void onNext(Object o) {

    }

    @Override
    public void onError(Throwable t) {

    }

    @Override
    public void onComplete() {

    }
}
