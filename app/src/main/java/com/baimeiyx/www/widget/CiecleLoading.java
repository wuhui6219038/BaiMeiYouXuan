package com.baimeiyx.www.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;

import com.baimeiyx.www.utils.LogUtils;
import com.baimeiyx.www.utils.SizeUtils;
import com.example.mrw.baimeiyouxuan.R;

public class CiecleLoading extends View {
    private static final int STARTDEGRESS = 10;
    private Paint mPaint, fontPaint;
    private int rotateDegrees = 30;
    /**
     * 旋转圆的半径
     */
    private float smallRadius = 5f;
    /**
     * 轨迹圆的大小
     */
    private float radius = SizeUtils.dp2px(20);
    /**
     * 旋转速度
     */
    private int speed = 50;

    /**
     * 数值大小,单位大小
     */
    private float textSize, unitTextSize;
    private int textColor;
    private int smallCircleColor;
    private String text = "11.2";
    private String text2 = "kg";
    private boolean start = false;

    public CiecleLoading(Context context, AttributeSet attrs) {
        super(context, attrs);
        _init(context, attrs);
    }

    public CiecleLoading(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        _init(context, attrs);
    }

    public CiecleLoading(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        _init(context, attrs);
    }

    private void _init(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CircleLoading);
        speed = typedArray.getInteger(R.styleable.CircleLoading_speed, 30);
        smallRadius = typedArray.getFloat(R.styleable.CircleLoading_smallRadius, 5);
        radius = typedArray.getDimension(R.styleable.CircleLoading_locusRadius, 50);
        textSize = typedArray.getDimension(R.styleable.CircleLoading_textSize, 30);
        unitTextSize = typedArray.getDimension(R.styleable.CircleLoading_unitTextSize, 20);
        textColor = typedArray.getColor(R.styleable.CircleLoading_textColor, Color.RED);
        smallCircleColor = typedArray.getColor(R.styleable.CircleLoading_smallCircleColor, Color.RED);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.RED);
        fontPaint = new Paint();
        fontPaint.setAntiAlias(true);
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        Typeface font = Typeface.create(Typeface.SANS_SERIF, Typeface.BOLD);
        fontPaint.setTypeface(font);
        fontPaint.setColor(textColor);
        fontPaint.setTextSize(textSize);
        float baseline = (getMeasuredHeight() - (fontPaint.descent() - fontPaint.ascent())) / 2 - fontPaint.ascent();
        float strWidth = fontPaint.measureText(text);
        float strWidth2 = fontPaint.measureText(text2);
        canvas.drawText(text, getWidth() / 2 - (strWidth + strWidth2) / 2, baseline, fontPaint);
        fontPaint.setTextSize(unitTextSize);
        canvas.drawText(text2, getWidth() / 2 - (strWidth + strWidth2) / 2 + strWidth + 20, baseline, fontPaint);
        canvas.translate(getWidth() / 2, getHeight() / 2);
        //实际旋转的角度
        float realRotateDegrees = 0;

        if (rotateDegrees == 360) {
            rotateDegrees = STARTDEGRESS;
        }

        mPaint.setColor(smallCircleColor);
        for (int index = 0; index < 360 / STARTDEGRESS; index++) {
            if (realRotateDegrees > 2 * Math.PI) {
                realRotateDegrees = (rotateDegrees + STARTDEGRESS * index - 360) * (float) Math.PI / 180;
            } else {
                realRotateDegrees = (rotateDegrees + STARTDEGRESS * index) * (float) Math.PI / 180;
            }
            canvas.drawCircle(radius * (float) Math.sin(-realRotateDegrees), radius * (float) Math.cos(-realRotateDegrees), smallRadius, mPaint);
        }
        rotateDegrees = rotateDegrees + 1;

        canvas.rotate(rotateDegrees, getWidth() / 2, getWidth() / 2);

        postInvalidateDelayed(speed);
        if (start) {

        }
    }

    public void setText(String value) {
        this.text = value;
    }

    public String getText() {
        return text;
    }

    public void start() {
        start = true;
        invalidate();
    }

    public void stop() {
        start = false;
    }
}
