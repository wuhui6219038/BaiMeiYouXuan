package com.baimeiyx.www.base.callback;

import android.os.Bundle;

/**
 * @author mr.w
 * fragment和ac通信接口回调
 */
public interface FragmentInteraction {
    /**
     * @param data   存放数据
     * @param action 类型
     */
    void fragmentToAcProcess(Bundle data, int action);

    /**
     * @param data 存放数据
     */
    void fragmentToAcProcess(String data);
}
