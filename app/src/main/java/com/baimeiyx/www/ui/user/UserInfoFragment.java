package com.baimeiyx.www.ui.user;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.baimeiyx.www.base.ui.BaseSimpleFragment;
import com.example.mrw.baimeiyouxuan.R;
import com.baimeiyx.www.module.http.result.LoginResult;
import com.qmuiteam.qmui.widget.dialog.QMUIDialog;
import com.qmuiteam.qmui.widget.dialog.QMUIDialogAction;
import com.baimeiyx.www.utils.AppUtils;
import com.baimeiyx.www.utils.ImageUtils;
import com.baimeiyx.www.utils.ToastUtils;
import com.baimeiyx.www.utils.myUtils.FragmentUtils;

import butterknife.BindView;
import butterknife.OnClick;

public class UserInfoFragment extends BaseSimpleFragment {
    @BindView(R.id.iv_avatar)
    ImageView ivAvatar;
    @BindView(R.id.tv_nickname)
    TextView tvNickname;
    @BindView(R.id.tv_declaration)
    TextView tvDeclaration;
    @BindView(R.id.tv_phone)
    TextView tvPhone;
    @BindView(R.id.tv_version)
    TextView tvVersion;
    private Bundle bundle = new Bundle();

    public static UserInfoFragment newInstance() {

        Bundle args = new Bundle();

        UserInfoFragment fragment = new UserInfoFragment();
        fragment.setArguments(args);
        return fragment;
    }


    private void _initValue() {
        LoginResult loginResult = gson.fromJson(spUtils.getString(SP_CACHE_USERINFO), LoginResult.class);
        tvDeclaration.setText(loginResult.getData().getLoginUser().getMyDeclaration());
        tvNickname.setText(loginResult.getData().getLoginUser().getWeixinName());
        tvPhone.setText(loginResult.getData().getLoginUser().getPhone());
        tvVersion.setText("v" + AppUtils.getAppVersionName(mActivity));
        ImageUtils.loadImageUrlRound(mActivity, ivAvatar, loginResult.getData().getLoginUser().getPhoto());
    }


    @Override
    protected int getViewId() {
        return R.layout.fragment_user_setting;
    }

    @Override
    protected void _init(Bundle savedInstanceState) {
        _initValue();
    }


    @OnClick({R.id.ll_avatar, R.id.ll_nick_name, R.id.ll_declaration, R.id.ll_login_psd, R.id.ll_pay_psd, R.id.ll_phone, R.id.btn_logout})
    public void onViewClicked(View view) {

        switch (view.getId()) {
            case R.id.ll_avatar:
                ToastUtils.showShortToast("暂无此功能");
                break;
            case R.id.ll_nick_name:
                bundle.putInt(UpdateUserInfoFragment.TYPE_FRAGMENT, UpdateUserInfoFragment.TYPE_NICKNAME);
                break;
            case R.id.ll_declaration:
                bundle.putInt(UpdateUserInfoFragment.TYPE_FRAGMENT, UpdateUserInfoFragment.TYPE_DESC);
                break;
            case R.id.ll_login_psd:
                bundle.putInt(UpdateUserInfoFragment.TYPE_FRAGMENT, UpdateUserInfoFragment.TYPE_PSW);
                break;
            case R.id.ll_pay_psd:
                bundle.putInt(UpdateUserInfoFragment.TYPE_FRAGMENT, UpdateUserInfoFragment.TYPE_PAY_PSW);
                break;
            case R.id.ll_phone:
                bundle.putInt(UpdateUserInfoFragment.TYPE_FRAGMENT, UpdateUserInfoFragment.TYPE_PHONE);
                break;
            case R.id.btn_logout:
                showMessagePositiveDialog();
                break;

        }
        if (view.getId() != R.id.btn_logout && view.getId() != R.id.ll_avatar)
            FragmentUtils.showFragmentAddStack(getFragmentManager(), R.id.user_contain, UpdateUserInfoFragment.newInstance(bundle));

    }

    private int mCurrentDialogStyle = com.qmuiteam.qmui.R.style.QMUI_Dialog;

    private void showMessagePositiveDialog() {
        new QMUIDialog.MessageDialogBuilder(getActivity())
                .setTitle(getResources().getString(R.string.dialog_hint))
                .setMessage(getResources().getString(R.string.dialog_logout))
                .addAction(getResources().getString(R.string.btn_cancel), new QMUIDialogAction.ActionListener() {
                    @Override
                    public void onClick(QMUIDialog dialog, int index) {
                        dialog.dismiss();

                    }
                })
                .addAction(getResources().getString(R.string.btn_sure), new QMUIDialogAction.ActionListener() {
                    @Override
                    public void onClick(QMUIDialog dialog, int index) {
                        dialog.dismiss();
                        spUtils.clear();
                        mActivity.finish();
                    }
                })
                .create(mCurrentDialogStyle).show();
    }


    @Override
    protected void setToolbar() {
        tvTitle.setText(getResources().getString(R.string.title_user_setting));
    }
}
