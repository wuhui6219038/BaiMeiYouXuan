package com.baimeiyx.www.widget;

import com.bigkoo.pickerview.view.OptionsPickerView;

import java.util.List;

public class MyOptionsPickerView<T> {
    private List<T> options1Items;
    private List<List<T>> options2Items;
    private List<List<List<T>>> options3Items;
    private OptionsPickerView optionsPickerView;

    public void setOptionsPickerView(OptionsPickerView optionsPickerView) {
        this.optionsPickerView = optionsPickerView;
    }

    public void setPicker(List<T> options1Items,
                          List<List<T>> options2Items,
                          List<List<List<T>>> options3Items) {
        optionsPickerView.setPicker(options1Items, options2Items, options3Items);
        this.options1Items = options1Items;
        this.options2Items = options2Items;
        this.options3Items = options3Items;
    }

    public List<T> getOptions1Items() {
        return options1Items;
    }

    public void setOptions1Items(List<T> options1Items) {
        this.options1Items = options1Items;
    }

    public List<List<T>> getOptions2Items() {
        return options2Items;
    }

    public void setOptions2Items(List<List<T>> options2Items) {
        this.options2Items = options2Items;
    }

    public List<List<List<T>>> getOptions3Items() {
        return options3Items;
    }

    public void setOptions3Items(List<List<List<T>>> options3Items) {
        this.options3Items = options3Items;
    }

    public OptionsPickerView getOptionsPickerView() {
        return optionsPickerView;
    }
}
