package com.cncn.library.util;

import android.content.Context;
import android.widget.Toast;

import com.cncn.library.app.AppContext;


/**
 * <简易Toast 保持只有一个实例，防止多次调用时长时间依次显示问题>
 *
 * @author chenml@cncn.com
 * @data: 2016/1/4 10:52
 * @version: V1.0
 */
public class ToastUtil {
    private static Toast sToast;


    public static void showToast(String msg) {
        showToast(AppContext.getContext(), msg);
    }

    public static void showToast(int msgResId) {
        showToast(AppContext.getContext(),AppContext.getContext().getResources().getString(msgResId));
    }

    public static void showToast(Context context, int msgResId) {
        showToast(context, context.getResources().getString(msgResId));
    }

    public static void showToast(Context context, String msg) {
        try {
            if (msg == null || msg.trim().length() == 0) {
                return;
            }
            if (sToast == null) {
                sToast = Toast.makeText(context.getApplicationContext(), msg, Toast.LENGTH_SHORT);
                sToast.show();
            } else {
                sToast.setText(msg);
                sToast.setDuration(Toast.LENGTH_SHORT);
                sToast.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void showLongToast(Context context, int msgResId) {
        showLongToast(context, context.getResources().getString(msgResId));
    }

    public static void showLongToast(Context context, String msg) {
        try {
            if (msg == null || msg.trim().length() == 0) {
                return;
            }
            if (sToast == null) {
                sToast = Toast.makeText(context.getApplicationContext(), msg, Toast.LENGTH_LONG);
                sToast.show();
            } else {
                sToast.setText(msg);
                sToast.setDuration(Toast.LENGTH_LONG);
                sToast.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void cancelToast() {
        if (sToast != null) {
            sToast.cancel();
        }
    }
}
