package com.baimeiyx.www.ui.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.baimeiyx.www.service.model.FoodsDetailResult;
import com.baimeiyx.www.service.model.FoodsResult;
import com.baimeiyx.www.utils.ImageUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.mrw.baimeiyouxuan.R;


public class AdapterHealthFoodsDetail extends BaseQuickAdapter<FoodsDetailResult.PageBean.ListBean, AdapterHealthFoodsDetail.HealthFoodsDetailViewHolder> {
    private Context mContext;

    public AdapterHealthFoodsDetail(Context context, int layoutResId) {
        super(layoutResId);
        this.mContext = context;
    }

    @Override
    protected void convert(HealthFoodsDetailViewHolder helper, FoodsDetailResult.PageBean.ListBean item) {
        helper.addOnClickListener(R.id.iv_foods_detail_img);
        ImageUtils.loadImgSrcByUrlCorner(mContext, helper.ivFoodsDetailImg, item.getFoodImg());
        helper.tvFoodsDetailName.setText(item.getFoodName());
        helper.tvFoodsDetailnNtrientElement.setText(item.getNutrientElement());
        helper.tvFoodsDetailUnit.setText(TextUtils.isEmpty(item.getRemark()) ? "毫克" : item.getRemark());
    }


    final class HealthFoodsDetailViewHolder extends BaseViewHolder {
        private ImageView ivFoodsDetailImg;
        private TextView tvFoodsDetailName;
        private TextView tvFoodsDetailUnit;
        private TextView tvFoodsDetailnNtrientElement;

        public HealthFoodsDetailViewHolder(View view) {
            super(view);
            ivFoodsDetailImg = view.findViewById(R.id.iv_foods_detail_img);
            tvFoodsDetailName = view.findViewById(R.id.tv_foods_detail_title);
            tvFoodsDetailUnit = view.findViewById(R.id.tv_foods_detail_unit);
            tvFoodsDetailnNtrientElement = view.findViewById(R.id.tv_foods_detail_nutrientElement);

        }
    }
}
