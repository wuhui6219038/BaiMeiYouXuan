package com.baimeiyx.www.constant;

/**
 * @author mr.w
 * 程序常用的key
 */
public interface Config extends KeyConstant{
    /**
     * 蓝牙通信读信息
     */
    String YUNCHEN_READ_SERVICE_UUID = "00001800-0000-1000-8000-00805f9b34fb";
    String YUNCHEN_READ_CHARACTERISTIC_UUID = "00002a01-0000-1000-8000-00805f9b34fb";
    /**
     * 蓝牙通信写数据
     */
    String YUNCHEN_WRITE_SERVICE_UUID = "0000fff0-0000-1000-8000-00805f9b34fb";
    String YUNCHEN_WRITE_CHARACTERISTIC_UUID = "0000FFF4-0000-1000-8000-00805F9B34FB";
    //秤的名称
    String[] DEVICE_NAME = {"YunChen"};
}
