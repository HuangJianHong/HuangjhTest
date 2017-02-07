package com.cncn.library.app;

/**
 * <请描述这个类是干什么的>
 *
 * @author caiyk@cncn.com
 * @data: 2016/7/4 16:23
 * @version: V1.0
 */
public interface ReturnCode {

    //未知错误
    int LOCAL_UNKNOWN_ERROR = 0x10100;

    //无网络状态
    int LOCAL_NO_NETWORK = 0x10101;

    //超时
    int LOCAL_TIMEOUT_ERROR = 0x10104;

    //失败
    int LOCAL_ERROR_TYPE_ERROR = 0x10108;

    //数据为空
    int LOCAL_ERROR_EMPTY = 0x10122;

    //成功
    int CODE_SUCCESS = 1;

    //失败
    int CODE_ERROR = -1;

    //数据为空
    int CODE_EMPTY = 1004;

    int CODE_TOKEN_INVALID = -106;

    //appid无效
    int CODE_APP_ID_INVALID = 90001;

    //登出，在别的设备已登录
    int CODE_USER_LOGOUT = 999999;

    int CODE_USER_AUTHEN_INVALID = -105;

//    1    成功
//    -1    失败
//    -101    sign值错误
//    -102    time未传
//    -103    time过期   // 返回文案：账户登录授权已过期，请重新登录
//    -104    sign 为空
//    -105    无效的授权
//    -106    token失效
//    1004 返回的数据为空
//    40010发送过于频繁
//    40011短信发送过多
//    40012手机号码错误
//    40013验证码错误
}
