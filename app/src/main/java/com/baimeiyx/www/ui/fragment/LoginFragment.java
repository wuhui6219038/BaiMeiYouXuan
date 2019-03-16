package com.baimeiyx.www.ui.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.baimeiyx.www.base.ui.BaseUserFragment;
import com.baimeiyx.www.service.model.LoginResult;
import com.baimeiyx.www.service.repository.DataManager;
import com.baimeiyx.www.service.rxjava.DialogSubscribe;
import com.baimeiyx.www.service.rxjava.RetryExceptionObservable;
import com.baimeiyx.www.service.rxjava.RxJavaUtils;
import com.example.mrw.baimeiyouxuan.R;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginFragment extends BaseUserFragment<LoginResult> {
    private static final String TAG = "LoginFragment";
    @BindView(R.id.et_username)
    EditText etUsername;
    @BindView(R.id.et_password)
    EditText etPassword;


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
    }

    @Override
    protected void setToolbar() {
        tvTitle.setText(getResources().getString(R.string.text_login));
    }

    @OnClick({R.id.btn_phone_login, R.id.btn_wx_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_phone_login:
                doLogin();
                break;
            case R.id.btn_wx_login:
                break;
        }
    }

    private void doLogin() {
        DataManager.getBaiMeiApiService()
                .doObservableLogin(etUsername.getText().toString(), etPassword.getText().toString())
                .compose(RxJavaUtils.rxSchedulerHelper())
                .retryWhen(new RetryExceptionObservable())
                .subscribe(new DialogSubscribe<LoginResult>(mActivity) {
                    @Override
                    public void dataSuccess(LoginResult data) {
                        onDataSuccessChanged(data);
                    }
                }.showLoadDialog(getResources().getString(R.string.toast_login_connneting)));
    }


    @Override
    protected void onDataSuccessChanged(LoginResult loginResult) {
        spUtils.putString(SP_SESSION_ID, loginResult.getData().getSessionId());
        spUtils.putString(SP_CACHE_USERINFO, gson.toJson(loginResult));
        mActivity.finish();
    }
}
