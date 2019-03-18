package com.baimeiyx.www.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.baimeiyx.www.base.ui.BaseFragment;
import com.baimeiyx.www.utils.BarUtils;
import com.baimeiyx.www.utils.ImageUtils;
import com.baimeiyx.www.utils.myUtils.FragmentUtils;
import com.baimeiyx.www.widget.LossToolItemView;
import com.example.mrw.baimeiyouxuan.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainLossToolFragment extends BaseFragment implements LossToolItemView.OnItemClickListenser {
    private static final String BANNERURL = "https://obs-7bff.obs.cn-north-1.myhwclouds.com/11111_small_app/tools_index_banner.png";
    @BindView(R.id.iv_banner)
    ImageView ivBanner;
    @BindView(R.id.losstoolview_1)
    LossToolItemView losstoolview1;
    @BindView(R.id.losstoolview_2)
    LossToolItemView losstoolview2;
    @BindView(R.id.losstoolview_3)
    LossToolItemView losstoolview3;
    @BindView(R.id.losstoolview_4)
    LossToolItemView losstoolview4;
    @BindView(R.id.losstoolview_5)
    LossToolItemView losstoolview5;
    @BindView(R.id.losstoolview_6)
    LossToolItemView losstoolview6;


    public static MainLossToolFragment newInstance() {
        Bundle args = new Bundle();
        MainLossToolFragment fragment = new MainLossToolFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void setToolbar() {
        tvTitle.setText(getResources().getString(R.string.title_loss_tool));
        toolbar.setBackgroundColor(getResources().getColor(R.color.colorBarHome));
        BarUtils.setColor(mActivity, getResources().getColor(R.color.colorBarHome), 0);

    }

    @Override
    protected int getViewId() {
        return R.layout.fragment_main_loss_tool;
    }

    @Override
    protected void _init(Bundle savedInstanceState) {
        ImageUtils.loadImageByUrl(getContext(), ivBanner, BANNERURL);
        losstoolview1.setOnItemClickListenser(this);
        losstoolview2.setOnItemClickListenser(this);
        losstoolview3.setOnItemClickListenser(this);
        losstoolview4.setOnItemClickListenser(this);
        losstoolview5.setOnItemClickListenser(this);
        losstoolview6.setOnItemClickListenser(this);
    }


    @Override
    public void onItemClick(View view, int type) {
        Bundle data = new Bundle();
        data.putInt(LossToolsIntroductionFragment.LOSSTOOLTYPE, type);
        FragmentUtils.showFragmentAddStack(getFragmentManager(), R.id.contain, LossToolsIntroductionFragment.newInstance(data));
    }


}
