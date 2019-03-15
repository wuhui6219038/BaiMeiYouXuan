package com.baimeiyx.www.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.baimeiyx.www.utils.LogUtils;
import com.example.mrw.baimeiyouxuan.R;

public class HealthPageCardView extends FrameLayout {
    private Context mContext;
    private int iv_1_bg_value, iv_2_bg_value, iv_1_src_value, iv_2_src_value;
    private String tv_title_1_value, tv_title_2_value, tv_sub_title_1_value, tv_sub_title_2_value;
    private ImageView iv_1, iv_2;
    private TextView tv_title_1, tv_sub_title_1, tv_title_2, tv_sub_title_2;
    private View item_1, item_2;
    private ItemClickListener listener;
    /**
     * 点击按钮的类型
     */
    private int subButtonType, subButtonType2;

    public HealthPageCardView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        _init(context, attrs);
    }

    public HealthPageCardView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        _init(context, attrs);
    }

    private void _init(Context context, @Nullable AttributeSet attrs) {
        this.mContext = context;
        _initAttr(attrs);
        _initSubView();
    }

    private void _initAttr(AttributeSet attrs) {
        TypedArray ta = mContext.obtainStyledAttributes(attrs, R.styleable.HealthPageCardView);
        iv_1_bg_value = ta.getResourceId(R.styleable.HealthPageCardView_iv_1_bg, 0);
        iv_1_src_value = ta.getResourceId(R.styleable.HealthPageCardView_iv_1_src, 0);
        tv_title_1_value = ta.getString(R.styleable.HealthPageCardView_tv_title_1);
        tv_sub_title_1_value = ta.getString(R.styleable.HealthPageCardView_tv_sub_title_1);
        iv_2_bg_value = ta.getResourceId(R.styleable.HealthPageCardView_iv_2_bg, 0);
        iv_2_src_value = ta.getResourceId(R.styleable.HealthPageCardView_iv_2_src, 0);
        tv_title_2_value = ta.getString(R.styleable.HealthPageCardView_tv_title_2);
        tv_sub_title_2_value = ta.getString(R.styleable.HealthPageCardView_tv_sub_title_2);
        subButtonType = ta.getInt(R.styleable.HealthPageCardView_subButtonType,0);
        subButtonType2 = ta.getInt(R.styleable.HealthPageCardView_subButtonType2,0);
        ta.recycle();
    }

    private void _initSubView() {
        View subView = LayoutInflater.from(mContext).inflate(R.layout.item_health_page_view, null, false);
        iv_1 = subView.findViewById(R.id.iv_1);
        iv_2 = subView.findViewById(R.id.iv_2);
        tv_title_1 = subView.findViewById(R.id.tv_title_1);
        tv_title_2 = subView.findViewById(R.id.tv_title_2);
        tv_sub_title_1 = subView.findViewById(R.id.tv_sub_title_1);
        tv_sub_title_2 = subView.findViewById(R.id.tv_sub_title_2);
        item_1 = subView.findViewById(R.id.ll_item_1);
        item_2 = subView.findViewById(R.id.ll_item_2);
        item_1.setOnClickListener((view) ->
                onClick(subButtonType)
        );
        item_2.setOnClickListener((view) ->
                onClick(subButtonType2)
        );
        iv_1.setBackgroundResource(iv_1_bg_value);
        iv_1.setImageDrawable(getResources().getDrawable(iv_1_src_value));
        iv_2.setBackgroundResource(iv_2_bg_value);
        iv_2.setImageDrawable(getResources().getDrawable(iv_2_src_value));
        tv_title_1.setText(tv_title_1_value);
        tv_title_2.setText(tv_title_2_value);
        tv_sub_title_2.setText(tv_sub_title_2_value);
        tv_sub_title_1.setText(tv_sub_title_1_value);

        this.addView(subView);
    }

    private void onClick(int subButtonType) {
        if (subButtonType==0 || listener == null) {
            LogUtils.e("没有设置type类型或者listener为空");
        } else {
            LogUtils.e(subButtonType);
            listener.onItemClick(subButtonType);

        }
    }

    public void setItemClickListener(ItemClickListener listener) {
        this.listener = listener;


    }

    public interface ItemClickListener {
        void onItemClick(int subButtonType);
    }

}

