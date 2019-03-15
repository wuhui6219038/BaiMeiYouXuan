package com.baimeiyx.www.utils.myUtils;

import com.baimeiyx.www.App;
import com.example.mrw.baimeiyouxuan.R;

/**
 * 体重相关
 */
public class WeightUtils {
    public static String getTargetStatus(double differenceWeight) {
        if (differenceWeight > 0) {
            return App.INSTANCE.getResources().getString(R.string.text_plus_weight);
        } else {
            return App.INSTANCE.getResources().getString(R.string.text_reduce_weight);
        }
    }
}
