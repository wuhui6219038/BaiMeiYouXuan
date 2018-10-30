package com.baimeiyx.www.base.callback;

import android.view.View;

/**
 * @author mr.w
 * recycleview 点击回调
 */
public interface ItemOnClickListener<T> {
    /**
     *
     * @param view 点击的view
     * @param data 数据
     * @param poistion 点击的位置
     */
   void onItemClick(View view, T data, int poistion);
}
