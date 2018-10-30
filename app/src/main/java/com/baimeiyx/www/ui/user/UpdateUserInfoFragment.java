package com.baimeiyx.www.ui.user;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


import com.baimeiyx.www.base.ui.BaseUserFragment;
import com.example.mrw.baimeiyouxuan.R;
import com.baimeiyx.www.module.http.result.BaseResult;
import com.baimeiyx.www.module.http.result.LoginResult;
import com.baimeiyx.www.utils.EmptyUtils;
import com.baimeiyx.www.utils.ToastUtils;
import com.baimeiyx.www.utils.myUtils.TimerCountUtils;

import java.util.HashMap;
import java.util.Map;

import butterknife.OnClick;

/**
 * 用户信息更新页面
 */
public class UpdateUserInfoFragment extends BaseUserFragment<BaseResult> {
    public static final String TYPE_FRAGMENT = "fragmentType";
    //修改昵称
    public static final int TYPE_NICKNAME = 1;
    //修改宣言
    public static final int TYPE_DESC = 2;
    //修改密码
    public static final int TYPE_PSW = 3;
    //修改支付密码
    public static final int TYPE_PAY_PSW = 4;
    //修改手机号码
    public static final int TYPE_PHONE = 5;

    private EditText etUserName;
    private EditText etDesc;
    private EditText etOldPsw;
    private EditText etNewPsw;
    private EditText etOldPhone;
    private EditText etNewPhone;
    private EditText etChechCodePhone;
    private EditText etCheckCode;
    private EditText etNewPayPsw;
    private TextView btnCheckCode;

    private int mType = 0;
    private String strName;
    private Map<String, String> params;
    private LoginResult data;
    private String strUserName, strDesc, strOldPsw, strNewPsw, strOldPhone, strNewPhone, strChechCodePhone, strCheckCode, strNewPayPsw;
    private String mPath, mPath2;
    //判断是否是获取验证码的操作
    private boolean isCheckCode;

    public static UpdateUserInfoFragment newInstance(Bundle args) {
        UpdateUserInfoFragment fragment = new UpdateUserInfoFragment();
        fragment.setArguments(args);
        return fragment;
    }


    protected int getViewId() {
        mType = getArguments().getInt(TYPE_FRAGMENT);
        return getCurrentViewId();
    }

    @Override
    protected void _init(Bundle savedInstanceState) {


        params = new HashMap<>();
        String strData = spUtils.getString(SP_CACHE_USERINFO);
        data = gson.fromJson(strData, LoginResult.class);
        _initView(rootView);
    }


    private void _initView(View view) {
        etUserName = view.findViewById(R.id.et_username);
        if (etUserName != null) {
            etUserName.setText(data.getData().getLoginUser().getWeixinName());
        }
        etDesc = view.findViewById(R.id.et_desc);
        if (etDesc != null) {
            etDesc.setText(data.getData().getLoginUser().getMyDeclaration());
        }
        etOldPsw = view.findViewById(R.id.et_original_psw);
        etNewPsw = view.findViewById(R.id.et_new_psw);
        etOldPhone = view.findViewById(R.id.et_old_phone);
        etNewPhone = view.findViewById(R.id.et_new_phone);
        etChechCodePhone = view.findViewById(R.id.et_check_code_phone);
        etCheckCode = view.findViewById(R.id.et_check_code);
        btnCheckCode = view.findViewById(R.id.btn_check_code);
        etNewPayPsw = view.findViewById(R.id.et_new_pay_psw);
        if (btnCheckCode != null)
            btnCheckCode.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    doClick(v);
                }
            });
    }

    /**
     * 获取当前需要加载的页面
     *
     * @return
     */
    private int getCurrentViewId() {
        int viewId = 0;
        switch (mType) {
            case TYPE_NICKNAME:
                viewId = R.layout.fragment_upate_userinfo_nickname;
                strName = getResources().getString(R.string.title_update_nickname);
                break;
            case TYPE_DESC:
                viewId = R.layout.fragment_upate_userinfo_desc;
                strName = getResources().getString(R.string.title_update_desc);
                break;
            case TYPE_PSW:
                viewId = R.layout.fragment_upate_userinfo_psw;
                strName = getResources().getString(R.string.title_update_login_psw);
                break;
            case TYPE_PAY_PSW:
                strName = getResources().getString(R.string.title_update_pay_psw);
                viewId = R.layout.fragment_upate_userinfo_pay_psw;
                break;
            case TYPE_PHONE:
                viewId = R.layout.fragment_upate_userinfo_phone;
                strName = getResources().getString(R.string.title_update_phone);
                break;
        }
        return viewId;
    }


    private void update() {
        params.clear();
        switch (mType) {
            case TYPE_NICKNAME:
                strUserName = etUserName.getText().toString();
                if (strUserName.trim().length() == 0) {
                    ToastUtils.showShortToast(getResources().getString(R.string.toast_nickname_unrequire));
                } else {
                    mPath = "login";
                    mPath2 = "updateMessage";
                    params.put("weixinName", strUserName);
                }
                break;
            case TYPE_DESC:
                strDesc = etDesc.getText().toString();
                if (EmptyUtils.isEmpty(strDesc)) {
                    ToastUtils.showShortToast(getResources().getString(R.string.toast_desc_unrequire));
                } else {
                    mPath = "login";
                    mPath2 = "updateMessage";
                    params.put("myDeclaration", strDesc);
                }
                break;
            case TYPE_PSW:
                strOldPsw = etOldPsw.getText().toString();
                strNewPsw = etNewPsw.getText().toString();
                if (EmptyUtils.isEmpty(strOldPsw) || EmptyUtils.isEmpty(strNewPsw)) {
                    ToastUtils.showShortToast(getResources().getString(R.string.toast_psw_unrequire));
                } else {
                    params.put("oldPassword", strOldPsw);
                    params.put("password", strNewPsw);
                    mPath = "login";
                    mPath2 = "setPassword";
                }
                break;
            case TYPE_PAY_PSW:
                strCheckCode = etCheckCode.getText().toString();
                strNewPayPsw = etNewPayPsw.getText().toString();
                strChechCodePhone = etChechCodePhone.getText().toString();
                if (EmptyUtils.isEmpty(strChechCodePhone)) {
                    ToastUtils.showShortToast(getResources().getString(R.string.toast_check_code_unrequire));
                } else if (EmptyUtils.isEmpty(strNewPayPsw)) {
                    ToastUtils.showShortToast(getResources().getString(R.string.toast_phone_unrequire));
                } else if (EmptyUtils.isEmpty(strChechCodePhone)) {
                    ToastUtils.showShortToast(getResources().getString(R.string.toast_psw_unrequire));
                } else {
                    mPath = "account";
                    mPath2 = "updatePassword";
                    params.put("phone", strChechCodePhone);
                    params.put("sms", strCheckCode);
                    params.put("payPassword", strNewPayPsw);
                }
                break;
            case TYPE_PHONE:
                strOldPhone = etOldPhone.getText().toString();
                strNewPhone = etNewPhone.getText().toString();
                if (strOldPhone.equals(strNewPhone)) {
                    ToastUtils.showShortToast(getResources().getString(R.string.toast_phone_same));
                } else if (EmptyUtils.isEmpty(strOldPhone) || EmptyUtils.isEmpty(strNewPhone)) {
                    ToastUtils.showShortToast(getResources().getString(R.string.toast_phone_unrequire));
                } else {
                    mPath = "updatePhone";
                    mPath2 = "";
                    params.put("oldPhone", strOldPhone);
                    params.put("newPhone", strNewPhone);
                }
                break;
        }
        if (!params.isEmpty()) {
            isCheckCode = false;
            doConnect();
        }
    }

    private void getCheckCode() {
        strChechCodePhone = etChechCodePhone.getText().toString();
        if (EmptyUtils.isEmpty(strChechCodePhone)) {
            ToastUtils.showShortToast(getResources().getString(R.string.toast_phone_unrequire));
        } else {
            isCheckCode = true;
            params.clear();
            mPath = "login";
            mPath2 = "sendmsPayPassword.htm";
            params.put("phone", strChechCodePhone);
            doConnect();
        }
    }

    private void doConnect() {
        mUserViewModel.doUpdateUserInfo(mPath, mPath2, spUtils.getString(SP_SESSION_ID), params)
                .observe(this, this);
    }


    @Override
    protected void onDataSuccessChanged(BaseResult baseResult) {
        if (isCheckCode) {
            TimerCountUtils.start(60 * 1000, 1000, btnCheckCode);
            ToastUtils.showShortToast(getResources().getString(R.string.toast_check_code_send_success));
        } else {
            setData();
            getFragmentManager().popBackStack();
        }
    }

    private void setData() {

        switch (mType) {
            case TYPE_NICKNAME:
                data.getData().getLoginUser().setWeixinName(etUserName.getText().toString());
                break;
            case TYPE_DESC:
                data.getData().getLoginUser().setMyDeclaration(etDesc.getText().toString());
                break;
            case TYPE_PHONE:
                data.getData().getLoginUser().setPhone(etNewPhone.getText().toString());
                break;
        }
        spUtils.putString(SP_CACHE_USERINFO, gson.toJson(data));
    }

    @Override
    protected void setToolbar() {
        tvTitle.setText(strName);
    }

    @OnClick(R.id.tv_update)
    public void doClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.tv_update:
                update();
                break;
            case R.id.btn_check_code:
                getCheckCode();
                break;
        }
    }
}
