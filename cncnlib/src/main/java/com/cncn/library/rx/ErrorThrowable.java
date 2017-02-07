package com.cncn.library.rx;

/**
 * <>
 *
 * @author chenml@cncn.com
 * @data: 2016/2/17 13:47
 * @version: V1.0
 */
public class ErrorThrowable extends Throwable {

    public int code;

    public String msg;

    public ErrorThrowable(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }


}
