package com.cncn.library.listview.manager;

import android.content.Context;

import java.util.List;

import rx.Observable;

/**
 * @author ml_bright
 * @version V1.0
 * @email 2504509903@qq.com
 * @date 2015-10-16 下午4:14:26
 */
public interface IGroupManager<T> {
    Observable<List<T>> refreshData(Context context);

    Observable<List<T>> loadMoreData(Context context);

    int getTotalCount();
}
