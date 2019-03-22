package com.baimeiyx.www.service.model;

import android.graphics.drawable.Drawable;

import com.example.mrw.baimeiyouxuan.R;

public class QingNiuBean {
    /**
     * 内容介绍
     */
    private String info;
    /**
     * 当前标准
     */
    private int level;

    private String levelMsg;
    /**
     * 距离保准体重
     */
    private double sOffset;
    /**
     * 偏移描述
     */
    private String offsetInfo;
    /**
     * 单位
     */
    private String unit;

    private float lowLeverMaxValue;
    private float lowerLeverMaxValue;
    private float standardLevelMaxValue;
    private float highLevelMaxValue;

    private String level_1;
    private String level_2;
    private String level_3;
    private String level_4;
    private String level_5;
    private int level_1_color;
    private int level_2_color;
    private int level_3_color;
    private int level_4_color;
    private int level_5_color;

    private int typeImgId;
    private String typeName;
    private int statusImgId;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getLevelMsg() {
        return levelMsg;
    }

    public void setLevelMsg(String levelMsg) {
        this.levelMsg = levelMsg;
    }

    public double getsOffset() {
        return sOffset;
    }

    public void setsOffset(double sOffset) {
        this.sOffset = sOffset;
    }

    public String getOffsetInfo() {
        return offsetInfo;
    }

    public void setOffsetInfo(String offsetInfo) {
        this.offsetInfo = offsetInfo;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public float getLowLeverMaxValue() {
        return lowLeverMaxValue;
    }

    public void setLowLeverMaxValue(float lowLeverMaxValue) {
        this.lowLeverMaxValue = lowLeverMaxValue;
    }

    public float getLowerLeverMaxValue() {
        return lowerLeverMaxValue;
    }

    public void setLowerLeverMaxValue(float lowerLeverMaxValue) {
        this.lowerLeverMaxValue = lowerLeverMaxValue;
    }

    public float getStandardLevelMaxValue() {
        return standardLevelMaxValue;
    }

    public void setStandardLevelMaxValue(float standardLevelMaxValue) {
        this.standardLevelMaxValue = standardLevelMaxValue;
    }

    public float getHighLevelMaxValue() {
        return highLevelMaxValue;
    }

    public void setHighLevelMaxValue(float highLevelMaxValue) {
        this.highLevelMaxValue = highLevelMaxValue;
    }

    public String getLevel_1() {
        return level_1;
    }

    public void setLevel_1(String level_1) {
        this.level_1 = level_1;
    }

    public String getLevel_2() {
        return level_2;
    }

    public void setLevel_2(String level_2) {
        this.level_2 = level_2;
    }

    public String getLevel_3() {
        return level_3;
    }

    public void setLevel_3(String level_3) {
        this.level_3 = level_3;
    }

    public String getLevel_4() {
        return level_4;
    }

    public void setLevel_4(String level_4) {
        this.level_4 = level_4;
    }

    public String getLevel_5() {
        return level_5;
    }

    public void setLevel_5(String level_5) {
        this.level_5 = level_5;
    }

    public int getLevel_1_color() {
        return level_1_color;
    }

    public void setLevel_1_color(int level_1_color) {
        this.level_1_color = level_1_color;
    }

    public int getLevel_2_color() {
        return level_2_color;
    }

    public void setLevel_2_color(int level_2_color) {
        this.level_2_color = level_2_color;
    }

    public int getLevel_3_color() {
        return level_3_color;
    }

    public void setLevel_3_color(int level_3_color) {
        this.level_3_color = level_3_color;
    }

    public int getLevel_4_color() {
        return level_4_color;
    }

    public void setLevel_4_color(int level_4_color) {
        this.level_4_color = level_4_color;
    }

    public int getLevel_5_color() {
        return level_5_color;
    }

    public void setLevel_5_color(int level_5_color) {
        this.level_5_color = level_5_color;
    }

    public int getTypeImg() {
        return typeImgId;
    }

    public void setTypeImg(int typeImg) {
        this.typeImgId = typeImg;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public int getStatusImgId() {
        switch (level) {
            case 1:
                statusImgId = R.drawable.bg_corner_lower;
                break;
            case 2:
                statusImgId = R.drawable.bg_corner_low;
                break;
            case 4:
                if (!levelMsg.equals("充足"))
                    statusImgId = R.drawable.bg_corner_high;
                break;
            case 5:
                statusImgId = R.drawable.bg_corner_higher;
                break;
        }
        return statusImgId;
    }

    public int getStatusTextColor() {
        int color = 0;
        switch (level) {
            case 1:
                color = R.color.levelLower;
                break;
            case 2:
                color = R.color.levelLow;
                break;
            case 4:
                if (!levelMsg.equals("充足"))
                    color = R.color.colorHigh;
                break;
            case 5:
                color = R.color.colorHigher;
                break;
        }
        return color;
    }

}
