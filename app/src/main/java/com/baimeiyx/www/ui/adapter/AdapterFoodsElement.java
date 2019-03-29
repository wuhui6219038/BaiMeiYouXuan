package com.baimeiyx.www.ui.adapter;

import android.view.View;
import android.widget.RadioButton;

import com.baimeiyx.www.service.model.FoodsElementSortResult;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

public class AdapterFoodsElement extends BaseQuickAdapter<FoodsElementSortResult.PageBean, AdapterFoodsElement.HealthFoodsDetailElementViewHolder> {


    public AdapterFoodsElement(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(HealthFoodsDetailElementViewHolder helper, FoodsElementSortResult.PageBean item) {
        helper.tvFoodsDetailnNtrientElementName.setText(item.getName());
    }

    final class HealthFoodsDetailElementViewHolder extends BaseViewHolder {

        private RadioButton tvFoodsDetailnNtrientElementName;

        public HealthFoodsDetailElementViewHolder(View view) {
            super(view);
            tvFoodsDetailnNtrientElementName = (RadioButton) view;

        }
    }
}
