package com.baimeiyx.www.ui.fragment;

import android.Manifest;
import android.os.Bundle;
import android.os.Handler;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.baimeiyx.www.base.ui.BaseFragment;
import com.baimeiyx.www.service.model.BleConfig;
import com.baimeiyx.www.service.model.CustomerExpectResult;
import com.baimeiyx.www.service.model.QingNiuBean;
import com.baimeiyx.www.utils.BarUtils;
import com.baimeiyx.www.utils.LogUtils;
import com.baimeiyx.www.utils.StringUtils;
import com.baimeiyx.www.utils.TimeUtils;
import com.baimeiyx.www.utils.ToastUtils;
import com.baimeiyx.www.utils.myUtils.DialogUtils;
import com.baimeiyx.www.utils.myUtils.NumFormatterUtils;
import com.baimeiyx.www.widget.CiecleLoading;
import com.baimeiyx.www.widget.LineLevelView;
import com.baimeiyx.www.widget.qingniu.QingNiuUtils;
import com.example.mrw.baimeiyouxuan.R;
import com.google.gson.Gson;
import com.qingniu.qnble.utils.QNLogUtils;
import com.qmuiteam.qmui.widget.dialog.QMUITipDialog;
import com.yolanda.health.qnblesdk.constant.CheckStatus;
import com.yolanda.health.qnblesdk.constant.QNIndicator;
import com.yolanda.health.qnblesdk.constant.QNScaleStatus;
import com.yolanda.health.qnblesdk.constant.UserGoal;
import com.yolanda.health.qnblesdk.constant.UserShape;
import com.yolanda.health.qnblesdk.listener.QNBleConnectionChangeListener;
import com.yolanda.health.qnblesdk.listener.QNBleDeviceDiscoveryListener;
import com.yolanda.health.qnblesdk.listener.QNDataListener;
import com.yolanda.health.qnblesdk.listener.QNResultCallback;
import com.yolanda.health.qnblesdk.out.QNBleApi;
import com.yolanda.health.qnblesdk.out.QNBleDevice;
import com.yolanda.health.qnblesdk.out.QNConfig;
import com.yolanda.health.qnblesdk.out.QNScaleData;
import com.yolanda.health.qnblesdk.out.QNScaleItemData;
import com.yolanda.health.qnblesdk.out.QNScaleStoreData;
import com.yolanda.health.qnblesdk.out.QNUser;

import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class WeightBleFragment extends BaseFragment {
    private static final String TAG = "WeightBleFragment";
    public static final String BUNDLE_WEIGHT = "weight";
    public static final String BUNDLE_FAT = "fat";
    public static final String BUNDLE_WATER = "water";
    public static final String BUNDLE_MUSCLE = "muscle";
    public static final String BUNDLE_CALORIES = "calories";
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_status)
    TextView tvStatus;
    @BindView(R.id.iv_refresh)
    ImageView ivRefresh;
    @BindView(R.id.tv_health_score)
    TextView tvHealthScore;
    @BindView(R.id.tv_health_score2)
    TextView tvHealthScore2;
    @BindView(R.id.cl_load)
    CiecleLoading clLoad;
    @BindView(R.id.btn_record)
    Button btnRecord;
    @BindView(R.id.ll_ble_result)
    LinearLayout llBleResult;
    @BindView(R.id.ll_score)
    LinearLayout llScore;


    ImageView ivType;
    TextView title;
    TextView tvValue;
    TextView tvValueUnit;
    CheckBox btnShowMore;
    TextView tvDistanceText;
    TextView tvResult;
    TextView tvResultInfo;
    LinearLayout llLevelInfo;
    LineLevelView lineLevelView;
    private QingNiuUtils qingNiuUtils;
    //轻牛相关设置
    private QNBleApi mQNBleApi;
    private BleConfig mConfig;
    private boolean isScanning;
    private Disposable disposable;

    public static WeightBleFragment newInstance() {

        Bundle args = new Bundle();
        WeightBleFragment fragment = new WeightBleFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected int getViewId() {
        return R.layout.fragment_blue_tooth_detail;
    }

    @Override
    protected void setToolbar() {
        toolbar.setBackgroundColor(getResources().getColor(R.color.colorBarWeightRecord));
        BarUtils.setColor(mActivity, getResources().getColor(R.color.colorBarWeightRecord), 0);
    }


    @Override
    protected void _init(Bundle savedInstanceState) {
        qingNiuUtils = new QingNiuUtils(spUtils);
        mQNBleApi = QNBleApi.getInstance(getContext());
        _initBle();
        _initBleData();
    }

    private void addHealthItem(float value, QingNiuBean qingNiuBean) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.item_qingniu_result, null, false);
        lineLevelView = view.findViewById(R.id.linelevelview);
        ivType = view.findViewById(R.id.iv_type);
        title = view.findViewById(R.id.levelMsg);
        tvValue = view.findViewById(R.id.tv_value);
        tvValueUnit = view.findViewById(R.id.tv_value_unit);
        tvDistanceText = view.findViewById(R.id.tv_distance_text);
        tvResult = view.findViewById(R.id.tv_result);
        tvResultInfo = view.findViewById(R.id.tv_result_info);
        llLevelInfo = view.findViewById(R.id.ll_level_info);
        btnShowMore = view.findViewById(R.id.btn_show_more);
        _initItemValue(value, qingNiuBean);
        llBleResult.addView(view, llBleResult.getChildCount());

    }

    private void _initItemValue(float value, QingNiuBean qingNiuBean) {
        lineLevelView.setValue(qingNiuBean);
        tvValue.setText(value + "");
        tvValueUnit.setText(qingNiuBean.getUnit());
        tvDistanceText.setText(qingNiuBean.getOffsetInfo());
        tvResult.setText(qingNiuBean.getLevelMsg());
        tvResultInfo.setText(qingNiuBean.getInfo());
        ivType.setImageDrawable(getResources().getDrawable(qingNiuBean.getTypeImg()));
        title.setText(qingNiuBean.getTypeName());
        if (qingNiuBean.getStatusImgId() != 0) {
            tvResult.setBackground(getResources().getDrawable(qingNiuBean.getStatusImgId()));
            tvResult.setTextColor(getResources().getColor(qingNiuBean.getStatusTextColor()));

        }
        btnShowMore.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                llLevelInfo.setVisibility(View.VISIBLE);
            } else {
                llLevelInfo.setVisibility(View.GONE);
            }
        });
    }

    private void readWeightValue(String weight) {
        tvStatus.setText("正在测量");
        llScore.setVisibility(View.GONE);
        clLoad.setVisibility(View.VISIBLE);
        clLoad.start();
        clLoad.setText(weight);


    }


    private void _initBle() {
        mQNBleApi.setBleDeviceDiscoveryListener(new QNBleDeviceDiscoveryListener() {
            @Override
            public void onDeviceDiscover(QNBleDevice device) {

                connectQnDevice(device);
            }

            @Override
            public void onStartScan() {
                // DialogUtils.showLoadDialog(getContext(), "设备搜索中。。。").show();
                Log.e(TAG, "onStartScan: ");
                isScanning = true;
            }

            @Override
            public void onStopScan() {
                isScanning = false;
                Log.e(TAG, "onStopScan: ");
                //  DialogUtils.showInfoDialog(getContext(), "搜索结束。。");

            }

            @Override
            public void onScanFail(int code) {
                isScanning = false;
                QNLogUtils.log("ScanActivity", "onScanFail:" + code);
                ToastUtils.showShortToast("扫描异常，请重启手机蓝牙!");
            }
        });
        mQNBleApi.setBleConnectionChangeListener(new QNBleConnectionChangeListener() {
            //正在连接
            @Override
            public void onConnecting(QNBleDevice device) {
                Log.e(TAG, "onConnecting: ");
            }

            //已连接
            @Override
            public void onConnected(QNBleDevice device) {
                Log.e(TAG, "onConnected: ");
            }

            @Override
            public void onServiceSearchComplete(QNBleDevice device) {
                Log.e(TAG, "onServiceSearchComplete: ");
            }

            //正在断开连接，调用断开连接时，会马上回调
            @Override
            public void onDisconnecting(QNBleDevice device) {
                Log.e(TAG, "onDisconnecting: ");
            }

            // 断开连接，断开连接后回调
            @Override
            public void onDisconnected(QNBleDevice device) {
                Log.e(TAG, "onDisconnected: ");
            }

            //出现了连接错误，错误码参考附表
            @Override
            public void onConnectError(QNBleDevice device, int errorCode) {
                Log.d("ConnectActivity", "onConnectError:" + errorCode);
            }

            //测量过程中的连接状态
            @Override
            public void onScaleStateChange(QNBleDevice device, int status) {
                Log.d("ConnectActivity", "蓝牙状态是:" + status);
            }
        });
            mQNBleApi.setDataListener(new QNDataListener() {
            @Override
            public void onGetUnsteadyWeight(QNBleDevice device, double weight) {
                Log.d("ConnectActivity", "体重是:" + weight);
                readWeightValue(NumFormatterUtils.getFormatNum(weight));
                // mWeightTv.setText(initWeight(weight));

            }

            @Override
            public void onGetScaleData(QNBleDevice device, QNScaleData data) {
                Log.d("ConnectActivity", "收到测量数据");
                //onReceiveScaleData(data);
                QNScaleItemData fatValue = data.getItem(QNIndicator.TYPE_SUBFAT);
                if (fatValue != null) {
                    String value = fatValue.getValue() + "";
                    Log.d("ConnectActivity", "收到皮下脂肪数据:" + value);
                }
                onReceiveScaleData(data);
//                Log.d("ConnectActivity", "收到体脂肪:"+data.getItem(QNIndicator.TYPE_BODYFAT).getValue());
            }

            @Override
            public void onGetStoredScale(QNBleDevice device, List<QNScaleStoreData> storedDataList) {

                Log.d("ConnectActivity", "收到存储数据");
                if (storedDataList != null && storedDataList.size() > 0) {
                    QNScaleStoreData data = storedDataList.get(0);
                    Log.d("ConnectActivity", "收到存储数据:" + data.getWeight());
                    QNUser qnUser = createQNUser();
                    data.setUser(qnUser);
                    QNScaleData qnScaleData = data.generateScaleData();
                    // onReceiveScaleData(qnScaleData);
                }
            }

            @Override
            public void onGetElectric(QNBleDevice device, int electric) {
                String text = "收到电池电量百分比:" + electric;
                Log.d("ConnectActivity", text);
                // Toast.makeText(ConnectActivity.this, text, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void _initBleData() {
        mConfig = new BleConfig();
        QNConfig mQnConfig = mQNBleApi.getConfig();//获取上次设置的对象,未设置获取的是默认对象
        mQnConfig.setAllowDuplicates(mConfig.isAllowDuplicates());
        mQnConfig.setDuration(mConfig.getDuration());
        mQnConfig.setScanOutTime(mConfig.getScanOutTime());
        mQnConfig.setConnectOutTime(mConfig.getConnectOutTime());
        mQnConfig.setUnit(mConfig.getUnit());
        mQnConfig.setOnlyScreenOn(mConfig.isOnlyScreenOn());
        //设置扫描对象
        mQnConfig.save(new QNResultCallback() {
            @Override
            public void onResult(int i, String s) {
                Log.d("ScanActivity", "initData:" + s);
            }
        });
    }


    private void connectQnDevice(QNBleDevice device) {
        Log.e(TAG, "connectQnDevice: 开始连接设备");
        mQNBleApi.connectDevice(device, createQNUser(), new QNResultCallback() {
            @Override
            public void onResult(int code, String msg) {
                Log.d("ConnectActivity", "连接设备返回:" + msg);
            }
        });
    }

    private QNUser createQNUser() {
        CustomerExpectResult.DataBeanX.DataBean userInfo = new Gson().fromJson(spUtils.getString(SP_CUSTOMEREXPECT), CustomerExpectResult.class).getData().getData();
        return mQNBleApi.buildUser("0",
                userInfo.getStature(), userInfo.getSex().equals("2") ? "male" : "female", TimeUtils.getNowOffsetDate(Calendar.YEAR, TimeUtils.DEFAULT_PATTERN5, -userInfo.getAge()), 0, UserShape.SHAPE_NONE, UserGoal.GOAL_NONE, new QNResultCallback() {
                    @Override
                    public void onResult(int code, String msg) {
                        Log.d("ConnectActivity", "创建用户信息返回:" + msg);
                    }
                });
    }

    //测量结束分析结果
    private void onReceiveScaleData(QNScaleData md) {
        clLoad.stop();
        QingNiuBean bean;
        List<QNScaleItemData> mDatas = md.getAllItem();
        for (QNScaleItemData qnScaleItemData : mDatas) {
            int type = qnScaleItemData.getType();
            float value = (float) qnScaleItemData.getValue();
            bean = qingNiuUtils.getDataByType(type, Float.valueOf(md.getItemValue(QNIndicator.TYPE_WEIGHT) + ""), value);
            if (bean != null)
                addHealthItem(value, bean);
            else {
                LogUtils.e("空的类型是" + type);
            }
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        disposable = rxPermissions.request(Manifest.permission.ACCESS_COARSE_LOCATION)
                .subscribe((granted) -> {
                    if (granted) {
                        startScan();
                    } else {
                        DialogUtils.showInfoDialog(DIALOG_DELAY, mActivity, "请开启相应权限");
                    }
                });

    }

    @Override
    public void onStop() {
        super.onStop();
        stopScan();
        if (!disposable.isDisposed())
            disposable.dispose();
    }

    private void startScan() {
        mQNBleApi.startBleDeviceDiscovery((code, msg) ->
                Log.d("ScanActivity", "code:" + code + ";msg:" + msg));
    }

    private void stopScan() {
        mQNBleApi.stopBleDeviceDiscovery(new QNResultCallback() {
            @Override
            public void onResult(int code, String msg) {
                if (code == CheckStatus.OK.getCode()) {
                    isScanning = false;
                }
            }
        });
    }

    @OnClick({R.id.iv_refresh, R.id.btn_record})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_refresh:
                if (isScanning) {
                    DialogUtils.showInfoDialog(getContext(), "客户别着急，正在搜索设备中。。。");
                } else {
                    DialogUtils.showInfoDialog(getContext(), "客观请上称。。");
                    startScan();
                }

                break;
            case R.id.btn_record:
                break;
        }
    }


}
