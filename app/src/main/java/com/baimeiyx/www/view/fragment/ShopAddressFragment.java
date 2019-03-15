package com.baimeiyx.www.view.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.baimeiyx.www.base.ui.BaseUserFragment;
import com.baimeiyx.www.widget.MyOptionsPickerView;
import com.baimeiyx.www.service.model.BaseResult;
import com.baimeiyx.www.service.model.ShopAddressResult;
import com.baimeiyx.www.service.repository.DataManager;
import com.baimeiyx.www.service.rxjava.DialogSubscribe;
import com.baimeiyx.www.service.rxjava.RetryExceptionObservable;
import com.baimeiyx.www.service.rxjava.RxJavaUtils;
import com.baimeiyx.www.utils.myUtils.AreaUtils;
import com.bigkoo.pickerview.builder.OptionsPickerBuilder;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.bigkoo.pickerview.view.OptionsPickerView;
import com.example.mrw.baimeiyouxuan.R;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 收货地址管理
 */
public class ShopAddressFragment extends BaseUserFragment {
    private static final String TAG = "ShopAddressFragment";
    public static final String SHOPADDRESSDATA = "shopAddressData";
    @BindView(R.id.et_receiver)
    EditText etReceiver;
    @BindView(R.id.et_phone)
    EditText etPhone;
    @BindView(R.id.tv_area)
    TextView tvArea;
    @BindView(R.id.et_address)
    EditText etAddress;
    private OptionsPickerView optionsPicker;
    private int provinceId, cityId, areaId;
    private Bundle data;

    public static ShopAddressFragment newInstance() {

        Bundle args = new Bundle();

        ShopAddressFragment fragment = new ShopAddressFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public static ShopAddressFragment newInstance(Bundle args) {
        ShopAddressFragment fragment = new ShopAddressFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getViewId() {
        return R.layout.fragment_shop_address_manage;
    }

    @Override
    protected void _init(Bundle savedInstanceState) {
        _initPickView();
        _initData();

    }

    private void _initData() {

        data = getArguments();
        ShopAddressResult.DataBean.ListBean shopAddress = (ShopAddressResult.DataBean.ListBean) data.getSerializable(SHOPADDRESSDATA);
        if (shopAddress != null) {

            etReceiver.setText(shopAddress.getConsignee());
            etPhone.setText(shopAddress.getMobile());
            etAddress.setText(shopAddress.getAddress());
            tvArea.setText(AreaUtils.getAreaName(shopAddress.getProvinceId() + "") + "," + AreaUtils.getAreaName(shopAddress.getCityId() + "") + "," + AreaUtils.getAreaName(shopAddress.getAreaId() + ""));
            provinceId = shopAddress.getProvinceId();
            cityId = shopAddress.getCityId();
            areaId = shopAddress.getAreaId();
            optionsPicker.setSelectOptions(AreaUtils.getAreaIndex(provinceId + ""), AreaUtils.getAreaIndex(cityId + ""), AreaUtils.getAreaIndex(areaId + ""));
        }
    }

    MyOptionsPickerView<String> myOptionsPickerView = null;

    private void _initPickView() {
        optionsPicker = new OptionsPickerBuilder(mActivity, new OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                String item1Name = myOptionsPickerView.getOptions1Items().get(options1);
                String item2Name = myOptionsPickerView.getOptions2Items().get(options1).get(options2);
                String item3Name = myOptionsPickerView.getOptions3Items().get(options1).get(options2).get(options3);
                tvArea.setText(item1Name + "，" + item2Name + "，" + item3Name);
                provinceId = AreaUtils.getAreaId(item1Name, null, null);
                cityId = AreaUtils.getAreaId(item1Name, item2Name, null);
                areaId = AreaUtils.getAreaId(item1Name, item2Name, item3Name);
            }
        }).isRestoreItem(false).build();
        myOptionsPickerView = AreaUtils.showArea(optionsPicker);
        optionsPicker = myOptionsPickerView.getOptionsPickerView();
    }

    private void showOptionsPicker() {
        optionsPicker.show();
    }


    @Override
    protected void setToolbar() {
        tvTitle.setText(getResources().getString(R.string.title_shipping_address));
    }


    @OnClick({R.id.btn_complete, R.id.tv_area})
    public void onViewClicked(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.tv_area:
                showOptionsPicker();
                break;
            case R.id.btn_complete:
                doSave();
                break;

        }
    }

    private void doSave() {
        Map<String, Object> params = new HashMap<>();
        params.put("consignee", etReceiver.getText());
        params.put("address", etAddress.getText());
        params.put("provinceId", provinceId);
        params.put("cityId", cityId);
        params.put("areaId", areaId);
        params.put("mobile", etPhone.getText());
        DataManager.getBaiMeiApiService().doSava(spUtils.getString(SP_SESSION_ID), params)
                .retryWhen(new RetryExceptionObservable())
                .compose(RxJavaUtils.rxSchedulerHelper())
                .subscribe(new DialogSubscribe<BaseResult>(mActivity) {
                    @Override
                    public void dataSuccess(BaseResult data) {
                        onDataSuccessChanged(data);
                    }
                });
    }

    @Override
    protected void onDataSuccessChanged(BaseResult baseResult) {
        if (baseResult.isOk()) {
            getFragmentManager().popBackStack();
        }
    }
}
