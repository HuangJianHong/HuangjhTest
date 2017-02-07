package com.cncn.library.ui.widge;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;

import com.cncn.library.R;

/**
 * <自定义圆形进度条>
 *
 * @author caiyk@cncn.com
 * @data: 2016/8/4 10:27
 * @version: V1.0
 */
public class CircleProgress extends View {
    private float roundWidth;
    private int roundColor;
    private int progressColor;
    private int max;
    private float textSize;
    private int textColor;
    private int style;
    private static final int STROKE = 1;
    private static final int FILL = 2;
    private Paint mPaint;
    private int progress;


    public CircleProgress(Context context) {
        this(context, null);
    }

    public CircleProgress(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircleProgress(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint();

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CircleProgress);
        roundColor = typedArray.getColor(R.styleable.CircleProgress_round_color, Color.GRAY);
        roundWidth = typedArray.getDimension(R.styleable.CircleProgress_round_width, 40);
        max = typedArray.getInteger(R.styleable.CircleProgress_max, 360);
        progressColor = typedArray.getColor(R.styleable.CircleProgress_progress_color, Color.BLACK);
        textSize = typedArray.getDimension(R.styleable.CircleProgress_text_size, 30);
        textColor = typedArray.getColor(R.styleable.CircleProgress_text_color, Color.BLACK);
        style = typedArray.getInt(R.styleable.CircleProgress_style, 1);
        typedArray.recycle();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int center = getWidth() / 2;
        int radius = (int) (center - roundWidth / 2);
        mPaint.setColor(roundColor);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(roundWidth);
        mPaint.setAntiAlias(true);
        canvas.drawCircle(center, center, radius, mPaint);

        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setStrokeWidth(roundWidth);
        mPaint.setColor(progressColor);
        RectF oval = new RectF(center - radius, center - radius, center + radius, center + radius);
        mPaint.setStyle(style == FILL ? Paint.Style.FILL_AND_STROKE : Paint.Style.STROKE);
        canvas.drawArc(oval, 0, 360 * progress / max, style == FILL, mPaint);


        mPaint.setStrokeWidth(0);
        mPaint.setColor(textColor);
        mPaint.setTextSize(textSize);
        mPaint.setTypeface(Typeface.DEFAULT_BOLD);
        int percent = (int) (((float) progress / (float) max) * 100);
        float textWidth = mPaint.measureText(percent + "%");
        canvas.drawText(percent + "%", center - textWidth / 2, center + textSize / 2, mPaint);
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getProgress() {
        return progress;
    }

    public synchronized void setProgress(int progress) {
        if (progress < 0) {
            throw new IllegalArgumentException("not less than 0");
        }
        if (progress <= max) {
            /*ValueAnimator valueAnimator = ValueAnimator.ofInt(getProgress(), progress).setDuration(3000);
            valueAnimator.addUpdateListener(animation -> {
            });*/
            this.progress = progress;
            postInvalidate();
//            valueAnimator.start();
        }
    }
}
