package com.cncn.library.ui.web;

import com.cncn.library.model.BaseInfo;

import java.io.Serializable;
/***
 * loadWithOver和layoutAlgorithm两种自适应屏幕方法
 * layoutAlgorithm解决了解海沧的适应问题
 */

/**
 * <//web页的配置信息>
 *
 * @author caiyk@cncn.com
 * @data: 2016/6/22 16:09
 * @version: V1.0
 */
public class WebConfig extends BaseInfo implements Serializable {
    /**
     * 认证审核
     */
    public static final int LOAD_CERTIFICATION_AUDIT=2;

    /**
     * 旅游资源
     */
    public static final int LOAD_TRAVELRES = 3;        //景区 ，酒店，旅行社，导游列表详情页;

    public String url;
    public boolean loadWithOver = true;
    public boolean isLayoutAlgorithm = false;
    public boolean isJump = false;
    public boolean isInterceptKeyEvent = true;//webView是否拦截按键事件

    public boolean leftClickFinishAble = true;//点击左上按钮是否立即退出activity
    public String title;//顶部标题
    public String publicParams;
    public String hostUrl;
    public String id="";
    public int reviewStatus;
    /**
     * 加载类型
     */
    public int loadType;


    public WebConfig(String url, String title, boolean isJump) {
        this.url = url;
        this.title = title;
        this.isJump = isJump;
    }

    public void setLeftClickFinishAble(boolean leftClickFinishAble) {
        this.leftClickFinishAble = leftClickFinishAble;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setJump(boolean jump) {
        isJump = jump;
    }

    public void setLoadWithOver(boolean isOver) {
        this.loadWithOver = isOver;
    }

    public void setPublicParams(String publicParams) {
        this.publicParams = publicParams;
    }

    public void setHostUrl(String hostUrl) {
        this.hostUrl = hostUrl;
    }
}
