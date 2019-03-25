package com.baimeiyx.www.ui.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baimeiyx.www.service.model.FoodsResult;
import com.baimeiyx.www.utils.ImageUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.mrw.baimeiyouxuan.R;


public class AdapterHealthFoods extends BaseQuickAdapter<FoodsResult.PageBean.ListBean, AdapterHealthFoods.HealthFoodsViewHolder> {
    private Context mContext;

    public AdapterHealthFoods(Context context, int layoutResId) {
        super(layoutResId);
        this.mContext = context;
    }

    @Override
    protected void convert(HealthFoodsViewHolder helper, FoodsResult.PageBean.ListBean item) {
        ImageUtils.loadImageUrlRound(mContext, helper.ivFoodsImg, item.getCion());
        helper.tvFoodsName.setText(item.getTypeName());
    }


    final class HealthFoodsViewHolder extends BaseViewHolder {
        private ImageView ivFoodsImg;
        private TextView tvFoodsName;

        public HealthFoodsViewHolder(View view) {
            super(view);
            ivFoodsImg = view.findViewById(R.id.iv_foods_img);
            tvFoodsName = view.findViewById(R.id.tv_foods_name);

        }
    }
}
