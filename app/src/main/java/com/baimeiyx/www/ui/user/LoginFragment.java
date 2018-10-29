package com.baimeiyx.www.ui.user;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.mrw.baimeiyouxuan.R;
import com.baimeiyx.www.base.ui.BaseUserFragment;
import com.baimeiyx.www.http.result.BaseResult;
import com.baimeiyx.www.http.result.LoginResult;
import com.baimeiyx.www.utils.myUtils.DialogUtils;
import com.qmuiteam.qmui.widget.dialog.QMUITipDialog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginFragment extends BaseUserFragment<LoginResult> {
    private static final String TAG = "LoginFragment";
    @BindView(R.id.et_username)
    EditText etUsername;
    @BindView(R.id.et_password)
    EditText etPassword;
    private QMUITipDialog dialog;


    public static LoginFragment newInstance() {

        Bundle args = new Bundle();

        LoginFragment fragment = new LoginFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected int getViewId() {
        return R.layout.fragment_login;
    }

    @Override
    protected void _init(Bundle savedInstanceState) {
        dialog = DialogUtils.showLoadDialog(getContext(), getResources().getString(R.string.toast_data_connneting));
    }

    @Override
    protected void setToolbar() {
        tvTitle.setText(getResources().getString(R.string.text_login));
    }

    @OnClick({R.id.btn_phone_login, R.id.btn_wx_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_phone_login:
                Log.e(TAG, "onViewClicked: ");
                dialog.show();
                mUserViewModel.doLogin(etUsername.getText().toString(), etPassword.getText().toString())
                        .observe(LoginFragment.this, this);
                break;
            case R.id.btn_wx_login:
                break;
        }
    }


    @Override
    protected void onDataSuccessChanged(LoginResult loginResult) {
        dialog.dismiss();
        spUtils.putString(SP_SESSION_ID, loginResult.getData().getSessionId());
        spUtils.putString(SP_CACHE_USERINFO, gson.toJson(loginResult));
        mActivity.finish();
    }
}
