package com.baimeiyx.www.ui.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.baimeiyx.www.utils.ToastUtils;
import com.example.mrw.baimeiyouxuan.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class DialogRecodeWidget extends DialogFragment {
    private Unbinder unbinder;


    public static DialogRecodeWidget newInstance(Bundle data) {
        DialogRecodeWidget fragment = new DialogRecodeWidget();
        fragment.setArguments(data);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        View rootView = inflater.inflate(R.layout.dialog_view_recode_widget, container, false);
        unbinder = ButterKnife.bind(this, rootView);
        _init();
        return rootView;
    }

    private void _init() {
        getDialog().setCanceledOnTouchOutside(true);

    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            DisplayMetrics dm = new DisplayMetrics();
            getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
            int width = (int) (dm.widthPixels * 0.85);
            dialog.getWindow().setLayout(width, WindowManager.LayoutParams.WRAP_CONTENT);
        }
    }

    @OnClick({R.id.tv_buy_balance, R.id.tv_recode_weight, R.id.iv_close})
    public void doClick(View view) {
        int id = view.getId();

        switch (id) {
            case R.id.tv_buy_balance:
                ToastUtils.showShortToast("功能暂时开放");
                break;
            case R.id.tv_recode_weight:
                break;
            case R.id.iv_close:
                dismiss();
                break;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}

