package com.baimeiyx.www.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.baimeiyx.www.utils.LogUtils;

/**
 * BMI 等级自定义图
 */
public class BMILevelVIew extends View {
    /**
     * 默认每个区域的颜色
     */
    private static final int[] DEFAULT_COLORS = {Color.GRAY, Color.GREEN, Color.YELLOW, Color.RED};
    /**
     * 默认轨迹的宽度
     */
    private static final float DEFAULT_STROKEWIDTH = 10.0f;
    /**
     * 外部paint
     */
    private Paint outPaint;
    /**
     * 内部控件的paint
     */
    private Paint innerPaint;
    /**
     * 字体的paint
     */
    private Paint fontPaint;
    private float mWidth, mHeigth;
    /**
     * 外圆，指针所在圆的半径,内圆的半径
     */
    private float mOutRadius, mSecRadius, mInnerRadius = 10;
    /**
     * 旋转角度
     */
    private float rotateDegress = 30;
    /**
     * 是否需要在每个区域块中插入颜色
     */
    private boolean isNeedInsertColor;

    public BMILevelVIew(Context context) {
        super(context);
        _init(context);
    }

    public BMILevelVIew(Context context, AttributeSet attrs) {
        super(context, attrs);
        _init(context);
    }

    public BMILevelVIew(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        _init(context);
    }

    private void _init(Context context) {
        _initPaint();
    }

    private void _initPaint() {
        outPaint = new Paint();
        outPaint.setAntiAlias(true);
        outPaint.setStrokeWidth(DEFAULT_STROKEWIDTH);
        outPaint.setStyle(Paint.Style.STROKE);
        innerPaint = new Paint();
        innerPaint.setAntiAlias(true);
        innerPaint.setStyle(Paint.Style.STROKE);
        fontPaint = new Paint();
        fontPaint.setAntiAlias(true);
        fontPaint.setStyle(Paint.Style.STROKE);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mHeigth = getHeight();
        mWidth = getWidth();
        float x = mWidth / 4;
        float y = mHeigth / 4;
        RectF oval = new RectF(x, y, mWidth - x, mHeigth - y);
        int sweepAngle = 45;
        int smallSweepAngle = 10;
        int startAngle;

        fontPaint.setColor(Color.RED);
        float textX, textY;
        for (int i = 1; i < 5; i++) {
            outPaint.setColor(DEFAULT_COLORS[i - 1]);
            if (i != 1) {
                startAngle = -180 + (i - 1) * sweepAngle + smallSweepAngle / 2;
            } else {
                startAngle = -180 + (i - 1) * sweepAngle;
            }
            canvas.drawArc(oval, startAngle, sweepAngle - smallSweepAngle / 2, false, outPaint);
            if (i != 4) {
                outPaint.setColor(Color.BLACK);
                canvas.drawArc(oval, -180 + i * sweepAngle - smallSweepAngle / 2, smallSweepAngle, false, outPaint);
            }
            String text = "我是测试字体";
            float strWidth = fontPaint.measureText(text);
            double angle = 0;
            if (i < 3) {
                angle = (-180 + sweepAngle * (i - 1)) * Math.PI / 180;
                textX = mWidth / 2 + mWidth / 4 * (float) Math.cos(angle) - strWidth;
            } else {
                angle = (-180 + sweepAngle * i) * Math.PI / 180;
                textX = mWidth / 2 + mWidth / 4 * (float) Math.cos(angle);
            }

            textY = mHeigth / 2 + mHeigth / 4 * (float) Math.sin(angle);
//            LogUtils.e("startAngle=" + startAngle + "  X=" + mWidth / 2 + "  Y=" + mHeigth / 2 + "  " + Math.cos(angle));
//            LogUtils.e("textX=" + textX + "  textY=" + textY);
            canvas.drawText("我是测试字体" + i, textX, textY, fontPaint);

        }
        _drawPointer(canvas, -90 * Math.PI / 180);

    }

    /**
     * 绘制圆形指针
     *
     * @param canvas
     */
    private void _drawPointer(Canvas canvas, double angle) {

        mSecRadius = mHeigth / 5;
        Paint pointPaint = new Paint();
        pointPaint.setStyle(Paint.Style.FILL);
        pointPaint.setColor(Color.BLACK);
        pointPaint.setStrokeWidth(10);
        canvas.rotate(rotateDegress - 90, mWidth / 2, mHeigth / 2);
        //顶点
        float startX = mWidth / 2 + mSecRadius * (float) Math.cos(angle);
        float startY = mHeigth / 2 + mSecRadius * (float) Math.sin(angle);
        LogUtils.e(Math.cos(angle) + " " + Math.sin(angle));
//        canvas.drawPoint(startX, startY, pointPaint);
        //切点
        float cutPointX = mWidth / 2 - mInnerRadius * (float) Math.sin(angle);
        float cutPointY = mHeigth / 2 - mInnerRadius * (float) Math.cos(angle);
//        canvas.drawPoint(cutPointX, cutPointY, pointPaint);
        //第二切点
        float cutPointX2 = mWidth / 2 + mInnerRadius * (float) Math.sin(angle);
        float cutPointY2 = mHeigth / 2 + mInnerRadius * (float) Math.cos(angle);

        Path path = new Path();
        path.moveTo(startX, startY);
        path.lineTo(cutPointX, cutPointY);
        innerPaint.setStyle(Paint.Style.FILL);
        innerPaint.setColor(Color.RED);
        canvas.drawCircle(mWidth / 2, mHeigth / 2, 10, innerPaint);
        path.lineTo(cutPointX2, cutPointY2);
        path.lineTo(startX, startY);
        canvas.drawPath(path, innerPaint);

    }
}
