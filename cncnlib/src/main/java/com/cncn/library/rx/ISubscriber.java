package com.cncn.library.rx;



/**
 * <请描述这个类是干什么的>
 *
 * @author caiyk@cncn.com
 * @data: 2016/6/23 11:16
 * @version: V1.0
 */
public interface ISubscriber<T> {
    void onPrepare();

    void onError(ErrorThrowable throwable);

    void onSuccess(T t);
}
