package com.baimeiyx.www.ui.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baimeiyx.www.App;
import com.baimeiyx.www.service.model.OrderListResult;
import com.baimeiyx.www.utils.ImageUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.mrw.baimeiyouxuan.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AdapterOrderList extends BaseQuickAdapter<OrderListResult.DataBean.ListBean, AdapterOrderList.OrderListViewHolder> {

    private Context context;

    public AdapterOrderList(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(OrderListViewHolder helper, OrderListResult.DataBean.ListBean item) {
        helper.tvOrderNum.setText(item.getOrderNo());
        if (item.getSkuImage() != null)
            ImageUtils.loadImageByUrl(context, helper.ivGoodsPic, item.getSkuImage() + "");
        helper.tvGoodsInfo.setText(item.getGoodsName());
        helper.tvGoodsPrice.setText(App.INSTANCE.getResources().getString(R.string.text_price, item.getAmount()));
        helper.tvGoodsNum.setText("x");
    }

    final class OrderListViewHolder extends BaseViewHolder {

        @BindView(R.id.tv_order_num)
        TextView tvOrderNum;
        @BindView(R.id.tv_order_status)
        TextView tvOrderStatus;
        @BindView(R.id.iv_goods_pic)
        ImageView ivGoodsPic;
        @BindView(R.id.tv_goods_info)
        TextView tvGoodsInfo;
        @BindView(R.id.tv_goods_price)
        TextView tvGoodsPrice;
        @BindView(R.id.tv_goods_num)
        TextView tvGoodsNum;
        @BindView(R.id.tv_goods_total_price)
        TextView tvGoodsTotalPrice;
        @BindView(R.id.btn_pay)
        TextView btnPay;
        @BindView(R.id.ll_order_item)
        LinearLayout llOrderItem;

        public OrderListViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        @OnClick({R.id.btn_pay, R.id.ll_order_item})
        public void onViewClicked(View view) {
            switch (view.getId()) {
                case R.id.btn_pay:
                    break;
                case R.id.ll_order_item:
                    break;
            }
        }
    }
}
