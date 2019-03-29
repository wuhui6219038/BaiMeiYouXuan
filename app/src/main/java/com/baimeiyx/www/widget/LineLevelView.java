package com.baimeiyx.www.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.baimeiyx.www.service.model.QingNiuBean;
import com.baimeiyx.www.utils.SizeUtils;
import com.example.mrw.baimeiyouxuan.R;

public class LineLevelView extends View {
    private static final String TAG = "LineLevelView";
    private Paint mPaint, fontPaint;
    private int lowerColor, lowColor, standardColor, highColor, higherColor;
    private String lowerValue, lowValue, standardValue, highValue, higherValue;
    private float lowerLeverMaxValue, lowLeverMaxValue, standardLevelMaxValue, highLevelMaxValue;
    //等级
    private int levelCount;
    //字体大小
    private float lineLevelTextSize;
    //选中字体的大小
    private float chooseLineLevelTextSize;

    private float currentLevel = 3;
    private QingNiuBean qingNiuBean;
    private boolean existLower, existLow, existStandard, existHigh, existHigher;
    float levelWidth;
    private int drawCount = 0;

    public LineLevelView(Context context, AttributeSet attrs) {
        super(context, attrs);
        _init(context, attrs);
    }

    public LineLevelView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        _init(context, attrs);
    }

    public LineLevelView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        _init(context, attrs);
    }

    private void _init(Context context, AttributeSet attrs) {
        Log.e(TAG, "_init: ");
        _attr(context, attrs);
        _initLevel();
        _initPaint();
    }

    private void _attr(Context context, AttributeSet attrs) {
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.LineLevelView);
        lowerColor = ta.getColor(R.styleable.LineLevelView_lowerColor, getResources().getColor(R.color.levelLower));
        lowColor = ta.getColor(R.styleable.LineLevelView_lowColor, getResources().getColor(R.color.levelLow));
        standardColor = ta.getColor(R.styleable.LineLevelView_standardColor, getResources().getColor(R.color.levelStandard));
        highColor = ta.getColor(R.styleable.LineLevelView_highColor, getResources().getColor(R.color.levelHigh));
        higherColor = ta.getColor(R.styleable.LineLevelView_higherColor, getResources().getColor(R.color.levelHigher));
        lowerValue = ta.getString(R.styleable.LineLevelView_lowerLevelText);
        lowValue = ta.getString(R.styleable.LineLevelView_lowLevelText);
        standardValue = ta.getString(R.styleable.LineLevelView_standardLevelText);
        highValue = ta.getString(R.styleable.LineLevelView_highLevelText);
        higherValue = ta.getString(R.styleable.LineLevelView_higherLevelText);
        lineLevelTextSize = ta.getDimension(R.styleable.LineLevelView_lineLevelTextSize, 12);
        chooseLineLevelTextSize = ta.getDimension(R.styleable.LineLevelView_chooseLineLevelTextSize, 14);
        lowerLeverMaxValue = ta.getFloat(R.styleable.LineLevelView_lowerLeverMaxValue, 0);
        lowLeverMaxValue = ta.getFloat(R.styleable.LineLevelView_lowLeverMaxValue, 0);
        standardLevelMaxValue = ta.getFloat(R.styleable.LineLevelView_standardLevelMaxValue, 0);
        highLevelMaxValue = ta.getFloat(R.styleable.LineLevelView_highLevelMaxValue, 0);

    }

    private void _initQingNiu() {
        Log.e(TAG, "_initQingNiu:");
        lowerValue = qingNiuBean.getLevel_1();
        lowValue = qingNiuBean.getLevel_2();
        standardValue = qingNiuBean.getLevel_3();
        highValue = qingNiuBean.getLevel_4();
        higherValue = qingNiuBean.getLevel_5();
        lowerColor = getResources().getColor(qingNiuBean.getLevel_1_color());
        lowColor = getResources().getColor(qingNiuBean.getLevel_2_color());
        standardColor = getResources().getColor(qingNiuBean.getLevel_3_color());
        highColor = getResources().getColor(qingNiuBean.getLevel_4_color());
        higherColor = getResources().getColor(qingNiuBean.getLevel_5_color());
        lowerLeverMaxValue = qingNiuBean.getLowerLeverMaxValue();
        lowLeverMaxValue = qingNiuBean.getLowLeverMaxValue();
        standardLevelMaxValue = qingNiuBean.getStandardLevelMaxValue();
        highLevelMaxValue = qingNiuBean.getHighLevelMaxValue();
        currentLevel = qingNiuBean.getLevel();
        lineLevelTextSize = SizeUtils.sp2px(12);
        chooseLineLevelTextSize = SizeUtils.sp2px(14);
        _initLevel();
        _initPaint();
    }

    private void _initPaint() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL);
        fontPaint = new Paint();
        fontPaint.setAntiAlias(true);
        fontPaint.setStyle(Paint.Style.FILL);
    }

    private void _initLevel() {
        if (lowerLeverMaxValue != 0) {
            existLower = true;
            existLow = true;
        }
        if (lowLeverMaxValue != 0) {
            existLow = true;
            existStandard = true;
        }
        if (standardLevelMaxValue != 0) {
            existStandard = true;
            existHigh = true;
        }
        if (highLevelMaxValue != 0) {
            existHigh = true;
            existHigher = true;
        }
        if (existLower) {
            levelCount++;
        }
        if (existLow) {
            levelCount++;
        }
        if (existStandard) {
            levelCount++;
        }
        if (existHigh) {
            levelCount++;
        }
        if (existHigher) {
            levelCount++;
        }
        if (qingNiuBean != null)
            Log.e(TAG, qingNiuBean.getTypeName() + " levelCount=" + levelCount);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.e(TAG, "onMeasure: " + getWidth());
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        Log.e(TAG, "onSizeChanged: " + getWidth());
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        Log.e(TAG, "onLayout: " + getWidth());
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (levelCount != 0) {
            float startX = 0;
            drawCount++;
            levelWidth = getWidth() / levelCount;
            canvas.translate(0, getHeight() / 2);

            if (existLower) {
                startX = drawLevel(canvas, lowerColor, lowerValue, lowerLeverMaxValue, 1, startX);

            }
            if (existLow) {
                startX = drawLevel(canvas, lowColor, lowValue, lowLeverMaxValue, 2, startX);
            }
            if (existStandard) {
                startX = drawLevel(canvas, standardColor, standardValue, standardLevelMaxValue, 3, startX);
            }
            if (existHigh) {
                startX = drawLevel(canvas, highColor, highValue, highLevelMaxValue, 4, startX);
            }
            if (existHigher) {
                startX = drawLevel(canvas, higherColor, higherValue, 0, 5, startX);
            }
        }
    }

    private float drawLevel(Canvas canvas, int color, String textValue, float levelValue, int level, float startX) {

        int offset = 10;
        mPaint.setStrokeWidth(SizeUtils.dp2px(5));
        mPaint.setColor(color);
        canvas.drawLine(startX, 0, (startX + levelWidth), 0, mPaint);
        if (level == currentLevel) {
            fontPaint.setTextSize(chooseLineLevelTextSize);
            fontPaint.setColor(color);
        } else {
            fontPaint.setTextSize(lineLevelTextSize);
            fontPaint.setColor(Color.GRAY);
        }

        float textWidth = startX + (levelWidth - fontPaint.measureText(textValue)) / 2;
        Rect rect = new Rect();
        fontPaint.getTextBounds(textValue, 0, textValue.length(), rect);

        canvas.drawText(textValue, textWidth, rect.height() + offset, fontPaint);
//        if (drawCount == 1)
        startX += levelWidth;
        //绘制区间值
        if (levelValue != 0) {
            float levelValueWidth = startX - mPaint.measureText(textValue) / 2;
            fontPaint.setColor(Color.BLACK);
            fontPaint.setTextSize(lineLevelTextSize);
            canvas.drawText(levelValue + "", levelValueWidth, -offset, fontPaint);
        }
        return startX;
    }

    public void setValue(QingNiuBean bean) {
        this.qingNiuBean = bean;
        _initQingNiu();
    }

    public void setChooseLevel(int level) {
        this.currentLevel = level;
    }


}
