package com.cncn.library.listview;

import android.view.View;

import java.util.List;

/**
 * 创建组件接口
 * 
 * @author ml_bright
 * @email 2504509903@qq.com
 * @date 2015-10-16 下午4:15:20
 * @version V1.0
 */
public interface IGroupPresenter<T> {

	
	View getRootView();


	void setItems(List<T> list);

	void addItems(List<T> list);

	void removeItem(int position);

	void removeItemRange(int startPos, int count);

	void removeAllItem();

	/**
	 * 修改Item项
	 */
	void replaceItem(int position, T item);

	void addItem(int position, T item);
}
