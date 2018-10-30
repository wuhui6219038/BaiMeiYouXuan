package com.baimeiyx.www.ui.user;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.baimeiyx.www.base.ui.BaseUserFragment;
import com.bigkoo.pickerview.builder.OptionsPickerBuilder;
import com.bigkoo.pickerview.listener.OnOptionsSelectChangeListener;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.bigkoo.pickerview.view.OptionsPickerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.mrw.baimeiyouxuan.R;
import com.baimeiyx.www.module.http.result.BaseResult;
import com.baimeiyx.www.module.http.result.RevenceDetailResult;
import com.baimeiyx.www.module.http.result.UserInfoResult;
import com.baimeiyx.www.ui.user.adapter.AdapterWallet;
import com.baimeiyx.www.utils.ConstUtils;
import com.baimeiyx.www.utils.LogUtils;
import com.baimeiyx.www.utils.TimeUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class WalletFragment extends BaseUserFragment implements View.OnClickListener {

    private static final String TAG = "WalletFragment";
    @BindView(R.id.rv_wallet)
    RecyclerView rvWallet;
    TextView tvMoney;
    TextView freezeCount;
    TextView usefulMoney;
    TextView tvTextClassic;
    TextView tvStartdate;
    TextView tvEnddate;
    LinearLayout llClassic;
    LinearLayout llChooseDate;
    @BindView(R.id.main_srl)
    SwipeRefreshLayout swipeRefreshLayout;
    private AdapterWallet mAdapterWallet;
    private int mPage = 1;
    private String mBehaviorType = "";
    private ArrayList<String> wheelType, wheelData, wheelData2;
    private int selectedTypeOps, selectedStartDateOps, selectedEndDateOps;
    private OptionsPickerView optionsPicker;
    //点击的是分类还是时间选择
    private int mClickType;
    //是否是刷新
    private boolean isRefresh = true;
    private View headerView;

    public static WalletFragment newInstance() {

        Bundle args = new Bundle();

        WalletFragment fragment = new WalletFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected int getViewId() {
        return R.layout.fragment_wallet;
    }

    @Override
    protected void _init(Bundle savedInstanceState) {
        headerView = getLayoutInflater().inflate(R.layout.view_wallet_header, null, false);
        _init();
    }

    private void _init() {
        wheelType = new ArrayList<>();
        wheelData = new ArrayList<>();
        wheelData2 = new ArrayList<>();
        mAdapterWallet = new AdapterWallet(R.layout.item_wallet_detail_view);
        mAdapterWallet.setHeaderView(headerView);
        mAdapterWallet.setHeaderAndEmpty(true);
        rvWallet.setAdapter(mAdapterWallet);

        rvWallet.setLayoutManager(new LinearLayoutManager(mActivity));

        mAdapterWallet.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                loadMore();
            }
        }, rvWallet);
        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright, android.R.color.holo_green_light,
                android.R.color.holo_orange_light, android.R.color.holo_red_light);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refresh();
            }
        });
        _initView();
        setDate();
        _initOptionsPickerView();
        _initValue();
    }

    private void _initView()

    {
        tvMoney = headerView.findViewById(R.id.tv_money);
        freezeCount = headerView.findViewById(R.id.freeze_count);
        usefulMoney = headerView.findViewById(R.id.useful_money);
        tvTextClassic = headerView.findViewById(R.id.tv_text_classic);
        tvStartdate = headerView.findViewById(R.id.tv_startdate);
        tvEnddate = headerView.findViewById(R.id.tv_enddate);
        llClassic = headerView.findViewById(R.id.ll_classic);
        llChooseDate = headerView.findViewById(R.id.ll_choose_date);
        llChooseDate.setOnClickListener(this);
        llClassic.setOnClickListener(this);
    }

    private void _initOptionsPickerView() {
        optionsPicker = new OptionsPickerBuilder(mActivity, new OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {

                if (mClickType == R.id.ll_classic) {
                    tvTextClassic.setText(wheelType.get(options1));
                    mBehaviorType = options1 == 0 ? "" : options1 + "";
                    selectedTypeOps = options1;
                } else {
                    selectedStartDateOps = options1;
                    selectedEndDateOps = options2;
                }
                refresh();
                Log.e(TAG, "onOptionsSelect: " + options1 + "   " + options2 + "  " + options3);
            }
        }).setOptionsSelectChangeListener(new OnOptionsSelectChangeListener() {
            @Override
            public void onOptionsSelectChanged(int options1, int options2, int options3) {
                if (mClickType == R.id.ll_choose_date) {
                    int timeSpan = options1 - options2;
                    LogUtils.e(TAG, "onOptionsSelectChanged: 时间差" + timeSpan);

                    if (timeSpan < 0) {

                        optionsPicker.setSelectOptions(options1, options1);
                    } else {
                        tvStartdate.setText(wheelData.get(options1));
                        tvEnddate.setText(wheelData2.get(options2));
                    }
                }
                Log.e(TAG, "onOptionsSelectChanged: " + options1 + "   " + options2 + "  " + options3);
            }
        }).isRestoreItem(false).build();
        optionsPicker.setDialogOutSideCancelable();
    }

    private void _initValue() {
        tvEnddate.setText(TimeUtils.getNowTimeString(TimeUtils.DEFAULT_PATTERN3));
        tvStartdate.setText(TimeUtils.getPreDate(TimeUtils.DEFAULT_PATTERN3, ConstUtils.TimeUnit.MONTH, 1));
    }

    @Override
    public void onStart() {
        super.onStart();
        refresh();

    }


    private void refresh() {
        mPage = 1;
        isRefresh = true;
        swipeRefreshLayout.setRefreshing(true);
        getGolfCapitalFlowData();
        getGoldData();
    }

    private void loadMore() {
        isRefresh = false;
        mPage++;
        getGolfCapitalFlowData();

    }

    private void getGolfCapitalFlowData() {
        mUserViewModel.getRelevanceDetail(spUtils.getString(SP_SESSION_ID), tvStartdate.getText().toString(), tvEnddate.getText().toString(), mPage, mBehaviorType)
                .observe(this, this);
    }

    private void getGoldData() {
        mUserViewModel.getUserInfo("searchCustomerRelevance", spUtils.getString(SP_SESSION_ID))
                .observe(this, this);
    }

    //设置选择的时间
    private void setDate() {
        String startDate, endDate;
        for (int index = 0; index < 12; index++) {
            endDate = TimeUtils.getPreDate(TimeUtils.DEFAULT_PATTERN3, ConstUtils.TimeUnit.MONTH, index);
            startDate = TimeUtils.getPreDate(TimeUtils.DEFAULT_PATTERN3, ConstUtils.TimeUnit.MONTH, index + 1);
            wheelData.add(startDate);
            wheelData2.add(endDate);
        }

    }


    @Override
    protected void onDataSuccessChanged(BaseResult baseResult) {
        if (baseResult instanceof RevenceDetailResult) {
            setData((RevenceDetailResult) baseResult);
        } else if (baseResult instanceof UserInfoResult) {
            setAmount((UserInfoResult) baseResult);
        }
    }

    //设置金币流水数据
    private void setData(RevenceDetailResult revenceDetailResult) {

        List data = revenceDetailResult.getData().getList().getList();
        wheelType.clear();
        //将类型加入到数组中
        wheelType.add("全部");
        wheelType.add(revenceDetailResult.getData().getData().get_$1());
        wheelType.add(revenceDetailResult.getData().getData().get_$2());
        wheelType.add(revenceDetailResult.getData().getData().get_$3());
        wheelType.add(revenceDetailResult.getData().getData().get_$4());
        LogUtils.e(TAG, "数据量" + data.size());
        if (isRefresh) {
            LogUtils.e(TAG, "刷新");
            swipeRefreshLayout.setRefreshing(false);
            mAdapterWallet.disableLoadMoreIfNotFullPage();

        } else {
            mAdapterWallet.loadMoreComplete();
        }
        if (mPage == 1) {
            mAdapterWallet.setNewData(revenceDetailResult.getData().getList().getList());
        } else {
            mAdapterWallet.addData(revenceDetailResult.getData().getList().getList());
        }
        if (data.size() < LIMIT) {
            if (mPage > 1)
                mAdapterWallet.loadMoreEnd(false);
        }
        if (data.size() == 0) {
            mAdapterWallet.setEmptyView(R.layout.view_empty);
        }
    }

    //设置金币
    private void setAmount(UserInfoResult userInfoResult) {
        tvMoney.setText(userInfoResult.getData().getCashBalance() + "");
        freezeCount.setText(userInfoResult.getData().getFreezingAmount().toString());
        usefulMoney.setText(userInfoResult.getData().getAvailableAmount() + "");
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        showPickerView(id);
    }

    private void showPickerView(int id) {
        mClickType = id;
        switch (id) {
            case R.id.ll_choose_date:
                optionsPicker.setSelectOptions(selectedStartDateOps, selectedEndDateOps);
                optionsPicker.setNPicker(wheelData, wheelData2, null);
                break;
            case R.id.ll_classic:
                optionsPicker.setSelectOptions(selectedTypeOps);
                optionsPicker.setNPicker(wheelType, null, null);
                break;
        }

        optionsPicker.show();
    }

    @Override
    protected void setToolbar() {
        tvTitle.setText(getResources().getString(R.string.title_money_detail));
    }

}
