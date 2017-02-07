package com.cncn.library.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.cncn.library.app.AppContext;
import com.cncn.library.model.ImageSize;

/**
 * <>
 *
 * @author chenml@cncn.com
 * @data: 2016/1/18 14:23
 * @version: V1.0
 */
public class BitmapUtil {

    public static Bitmap decodeSampleBitmapFromResource(int resId, ImageSize imageSize) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(AppContext.getContext().getResources(), resId, options);
        options.inSampleSize = calculateInSampleSize(options, imageSize);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(AppContext.getContext().getResources(), resId, options);
    }

    public static Bitmap decodeSampleBitmapFromFile(String filePath, ImageSize imageSize) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(filePath, options);
        options.inSampleSize = calculateInSampleSize(options, imageSize);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(filePath, options);
    }

    private static int calculateInSampleSize(BitmapFactory.Options options, ImageSize imageSize) {
        //原图片宽高信息
        final int width = options.outWidth;
        final int height = options.outHeight;
        int inSampleSize = 1;

        if(height > imageSize.height || width > imageSize.width) {
            //计算出实际宽高和目标宽高的比率
            final int heightRatio = Math.round((float)height / (float)imageSize.height);
            final int widthRatio = Math.round((float)width / (float)imageSize.width);
            //选择宽高比中最小的比率作为inSampleSize的值，这样可以保证最终图片的宽和高一定都会大于等于目标的宽和高
            inSampleSize = heightRatio > widthRatio ? widthRatio : heightRatio;
        }

        return inSampleSize;
    }

}
