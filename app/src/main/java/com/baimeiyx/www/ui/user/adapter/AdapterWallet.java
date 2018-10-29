package com.baimeiyx.www.ui.user.adapter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.baimeiyx.www.App;
import com.example.mrw.baimeiyouxuan.R;
import com.baimeiyx.www.http.result.RevenceDetailResult;
import com.baimeiyx.www.utils.TimeUtils;


public class AdapterWallet extends BaseQuickAdapter<RevenceDetailResult.DataBeanX.ListBeanX.ListBean, AdapterWallet.WalletViewHolder> {

    public AdapterWallet(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(WalletViewHolder helper, RevenceDetailResult.DataBeanX.ListBeanX.ListBean item) {
        helper.tvDate.setText(TimeUtils.millis2String(item.getAddTime(), TimeUtils.DEFAULT_PATTERN2));
        String strChangeValue = null;
        int fontColor = 0;
        //收入
        if (item.getTxType() == 1) {
            strChangeValue = "+" + item.getChangeValue();
            fontColor = R.color.colorPrimary;
        } else {
            //支出
            strChangeValue = "-" + item.getChangeValue();
            fontColor = R.color.colorAccent;
        }
        helper.tvChangeValue.setText(strChangeValue);
        helper.tvChangeValue.setTextColor(App.INSTANCE.getResources().getColor(fontColor));
        helper.tvType.setText(item.getRemark());
    }


    final class WalletViewHolder extends BaseViewHolder {
        private TextView tvDate;
        private TextView tvType;
        private TextView tvChangeValue;

        public WalletViewHolder(View view) {
            super(view);
            tvDate = view.findViewById(R.id.tv_date);
            tvType = view.findViewById(R.id.tv_type);
            tvChangeValue = view.findViewById(R.id.tv_valuechange);
        }
    }
}
