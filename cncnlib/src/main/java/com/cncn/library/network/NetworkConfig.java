package com.cncn.library.network;

/**
 * <网络模块 配置文件>
 *
 * @author chenml@cncn.com
 * @data: 2016/2/17 11:30
 * @version: V1.0
 */
public class NetworkConfig {
    private static String BASE_URL;

    public static void setBaseUrl(String url) {
        NetworkConfig.BASE_URL = url;
    }

    public static String getBaseUrl() {
        return BASE_URL;
    }

}
