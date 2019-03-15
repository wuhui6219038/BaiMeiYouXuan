package com.baimeiyx.www.view.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.baimeiyx.www.base.ui.BaseUserFragment;
import com.baimeiyx.www.constant.Constant;
import com.baimeiyx.www.service.model.CustomWeightLogResult;
import com.baimeiyx.www.service.repository.DataManager;
import com.baimeiyx.www.service.rxjava.DialogSubscribe;
import com.baimeiyx.www.service.rxjava.RetryExceptionObservable;
import com.baimeiyx.www.service.rxjava.RxJavaUtils;
import com.baimeiyx.www.utils.TimeUtils;
import com.baimeiyx.www.utils.myUtils.NumFormatterUtils;
import com.example.mrw.baimeiyouxuan.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import lecho.lib.hellocharts.formatter.SimpleLineChartValueFormatter;
import lecho.lib.hellocharts.gesture.ContainerScrollType;
import lecho.lib.hellocharts.gesture.ZoomType;
import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.model.ValueShape;
import lecho.lib.hellocharts.model.Viewport;
import lecho.lib.hellocharts.view.LineChartView;

/**
 * 体重日志
 */
public class WeightLogFragment extends BaseUserFragment<CustomWeightLogResult> {
    private static final String TAG = "WeightLogFragment";
    @BindView(R.id.tv_last_weight)
    TextView tvLastWeight;
    @BindView(R.id.chart)
    LineChartView chart;
    private Bundle data;
    private List<PointValue> mPointValues = new ArrayList<PointValue>();
    private List<AxisValue> mAxisXValues = new ArrayList<AxisValue>();
    private List<AxisValue> mAxisYValues = new ArrayList<AxisValue>();

    public static WeightLogFragment newInstance(Bundle args) {

        WeightLogFragment fragment = new WeightLogFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public static WeightLogFragment newInstance() {
        WeightLogFragment fragment = new WeightLogFragment();
        return fragment;
    }

    @Override
    protected int getViewId() {
        return R.layout.fragment_weightlog;
    }

    @Override
    protected void _init(Bundle savedInstanceState) {
        _initData();
    }


    private void _initData() {
        data = getArguments();


    }

    private void _initAxisXLables(List<CustomWeightLogResult.DataBean.ListBean> datas) {

        for (int index = 0; index < datas.size() + 2; index++) {
            CustomWeightLogResult.DataBean.ListBean dateX;
            if (index == 0) {
                dateX = datas.get(0);
                tvLastWeight.setText(NumFormatterUtils.getFormatNum(dateX.getCustomerW()));
            } else if (index == datas.size() + 1) {
                dateX = datas.get(datas.size() - 1);
            } else {
                dateX = datas.get(index - 1);
            }
            mAxisXValues.add(new AxisValue(index).setLabel(TimeUtils.millis2String(dateX.getCreateTime(), TimeUtils.DEFAULT_PATTERN6)));
            mPointValues.add(new PointValue(index, (float) dateX.getCustomerW()));

        }
        _initlineChart();
    }


    private void _initlineChart() {
        Line line = new Line(mPointValues).setColor(getResources().getColor(R.color.colorBarWeightRecord));//折线的颜色
        List<Line> lines = new ArrayList<Line>();
        line.setShape(ValueShape.CIRCLE);//折线图上每个数据点的形状  这里是圆形 （有三种 ：ValueShape.SQUARE  ValueShape.CIRCLE  ValueShape.SQUARE）
        line.setCubic(false);//曲线是否平
//	 line.setStrokeWidth(3);//线条的粗细，默认是3
        line.setFilled(true);//是否填充曲线的面积
        line.setHasLabels(true);//曲线的数据坐标是否加上备注
        line.setFormatter(new SimpleLineChartValueFormatter(1));//设置显示小数点
//        line.setHasLabelsOnlyForSelected(true);//点击数据坐标提示数据（设置了这个line.setHasLabels(true);就无效）
        line.setHasLines(true);//是否用直线显示。如果为false 则没有曲线只有点显示
        line.setHasPoints(true);//是否显示圆点 如果为false 则没有原点只有点显示
        line.setStrokeWidth(1);
        line.setPointRadius(6);
        lines.add(line);

        LineChartData data = new LineChartData();
        data.setValueLabelBackgroundColor(Color.TRANSPARENT);
        data.setValueLabelBackgroundAuto(true);
        data.setValueLabelBackgroundEnabled(true);
        data.setValueLabelTextSize(10);
        data.setValueLabelsTextColor(Color.WHITE); //此处设置坐标点旁边的文字颜色
        data.setLines(lines);
        //坐标轴
        Axis axisX = new Axis(); //X轴
        axisX.setHasTiltedLabels(false); //X轴下面坐标轴字体是斜的显示还是直的，true是斜的显示
        axisX.setTextColor(Color.GRAY);//灰色
        axisX.setTextSize(10);//设置字体大小
//        axisX.setMaxLabelChars(11); //最多几个X轴坐标，意思就是你的缩放让X轴上数据的个数7<=x<=mAxisValues.length
        axisX.setValues(mAxisXValues);//填充X轴的坐标名称
        // data.setAxisXBottom(axisX); //x 轴在底部
        data.setAxisXTop(axisX);//x 轴在顶部
        axisX.setHasLines(false); //x 轴分割线

        // Y轴是根据数据的大小自动设置Y轴上限(在下面我会给出固定Y轴数据个数的解决方案)
        Axis axisY = new Axis(); //Y轴
        axisY.setTextSize(8);//设置字体大小
        axisY.setHasLines(false);
        axisY.setTextColor(Color.GRAY);
        axisY.setMaxLabelChars(3);//max label length, for example 60
// 这样添加y轴坐标 就可以固定y轴的数据
//        axisY.setValues(mAxisYValues);
        data.setAxisYLeft(axisY);//Y轴设置在左边

        //设置行为属性，支持缩放、滑动以及平移
        chart.setInteractive(true);
        chart.setZoomEnabled(true);
        chart.setZoomType(ZoomType.HORIZONTAL);
        chart.setMaxZoom((float) 1.3);//最大放大比例
        chart.setContainerScrollEnabled(true, ContainerScrollType.HORIZONTAL);
        chart.setLineChartData(data);
        chart.setVisibility(View.VISIBLE);
        /**注：下面的7，10只是代表一个数字去类比而已
          * 当时是为了解决X轴固定数据个数。见（http://forum.xda-developers.com/tools/programming/library-hellocharts-charting-library-t2904456/page2）;
          */
//        Viewport v = new Viewport(chart.getMaximumViewport());
//        v.left = 0;
//        v.right = 7;
//        v.bottom = 0;
//        chart.setCurrentViewport(v);

        Viewport v = new Viewport(chart.getMaximumViewport());
//        v.bottom = minY;
//        v.top = maxY;
//        //固定Y轴的范围,如果没有这个,Y轴的范围会根据数据的最大值和最小值决定,这不是我想要的
//        lineChart.setMaximumViewport(v);
        v.bottom = -5;
        v.top = 200;
        chart.setMaximumViewport(v);
        //这2个属性的设置一定要在lineChart.setMaximumViewport(v);这个方法之后,不然显示的坐标数据是不能左右滑动查看更多数据的
        v.left = 0;
        v.right = 7;
        chart.setCurrentViewport(v);

    }

    @Override
    public void onStart() {
        super.onStart();
        DataManager.getBaiMeiApiService().getCustomerWList(spUtils.getString(Constant.SP_SESSION_ID), "1", "60")
                .retryWhen(new RetryExceptionObservable())
                .compose(RxJavaUtils.rxSchedulerHelper())
                .subscribe(new DialogSubscribe<CustomWeightLogResult>(mActivity) {
                    @Override
                    public void dataSuccess(CustomWeightLogResult data) {
                        onDataSuccessChanged(data);
                    }
                });
//        mDataViewModel.getCustomerWList().observe(this, this);
    }

    @Override
    protected void setToolbar() {
        tvTitle.setText(getString(R.string.title_weight_log));
        toolbar.setBackgroundColor(getResources().getColor(R.color.colorBarWeightRecord));
    }


    @Override
    protected void onDataSuccessChanged(CustomWeightLogResult baseResult) {
        _initAxisXLables(baseResult.getData().getList());
    }
}
