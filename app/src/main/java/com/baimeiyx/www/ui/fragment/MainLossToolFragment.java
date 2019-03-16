package com.baimeiyx.www.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.baimeiyx.www.base.ui.BaseFragment;
import com.baimeiyx.www.utils.BarUtils;
import com.baimeiyx.www.utils.ImageUtils;
import com.example.mrw.baimeiyouxuan.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainLossToolFragment extends BaseFragment {
    private static final String BANNERURL = "https://obs-7bff.obs.cn-north-1.myhwclouds.com/11111_small_app/tools_index_banner.png";
    @BindView(R.id.iv_banner)
    ImageView ivBanner;


    public static MainLossToolFragment newInstance() {
        Bundle args = new Bundle();
        MainLossToolFragment fragment = new MainLossToolFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void setToolbar() {
        tvTitle.setText(getResources().getString(R.string.title_loss_tool));
    }

    @Override
    protected int getViewId() {
        return R.layout.fragment_main_loss_tool;
    }

    @Override
    protected void _init(Bundle savedInstanceState) {
        toolbar.setBackgroundColor(getResources().getColor(R.color.colorBarHome));
        BarUtils.setColor(mActivity, getResources().getColor(R.color.colorBarHome), 0);
        ImageUtils.loadImageByUrl(getContext(), ivBanner, BANNERURL);
    }


}
