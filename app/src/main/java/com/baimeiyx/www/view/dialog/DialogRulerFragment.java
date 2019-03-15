package com.baimeiyx.www.view.dialog;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

import com.baimeiyx.www.widget.Ruler;
import com.baimeiyx.www.utils.ScreenUtils;
import com.example.mrw.baimeiyouxuan.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class DialogRulerFragment extends DialogFragment {
    public static final String DEFVALUE = "defValue";
    @BindView(R.id.tv_weight)
    TextView tvWeight;
    @BindView(R.id.ruler)
    Ruler ruler;
    @BindView(R.id.tv_cancel)
    TextView tvCancel;
    @BindView(R.id.tv_sure)
    TextView tvSure;
    private Unbinder unbinder;
    private String selectWeight = "45.5";
    private OnValueChangeListenser onValueChangeListenser;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        View rootView = inflater.inflate(R.layout.dialog_view_ruler, container, false);
        unbinder = ButterKnife.bind(this, rootView);
        _init();
        return rootView;
    }

    private void _init() {
        getDialog().setCanceledOnTouchOutside(true);
        selectWeight = getArguments().getString(DEFVALUE, selectWeight);
        tvWeight.setText(selectWeight + "");
        ruler.setValue(Double.parseDouble(selectWeight));
        ruler.setOnValueChangeListener(new Ruler.OnValueChangeListener() {
            @Override
            public void onValueChange(double size) {
                tvWeight.setText(size + "");
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        Window mWindow = getDialog().getWindow();
        mWindow.setLayout((int) (ScreenUtils.getScreenWidth() * 0.9), (int) (ScreenUtils.getScreenHeight() * 0.4));


    }

    public void setOnValueChangeListenser(OnValueChangeListenser listenser) {
        this.onValueChangeListenser = listenser;
    }

    @OnClick({R.id.tv_cancel, R.id.tv_sure})
    public void doClick(View view) {

        int id = view.getId();
        switch (id) {
            case R.id.tv_sure:
                onValueChangeListenser.onValueChange(tvWeight.getText().toString());
                break;
        }
        dismiss();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }


    public interface OnValueChangeListenser {
        void onValueChange(String value);
    }

}
