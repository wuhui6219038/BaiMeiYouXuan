package com.baimeiyx.www.utils.myUtils;


import com.baimeiyx.www.utils.ConstUtils;

import java.text.DecimalFormat;

public class NumFormatterUtils {

    public static String getFormatNum(double data) {
        DecimalFormat df = new DecimalFormat(ConstUtils.NUM_FORMAT_1);
        return df.format(data);
    }

    /**
     * @param data
     * @param format {@link ConstUtils#NUM_FORMAT_1}
     *               {@link ConstUtils#NUM_FORMAT_2}
     *               {@link ConstUtils#NUM_FORMAT_3}
     * @return
     */
    public static String getFormatNum(double data, String format) {
        DecimalFormat df = new DecimalFormat(format);
        return df.format(data);
    }

    /**
     * {@link NumFormatterUtils#getFormatNum(double, String)}
     *
     * @param data
     * @param format
     * @return
     */
    public static String getFormatNum(long data, String format) {
        DecimalFormat df = new DecimalFormat(format);
        return df.format(data);
    }

    /**
     * {@link NumFormatterUtils#getFormatNum(double, String)}
     *
     * @param data
     * @param format
     * @return
     */
    public static String getFormatNum(String data, String format) {
        DecimalFormat df = new DecimalFormat(format);
        return df.format(data);
    }
}
