package com.baimeiyx.www.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.baimeiyx.www.service.model.FoodElementDetailResult;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.mrw.baimeiyouxuan.R;

public class AdapterFoodsElementDetails extends BaseQuickAdapter<FoodElementDetailResult.PageBean.NutrientListBean, AdapterFoodsElementDetails.FoodsElementDetailsViewHolder> {


    public AdapterFoodsElementDetails(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(FoodsElementDetailsViewHolder helper, FoodElementDetailResult.PageBean.NutrientListBean item) {
        helper.tvElement.setText(item.getName());
        helper.tvComponent.setText(item.getNutrientElement());
        helper.tvRemark.setText(item.getRemarks());
    }

    final class FoodsElementDetailsViewHolder extends BaseViewHolder {
        TextView tvElement;
        TextView tvComponent;
        TextView tvRemark;

        public FoodsElementDetailsViewHolder(@NonNull View itemView) {
            super(itemView);
            tvElement = itemView.findViewById(R.id.tv_element);
            tvComponent = itemView.findViewById(R.id.tv_component);
            tvRemark = itemView.findViewById(R.id.tv_remark);
        }
    }
}
