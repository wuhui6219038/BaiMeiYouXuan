package com.baimeiyx.www.utils.myUtils;

import android.util.Log;

import com.baimeiyx.www.App;
import com.baimeiyx.www.widget.MyOptionsPickerView;
import com.baimeiyx.www.utils.FileUtils;
import com.bigkoo.pickerview.view.OptionsPickerView;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AreaUtils {

    private static final String TAG = "AreaUtils";

    public static String getAreaName(String key) {
        String value = App.jsonData.get(key).getAsJsonObject().get("name").toString().replace("\"", "");
        return value;
    }

    public static int getAreaIndex(String key) {
        int value = App.jsonData.get(key).getAsJsonObject().get("index").getAsInt();
        Log.e(TAG, "getAreaIndex: " + value);
        return value;
    }

    public static int getAreaId(String item1, String item2, String item3) {
        if (item2 == null && item3 == null) {
            return App.jsonData2.get(item1).getAsJsonObject().get("id").getAsInt();
        } else if (item3 == null) {
            return App.jsonData2.get(item1).getAsJsonObject().get(item2).getAsJsonObject().get("id").getAsInt();
        } else {
            return App.jsonData2.get(item1).getAsJsonObject().get(item2).getAsJsonObject().get(item3).getAsJsonObject().get("id").getAsInt();
        }

    }

    public static MyOptionsPickerView showArea(OptionsPickerView optionsPicker) {
        List<String> options1Items = new ArrayList<>();
        List<List<String>> options2Items = new ArrayList<>();
        List<List<List<String>>> options3Items = new ArrayList<>();

        String key2, key3 = null;

        JsonObject jsonData = App.jsonData2;
        for (Map.Entry<String, JsonElement> jsonElement : jsonData.entrySet()) {
            List<String> optionsItems_2 = new ArrayList<>();
            //省
            options1Items.add(jsonElement.getKey());

            //处理市
            JsonObject jsonObject2 = jsonElement.getValue().getAsJsonObject();
            options2Items.add(optionsItems_2);
            //区
            List<List<String>> optionsItems_3 = new ArrayList<>();
            for (Map.Entry<String, JsonElement> jsonElement2 : jsonObject2.entrySet()) {
                key2 = jsonElement2.getKey();

                if (!(key2.contains("id") || key2.contains("code"))) {
                    List<String> optionsItems_3_1 = new ArrayList<>();
                    optionsItems_2.add(key2);
                    JsonObject jsonObject3 = jsonElement2.getValue().getAsJsonObject();
                    for (Map.Entry<String, JsonElement> jsonElement3 : jsonObject3.entrySet()) {
                        key3 = jsonElement3.getKey();
                        if (!(key3.contains("id") || key3.contains("code"))) {
                            optionsItems_3_1.add(key3);
                        }
                    }
                    optionsItems_3.add(optionsItems_3_1);
                }

            }
            options3Items.add(optionsItems_3);
        }
        MyOptionsPickerView myOptionsPicker = new MyOptionsPickerView();
        myOptionsPicker.setOptionsPickerView(optionsPicker);
        myOptionsPicker.setPicker(options1Items, options2Items, options3Items);
        return myOptionsPicker;
    }

    public static JsonObject parseJson(String path) throws IOException {
        String strJson = null;
        strJson = FileUtils.readFile2String(App.INSTANCE.getAssets().open(path), "UTF-8");
        strJson = strJson.replace("\r\n", "").replace("  ", "").replace("//", "");
        return new JsonParser().parse(strJson).getAsJsonObject();
    }
}
