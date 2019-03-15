package com.baimeiyx.www.view.dialog;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;

import com.baimeiyx.www.MainActivity;
import com.baimeiyx.www.utils.ScreenUtils;
import com.example.mrw.baimeiyouxuan.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class DialogInputFragment extends DialogFragment {
    public static final String DEFAULT_VALUE = "defaultValue";
    public static final String TITLE_VALUE = "titleValue";
    public static final String VALUE_UNIT = "unit";

    @BindView(R.id.tv_dialog_title)
    TextView tvDialogTitle;
    @BindView(R.id.et_value)
    EditText etValue;
    @BindView(R.id.btn_sure)
    TextView btnSure;
    private Unbinder unbinder;
    private String titlePre, defValue;
    private Bundle data;

    public static DialogInputFragment newInstance(Bundle data) {
        DialogInputFragment fragment = new DialogInputFragment();
        fragment.setArguments(data);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        View rootView = inflater.inflate(R.layout.dialog_view_input, container, false);
        unbinder = ButterKnife.bind(this, rootView);
        _init();
        return rootView;
    }

    private void _init() {
        getDialog().setCanceledOnTouchOutside(true);

        _initValue();
        _initView();
    }

    private void _initValue() {
        data = getArguments();
        if (data != null) {
            defValue = data.getString(DEFAULT_VALUE);
            titlePre = data.getString(TITLE_VALUE);
            etValue.setText(defValue + "");
            tvDialogTitle.setText(getResources().getString(R.string.text_please, titlePre));
        }

    }

    private void _initView() {
        etValue.setSelection(etValue.length());
        etValue.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (TextUtils.isEmpty(s)) {
                    btnSure.setEnabled(false);
                    btnSure.setBackgroundColor(getResources().getColor(R.color.colorMainBackgroud));
                } else {
                    btnSure.setEnabled(true);
                    btnSure.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        Window mWindow = getDialog().getWindow();

        mWindow.setLayout((int) (ScreenUtils.getScreenWidth() * 0.8), ViewGroup.LayoutParams.WRAP_CONTENT);


    }


    @OnClick({R.id.btn_cancel, R.id.btn_sure})
    public void doClick(View view) {
        dismiss();
        int id = view.getId();
        switch (id) {
            case R.id.btn_sure:
                MainActivity.appViewModel.getSingleObserver().setValue(etValue.getText().toString());
                break;
        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }


}
