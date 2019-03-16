package com.baimeiyx.www.ui.fragment;

import android.os.Bundle;
import android.view.View;

import com.baimeiyx.www.base.ui.BaseSimpleFragment;
import com.baimeiyx.www.utils.BarUtils;
import com.example.mrw.baimeiyouxuan.R;

public class ShopMainFragment extends BaseSimpleFragment {
    public static ShopMainFragment newInstance() {

        Bundle args = new Bundle();

        ShopMainFragment fragment = new ShopMainFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void setToolbar() {
        tvTitle.setText(getResources().getString(R.string.title_shop));
        toolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        BarUtils.setColor(mActivity, getResources().getColor(R.color.colorPrimary), 0);
        ivBack.setVisibility(View.GONE);
    }

    @Override
    protected int getViewId() {
        return R.layout.fragment_shop;
    }

    @Override
    protected void _init(Bundle savedInstanceState) {
    }
}
