package com.baimeiyx.www.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

import com.example.mrw.baimeiyouxuan.R;
import com.baimeiyx.www.utils.SizeUtils;


/**
 * @author mr.w
 * @desc 步骤类控件
 */
public class StepView extends View {
    private Paint mPaint, textPaint;
    private int mWidth, mHeight;
    private Context mContext;
    //背景默认宽度
    private static final int DEFLUAT_HEIGHT = 20;
    //默认步骤数
    private static final int DEFLUAT_STEPS = 5;
    //选中的状态位置
    private static final int DEFLUAT_CHECK_POS = 2;
    //radius圆圈半径
    private static final int DEFLUAT_RADIUS = 50;
    //字体大小
    private static final int DEFLUAT_FONT_SIZE = 18;
    private int steps, checkPos;
    private String[] titles;

    public StepView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        _init(context, attrs);
    }

    public StepView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        _init(context, attrs);
    }

    private void _init(Context context, AttributeSet attrs) {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        this.mContext = context;
        _initAttr(attrs);
        _initTextPaint();
    }

    private void _initAttr(AttributeSet attrs) {
        TypedArray ta = mContext.obtainStyledAttributes(attrs, R.styleable.StepView);
        steps = ta.getInteger(R.styleable.StepView_steps, DEFLUAT_STEPS);
        checkPos = ta.getInteger(R.styleable.StepView_checkpos, DEFLUAT_CHECK_POS);

        ta.recycle();
    }

    private void _initTextPaint() {
        textPaint = new Paint();
        textPaint.setColor(Color.WHITE);
        textPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        textPaint.setTextAlign(Paint.Align.CENTER);
        textPaint.setAntiAlias(true);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(measureWidth(widthMeasureSpec),
                measureHeight(heightMeasureSpec));
    }

    private int measureHeight(int measureSpec) {
        int result = 0;
        int mode = MeasureSpec.getMode(measureSpec);
        int size = MeasureSpec.getSize(measureSpec);

        if (mode == MeasureSpec.EXACTLY) {
            result = size;
        } else {
            result = SizeUtils.dp2px(50);
            if (mode == MeasureSpec.AT_MOST) {
                result = Math.min(result, size);
            }
        }
        return result;

    }

    private int measureWidth(int measureSpec) {
        int result = 0;
        int mode = MeasureSpec.getMode(measureSpec);
        int size = MeasureSpec.getSize(measureSpec);

        if (mode == MeasureSpec.EXACTLY) {
            result = size;
        } else {
            result = 75;//根据自己的需要更改
            if (mode == MeasureSpec.AT_MOST) {
                result = Math.min(result, size);
            }
        }
        return result;

    }


    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //圆角矩形
        mPaint.setStyle(Paint.Style.FILL);//充满
        mPaint.setStrokeWidth(5);
        mPaint.setColor(Color.LTGRAY);
        mPaint.setAlpha(55);
        int margin = mWidth / 10;
        RectF oval3 = new RectF(margin, (mHeight - DEFLUAT_HEIGHT) / 2, mWidth - margin, (mHeight + DEFLUAT_HEIGHT) / 2);// 设置个新的长方形
        canvas.drawRoundRect(oval3, 20, 15, mPaint);//第二个参数是x半径，第三个参数是y半径
        //画圆圈
        int cy = mHeight / 2;
        int startCx = mWidth / 5;
        int radius;
        for (int index = 0; index < steps; index++) {
            if (index == checkPos) {
                mPaint.setColor(mContext.getColor(R.color.colocCheckStep));
                radius = DEFLUAT_RADIUS + 10;
                textPaint.setTextSize(SizeUtils.sp2px(DEFLUAT_FONT_SIZE + 5));
            } else {
                textPaint.setTextSize(SizeUtils.sp2px(DEFLUAT_FONT_SIZE));
                mPaint.setColor(mContext.getColor(R.color.colorPrimary));
                radius = DEFLUAT_RADIUS;
            }
            canvas.drawCircle(startCx, cy, radius, mPaint);
            drawText(titles[index], new Rect(startCx - radius, cy - radius, startCx + radius, cy + radius), canvas);
            startCx += mWidth * 3 / 20;
        }
    }

    private void drawText(String text, Rect rect, Canvas canvas) {
        Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
        float top = fontMetrics.top;//为基线到字体上边框的距离,即上图中的top
        float bottom = fontMetrics.bottom;//为基线到字体下边框的距离,即上图中的bottom
        int baseLineY = (int) (rect.centerY() - top / 2 - bottom / 2);//基线中间点的y轴计算公式
        canvas.drawText(text, rect.centerX(), baseLineY, textPaint);

    }

    public void setStepsNum(int stepsNum) {
        this.steps = stepsNum;
    }

    public void setCheckPos(int checkPos) {
        this.checkPos = checkPos;
    }

    /**
     * 设置步骤的标题
     *
     * @param titles
     */
    public void setStepsTitle(String[] titles) {
        this.titles = titles;
    }
}
