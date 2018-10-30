package com.baimeiyx.www.ui.user;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baimeiyx.www.base.ui.BaseUserFragment;
import com.example.mrw.baimeiyouxuan.R;
import com.baimeiyx.www.module.http.result.LoginResult;
import com.baimeiyx.www.module.http.result.UserInfoResult;
import com.baimeiyx.www.utils.ActivityUtils;
import com.baimeiyx.www.utils.BarUtils;
import com.baimeiyx.www.utils.ConstUtils;
import com.baimeiyx.www.utils.ImageUtils;
import com.baimeiyx.www.utils.myUtils.NumFormatterUtils;
import com.baimeiyx.www.utils.myUtils.SvgUtils;

import butterknife.BindView;
import butterknife.OnClick;

import static com.baimeiyx.www.constant.Constant.LEVEL;
import static com.baimeiyx.www.constant.KeyConstant.SP_CACHE_USERINFO;
import static com.baimeiyx.www.constant.KeyConstant.SP_SESSION_ID;

/**
 * 个人中心
 */
public class AccountFragment extends BaseUserFragment<UserInfoResult> {
    private static final String TAG = "AccountFragment";
    @BindView(R.id.iv_personal)
    ImageView ivPersonal;
    @BindView(R.id.tv_username)
    TextView tvUsername;
    @BindView(R.id.tv_member_level)
    TextView tvMemberLevel;
    @BindView(R.id.tv_glod)
    TextView tvGlod;
    @BindView(R.id.tv_has_cost)
    TextView tvHasCost;
    @BindView(R.id.tv_available_gold)
    TextView tvAvailableGold;
    @BindView(R.id.text_icon_next)
    TextView textIconNext;
    @BindView(R.id.ll_user)
    LinearLayout llUser;
    @BindView(R.id.ll_user_finance)
    LinearLayout llUserFinance;
    @BindView(R.id.ll_user_finance2)
    LinearLayout llUserFinance2;
    @BindView(R.id.tv_order)
    TextView tvOrder;
    @BindView(R.id.tv_shop)
    TextView tvShop;
    @BindView(R.id.tv_address)
    TextView tvAddress;
    @BindView(R.id.tv_card)
    TextView tvCard;
    @BindView(R.id.tv_erweima)
    TextView tvErweima;
    @BindView(R.id.tv_friends)
    TextView tvFriends;
    private String sessionId;


    public static AccountFragment newInstance() {
        Bundle args = new Bundle();
        AccountFragment fragment = new AccountFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getViewId() {
        return R.layout.fragment_account;
    }


    protected void _init(Bundle data) {
        SvgUtils.setIcon(mActivity, textIconNext, "iconfont.ttf");
    }

    private void _initValue() {
        String strData = spUtils.getString(SP_CACHE_USERINFO);
        if (strData != null) {
            LoginResult data = gson.fromJson(strData, LoginResult.class);
            ImageUtils.loadImageUrlRound(mActivity, ivPersonal, data.getData().getLoginUser().getPhoto());
            tvUsername.setText(data.getData().getLoginUser().getWeixinName());
            tvMemberLevel.setText(LEVEL[data.getData().getLoginUser().getCustomerLevel() - 1]);
        } else {
            ivPersonal.setImageResource(R.drawable.empty_avatar_user);
            tvUsername.setText(getResources().getString(R.string.text_login_regist));
            tvMemberLevel.setText(getResources().getString(R.string.text_default_member_level));
            setGold(new UserInfoResult.DataBean(), new UserInfoResult.DataBean());
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        sessionId = spUtils.getString(SP_SESSION_ID);
        _initValue();
        if (!TextUtils.isEmpty(sessionId)) {
            mUserViewModel.getUserInfo("searchCustomerRelevance", sessionId)
                    .observe(this, this);
        }
    }

    @Override
    protected void onDataSuccessChanged(UserInfoResult userInfoResult) {
        setGold(userInfoResult.getData(), userInfoResult.getPage());
    }

    private void setGold(UserInfoResult.DataBean dataBean, UserInfoResult.DataBean dataPage) {
        tvAvailableGold.setText(NumFormatterUtils.getFormatNum(dataBean.getAvailableAmount(), ConstUtils.NUM_FORMAT_1));
        tvGlod.setText(NumFormatterUtils.getFormatNum(dataBean.getCashBalance(), ConstUtils.NUM_FORMAT_1));
        tvHasCost.setText(NumFormatterUtils.getFormatNum(dataPage.getSumChangeValue(), ConstUtils.NUM_FORMAT_1));


    }

    @Override
    protected void setToolbar() {
        tvTitle.setText(getResources().getString(R.string.title_account));
        toolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        ivBack.setVisibility(View.GONE);
        BarUtils.setColor(mActivity, getResources().getColor(R.color.colorPrimary), 0);
    }


    @OnClick({R.id.ll_user, R.id.ll_user_finance, R.id.ll_user_finance2, R.id.tv_order, R.id.tv_shop, R.id.tv_address, R.id.tv_card, R.id.tv_erweima, R.id.tv_friends})
    public void onViewClicked(View view) {
        Bundle bundle = new Bundle();
        if (TextUtils.isEmpty(sessionId)) {
            bundle.putString(UserInfoActivity.FRAGMENT_TYPE, LoginFragment.class.getName());

        } else {
            switch (view.getId()) {
                case R.id.ll_user_finance:

                case R.id.ll_user_finance2:
                    bundle.putString(UserInfoActivity.FRAGMENT_TYPE, WalletFragment.class.getName());
                    break;
                case R.id.ll_user:
                    bundle.putString(UserInfoActivity.FRAGMENT_TYPE, UserInfoFragment.class.getName());
                    break;
                case R.id.tv_order:
                    break;
                case R.id.tv_shop:
                    break;
                case R.id.tv_address:
                    break;
                case R.id.tv_card:
                    break;
                case R.id.tv_erweima:
                    break;
                case R.id.tv_friends:
                    break;
            }
        }
        ActivityUtils.launchActivity(mActivity, packageName, packageName + ".ui.user.UserInfoActivity", bundle);
    }


}