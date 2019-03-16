package com.baimeiyx.www.ui.fragment;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.baimeiyx.www.base.ui.BaseUserFragment;
import com.baimeiyx.www.service.model.BaseResult;
import com.baimeiyx.www.service.model.ShopAddressResult;
import com.baimeiyx.www.service.repository.DataManager;
import com.baimeiyx.www.service.rxjava.DialogSubscribe;
import com.baimeiyx.www.service.rxjava.RetryExceptionObservable;
import com.baimeiyx.www.service.rxjava.RxJavaUtils;
import com.baimeiyx.www.utils.ToastUtils;
import com.baimeiyx.www.utils.myUtils.FragmentUtils;
import com.baimeiyx.www.ui.adapter.AdapterShopAddress;
import com.example.mrw.baimeiyouxuan.R;
import com.qmuiteam.qmui.widget.dialog.QMUIDialog;

import butterknife.BindView;
import butterknife.OnClick;

public class ShopAddressManageFragment extends BaseUserFragment<ShopAddressResult> {
    private static final String TAG = "ShopAddressManageFragment";
    @BindView(R.id.rv_order_list)
    RecyclerView rvOrderList;
    @BindView(R.id.main_srl)
    SwipeRefreshLayout mainSrl;
    @BindView(R.id.add_address)
    TextView addAddress;
    private AdapterShopAddress mAdapterShopAddress;

    public static ShopAddressManageFragment newInstance() {

        Bundle args = new Bundle();

        ShopAddressManageFragment fragment = new ShopAddressManageFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected int getViewId() {
        return R.layout.fragment_shop_address;
    }

    @Override
    protected void _init(Bundle savedInstanceState) {
        _initSwipeRefresh(mainSrl);
        _initRv();
    }

    private void _initRv() {
        mAdapterShopAddress = new AdapterShopAddress(R.layout.item_shop_address);
        mAdapterShopAddress.setHeaderAndEmpty(true);
        mAdapterShopAddress.bindToRecyclerView(rvOrderList);
        mAdapterShopAddress.setOnClickListener((data, type) -> {
            if (type == AdapterShopAddress.UPDATE) {
                Bundle bundle = new Bundle();
                bundle.putSerializable(ShopAddressFragment.SHOPADDRESSDATA, data);
                FragmentUtils.showFragmentAddStack(getFragmentManager(), R.id.contain, ShopAddressFragment.newInstance(bundle));
            } else if (type == AdapterShopAddress.DELETE) {
                showMessagePositiveDialog(data);
            } else {
                setDefaultAddress(data.getId());
            }
        });
        rvOrderList.setAdapter(mAdapterShopAddress);
        rvOrderList.setLayoutManager(new LinearLayoutManager(mActivity));

    }

    @Override
    protected void swipeRefresh() {
        getData();
    }

    @Override
    public void onStart() {
        super.onStart();
        getData();
    }

    private void getData() {
        DataManager.getBaiMeiApiService().getAllShopAddress(spUtils.getString(SP_SESSION_ID), 100, 1)
                .retryWhen(new RetryExceptionObservable())
                .compose(RxJavaUtils.rxSchedulerHelper())
                .subscribe(new DialogSubscribe<ShopAddressResult>(mActivity) {
                    @Override
                    public void dataSuccess(ShopAddressResult data) {
                        onDataSuccessChanged(data);
                    }
                });
    }

    private void showMessagePositiveDialog(ShopAddressResult.DataBean.ListBean data) {
        new QMUIDialog.MessageDialogBuilder(getActivity())
                .setTitle(getResources().getString(R.string.dialog_hint_del))
                .setMessage(getResources().getString(R.string.dialog_hint_del_info))
                .addAction(getResources().getString(R.string.btn_cancel), (dialog, index) -> dialog.dismiss())
                .addAction(getResources().getString(R.string.btn_sure), (dialog, index) -> {
                    dialog.dismiss();
                    DataManager.getBaiMeiApiService().doDelShopAddress(spUtils.getString(SP_SESSION_ID), data.getId())
                            .retryWhen(new RetryExceptionObservable())
                            .compose(RxJavaUtils.rxSchedulerHelper())
                            .subscribe(new DialogSubscribe<BaseResult>(mActivity) {
                                @Override
                                public void dataSuccess(BaseResult data) {
                                    getData();
                                }
                            });
                })
                .create(com.qmuiteam.qmui.R.style.QMUI_Dialog).show();
    }

    private void setDefaultAddress(int id) {
        DataManager.getBaiMeiApiService().setDefaultAddress(spUtils.getString(SP_SESSION_ID), id)
                .retryWhen(new RetryExceptionObservable())
                .compose(RxJavaUtils.rxSchedulerHelper())
                .subscribe(new DialogSubscribe<BaseResult>(mActivity) {
                    @Override
                    public void dataSuccess(BaseResult data) {
                        ToastUtils.showShortToast("设置成功");
                        getData();
                    }
                });
    }

    @Override
    protected void onDataSuccessChanged(ShopAddressResult baseResult) {
        mainSrl.setRefreshing(false);
        if (baseResult.getData().getList().size() == 0)
            mAdapterShopAddress.setEmptyView(R.layout.view_empty);
        else {
            mAdapterShopAddress.setNewData(baseResult.getData().getList());
        }
    }

    @Override
    protected void setToolbar() {
        tvTitle.setText(getResources().getString(R.string.title_shipping_address_manage));
    }


    @OnClick({R.id.add_address})
    public void onViewClicked(View view) {
        FragmentUtils.showFragmentAddStack(getFragmentManager(), R.id.contain, ShopAddressFragment.newInstance());
    }


}
