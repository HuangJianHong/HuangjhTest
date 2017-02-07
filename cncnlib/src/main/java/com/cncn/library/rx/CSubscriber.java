package com.cncn.library.rx;

import com.cncn.library.app.ReturnCode;

import rx.Subscriber;

/**
 * <>
 *
 * @author chenml@cncn.com
 * @data: 2016/2/24 12:32
 * @version: V1.0
 */
public abstract class CSubscriber<T> extends Subscriber<T> {

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        if (e == null) {
            onError(new ErrorThrowable(ReturnCode.LOCAL_UNKNOWN_ERROR, ""));
        } else if (e instanceof ErrorThrowable) {
            onError((ErrorThrowable) e);
        } else {
            onError(new ErrorThrowable(ReturnCode.LOCAL_ERROR_TYPE_ERROR, e.getMessage()));
        }
    }

    @Override
    public void onNext(T t) {
        onSuccess(t);
    }

    @Override
    public void onStart() {
        super.onStart();
        onPrepare();
    }

    public abstract void onPrepare();

    public abstract void onError(ErrorThrowable throwable);

    public abstract void onSuccess(T t);


}
