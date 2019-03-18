package com.baimeiyx.www.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mrw.baimeiyouxuan.R;

/**
 * 减肥工具item
 */
public class LossToolItemView extends FrameLayout implements View.OnClickListener {

    private String title, detail;
    private TextView tvTitle, tvDetail;
    private ImageView imageView;
    private Context mContext;
    private int backgroudId, imageId;
    private OnItemClickListenser listenser;

    public LossToolItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        _init(context, attrs);
    }

    public LossToolItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        _init(context, attrs);
    }

    private void _init(Context context, AttributeSet attrs) {
        this.mContext = context;
        _initAttr(attrs);
        _initSubView();
        setBackground(getResources().getDrawable(backgroudId));
    }

    private void _initAttr(AttributeSet attrs) {
        TypedArray ta = mContext.obtainStyledAttributes(attrs, R.styleable.LossTool);
        title = ta.getString(R.styleable.LossTool_loss_tool_title);
        detail = ta.getString(R.styleable.LossTool_loss_tool_detail);
        backgroudId = ta.getResourceId(R.styleable.LossTool_loss_tool_bg, 0);
        imageId = ta.getResourceId(R.styleable.LossTool_loss_tool_image, 0);
    }

    private void _initSubView() {
        View subView = LayoutInflater.from(mContext).inflate(R.layout.item_loss_tool_view, null, false);
        tvTitle = subView.findViewById(R.id.tv_loss_tool_title);
        tvDetail = subView.findViewById(R.id.tv_loss_tool_detail);
        imageView = subView.findViewById(R.id.iv_loss_tool);
        tvTitle.setText(title);
        tvDetail.setText(detail);
        imageView.setImageDrawable(getResources().getDrawable(imageId));
        addView(subView);
        setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        listenser.onItemClick(v, imageId);
    }

    public void setOnItemClickListenser(OnItemClickListenser listenser) {
        this.listenser = listenser;
    }

    public interface OnItemClickListenser {
        void onItemClick(View view, int type);
    }

}
