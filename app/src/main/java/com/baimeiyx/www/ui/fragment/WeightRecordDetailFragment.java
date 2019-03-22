package com.baimeiyx.www.ui.fragment;

import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.bluetooth.BluetoothProfile;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.baimeiyx.www.MainActivity;
import com.baimeiyx.www.adapter.BleGattCallbackAdapter;
import com.baimeiyx.www.base.callback.ItemOnClickListener;
import com.baimeiyx.www.base.ui.BaseUserFragment;
import com.baimeiyx.www.service.model.BaseResult;
import com.baimeiyx.www.service.repository.DataManager;
import com.baimeiyx.www.service.rxjava.DialogSubscribe;
import com.baimeiyx.www.service.rxjava.RetryExceptionObservable;
import com.baimeiyx.www.service.rxjava.RxJavaUtils;
import com.baimeiyx.www.utils.ConvertUtils;
import com.baimeiyx.www.utils.LogUtils;
import com.baimeiyx.www.utils.ToastUtils;
import com.baimeiyx.www.utils.myUtils.DialogUtils;
import com.baimeiyx.www.utils.myUtils.FragmentUtils;
import com.baimeiyx.www.utils.myUtils.NumFormatterUtils;
import com.baimeiyx.www.ui.adapter.AdapterBlueToothDevices;
import com.baimeiyx.www.ui.dialog.DialogRulerFragment;
import com.example.mrw.baimeiyouxuan.R;
import com.qmuiteam.qmui.widget.dialog.QMUITipDialog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.functions.Consumer;
@Deprecated
public class WeightRecordDetailFragment extends BaseUserFragment<BaseResult> {
    @BindView(R.id.rv_bluetooth)
    RecyclerView rvBluetooth;
    private static final String TAG = "WeightRecordDetailFragment";
    @BindView(R.id.tv_no_more)
    TextView tvNoMore;
    private AdapterBlueToothDevices adapterBlueToothDevices;
    private BluetoothAdapter bluetoothAdapter;
    private List<BluetoothDevice> devices = new ArrayList<>();
    private boolean hasRegister = false;
    private BluetoothGatt mBluetoothGatt;
    private QMUITipDialog loadDialog;
    private WeightBleFragment weightBleFragment;
    /**
     * 存放蓝牙数据
     */
    private Bundle bleData;

    public static WeightRecordDetailFragment newInstance() {
        Bundle args = new Bundle();
        WeightRecordDetailFragment fragment = new WeightRecordDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected int getViewId() {
        return R.layout.fragment_weight_record_detail;
    }

    @Override
    protected void _init(Bundle savedInstanceState) {
        _init();
    }

    private void _init() {
        bleData = new Bundle();
        adapterBlueToothDevices = new AdapterBlueToothDevices(mActivity);
        rvBluetooth.setLayoutManager(new LinearLayoutManager(mActivity));
        rvBluetooth.setAdapter(adapterBlueToothDevices);
        weightBleFragment = WeightBleFragment.newInstance();
        adapterBlueToothDevices.setItemOnClickListener(new ItemOnClickListener<BluetoothDevice>() {
            @Override
            public void onItemClick(View view, BluetoothDevice data, int poistion) {
                connectBle(data);
                FragmentUtils.showFragmentAddStack(getFragmentManager(), R.id.container, weightBleFragment);
            }
        });


    }

    private void _initBlueTooth() {
        loadDialog = DialogUtils.showLoadDialog(mActivity, getResources().getString(R.string.toast_searching_ble));
        if (!loadDialog.isShowing())
            loadDialog.show();
        BluetoothManager bluetoothManager = (BluetoothManager) mActivity.getSystemService(Context.BLUETOOTH_SERVICE);
        bluetoothAdapter = bluetoothManager.getAdapter();
        if (bluetoothAdapter == null || !bluetoothAdapter.isEnabled()) {
            DialogUtils.showFailDialog(DIALOG_DELAY, mActivity, getResources().getString(R.string.toast_pelase_open_ble));
            return;
        }
        //1)mAdapter.startDiscovery()是第一步,可是你会发现没有返回的蓝牙设备，怎么知道查找到了呢？
        //  2)定义BroadcastReceiver，代码如下
        bluetoothAdapter.startDiscovery();
        IntentFilter filter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
        mActivity.registerReceiver(mReceiver, filter);
        filter = new IntentFilter(BluetoothAdapter.ACTION_DISCOVERY_FINISHED);
        mActivity.registerReceiver(mReceiver, filter);
        hasRegister = true;

    }


    private void connectBle(BluetoothDevice device) {
        if (device == null) {
            ToastUtils.showShortToast(getResources().getString(R.string.toast_no_device));
            mBluetoothGatt = device.connectGatt(mActivity, false, bluetoothGattCallback);
        } else {
            loadDialog = DialogUtils.showLoadDialog(mActivity, getResources().getString(R.string.toast_connecting));
            loadDialog.show();
            mBluetoothGatt = device.connectGatt(mActivity, false, bluetoothGattCallback);
        }
    }

    BroadcastReceiver mReceiver = new BroadcastReceiver() {
        String deviceName;

        public void onReceive(Context context, Intent intent) {

            String action = intent.getAction();
            //找到设备
            if (BluetoothDevice.ACTION_FOUND.equals(action)) {
                BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                if (device.getBondState() != BluetoothDevice.BOND_BONDED) {
                    deviceName = device.getName();
                    LogUtils.e(TAG, "find device:" + deviceName + device.getAddress());
                    if (deviceName != null) {
                        if (Arrays.asList(DEVICE_NAME).contains(deviceName)) {
                            devices.add(device);
                            bluetoothAdapter.cancelDiscovery();
                        }

                    }

                    if (!devices.isEmpty()) {
                        adapterBlueToothDevices.setData(devices);
                        tvNoMore.setVisibility(View.GONE);
                        rvBluetooth.setVisibility(View.VISIBLE);
                    } else {
                        tvNoMore.setVisibility(View.VISIBLE);
                        rvBluetooth.setVisibility(View.GONE);
                    }

                }
                //搜索完成
            } else if (BluetoothAdapter.ACTION_DISCOVERY_FINISHED.equals(action)) {
//                hideDialog();
                if (devices.isEmpty()) {
                    DialogUtils.showFailDialog(DIALOG_DELAY, mActivity, getResources().getString(R.string.toast_no_useable_ble));
                } else {
                    DialogUtils.showSuccessDialog(DIALOG_DELAY, mActivity, getResources().getString(R.string.toast_search_complete));
                    devices.clear();
                }
                LogUtils.e(TAG, "搜索完成");


            }//执行更新列表的代码
        }
    };
    private BluetoothGattCallback bluetoothGattCallback = new BleGattCallbackAdapter() {

        @Override
        public void onConnectionStateChange(BluetoothGatt gatt, int status, int newState) {
            if (newState == BluetoothProfile.STATE_CONNECTED) {
                //链接成功
                LogUtils.e(TAG, "链接成功");
                DialogUtils.showSuccessDialog(DIALOG_DELAY, mActivity, getResources().getString(R.string.toast_connect_success));
                gatt.discoverServices();
            } else if (newState == BluetoothProfile.STATE_DISCONNECTED) {
                gatt.close();
                LogUtils.e(TAG, "链接失败");
                DialogUtils.showFailDialog(DIALOG_DELAY, mActivity, getResources().getString(R.string.toast_connect_fail));
            }
        }

        @Override
        public void onServicesDiscovered(BluetoothGatt gatt, int status) {
            if (status == BluetoothGatt.GATT_SUCCESS) {   //找到服务了
                //在这里可以对服务进行解析，寻找到你需要的服务
                LogUtils.e(TAG, "蓝牙连接正常");
                //写数据
                BluetoothGattService wrirteService = gatt.getService(UUID.fromString(YUNCHEN_WRITE_SERVICE_UUID));
                BluetoothGattCharacteristic writeCharacteristic = wrirteService.getCharacteristic(UUID.fromString(YUNCHEN_WRITE_CHARACTERISTIC_UUID));
                gatt.setCharacteristicNotification(writeCharacteristic, true);
                writeCharacteristic.setValue(ConvertUtils.hexString2Bytes("A5"));
                writeCharacteristic.setValue(ConvertUtils.hexString2Bytes("00"));
                writeCharacteristic.setValue(ConvertUtils.hexString2Bytes("19"));
                writeCharacteristic.setValue(ConvertUtils.hexString2Bytes("AF"));
                writeCharacteristic.setValue(ConvertUtils.hexString2Bytes("50"));
                writeCharacteristic.setValue(ConvertUtils.hexString2Bytes("5A"));
                writeCharacteristic.setValue(ConvertUtils.hexString2Bytes("19"));
                writeCharacteristic.setWriteType(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
                boolean writesuccess = mBluetoothGatt.writeCharacteristic(writeCharacteristic);
                if (writesuccess) {
                    LogUtils.e(TAG, "写入成功");
                } else {
                    LogUtils.e(TAG, "写入失败");
                }
                BluetoothGattService readService = gatt.getService(UUID.fromString(YUNCHEN_READ_SERVICE_UUID));
                BluetoothGattCharacteristic readCharacteristic = readService.getCharacteristic(UUID.fromString(YUNCHEN_READ_CHARACTERISTIC_UUID));
                gatt.readCharacteristic(readCharacteristic);
//                List<BluetoothGattService> supportedGattServices = mBluetoothGatt.getServices();
//                for (int i = 0; i < supportedGattServices.size(); i++) {
//                    LogUtils.e(TAG, "1:BluetoothGattService UUID=:" + supportedGattServices.get(i).getUuid());
//                    List<BluetoothGattCharacteristic> listGattCharacteristic = supportedGattServices.get(i).getCharacteristics();
//                    for (int j = 0; j < listGattCharacteristic.size(); j++) {
//                        LogUtils.e(TAG, "2:   BluetoothGattCharacteristic UUID=:" + listGattCharacteristic.get(j).getUuid());
//                    }
//                }
//                for (BluetoothGattService gattService : supportedGattServices) {
//                    List<BluetoothGattCharacteristic> gattCharacteristics = gattService.getCharacteristics();
//                    for (BluetoothGattCharacteristic gattCharacteristic : gattCharacteristics) {
//                        int charaProp = gattCharacteristic.getProperties();
//                        if ((charaProp | BluetoothGattCharacteristic.PROPERTY_READ) > 0) {
//                            LogUtils.e("nihao", "可读gattCharacteristic的UUID为:" + gattCharacteristic.getUuid());
//                            // Log.e("nihao","gattCharacteristic的属性为:  可读");
//                        }
//                        if ((charaProp | BluetoothGattCharacteristic.PROPERTY_WRITE) > 0) {
//                            LogUtils.e("nihao", "可写gattCharacteristic的UUID为:" + gattCharacteristic.getUuid());
//                            // Log.e("nihao","gattCharacteristic的属性为:  可写");
//                        }
//                        if ((charaProp | BluetoothGattCharacteristic.PROPERTY_NOTIFY) > 0) {
//                            LogUtils.e("nihao", "具备通知属性gattCharacteristic的UUID为:" + gattCharacteristic.getUuid());
//                            // Log.e("nihao","gattCharacteristic的属性为:  具备通知属性");
//                        }
//
//                    }
//                }
            } else {
                LogUtils.e(TAG, "onServicesDiscovered received: " + status);
            }
        }


        @Override
        public void onCharacteristicChanged(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic) {
            byte[] datas = characteristic.getValue();
            double weight = (double) (Integer.parseInt(Integer.toHexString(Math.abs(datas[2])) + "" + Integer.toHexString(Math.abs(datas[3])), 16));
            double fat = (double) (Integer.parseInt(Integer.toHexString(Math.abs(datas[4])) + Integer.toHexString(Math.abs(datas[5])), 16));// 脂肪
            double water = (double) (Integer.parseInt(Integer.toHexString(Math.abs(datas[8])) + Integer.toHexString(Math.abs(datas[9])), 16)); // 水分
            double muscle = (double) (Integer.parseInt(Integer.toHexString(Math.abs(datas[10])) + Integer.toHexString(Math.abs(datas[11])), 16)); // 骨骼
            double calories = (double) (Integer.parseInt(Integer.toHexString(Math.abs(datas[14])) + Integer.toHexString(Math.abs(datas[15])), 16)); // 卡路里
            //LogUtils.e(TAG, "数据写入成功 " + weight + "===" + fat + "===" + water + "===" + muscle + "===" + calories);

            bleData.putString(WeightBleFragment.BUNDLE_WEIGHT, NumFormatterUtils.getFormatNum(weight / 100));
            bleData.putString(WeightBleFragment.BUNDLE_FAT, NumFormatterUtils.getFormatNum(fat / 100));
            bleData.putString(WeightBleFragment.BUNDLE_WATER, NumFormatterUtils.getFormatNum(water / 10));
            bleData.putString(WeightBleFragment.BUNDLE_MUSCLE, NumFormatterUtils.getFormatNum(muscle / 10));
            bleData.putString(WeightBleFragment.BUNDLE_CALORIES, NumFormatterUtils.getFormatNum(calories / 10));
            LogUtils.e(TAG, "传递出去的重量是：" + bleData.getString(WeightBleFragment.BUNDLE_WEIGHT));
            MainActivity.appViewModel.getMutliObserver().postValue(bleData);
//            weightBleFragment.setWeight(bleData);

            for (int index = 0; index < datas.length; index++) {
//                LogUtils.e(TAG, "当前位置" + index + "   值是" + datas[index]);
            }

        }

    };

    @Override
    protected void setToolbar() {
        tvTitle.setText(getString(R.string.title_weight_record));
        toolbar.setBackgroundColor(getResources().getColor(R.color.colorBarWeightRecord));
    }


    @OnClick({R.id.tv_search_bluetooth, R.id.tv_input_weight})
    public void doClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.tv_search_bluetooth:
                rxPermissions.request(Manifest.permission.ACCESS_COARSE_LOCATION)
                        .subscribe(new Consumer<Boolean>() {
                            @Override
                            public void accept(Boolean aBoolean) {
                                if (aBoolean) {
                                    _initBlueTooth();
                                } else {
                                    DialogUtils.showInfoDialog(DIALOG_DELAY, mActivity, "请开启相应权限");
                                }
                            }
                        });
                break;
            case R.id.tv_input_weight:
                showRulerDialog(null);
                break;

        }
    }

    @Override
    public void onStart() {
        super.onStart();
        dialogRulerFragment.setOnValueChangeListenser(new DialogRulerFragment.OnValueChangeListenser() {
            @Override
            public void onValueChange(String value) {
                LogUtils.e(TAG, "从尺子插件获取到的数据");
                DataManager.getBaiMeiApiService().doUpdateEveryDayWeight(spUtils.getString(SP_SESSION_ID), value)
                        .retryWhen(new RetryExceptionObservable())
                        .compose(RxJavaUtils.rxSchedulerHelper())
                        .subscribe(new DialogSubscribe<BaseResult>(mActivity) {
                            @Override
                            public void dataSuccess(BaseResult data) {
                                LogUtils.e(TAG, "修改成功");
                                onDataSuccessChanged(data);
                            }
                        });
            }
        });

    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (bluetoothAdapter != null && bluetoothAdapter.isDiscovering())
            bluetoothAdapter.cancelDiscovery();
        if (hasRegister)
            mActivity.unregisterReceiver(mReceiver);
    }


    @Override
    protected void onDataSuccessChanged(BaseResult baseResult) {
        FragmentUtils.showFragmentAddStack(getFragmentManager(), R.id.container, WeightLogFragment.newInstance());
    }
}
