package com.baimeiyx.www.service.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 蓝牙设备的配置
 */
public class BleConfig implements Parcelable {
    private boolean onlyScreenOn;
    //每个设备单次扫描只返回一次
    private boolean allowDuplicates = false;
    //0:kg ,1:kb,2:斤 ,3:st
    private int unit = 0;
    //扫描时间
    private int duration = 0;
    //扫描超时时间
    private long scanOutTime = 0;
    //连接超时时间
    private long connectOutTime = 6000;

    public BleConfig() {
    }

    public boolean isOnlyScreenOn() {
        return onlyScreenOn;
    }

    public void setOnlyScreenOn(boolean onlyScreenOn) {
        this.onlyScreenOn = onlyScreenOn;
    }

    public boolean isAllowDuplicates() {
        return allowDuplicates;
    }

    public void setAllowDuplicates(boolean allowDuplicates) {
        this.allowDuplicates = allowDuplicates;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }


    public long getScanOutTime() {
        return scanOutTime;
    }

    public void setScanOutTime(long scanOutTime) {
        this.scanOutTime = scanOutTime;
    }


    public long getConnectOutTime() {
        return connectOutTime;
    }

    public void setConnectOutTime(long connectOutTime) {
        this.connectOutTime = connectOutTime;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte(this.onlyScreenOn ? (byte) 1 : (byte) 0);
        dest.writeByte(this.allowDuplicates ? (byte) 1 : (byte) 0);
        dest.writeInt(this.duration);
        dest.writeInt(this.unit);
        dest.writeLong(this.scanOutTime);
    }

    protected BleConfig(Parcel in) {
        this.onlyScreenOn = in.readByte() != 0;
        this.allowDuplicates = in.readByte() != 0;
        this.duration = in.readInt();
        this.unit = in.readInt();
        this.scanOutTime = in.readLong();
    }

    public static final Creator<BleConfig> CREATOR = new Creator<BleConfig>() {
        @Override
        public BleConfig createFromParcel(Parcel source) {
            return new BleConfig(source);
        }

        @Override
        public BleConfig[] newArray(int size) {
            return new BleConfig[size];
        }
    };
}
