package com.baimeiyx.www.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.example.mrw.baimeiyouxuan.R;

public class Sun extends View {
    private Paint fontPaint, mPaint;
    private static final String TAG = "Sun";
    private String text = "我是测试内容", subText = "我是二号标题";
    private float centerTextSize = 20;
    private float subTextSize;
    //完成的角度
    private float sweepAngle = 50;
    private int chooseColor, unChooseColor, centerTextColor, subTextColor;
    //两个光芒线之间的间隔度数
    private int offsetDegress = 10;
    //开始位置的角度
    private int startAngle = -90;
    //圆的半径
    private float radius = 200;
    //顶部原点半径
    private float pointRadius = 10;
    private float subTopToCenter;
    private boolean showOuter = true;

    public Sun(Context context, AttributeSet attrs) {
        super(context, attrs);
        _init(context, attrs);
    }

    public Sun(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        _init(context, attrs);
    }

    public Sun(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        _init(context, attrs);
    }

    private void _init(Context context, AttributeSet attrs) {

        _initAttr(context, attrs);
        _initPaint();
    }

    private void _initAttr(Context context, AttributeSet attrs) {
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.Sun);
        centerTextSize = ta.getDimension(R.styleable.Sun_centerTextSize, 20);
        subTextSize = ta.getDimensionPixelSize(R.styleable.Sun_subTextSize, 15);
        centerTextColor = ta.getColor(R.styleable.Sun_centerTextColor, Color.RED);
        subTextColor = ta.getColor(R.styleable.Sun_subTextColor, Color.RED);
        chooseColor = ta.getColor(R.styleable.Sun_chooseColor, Color.RED);
        unChooseColor = ta.getColor(R.styleable.Sun_unChooseColor, Color.GRAY);
        radius = ta.getDimension(R.styleable.Sun_radius, 150);
        pointRadius = ta.getDimension(R.styleable.Sun_pointRadius, 10);
        subTopToCenter = ta.getDimension(R.styleable.Sun_subTextTopToCenter, 30);
    }

    private void _initPaint() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth(8);
        fontPaint = new Paint();
        fontPaint.setAntiAlias(true);
    }

    private int count = 0;

    @Override
    protected void onDraw(Canvas canvas) {
        count++;
        if (count == 2) {
            super.onDraw(canvas);
            Log.e(TAG, "onDraw: ");
            //绘制文字
            fontPaint.setColor(centerTextColor);
            fontPaint.setTextSize(centerTextSize);
            float baseline = (getMeasuredHeight() - (fontPaint.descent() - fontPaint.ascent())) / 2 - fontPaint.ascent();
            float textWidth = fontPaint.measureText(text);
            canvas.drawText(text, (getWidth() - textWidth) / 2, baseline, fontPaint);

            fontPaint.setColor(subTextColor);
            fontPaint.setTextSize(subTextSize);
            float baseSubTextline = baseline + subTopToCenter;
            float SubTextWidth = fontPaint.measureText(subText);
            canvas.drawText(subText, (getWidth() - SubTextWidth) / 2, baseSubTextline, fontPaint);

            mPaint.setStyle(Paint.Style.STROKE);
            canvas.translate(getWidth() / 2, getHeight() / 2);
            mPaint.setColor(unChooseColor);
            canvas.drawCircle(0, 0, radius, mPaint);
            mPaint.setStyle(Paint.Style.FILL);
            mPaint.setColor(Color.RED);
            canvas.drawCircle(radius * (float) Math.cos(startAngle * Math.PI / 180), radius * (float) Math.sin(startAngle * Math.PI / 180), pointRadius, mPaint);
            mPaint.setStyle(Paint.Style.STROKE);
            canvas.drawArc(new RectF(-radius, -radius, radius, radius), startAngle, sweepAngle, false, mPaint);
            int realDegress;
            //绘制外边的光芒
            if (showOuter) {
                for (int i = 0; i < 36; i++) {
                    realDegress = startAngle + offsetDegress * i;
                    float startX = (radius + 20) * (float) Math.cos(realDegress * Math.PI / 180);
                    float startY = (radius + 20) * (float) Math.sin(realDegress * Math.PI / 180);
                    float endX = (radius + 40) * (float) Math.cos(realDegress * Math.PI / 180);
                    float endY = (radius + 40) * (float) Math.sin(realDegress * Math.PI / 180);

                    if (offsetDegress * i <= sweepAngle) {
                        mPaint.setColor(chooseColor);
                    } else {
                        mPaint.setColor(unChooseColor);
                    }
                    canvas.drawLine(startX, startY, endX, endY, mPaint);
                }
            }
        }
    }
}
