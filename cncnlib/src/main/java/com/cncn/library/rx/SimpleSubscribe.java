package com.cncn.library.rx;


import rx.Subscriber;

/**
 * <请描述这个类是干什么的>
 *
 * @author caiyk@cncn.com
 * @data: 2016/6/23 10:27
 * @version: V1.0
 */
public abstract class SimpleSubscribe<T> extends Subscriber<T> {
    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
    }

    @Override
    public void onNext(T t) {
        onSuccess(t);
    }

    @Override
    public void onStart() {
        super.onStart();
    }


    public abstract void onSuccess(T t);

}
