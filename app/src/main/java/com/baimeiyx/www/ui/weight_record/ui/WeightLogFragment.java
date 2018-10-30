package com.baimeiyx.www.ui.weight_record.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.baimeiyx.www.base.ui.BaseSimpleFragment;
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
public class WeightLogFragment extends BaseSimpleFragment {
    /**
     * 最新的重量
     */
    public static final String LASTEST_WEIGHT = "weight";
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
        if (data != null)
            tvLastWeight.setText(data.getString(LASTEST_WEIGHT, "没有值"));
        _initAxisXLables();
        _initAxisYLables();
        _initAxisPoints();
        _initlineChart();
    }

    private void _initAxisXLables() {
        String[] dateX = {"11-01", "11-02", "11-03", "11-04", "11-05", "11-06", "11-07", "11-08", "11-09", "11-10"};//X轴的标注

        for (int index = 0; index < dateX.length; index++) {
            mAxisXValues.add(new AxisValue(index).setLabel(dateX[index]));
        }
    }

    private void _initAxisYLables() {
        float[] dataY = {0, 20, 40, 60, 80, 100, 120, 140, 160};//X轴的标注

        for (int index = 0; index < dataY.length; index++) {
            mAxisYValues.add(new AxisValue(dataY[index]));
        }
    }

    private void _initAxisPoints() {
        int[] weights = {50, 42, 90, 33, 20, 74, 22, 18, 79, 20};//图表的数据点
        for (int i = 0; i < weights.length; i++) {
            mPointValues.add(new PointValue(i, weights[i]));
        }
    }

    private void _initlineChart() {
        Line line = new Line(mPointValues).setColor(getResources().getColor(R.color.colorBarWeightRecord));//折线的颜色
        List<Line> lines = new ArrayList<Line>();
        line.setShape(ValueShape.CIRCLE);//折线图上每个数据点的形状  这里是圆形 （有三种 ：ValueShape.SQUARE  ValueShape.CIRCLE  ValueShape.SQUARE）
        line.setCubic(false);//曲线是否平
//	 line.setStrokeWidth(3);//线条的粗细，默认是3
        line.setFilled(true);//是否填充曲线的面积
        line.setHasLabels(true);//曲线的数据坐标是否加上备注
        line.setFormatter(new SimpleLineChartValueFormatter(2));//设置显示小数点
//	line.setHasLabelsOnlyForSelected(true);//点击数据坐标提示数据（设置了这个line.setHasLabels(true);就无效）
        line.setHasLines(true);//是否用直线显示。如果为false 则没有曲线只有点显示
        line.setHasPoints(true);//是否显示圆点 如果为false 则没有原点只有点显示
        line.setStrokeWidth(1);
        line.setPointRadius(5);
        lines.add(line);
        LineChartData data = new LineChartData();
        data.setValueLabelBackgroundColor(Color.TRANSPARENT);
        data.setValueLabelBackgroundAuto(true);
        data.setValueLabelBackgroundEnabled(true);
        data.setValueLabelTextSize(16);
        data.setValueLabelsTextColor(Color.WHITE); //此处设置坐标点旁边的文字颜色
        data.setLines(lines);
        //坐标轴
        Axis axisX = new Axis(); //X轴
        axisX.setHasTiltedLabels(false); //X轴下面坐标轴字体是斜的显示还是直的，true是斜的显示
        axisX.setTextColor(Color.GRAY);//灰色
        axisX.setTextSize(13);//设置字体大小
//        axisX.setMaxLabelChars(11); //最多几个X轴坐标，意思就是你的缩放让X轴上数据的个数7<=x<=mAxisValues.length
        axisX.setValues(mAxisXValues);//填充X轴的坐标名称
        // data.setAxisXBottom(axisX); //x 轴在底部
        data.setAxisXTop(axisX);//x 轴在顶部
        axisX.setHasLines(false); //x 轴分割线

        // Y轴是根据数据的大小自动设置Y轴上限(在下面我会给出固定Y轴数据个数的解决方案)
        Axis axisY = new Axis(); //Y轴
        axisY.setTextSize(8);//设置字体大小
        axisY.setHasLines(true);
        axisY.setTextColor(Color.GRAY);
        axisY.setMaxLabelChars(3);//max label length, for example 60
// 这样添加y轴坐标 就可以固定y轴的数据
        axisY.setValues(mAxisYValues);
        data.setAxisYLeft(axisY);//Y轴设置在左边


        //设置行为属性，支持缩放、滑动以及平移
        chart.setInteractive(true);
        chart.setZoomEnabled(true);
        chart.setZoomType(ZoomType.HORIZONTAL);
        chart.setMaxZoom((float) 2);//最大放大比例
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
        v.bottom = -1;
        v.top = 100;
        chart.setMaximumViewport(v);
        //这2个属性的设置一定要在lineChart.setMaximumViewport(v);这个方法之后,不然显示的坐标数据是不能左右滑动查看更多数据的
        v.left = 0;
        v.right = 6;
        chart.setCurrentViewport(v);

    }

    @Override
    protected void setToolbar() {
        tvTitle.setText(getString(R.string.title_weight_log));
        toolbar.setBackgroundColor(getResources().getColor(R.color.colorBarWeightRecord));
    }


}
