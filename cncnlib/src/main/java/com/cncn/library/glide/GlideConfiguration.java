package com.cncn.library.glide;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.module.GlideModule;

/**
 * <>
 *
 * @author chenml@cncn.com
 * @data: 2016/2/18 17:28
 * @version: V1.0
 */
public class GlideConfiguration implements GlideModule {

    @Override
    public void applyOptions(Context context, GlideBuilder builder) {
        //如果你对默认的RGB_565效果还比较满意，可以不做任何事，但是如果你觉得难以接受，可以创建一个新的GlideModule将Bitmap格式转换到ARGB_8888：
        builder.setDecodeFormat(DecodeFormat.PREFER_RGB_565);
    }

    @Override
    public void registerComponents(Context context, Glide glide) {

    }

}
