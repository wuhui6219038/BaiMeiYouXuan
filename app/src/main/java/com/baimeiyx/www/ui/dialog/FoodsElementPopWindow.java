package com.baimeiyx.www.ui.dialog;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.RadioButton;

import com.baimeiyx.www.service.model.FoodsElementSortResult;
import com.baimeiyx.www.ui.adapter.AdapterFoodsElement;
import com.example.mrw.baimeiyouxuan.R;

import java.util.List;

public class FoodsElementPopWindow extends PopupWindow implements PopupWindow.OnDismissListener {
    private static final String TAG = "FoodsElementPopWindow";
    private Context mContext;
    private RecyclerView recyclerView;
    private AdapterFoodsElement adapter;
    private LayoutInflater inflater;
    private RadioButton itemCheckBox;
    private OnPopWindowistenser listenser;

    public FoodsElementPopWindow(Context context) {
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        recyclerView = (RecyclerView) inflater.inflate(R.layout.popwindon_foods_element, null, false);
        mContext = context;
        _init();
        setOnDismissListener(this);
    }

    private void _init() {
        setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        setOutsideTouchable(true);
        setFocusable(true);
        setBackgroundDrawable(new ColorDrawable(Color.WHITE));
        setContentView(recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(mContext, 3));
        adapter = new AdapterFoodsElement(R.layout.item_foods_element_type);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener((adapter, view, poistion) -> {
            if (itemCheckBox != view) {
                Log.e(TAG, " 点击了");
                if (itemCheckBox != null) {
                    itemCheckBox.setChecked(false);
                }
                itemCheckBox = (RadioButton) view;
            }
            listenser.onItemClick((FoodsElementSortResult.PageBean) adapter.getData().get(poistion));
        });
    }

    public void setData(List<FoodsElementSortResult.PageBean> datas) {
        adapter.setNewData(datas);
    }

    public void setListenser(OnPopWindowistenser listenser) {
        this.listenser = listenser;
    }

    @Override
    public void onDismiss() {
        listenser.onDismiss();

    }

    public interface OnPopWindowistenser {
        void onItemClick(FoodsElementSortResult.PageBean bean);

        void onDismiss();
    }
}
