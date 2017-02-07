package com.cncn.library.listview.loading;


import android.view.ViewGroup;

/**
 * @author ml_bright
 * @version V1.0
 * @email 2504509903@qq.com
 * @date 2015-10-16 下午4:15:10
 */
public interface IGroupLoadingHelp {

    void createLoadingPage(ViewGroup rootView);

    void showLoading();

    boolean isShowLaunchPage();

    void showFailPage(int failCode);

    void showEmptyLoadingPage();

    void setOnFailClickListener(OnFailClickListener onFailClickListener);


    void hideLoading();

}
