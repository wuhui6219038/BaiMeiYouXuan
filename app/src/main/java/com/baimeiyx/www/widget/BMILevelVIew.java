package com.baimeiyx.www.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.baimeiyx.www.utils.LogUtils;
import com.baimeiyx.www.utils.SizeUtils;

/**
 * BMI 等级自定义图
 */
public class BMILevelVIew extends View {
    private static final String TAG = "BMILevelVIew";
    /**
     * 默认每个区域的颜色
     */
    private static final String[] DEFAULT_COLORS = {"#CBCCD0", "#6DC00A", "#F5C623", "#EC6416"};
    /**
     * 默认轨迹的宽度
     */
    private static final float DEFAULT_STROKEWIDTH = 40.0f;
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
    private float mOutRadius, mSecRadius, mInnerRadius = 40;
    /**
     * 旋转角度
     */
    private float rotateDegress = 30;
    /**
     * 是否需要在每个区域块中插入颜色
     */
    private boolean isNeedInsertColor;
    private static final String[] titleText = {"BMI<18.5", "18.5≤BMI＜24", "24≤BMI＜28", "28≤BMI"};
    private static final String[] subTitleText = {"轻体重", "健康体重", "超重", "肥胖"};

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
        fontPaint.setStyle(Paint.Style.FILL);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mWidth = Math.min(getWidth(), getHeight());
        mHeigth = mWidth;

        float x = mWidth / 4;
        float y = mHeigth / 4;
        RectF oval = new RectF(x, y, mWidth - x, mHeigth - y);
        int sweepAngle = 45;
        int smallSweepAngle = 4;
        int startAngle;
        float offset = 40;
        fontPaint.setColor(Color.WHITE);
        fontPaint.setTextSize(SizeUtils.sp2px(12));
        float textX, textY, subTextX;
        for (int i = 1; i < 5; i++) {
            outPaint.setColor(Color.parseColor(DEFAULT_COLORS[i - 1]));
            startAngle = -180 + (i - 1) * sweepAngle;
            canvas.drawArc(oval, startAngle, sweepAngle, false, outPaint);
//            if (i != 4 ) {
//                outPaint.setColor(Color.WHITE);
//                Log.e(TAG, "onDraw: "+(-180 + i * sweepAngle + smallSweepAngle / 2) );
//                canvas.drawArc(oval, -180 + i * sweepAngle + smallSweepAngle / 2, smallSweepAngle, false, outPaint);
//            }


            float strWidth = fontPaint.measureText(titleText[i - 1]);
            float strWidth2 = fontPaint.measureText(subTitleText[i - 1]);
            double angle = 0;
            if (i < 3) {
                angle = (-160 + sweepAngle * (i - 1)) * Math.PI / 180;
                textX = mWidth / 2 + mWidth / 4 * (float) Math.cos(angle) - strWidth - offset;
                subTextX = textX + strWidth / 2 - strWidth2 / 2;
            } else {
                angle = (-200 + sweepAngle * i) * Math.PI / 180;
                textX = mWidth / 2 + mWidth / 4 * (float) Math.cos(angle) + offset;
                subTextX = textX + strWidth / 2 - strWidth2 / 2;
            }

            textY = mHeigth / 2 + mHeigth / 4 * (float) Math.sin(angle);
            canvas.drawText(titleText[i - 1], textX, textY, fontPaint);
            canvas.drawText(subTitleText[i - 1], subTextX, textY + fontPaint.ascent() - 10, fontPaint);

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
        pointPaint.setColor(Color.WHITE);
        canvas.rotate(rotateDegress - 90, mWidth / 2, mHeigth / 2);
        //顶点
        float startX = mWidth / 2 + mSecRadius * (float) Math.cos(angle);
        float startY = mHeigth / 2 + mSecRadius * (float) Math.sin(angle);
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
        innerPaint.setColor(Color.WHITE);
        canvas.drawCircle(mWidth / 2, mHeigth / 2, mInnerRadius, pointPaint);
        path.lineTo(cutPointX2, cutPointY2);
        path.lineTo(startX, startY);
        canvas.drawPath(path, innerPaint);

    }

    public void setRotateDegress(float degress) {
        this.rotateDegress = degress;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(measure(widthMeasureSpec), measure(widthMeasureSpec));


    }

    private int measure(int measureSpec) {
        int result;
        int mode = MeasureSpec.getMode(measureSpec);
        int size = MeasureSpec.getSize(measureSpec);
        if (mode == MeasureSpec.EXACTLY) {
            result = size;
        } else {
            result = SizeUtils.dp2px(200);
            if (mode == MeasureSpec.AT_MOST) {
                result = Math.min(result, size);
            }
        }
        return result;
    }
}
