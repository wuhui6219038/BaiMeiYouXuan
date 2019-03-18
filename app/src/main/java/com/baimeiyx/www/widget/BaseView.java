package com.baimeiyx.www.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

public class BaseView extends View {
    private CustomViewOnClickListener listener;

    public BaseView(Context context) {
        super(context);
    }

    public BaseView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BaseView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public BaseView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    void setCustomViewOnClickListener(CustomViewOnClickListener listener) {
        this.listener = listener;
    }
}
