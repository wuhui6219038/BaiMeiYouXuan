package com.baimeiyx.www.ui.weight_record.ui;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.baimeiyx.www.base.callback.ItemOnClickListener;
import com.baimeiyx.www.base.ui.BaseAdapter;
import com.example.mrw.baimeiyouxuan.R;

import java.util.ArrayList;
import java.util.List;

public class AdapterBlueToothDevices extends BaseAdapter<AdapterBlueToothDevices.DeviceViewHolder> {
    private List<BluetoothDevice> deviceList;
    private Context mContext;
    private ItemOnClickListener itemOnClickListener;

    public AdapterBlueToothDevices(Context context) {
        this.mContext = context;
        deviceList = new ArrayList<>();
    }

    @NonNull
    @Override
    public AdapterBlueToothDevices.DeviceViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_device_view, viewGroup, false);
        return new DeviceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        String msg = deviceList.get(i).getName() == null ? deviceList.get(i).getAddress() : deviceList.get(i).getName();
        ((DeviceViewHolder) viewHolder).textView.setText(msg);
        ((DeviceViewHolder) viewHolder).textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (itemOnClickListener != null)
                    itemOnClickListener.onItemClick(v, deviceList.get(i), i);
            }
        });
    }


    @Override
    public int getItemCount() {
        return deviceList == null ? 0 : deviceList.size();
    }

    public void setData(List deviceList) {
        this.deviceList.clear();
        this.deviceList.addAll(deviceList);
        notifyDataSetChanged();
    }

    public void setItemOnClickListener(ItemOnClickListener<BluetoothDevice> listener) {
        this.itemOnClickListener = listener;
    }

    final class DeviceViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public DeviceViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_bluetooth_name);
        }
    }
}
