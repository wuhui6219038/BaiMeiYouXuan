package com.baimeiyx.www.ui.weight_record.ui;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

import com.example.mrw.baimeiyouxuan.R;
import com.baimeiyx.www.base.callback.FragmentInteraction;
import com.baimeiyx.www.utils.ScreenUtils;
import com.baimeiyx.www.view.Ruler;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class DialogRulerFragment extends DialogFragment {
    @BindView(R.id.tv_weight)
    TextView tvWeight;
    @BindView(R.id.ruler)
    Ruler ruler;
    @BindView(R.id.tv_cancel)
    TextView tvCancel;
    @BindView(R.id.tv_sure)
    TextView tvSure;
    private Unbinder unbinder;
    private double selectWeight = 45.5;
    private FragmentInteraction fragmentInteraction;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        View rootView = inflater.inflate(R.layout.view_ruler, container, false);
        unbinder = ButterKnife.bind(this, rootView);
        _init();
        return rootView;
    }

    private void _init() {
        getDialog().setCanceledOnTouchOutside(true);
        tvWeight.setText(selectWeight + "");
        ruler.setValue(selectWeight);
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

    public void setListener(FragmentInteraction fragmentInteraction) {
        this.fragmentInteraction = fragmentInteraction;
    }

    @OnClick({R.id.tv_cancel, R.id.tv_sure})
    public void doClick(View view) {
        dismiss();
        int id = view.getId();
        switch (id) {
            case R.id.tv_sure:
                fragmentInteraction.fragmentToAcProcess(tvWeight.getText().toString());
                break;
        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }


}
