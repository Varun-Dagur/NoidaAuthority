package com.noida.authority.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.highsoft.highcharts.common.HIColor;
import com.highsoft.highcharts.common.hichartsclasses.HIArea;
import com.highsoft.highcharts.common.hichartsclasses.HIAreaspline;
import com.highsoft.highcharts.common.hichartsclasses.HIChart;
import com.highsoft.highcharts.common.hichartsclasses.HICondition;
import com.highsoft.highcharts.common.hichartsclasses.HICredits;
import com.highsoft.highcharts.common.hichartsclasses.HIExporting;
import com.highsoft.highcharts.common.hichartsclasses.HIHover;
import com.highsoft.highcharts.common.hichartsclasses.HILabel;
import com.highsoft.highcharts.common.hichartsclasses.HILabels;
import com.highsoft.highcharts.common.hichartsclasses.HILegend;
import com.highsoft.highcharts.common.hichartsclasses.HILine;
import com.highsoft.highcharts.common.hichartsclasses.HIMarker;
import com.highsoft.highcharts.common.hichartsclasses.HIOptions;
import com.highsoft.highcharts.common.hichartsclasses.HIPlotBands;
import com.highsoft.highcharts.common.hichartsclasses.HIPlotOptions;
import com.highsoft.highcharts.common.hichartsclasses.HIResponsive;
import com.highsoft.highcharts.common.hichartsclasses.HIRules;
import com.highsoft.highcharts.common.hichartsclasses.HISeries;
import com.highsoft.highcharts.common.hichartsclasses.HISpline;
import com.highsoft.highcharts.common.hichartsclasses.HIStates;
import com.highsoft.highcharts.common.hichartsclasses.HISubtitle;
import com.highsoft.highcharts.common.hichartsclasses.HITitle;
import com.highsoft.highcharts.common.hichartsclasses.HITooltip;
import com.highsoft.highcharts.common.hichartsclasses.HIXAxis;
import com.highsoft.highcharts.common.hichartsclasses.HIYAxis;
import com.highsoft.highcharts.core.HIChartView;
import com.highsoft.highcharts.core.HIFunction;
import com.noida.authority.R;
import com.noida.authority.utils.BaseActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class GraphActivity extends BaseActivity {

    HIChartView chartView, areaChartView, hcMultipleLine, area_MultipleLine, hcbasicLine;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.graph_activity);

        setToolbarTitle("Dashboard");

        chartView = findViewById(R.id.hc);
        hcMultipleLine = findViewById(R.id.hcMultipleLine);
        areaChartView = findViewById(R.id.area_basic);
        area_MultipleLine = findViewById(R.id.area_MultipleLine);
        hcbasicLine = findViewById(R.id.hcbasicLine);


        lineGraph();
        MultiPleLineGraph();
        BasicLineGraph();
        areaBasic();
        MultipleArea();

    }

    private void BasicLineGraph() {

        HIOptions options = new HIOptions();
        HIExporting hiExporting = new HIExporting();
        hiExporting.setEnabled(false);
        options.setExporting(hiExporting);

        HIChart chart = new HIChart();
        chart.setType("spline");
        chart.setInverted(true);
        options.setChart(chart);

        HITitle title = new HITitle();
        title.setText("Dues Amount (total) by dues type - Department Wise");
        options.setTitle(title);

        HISubtitle subtitle = new HISubtitle();
        // subtitle.setText("According to the Standard Atmosphere Model");
        options.setSubtitle(subtitle);

        HIXAxis xAxis = new HIXAxis();
        xAxis.setReversed(true);
        xAxis.setTitle(new HITitle());
        xAxis.getTitle().setText("Altitude");
        xAxis.setLabels(new HILabels());
        xAxis.getLabels().setFormatter(new HIFunction(
                f -> f.getProperty("value") + "",
                new String[]{"value"}));
        xAxis.setMaxPadding(0.05);
        xAxis.setShowLastLabel(true);
        options.setXAxis(new ArrayList<HIXAxis>() {{
            add(xAxis);
        }});

        HIYAxis yAxis = new HIYAxis();
        yAxis.setTitle(new HITitle());
        yAxis.getTitle().setText("Installment and Lease");
        yAxis.setLabels(new HILabels());
        yAxis.getLabels().setFormatter(new HIFunction(
                f -> f.getProperty("value") + "°C",
                new String[]{"value"}));
        yAxis.setLineWidth(2);
        options.setYAxis(new ArrayList<HIYAxis>() {{
            add(yAxis);
        }});

        HILegend legend = new HILegend();
        legend.setEnabled(false);
        options.setLegend(legend);

        HITooltip tooltip = new HITooltip();
        tooltip.setHeaderFormat("<b>{series.name}</b><br/>");
        tooltip.setPointFormat("{point.x}'km': {point.y}°C");
        options.setTooltip(tooltip);

        HIPlotOptions plotOptions = new HIPlotOptions();
        plotOptions.setSpline(new HISpline());
        plotOptions.getSpline().setMarker(new HIMarker());
        plotOptions.getSpline().getMarker().setEnabled(false);
        options.setPlotOptions(plotOptions);

        HISpline series1 = new HISpline();
        series1.setName("Installment and Lease");
        Number[][] series1_data = new Number[][]{{0, 15}, {10, -50}, {20, -56.5}, {30, -46.5}, {40, -22.1}, {50, -2.5}, {60, -27.7}, {70, -55.7}, {80, -76.5}};
        series1.setData(new ArrayList<>(Arrays.asList(series1_data)));
        options.setSeries(new ArrayList<>(Arrays.asList(series1)));

        hcbasicLine.setOptions(options);


    }

    private void MultipleArea() {

        HIOptions options = new HIOptions();
        HIExporting hiExporting = new HIExporting();
        hiExporting.setEnabled(false);
        options.setExporting(hiExporting);

        HITitle title = new HITitle();
        title.setText("Department Wise");
        options.setTitle(title);

        HILegend legend = new HILegend();
        legend.setLayout("vertical");
        legend.setAlign("left");
        legend.setVerticalAlign("top");
        legend.setX(150);
        legend.setY(150);
        legend.setFloating(true);
        legend.setBorderWidth(1);
        legend.setBackgroundColor(HIColor.initWithHexValue("FFFFFF"));
        options.setLegend(legend);

        HIXAxis xaxis = new HIXAxis();
        String[] categories = new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        xaxis.setCategories(new ArrayList<>(Arrays.asList(categories)));
        HIPlotBands plotband = new HIPlotBands();
        //plotband.setFrom(4.5);
        //plotband.setTo(6.5);
        // plotband.setColor(HIColor.initWithRGBA(68, 170, 213, 2));
        xaxis.setPlotBands(new ArrayList<>(Arrays.asList(plotband)));
        options.setXAxis(new ArrayList<HIXAxis>() {{
            add(xaxis);
        }});

        HIYAxis yaxis = new HIYAxis();
        yaxis.setTitle(new HITitle());
        yaxis.getTitle().setText("Fruit unit");
        options.setYAxis(new ArrayList<HIYAxis>() {{
            add(yaxis);
        }});

        HITooltip tooltip = new HITooltip();
        tooltip.setShared(true);
        tooltip.setValueSuffix(" units");
        options.setTooltip(tooltip);

        HICredits credits = new HICredits();
        credits.setEnabled(false);
        options.setCredits(credits);

        HIPlotOptions plotOptions = new HIPlotOptions();
        plotOptions.setAreaspline(new HIAreaspline());
        plotOptions.getAreaspline().setFillOpacity(0.5);
        options.setPlotOptions(plotOptions);

        HIAreaspline areaspline1 = new HIAreaspline();
        areaspline1.setName("Noida");
        Number[] areaspline1Data = new Number[]{0, 1, 2, 3, 4, 3, 5, 4, 10, 12};
        areaspline1.setData(new ArrayList<>(Arrays.asList(areaspline1Data)));

       /* HIAreaspline areaspline2 = new HIAreaspline();
        areaspline2.setName("Jane");
        Number[] areaspline2Data = new Number[] { 1, 3, 4, 3, 3, 5, 4 };
        areaspline2.setData(new ArrayList<>(Arrays.asList(areaspline2Data)));*/

        options.setSeries(new ArrayList<>(Arrays.asList(areaspline1)));

        area_MultipleLine.setOptions(options);

    }

    private void MultiPleLineGraph() {

        HIOptions options = new HIOptions();
        HIExporting hiExporting = new HIExporting();
        hiExporting.setEnabled(false);
        options.setExporting(hiExporting);

        HITitle title = new HITitle();
        title.setText("Defaulter Count by Dues Type - Department Wise");
        options.setTitle(title);

        HISubtitle subtitle = new HISubtitle();
        //subtitle.setText("Source: thesolarfoundation.com");
        options.setSubtitle(subtitle);

        HIYAxis yaxis = new HIYAxis();
        yaxis.setTitle(new HITitle());
        yaxis.getTitle().setText("Number of Employees");
        options.setYAxis(new ArrayList<>(Collections.singletonList(yaxis)));

        HILegend legend = new HILegend();
        legend.setLayout("vertical");
        legend.setAlign("right");
        legend.setVerticalAlign("middle");
        options.setLegend(legend);

        HIPlotOptions plotoptions = new HIPlotOptions();
        plotoptions.setSeries(new HISeries());
        plotoptions.getSeries().setLabel(new HILabel());
        plotoptions.getSeries().getLabel().setConnectorAllowed(false);
        plotoptions.getSeries().setPointStart(2010);
        options.setPlotOptions(plotoptions);

        HILine line1 = new HILine();
        line1.setName("Institutional");
        line1.setData(new ArrayList<>(Arrays.asList(43934, 52503, 57177, 69658, 97031, 119931, 137133, 154175)));


        HILine line2 = new HILine();
        line2.setName("Commercial");
        line2.setData(new ArrayList<>(Arrays.asList(24916, 24064, 29742, 29851, 32490, 30282, 38121, 40434)));

        HILine line3 = new HILine();
        line3.setName("Residential");
        line3.setData(new ArrayList<>(Arrays.asList(11744, 17722, 16005, 19771, 20185, 24377, 32147, 39387)));

        HILine line4 = new HILine();
        line4.setName("Industrial");
        line4.setData(new ArrayList<>(Arrays.asList(null, null, 7988, 12169, 15112, 22452, 34400, 34227)));

        HILine line5 = new HILine();
        line5.setName("Housing");
        line5.setData(new ArrayList<>(Arrays.asList(12908, 5948, 8105, 11248, 8989, 11816, 18274, 18111)));


        HIResponsive responsive = new HIResponsive();

        HIRules rules1 = new HIRules();
        rules1.setCondition(new HICondition());
        rules1.getCondition().setMaxWidth(500);
        HashMap<String, HashMap> chartLegend = new HashMap<>();
        HashMap<String, String> legendOptions = new HashMap<>();
        legendOptions.put("layout", "horizontal");
        legendOptions.put("align", "center");
        legendOptions.put("verticalAlign", "bottom");
        chartLegend.put("legend", legendOptions);
        rules1.setChartOptions(chartLegend);
        responsive.setRules(new ArrayList<>(Collections.singletonList(rules1)));
        options.setResponsive(responsive);

      /*    options.setSeries(new ArrayList<>(Arrays.asList(line1)));
      options.setSeries(new ArrayList<>(Arrays.asList(line2)));
        options.setSeries(new ArrayList<>(Arrays.asList(line3)));*/
        options.setSeries(new ArrayList<>(Arrays.asList(line1, line2, line3, line4, line5)));

        hcMultipleLine.setOptions(options);

    }

    private void lineGraph() {

        HIOptions options = new HIOptions();
        HIExporting hiExporting = new HIExporting();
        hiExporting.setEnabled(false);
        options.setExporting(hiExporting);
        //  options.setExporting(new HIExporting().setEnabled(false));

        HITitle title = new HITitle();
        title.setText("Dues Amount (total) by dues type - Department Wise");
        options.setTitle(title);

        HISubtitle subtitle = new HISubtitle();
        // subtitle.setText("Source: thesolarfoundation.com");
        options.setSubtitle(subtitle);

        HIYAxis yaxis = new HIYAxis();
        yaxis.setTitle(new HITitle());
        yaxis.getTitle().setText("Number of Employees");
        options.setYAxis(new ArrayList<>(Collections.singletonList(yaxis)));

        HILegend legend = new HILegend();
        legend.setLayout("vertical");
        legend.setAlign("right");
        legend.setVerticalAlign("middle");
        options.setLegend(legend);

        HIPlotOptions plotoptions = new HIPlotOptions();
        plotoptions.setSeries(new HISeries());
        plotoptions.getSeries().setLabel(new HILabel());
        plotoptions.getSeries().getLabel().setConnectorAllowed(false);
        plotoptions.getSeries().setPointStart(2010);
        options.setPlotOptions(plotoptions);

        HILine line1 = new HILine();
        line1.setName("Institutional");
        line1.setData(new ArrayList<>(Arrays.asList(43934, 52503, 57177, 69658, 97031, 119931, 137133, 154175)));


        HILine line2 = new HILine();
        line2.setName("Commercial");
        line2.setData(new ArrayList<>(Arrays.asList(24916, 24064, 29742, 29851, 32490, 30282, 38121, 40434)));

        HILine line3 = new HILine();
        line3.setName("Residential");
        line3.setData(new ArrayList<>(Arrays.asList(11744, 17722, 16005, 19771, 20185, 24377, 32147, 39387)));

        HILine line4 = new HILine();
        line4.setName("Industrial");
        line4.setData(new ArrayList<>(Arrays.asList(null, null, 7988, 12169, 15112, 22452, 34400, 34227)));

        HILine line5 = new HILine();
        line5.setName("Housing");
        line5.setData(new ArrayList<>(Arrays.asList(12908, 5948, 8105, 11248, 8989, 11816, 18274, 18111)));


        HIResponsive responsive = new HIResponsive();

        HIRules rules1 = new HIRules();
        rules1.setCondition(new HICondition());
        rules1.getCondition().setMaxWidth(500);
        HashMap<String, HashMap> chartLegend = new HashMap<>();
        HashMap<String, String> legendOptions = new HashMap<>();
        legendOptions.put("layout", "horizontal");
        legendOptions.put("align", "center");
        legendOptions.put("verticalAlign", "bottom");
        chartLegend.put("legend", legendOptions);
        rules1.setChartOptions(chartLegend);
        responsive.setRules(new ArrayList<>(Collections.singletonList(rules1)));
        options.setResponsive(responsive);

        options.setSeries(new ArrayList<>(Arrays.asList(line1)));
       /* options.setSeries(new ArrayList<>(Arrays.asList(line2)));
        options.setSeries(new ArrayList<>(Arrays.asList(line3)));*/
//        options.setSeries(new ArrayList<>(Arrays.asList(line1, line2, line3, line4, line5)));

        chartView.setOptions(options);
    }

    void areaBasic() {
        HIOptions options = new HIOptions();
        HIExporting hiExporting = new HIExporting();
        hiExporting.setEnabled(false);
        options.setExporting(hiExporting);

        HIChart chart = new HIChart();
        chart.setType("area");
        options.setChart(chart);

        HITitle title = new HITitle();
        title.setText("Department Wise");
        options.setTitle(title);

        HISubtitle subtitle = new HISubtitle();
        //  subtitle.setText("Source: <a href=\"http://thebulletin.metapress.com/content/c4120650912x74k7/fulltext.pdf\">thebulletin.metapress.com</a>");
        options.setSubtitle(subtitle);

        HIXAxis xAxis = new HIXAxis();
        xAxis.setAllowDecimals(false);
        xAxis.setLabels(new HILabels());
        xAxis.getLabels().setFormatter(new HIFunction(
                f -> {
                    return String.valueOf(f.getProperty("value"));
                },
                new String[]{"value"})); /*clean, unformatted number for year*/
        options.setXAxis(new ArrayList<HIXAxis>() {{
            add(xAxis);
        }});

        HIYAxis yAxis = new HIYAxis();
        yAxis.setTitle(new HITitle());
        yAxis.getTitle().setText("Noida states");
        yAxis.setLabels(new HILabels());
        yAxis.getLabels().setFormatter(new HIFunction(
                f -> {
                    return String.valueOf((Double) f.getProperty("value") / 1000);
                }, new String[]{"value"}));
        options.setYAxis(new ArrayList<HIYAxis>() {{
            add(yAxis);
        }});

        HITooltip tooltip = new HITooltip();
        tooltip.setPointFormat("{series.name} produced <b>{point.y:,.0f}</b><br/>warheads in {point.x}");
        options.setTooltip(tooltip);

        HIPlotOptions plotOptions = new HIPlotOptions();
        plotOptions.setArea(new HIArea());
        plotOptions.getArea().setPointStart(1940);
        plotOptions.getArea().setMarker(new HIMarker());
        plotOptions.getArea().getMarker().setEnabled(false);
        plotOptions.getArea().getMarker().setSymbol("circle");
        plotOptions.getArea().getMarker().setRadius(2);
        plotOptions.getArea().getMarker().setStates(new HIStates());
        plotOptions.getArea().getMarker().getStates().setHover(new HIHover());
        plotOptions.getArea().getMarker().getStates().getHover().setEnabled(true);
        options.setPlotOptions(plotOptions);

        HIArea series1 = new HIArea();
        series1.setName("Noida");
        Number[] series1_data = new Number[]{null, null, null, null, null, 6, 11, 32, 110, 235, 369, 640, 1005, 1436, 2063, 3057, 4618, 6444, 9822, 15468, 20434, 24126, 27387, 29459, 31056, 31982, 32040, 31233, 29224, 27342, 26662, 26956, 27912, 28999, 28965, 27826, 25579, 25722, 24826, 24605, 24304, 23464, 23708, 24099, 24357, 24237, 24401, 24344, 23586, 22380, 21004, 17287, 14747, 13076, 12555, 12144, 11009, 10950, 10871, 10824, 10577, 10527, 10475, 10421, 10358, 10295, 10104};
        series1.setData(new ArrayList<>(Arrays.asList(series1_data)));
        HIArea series2 = new HIArea();
        series2.setName("Noida/India");
        Number[] series2_data = new Number[]{null, null, null, null, null, null, null, null, null, null, 5, 25, 50, 120, 150, 200, 426, 660, 869, 1060, 1605, 2471, 3322, 4238, 5221, 6129, 7089, 8339, 9399, 10538, 11643, 13092, 14478, 15915, 17385, 19055, 21205, 23044, 25393, 27935, 30062, 32049, 33952, 35804, 37431, 39197, 45000, 43000, 41000, 39000, 37000, 35000, 33000, 31000, 29000, 27000, 25000, 24000, 23000, 22000, 21000, 20000, 19000, 18000, 18000, 17000, 16000};
        series2.setData(new ArrayList<>(Arrays.asList(series2_data)));
        options.setSeries(new ArrayList<>(Arrays.asList(series1, series2)));

        areaChartView.setOptions(options);

    }
}