package com.baimeiyx.www.ui.adapter;

import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import com.baimeiyx.www.service.model.ShopAddressResult;
import com.baimeiyx.www.utils.myUtils.AreaUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.mrw.baimeiyouxuan.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class AdapterShopAddress extends BaseQuickAdapter<ShopAddressResult.DataBean.ListBean, AdapterShopAddress.ShopAddressViewHolder> {
    public static final int DELETE = 0;
    public static final int UPDATE = 1;
    public static final int DEFAULT = 2;
    OnClickListener listener;

    public AdapterShopAddress(int layoutResId) {
        super(layoutResId);
    }

    private RadioButton mRadioButton;

    @Override
    protected void convert(ShopAddressViewHolder helper, ShopAddressResult.DataBean.ListBean item) {
        helper.tvUsername.setText(item.getConsignee());
        helper.tvPhone.setText(item.getMobile());
        helper.tvAddress.setText(AreaUtils.getAreaName(item.getProvinceId() + "") + "," + AreaUtils.getAreaName(item.getCityId() + "") + "," + AreaUtils.getAreaName(item.getAreaId() + "") + item.getAddress());

        if (item.getIsDefault().equals("1")) {
            helper.rbDefault.setChecked(true);
            mRadioButton = helper.rbDefault;
        }
        helper.rbDefault.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (buttonView != mRadioButton) {
                mRadioButton.setChecked(!isChecked);
                mRadioButton = (RadioButton) buttonView;
                listener.onClick(item, DEFAULT);
            }

        });
        helper.btnDel.setOnClickListener((v) -> {
            listener.onClick(item, DELETE);
        });
        helper.btnUpdate.setOnClickListener((v) -> {
            listener.onClick(item, UPDATE);
        });
    }

    public void setOnClickListener(OnClickListener listener) {
        this.listener = listener;
    }

    public interface OnClickListener {
        void onClick(ShopAddressResult.DataBean.ListBean data, int type);
    }

    final class ShopAddressViewHolder extends BaseViewHolder {

        @BindView(R.id.tv_username)
        TextView tvUsername;
        @BindView(R.id.tv_phone)
        TextView tvPhone;
        @BindView(R.id.tv_address)
        TextView tvAddress;
        @BindView(R.id.rb_default)
        RadioButton rbDefault;
        @BindView(R.id.btn_update)
        TextView btnUpdate;
        @BindView(R.id.btn_delete)
        TextView btnDel;

        public ShopAddressViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }


    }
}
