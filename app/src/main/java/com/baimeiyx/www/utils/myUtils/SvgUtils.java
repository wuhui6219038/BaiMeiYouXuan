package com.baimeiyx.www.utils.myUtils;

import android.app.Activity;
import android.graphics.Typeface;
import android.widget.TextView;

/**
 * @author mr.w
 * svg的相关内容
 */
public class SvgUtils {
    private SvgUtils() {

    }

    /**
     * 利用svg图片
     *
     * @param activity
     * @param textIcon
     * @param svgPath
     */
    public static void setIcon(Activity activity, TextView textIcon, String svgPath) {
        Typeface tf = Typeface.createFromAsset(activity.getAssets(), svgPath);
        textIcon.setTypeface(tf);
    }
}
