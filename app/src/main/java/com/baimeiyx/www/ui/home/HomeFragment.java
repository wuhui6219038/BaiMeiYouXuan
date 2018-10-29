package com.baimeiyx.www.ui.home;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mrw.baimeiyouxuan.R;
import com.baimeiyx.www.base.ui.BaseFragment;
import com.baimeiyx.www.base.ui.BaseSimpleFragment;
import com.baimeiyx.www.utils.ActivityUtils;
import com.baimeiyx.www.utils.BarUtils;
import com.baimeiyx.www.utils.ImageUtils;
import com.baimeiyx.www.utils.ToastUtils;
import com.baimeiyx.www.utils.myUtils.SvgUtils;
import com.baimeiyx.www.view.StepView;
import com.baimeiyx.www.view.circleprogress.ArcProgress;

import org.reactivestreams.Publisher;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Flowable;
import io.reactivex.FlowableTransformer;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;


public class HomeFragment extends BaseSimpleFragment {
    @BindView(R.id.text_icon)
    TextView textIcon;
    @BindView(R.id.text_icon_next)
    TextView textIconNext;
    @BindView(R.id.fl_content)
    FrameLayout flContent;
    @BindView(R.id.iv_bg)
    ImageView ivBg;
    @BindView(R.id.arc_progress)
    ArcProgress arcProgress;
    @BindView(R.id.tv_weight_record)
    TextView tvWeightRecord;
    @BindView(R.id.tv_weight_record_en)
    TextView tvWeightRecordEn;


    @BindView(R.id.stepview)
    StepView stepview;
    @BindView(R.id.et_search_info)
    EditText etSearchInfo;
    @BindView(R.id.ll_weight_record)
    LinearLayout llWeightRecord;
    @BindView(R.id.tv_icon_search)
    TextView tvIconSearch;
    @BindView(R.id.tv_icon_message)
    TextView tvIconMessage;

    private HomeViewModel mViewModel;
    private static final String[] STEPTILTE = {"S", "A", "B", "C", "F"};

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }


    @Override
    protected int getViewId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void _init(Bundle savedInstanceState) {
        _init();
    }

    private void _init() {
        ImageUtils.loadImageByUrl(getActivity(), ivBg, "http://www.baimeiyx.com/wx-app/cover.png");
        SvgUtils.setIcon(mActivity, textIcon, "iconfont.ttf");
        SvgUtils.setIcon(mActivity, tvIconMessage, "iconfont.ttf");
        SvgUtils.setIcon(mActivity, textIconNext, "iconfont.ttf");
        SvgUtils.setIcon(mActivity, tvIconSearch, "iconfont.ttf");
        stepview.setStepsTitle(STEPTILTE);
        _initView();

    }

    private static final String TAG = "HomeFragment";

    private void _initView() {
        Observable<String> observable = Observable.just("I", "am", "RxJava");
        Observable<Integer> observable2 = Observable.just(1, 2, 3);
        Log.e(TAG, "_initView: ");


    }


    @OnClick({R.id.ll_weight_record})
    public void doClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.ll_weight_record:
                ActivityUtils.launchActivity(mActivity, mActivity.getPackageName(), mActivity.getPackageName() + ".ui.weight_record.WeightRecordActivity");
                break;

        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    protected void setToolbar() {
        toolbar.setBackgroundColor(getResources().getColor(R.color.colorBarHome));
        BarUtils.setColor(mActivity, getResources().getColor(R.color.colorBarHome), 0);
        ivBack.setVisibility(View.GONE);
    }


}
