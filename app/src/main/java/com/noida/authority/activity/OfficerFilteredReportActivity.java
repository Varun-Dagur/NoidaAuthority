package com.noida.authority.activity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.chart.common.listener.Event;
import com.anychart.chart.common.listener.ListenersInterface;
import com.anychart.charts.Cartesian;
import com.anychart.core.cartesian.series.Bar;
import com.anychart.core.cartesian.series.JumpLine;
import com.anychart.data.Mapping;
import com.anychart.data.Set;
import com.anychart.enums.Anchor;
import com.anychart.enums.HoverMode;
import com.anychart.enums.ScaleStackMode;
import com.anychart.enums.TooltipDisplayMode;
import com.anychart.enums.TooltipPositionMode;
import com.anychart.ui.Preloader;
import com.jaredrummler.materialspinner.MaterialSpinner;
import com.noida.authority.R;
import com.noida.authority.adapter.ReportsAdapter;
import com.noida.authority.adapter.ServiceTimeLineAdapter;
import com.noida.authority.response_model.ServiceReportResponse;
import com.noida.authority.response_model.ServiceTimeLineModel;
import com.noida.authority.retrofit.ApiManager;
import com.noida.authority.retrofit.ApiResponseInterface;
import com.noida.authority.utils.Constants;
import com.noida.authority.utils.dataExportClass;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class OfficerFilteredReportActivity extends AppCompatActivity implements ApiResponseInterface {


    TextView title;
    ImageView back_arrow;
    RelativeLayout reportLayout;
    LinearLayout initialsLayout;
    TextView startDate, endDate;
    String selectedposition, requestthrough, selectedStartDate, selectedEndDate;
    ApiManager apiManager;
    DatePickerDialog picker;
    int flag = 0;
    RecyclerView reportGrid;
    ReportsAdapter reportsAdapter;
    RelativeLayout reportViewLayout;
    private static final int PERMISSION_REQUEST_CODE = 100;
    List<ServiceReportResponse> serviceReportResponseList;
    TextView txtProperty, txtAccount;
    int dashboardType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line_chart_report);
        title = findViewById(R.id.title);
        back_arrow = findViewById(R.id.back_arrow);
        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        dashboardType = 0;

        txtProperty = findViewById(R.id.txtProperty);
        txtProperty.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                txtProperty.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorAccent)));
                txtProperty.setTextColor(getResources().getColor(R.color.colorBlack));

                txtAccount.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorBlackLight)));
                txtAccount.setTextColor(getResources().getColor(R.color.colorWhite));
                dashboardType = 0;
            }
        });


        txtAccount = findViewById(R.id.txtAccount);
        txtAccount.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                txtAccount.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorAccent)));
                txtAccount.setTextColor(getResources().getColor(R.color.colorBlack));

                txtProperty.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorBlackLight)));
                txtProperty.setTextColor(getResources().getColor(R.color.colorWhite));
                dashboardType = 1;
            }
        });



        title.setText("TIMELINE OF SERVICES (ONLINE)");
        apiManager = new ApiManager(this, this);


        startDate = findViewById(R.id.startdate);
        endDate = findViewById(R.id.enddate);
        selectedposition = "1";
        requestthrough = "Online";
        reportViewLayout = findViewById(R.id.reportViewLayout);


        reportGrid = findViewById(R.id.ReportGrid);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this) {
            @Override
            public boolean canScrollVertically() {
                return true;
            }
        };

        reportGrid.setLayoutManager(linearLayoutManager);

        MaterialSpinner requestSpinner = (MaterialSpinner) findViewById(R.id.requestspinner);
        requestSpinner.setItems("Online", "JSK", "Nivesh Mitra");
        requestSpinner.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {

            @Override public void onItemSelected(MaterialSpinner view, int position, long id, String item) {

                flag = 1;
                switch(item)
                {
                    case "Online":
                        requestthrough = "Online";
                        break;
                    case "JSK":
                        requestthrough = "JSK";
                        break;
                    case "Nivesh Mitra":
                        requestthrough = "Nivesh Mitra";
                        break;
                    default:
                        requestthrough = "0";

                }
            }
        });




        MaterialSpinner spinner = (MaterialSpinner) findViewById(R.id.departmentspinner);
        spinner.setItems("Institutional", "Commercial", "Residential", "Industrial", "Housing", "Group Housing", "5% Abadi", "All Dept.");
        spinner.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {

            @Override public void onItemSelected(MaterialSpinner view, int position, long id, String item) {

                flag = 1;
                switch(item)
                {
                    case "Institutional":
                        selectedposition = "1";
                        break;
                    case "Commercial":
                        selectedposition = "2";
                        break;
                    case "Residential":
                        selectedposition = "3";
                        break;
                    case "Industrial":
                        selectedposition = "4";
                        break;
                    case "Housing":
                        selectedposition = "5";
                        break;
                    case "Group Housing":
                        selectedposition = "6";
                        break;
                    case "5% Abadi":
                        selectedposition = "7";
                        break;
                    default:
                        selectedposition = "51";

                }
            }
        });



        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, 0);
        calendar.set(Calendar.DATE, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        Date monthFirstDay = calendar.getTime();

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String startDateStr = df.format(monthFirstDay);

        Date c = Calendar.getInstance().getTime();

        String currentDate = df.format(c);


        selectedStartDate = startDateStr;
        selectedEndDate = currentDate;



        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String startdateInSimpleformat = sdf.format(monthFirstDay);
        String enddateInSimpleformat = sdf.format(c);


        startDate.setText(startdateInSimpleformat);
        endDate.setText(enddateInSimpleformat);

        reportLayout = findViewById(R.id.reportLayout);
        initialsLayout = findViewById(R.id.initialLayout);
    }

    public void CallStartDate(View view)
    {
        final Calendar cldr = Calendar.getInstance();
        int day = cldr.get(Calendar.DAY_OF_MONTH);
        int month = cldr.get(Calendar.MONTH);
        int year = cldr.get(Calendar.YEAR);
        // date picker dialog in to CallStartDate
        picker = new DatePickerDialog(OfficerFilteredReportActivity.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        startDate.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                        selectedStartDate = String.valueOf(year) + "-" + String.valueOf((monthOfYear + 1)) + "-" +String.valueOf(dayOfMonth);
                    }
                }, year, month, day);
        picker.show();

    }



    public void CallEndDate(View view)
    {
        final Calendar cldr = Calendar.getInstance();
        int day = cldr.get(Calendar.DAY_OF_MONTH);
        int month = cldr.get(Calendar.MONTH);
        int year = cldr.get(Calendar.YEAR);
        // date picker dialog
        picker = new DatePickerDialog(OfficerFilteredReportActivity.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        endDate.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                        selectedEndDate = String.valueOf(year) + "-" + String.valueOf((monthOfYear + 1)) + "-" +String.valueOf(dayOfMonth);
                    }
                }, year, month, day);
        picker.show();


    }


    public void fetchValues(View View)
    {
        try{
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date selectedDateStart = formatter.parse(selectedStartDate);
            Date selectedDateEnd = formatter.parse(selectedEndDate);

            if (selectedDateStart.compareTo(selectedDateEnd)<0)
            {
                if(dashboardType == 0) {
                    apiManager.getServiceReportByDept(selectedposition, selectedStartDate, selectedEndDate, requestthrough);
                    apiManager.getServiceTimeLine(selectedposition, selectedStartDate, selectedEndDate, "1", requestthrough, "DepartmentWise", "0");
                }
                else if(dashboardType == 1){
//                    Toast.makeText(this, String.valueOf(dashboardType), Toast.LENGTH_SHORT).show();
//                    apiManager.getAccountServiceByAccount(selectedposition, selectedStartDate, selectedEndDate, requestthrough);
//                    apiManager.getAccountServiceTimeLine(selectedposition, selectedStartDate, selectedEndDate, "1", requestthrough, "DepartmentWise", "0");

                }
            }
            else
            {
                Toast.makeText(this, "End Date can't be less than Start Date ", Toast.LENGTH_SHORT).show();
            }

        }catch (ParseException e1){
            e1.printStackTrace();
        }


    }

    @Override
    public void isError(String errorCode) {

    }

    @Override
    public void isSuccess(Object response, int ServiceCode) {

        if(ServiceCode == Constants.GRAPH_REQUEST) {
            serviceReportResponseList = (List<ServiceReportResponse>) response;

            ServiceReportResponse serviceReportResponse = new ServiceReportResponse();
            if (serviceReportResponseList.size() == 0) {
                Toast.makeText(this, "No data found in given details.", Toast.LENGTH_SHORT).show();
                reportLayout.setVisibility(View.GONE);
                return;
            }

            if (serviceReportResponseList.size() == 1) {


                reportLayout.setVisibility(View.VISIBLE);
                initialsLayout.setVisibility(View.VISIBLE);
                serviceReportResponse = serviceReportResponseList.get(0);
                reportLayout.removeAllViews();

                AnyChartView anyChartView = new AnyChartView(this);
                anyChartView.setLayoutParams(new WindowManager.LayoutParams(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT));
                reportLayout.addView(anyChartView);

                RelativeLayout view = new RelativeLayout(this);
                RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams((new LinearLayout.LayoutParams(
                        230,
                        30)));
                params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
                params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
                view.setLayoutParams(params);
                view.setBackgroundColor(Color.WHITE);

                reportLayout.addView(view);

                Cartesian vertical = AnyChart.vertical();
                vertical.animation(true).title("");
                vertical.credits().text("Noida Authority");
                vertical.credits().enabled(true);
                vertical.yGrid(true);
                vertical.xGrid(true);

                List<DataEntry> data = new ArrayList<>();

//            data.add(new CustomDataEntry("Total Received", serviceReportResponse.getTotalReceived(), serviceReportResponse.getDepartment()));
//            data.add(new CustomDataEntry("WithDrawn", serviceReportResponse.getWithDrawn(), serviceReportResponse.getDepartment()));
//            data.add(new CustomDataEntry("CompletedWithinTime", serviceReportResponse.getCompletedWithinTime(), serviceReportResponse.getDepartment()));
//            data.add(new CustomDataEntry("CompletedBeyondTime", serviceReportResponse.getCompletedBeyondTime(), serviceReportResponse.getDepartment()));
//            data.add(new CustomDataEntry("PendingWithTime", serviceReportResponse.getPendingWithTime(), serviceReportResponse.getDepartment()));
//            data.add(new CustomDataEntry("PendingMoreThanWeek", serviceReportResponse.getPendingMoreThanWeek(), serviceReportResponse.getDepartment()));
//            data.add(new CustomDataEntry("PendingMoreThanFortNight", serviceReportResponse.getPendingMoreThanFortNight(), serviceReportResponse.getDepartment()));
//            data.add(new CustomDataEntry("PendingMoreThanOneMonth", serviceReportResponse.getPendingMoreThanOneMonth(), serviceReportResponse.getDepartment()));
//            data.add(new CustomDataEntry("TotalReject", serviceReportResponse.getTotalReject(), serviceReportResponse.getDepartment()));
//            data.add(new CustomDataEntry("TotalObjection", serviceReportResponse.getTotalObjection(), serviceReportResponse.getDepartment()));
//            data.add(new CustomDataEntry("Total", serviceReportResponse.getTotal(), serviceReportResponse.getDepartment()));
//            data.add(new CustomDataEntry("AverageProcessingTime", serviceReportResponse.getAverageProcessingTime(), serviceReportResponse.getDepartment()));
//            data.add(new CustomDataEntry("AverageDelaytime", serviceReportResponse.getAverageDelaytime(), serviceReportResponse.getDepartment()));

                data.add(new CustomDataEntry("T1", serviceReportResponse.getTotalReceived(), serviceReportResponse.getDepartment()));
                data.add(new CustomDataEntry("T2", serviceReportResponse.getWithDrawn(), serviceReportResponse.getDepartment()));
                data.add(new CustomDataEntry("T3", serviceReportResponse.getCompletedWithinTime(), serviceReportResponse.getDepartment()));
                data.add(new CustomDataEntry("T4", serviceReportResponse.getCompletedBeyondTime(), serviceReportResponse.getDepartment()));
                data.add(new CustomDataEntry("T5", serviceReportResponse.getPendingWithTime(), serviceReportResponse.getDepartment()));
                data.add(new CustomDataEntry("T6", serviceReportResponse.getPendingMoreThanWeek(), serviceReportResponse.getDepartment()));
                data.add(new CustomDataEntry("T7", serviceReportResponse.getPendingMoreThanFortNight(), serviceReportResponse.getDepartment()));
                data.add(new CustomDataEntry("T8", serviceReportResponse.getPendingMoreThanOneMonth(), serviceReportResponse.getDepartment()));
                data.add(new CustomDataEntry("T9", serviceReportResponse.getTotalReject(), serviceReportResponse.getDepartment()));
                data.add(new CustomDataEntry("T10", serviceReportResponse.getTotalObjection(), serviceReportResponse.getDepartment()));
                data.add(new CustomDataEntry("T11", serviceReportResponse.getTotal(), serviceReportResponse.getDepartment()));
                data.add(new CustomDataEntry("T12", serviceReportResponse.getAverageProcessingTime(), serviceReportResponse.getDepartment()));
                data.add(new CustomDataEntry("T13", serviceReportResponse.getAverageDelaytime(), serviceReportResponse.getDepartment()));


                Set set = Set.instantiate();
                set.data(data);
                Mapping barData = set.mapAs("{ x: 'x', value: 'value' }");
                Mapping jumpLineData = set.mapAs("{ x: 'x', value: 'jumpLine' }");

                Bar bar = vertical.bar(barData);
                bar.labels().format("${%Value} mln");
                bar.labels().enabled(false);


                switch (serviceReportResponse.getDepartment()) {
                    case "Institutional":
                        bar.color("#FFC0CB");
                        bar.name("Institutional");
                        break;
                    case "Commercial":
                        bar.color("#FFA07A");
                        bar.name("Commercial");
                        break;
                    case "Residential":
                        bar.color("#00FFFF");
                        bar.name("Residential");
                        break;
                    case "Industrial":
                        bar.color("#00BFFF");
                        bar.name("Industrial");
                        break;
                    case "Housing":
                        bar.color("#2F4F4F");
                        bar.name("Housing");
                        break;
                    case "Group Housing":
                        bar.color("#2F4F4F");
                        bar.name("Group Housing");
                        break;
                    default:
                        bar.color("#4169E1");
                        bar.name("5% Abadi");

                }


                JumpLine jumpLine = vertical.jumpLine(jumpLineData);
                jumpLine.stroke("0 #60727B");
                jumpLine.labels().enabled(false);
                jumpLine.name(" ");
                vertical.labels(true);
                vertical.tooltip()
                        .useHtml(true)
                        .displayMode(TooltipDisplayMode.UNION)
                        .positionMode(TooltipPositionMode.FLOAT)
                        .anchor(Anchor.LEFT_CENTER)
                        .unionFormat(
                                "function() {\n" +
                                        "      return  this.getData('jumpLine')+' : '+ this.points[0].value \n" +
                                        "    }");

                //vertical.interactivity().hoverMode(HoverMode.BY_X);
                vertical.interactivity().hoverMode(HoverMode.SINGLE);
                vertical.xAxis(true);
                vertical.yAxis(true);
                vertical.yAxis(0).labels().format("{%Value} ");
//            vertical.yScale().minimum(10d);

                vertical.legend().enabled(true);
                vertical.legend().inverted(false);
                vertical.legend().fontSize(13d);
                vertical.legend().padding(0d, 0d, 20d, 0d);
                vertical.credits().enabled(false);
                vertical.credits().text("Noida Authority");


                anyChartView.setChart(vertical);
                anyChartView.invalidate();

//                reportViewLayout.setVisibility(View.VISIBLE);
//                reportsAdapter = new ReportsAdapter(this, serviceReportResponseList, 0);
//                reportGrid.setAdapter(reportsAdapter);


            } else {
                if (serviceReportResponseList.size() < 6) {
                    Toast.makeText(this, "No data found in given details.", Toast.LENGTH_SHORT).show();
                    reportLayout.setVisibility(View.GONE);
                    return;
                }


                reportLayout.setVisibility(View.VISIBLE);
                initialsLayout.setVisibility(View.VISIBLE);
                reportLayout.removeAllViews();
                AnyChartView anyChartView = new AnyChartView(this);
                anyChartView.setLayoutParams(new WindowManager.LayoutParams(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT));
                reportLayout.addView(anyChartView);

//            ProgressBar progressBar = new ProgressBar(OfficerFilteredReportActivity.this,null,android.R.attr.progressBarStyleSmall);
//            progressBar.setIndeterminate(true);
//            progressBar.setVisibility(View.VISIBLE);
//            RelativeLayout.LayoutParams params1 = new RelativeLayout.LayoutParams(100,100);
//            params1.addRule(RelativeLayout.CENTER_IN_PARENT);
//            anyChartView.addView(progressBar,params1);

                RelativeLayout view = new RelativeLayout(this);
                RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams((new LinearLayout.LayoutParams(230, 30)));
                params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
                params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
                view.setLayoutParams(params);
                view.setBackgroundColor(Color.WHITE);
                reportLayout.addView(view);


                Cartesian cartesian = AnyChart.vertical();
                cartesian.animation(true);
                cartesian.yScale().stackMode(ScaleStackMode.VALUE);
                //cartesian.yScale().stackMode(ScaleStackMode.PERCENT);
                cartesian.credits().text("Noida Authority");
                cartesian.credits().enabled(true);
                cartesian.yGrid(true);
                cartesian.xGrid(true);

//            cartesian.yScale().minimumGap(10);
//            cartesian.yScale().minimum(50d);
//                    .minimum(4d)


                cartesian.xAxis(true);
                cartesian.yAxis(true);

                List<DataEntry> data = new ArrayList<>();
//            data.add(new MultiCustomDataEntry("Total Received", serviceReportResponseList.get(0).getTotalReceived(), serviceReportResponseList.get(1).getTotalReceived(), serviceReportResponseList.get(2).getTotalReceived(), serviceReportResponseList.get(3).getTotalReceived(), serviceReportResponseList.get(4).getTotalReceived(),serviceReportResponseList.get(0).getTotalReceived()));
//            data.add(new MultiCustomDataEntry("WithDrawn", serviceReportResponseList.get(0).getWithDrawn(), serviceReportResponseList.get(1).getWithDrawn(), serviceReportResponseList.get(2).getWithDrawn(), serviceReportResponseList.get(3).getWithDrawn(),serviceReportResponseList.get(4).getWithDrawn(),serviceReportResponseList.get(5).getWithDrawn()));
//            data.add(new MultiCustomDataEntry("CompletedWithinTime", serviceReportResponseList.get(0).getCompletedWithinTime(), serviceReportResponseList.get(1).getCompletedWithinTime(), serviceReportResponseList.get(2).getCompletedWithinTime(), serviceReportResponseList.get(3).getCompletedWithinTime(),serviceReportResponseList.get(4).getCompletedWithinTime(),serviceReportResponseList.get(5).getCompletedWithinTime()));
//            data.add(new MultiCustomDataEntry("CompletedBeyondTime", serviceReportResponseList.get(0).getCompletedBeyondTime(), serviceReportResponseList.get(1).getCompletedBeyondTime(), serviceReportResponseList.get(2).getCompletedBeyondTime(), serviceReportResponseList.get(3).getCompletedBeyondTime(), serviceReportResponseList.get(4).getCompletedBeyondTime(),serviceReportResponseList.get(5).getCompletedBeyondTime()));
//            data.add(new MultiCustomDataEntry("PendingWithTime", serviceReportResponseList.get(0).getPendingWithTime(), serviceReportResponseList.get(1).getPendingWithTime(), serviceReportResponseList.get(2).getPendingWithTime(), serviceReportResponseList.get(3).getPendingWithTime(),serviceReportResponseList.get(4).getPendingWithTime(),serviceReportResponseList.get(5).getPendingWithTime()));
//            data.add(new MultiCustomDataEntry("PendingMoreThanWeek", serviceReportResponseList.get(0).getPendingMoreThanWeek(), serviceReportResponseList.get(1).getPendingMoreThanWeek(), serviceReportResponseList.get(2).getPendingMoreThanWeek(), serviceReportResponseList.get(3).getPendingMoreThanWeek(),serviceReportResponseList.get(4).getPendingMoreThanWeek(),serviceReportResponseList.get(5).getPendingMoreThanWeek()));
//            data.add(new MultiCustomDataEntry("PendingMoreThanFortNight", serviceReportResponseList.get(0).getPendingMoreThanFortNight(), serviceReportResponseList.get(1).getPendingMoreThanFortNight(), serviceReportResponseList.get(2).getPendingMoreThanFortNight(), serviceReportResponseList.get(3).getPendingMoreThanFortNight(),serviceReportResponseList.get(4).getPendingMoreThanFortNight(),serviceReportResponseList.get(5).getPendingMoreThanFortNight()));
//            data.add(new MultiCustomDataEntry("TotalReject", serviceReportResponseList.get(0).getTotalReject(), serviceReportResponseList.get(1).getTotalReject(), serviceReportResponseList.get(2).getTotalReject(), serviceReportResponseList.get(3).getTotalReject(),serviceReportResponseList.get(4).getTotalReject(),serviceReportResponseList.get(5).getTotalReject()));
//            data.add(new MultiCustomDataEntry("TotalObjection", serviceReportResponseList.get(0).getTotalObjection(), serviceReportResponseList.get(1).getTotalObjection(), serviceReportResponseList.get(2).getTotalObjection(), serviceReportResponseList.get(3).getTotalObjection(),serviceReportResponseList.get(4).getTotalObjection(),serviceReportResponseList.get(5).getTotalObjection()));
//            data.add(new MultiCustomDataEntry("Total", serviceReportResponseList.get(0).getTotal(), serviceReportResponseList.get(1).getTotal(), serviceReportResponseList.get(2).getTotal(), serviceReportResponseList.get(3).getTotal(),serviceReportResponseList.get(4).getTotal(),serviceReportResponseList.get(5).getTotal()));
//            data.add(new MultiCustomDataEntry("AverageProcessingTime", serviceReportResponseList.get(0).getAverageProcessingTime(), serviceReportResponseList.get(1).getAverageProcessingTime(), serviceReportResponseList.get(2).getAverageProcessingTime(), serviceReportResponseList.get(3).getAverageProcessingTime(),serviceReportResponseList.get(4).getAverageProcessingTime(),serviceReportResponseList.get(5).getAverageProcessingTime()));
//            data.add(new MultiCustomDataEntry("AverageDelaytime", serviceReportResponseList.get(0).getAverageDelaytime(), serviceReportResponseList.get(1).getAverageDelaytime(), serviceReportResponseList.get(2).getAverageDelaytime(), serviceReportResponseList.get(3).getAverageDelaytime(),serviceReportResponseList.get(4).getAverageDelaytime(),serviceReportResponseList.get(5).getAverageDelaytime()));


                data.add(new MultiCustomDataEntry("T1", serviceReportResponseList.get(0).getTotalReceived(), serviceReportResponseList.get(1).getTotalReceived(), serviceReportResponseList.get(2).getTotalReceived(), serviceReportResponseList.get(3).getTotalReceived(), serviceReportResponseList.get(4).getTotalReceived(), serviceReportResponseList.get(5).getTotalReceived(), serviceReportResponseList.get(6).getTotalReceived()));
                data.add(new MultiCustomDataEntry("T2", serviceReportResponseList.get(0).getWithDrawn(), serviceReportResponseList.get(1).getWithDrawn(), serviceReportResponseList.get(2).getWithDrawn(), serviceReportResponseList.get(3).getWithDrawn(), serviceReportResponseList.get(4).getWithDrawn(), serviceReportResponseList.get(5).getWithDrawn(), serviceReportResponseList.get(6).getWithDrawn()));
                data.add(new MultiCustomDataEntry("T3", serviceReportResponseList.get(0).getCompletedWithinTime(), serviceReportResponseList.get(1).getCompletedWithinTime(), serviceReportResponseList.get(2).getCompletedWithinTime(), serviceReportResponseList.get(3).getCompletedWithinTime(), serviceReportResponseList.get(4).getCompletedWithinTime(), serviceReportResponseList.get(5).getCompletedWithinTime(), serviceReportResponseList.get(6).getCompletedWithinTime()));
                data.add(new MultiCustomDataEntry("T4", serviceReportResponseList.get(0).getCompletedBeyondTime(), serviceReportResponseList.get(1).getCompletedBeyondTime(), serviceReportResponseList.get(2).getCompletedBeyondTime(), serviceReportResponseList.get(3).getCompletedBeyondTime(), serviceReportResponseList.get(4).getCompletedBeyondTime(), serviceReportResponseList.get(5).getCompletedBeyondTime(), serviceReportResponseList.get(6).getCompletedBeyondTime()));
                data.add(new MultiCustomDataEntry("T5", serviceReportResponseList.get(0).getPendingWithTime(), serviceReportResponseList.get(1).getPendingWithTime(), serviceReportResponseList.get(2).getPendingWithTime(), serviceReportResponseList.get(3).getPendingWithTime(), serviceReportResponseList.get(4).getPendingWithTime(), serviceReportResponseList.get(5).getPendingWithTime(), serviceReportResponseList.get(6).getPendingWithTime()));
                data.add(new MultiCustomDataEntry("T6", serviceReportResponseList.get(0).getPendingMoreThanWeek(), serviceReportResponseList.get(1).getPendingMoreThanWeek(), serviceReportResponseList.get(2).getPendingMoreThanWeek(), serviceReportResponseList.get(3).getPendingMoreThanWeek(), serviceReportResponseList.get(4).getPendingMoreThanWeek(), serviceReportResponseList.get(5).getPendingMoreThanWeek(), serviceReportResponseList.get(6).getPendingMoreThanWeek()));
                data.add(new MultiCustomDataEntry("T7", serviceReportResponseList.get(0).getPendingMoreThanFortNight(), serviceReportResponseList.get(1).getPendingMoreThanFortNight(), serviceReportResponseList.get(2).getPendingMoreThanFortNight(), serviceReportResponseList.get(3).getPendingMoreThanFortNight(), serviceReportResponseList.get(4).getPendingMoreThanFortNight(), serviceReportResponseList.get(5).getPendingMoreThanFortNight(), serviceReportResponseList.get(6).getPendingMoreThanFortNight()));
                data.add(new MultiCustomDataEntry("T8", serviceReportResponseList.get(0).getPendingMoreThanOneMonth(), serviceReportResponseList.get(1).getPendingMoreThanOneMonth(), serviceReportResponseList.get(2).getPendingMoreThanOneMonth(), serviceReportResponseList.get(3).getPendingMoreThanOneMonth(), serviceReportResponseList.get(4).getPendingMoreThanOneMonth(), serviceReportResponseList.get(5).getPendingMoreThanOneMonth(), serviceReportResponseList.get(6).getPendingMoreThanOneMonth()));
                data.add(new MultiCustomDataEntry("T9", serviceReportResponseList.get(0).getTotalReject(), serviceReportResponseList.get(1).getTotalReject(), serviceReportResponseList.get(2).getTotalReject(), serviceReportResponseList.get(3).getTotalReject(), serviceReportResponseList.get(4).getTotalReject(), serviceReportResponseList.get(5).getTotalReject(), serviceReportResponseList.get(6).getTotalReject()));
                data.add(new MultiCustomDataEntry("T10", serviceReportResponseList.get(0).getTotalObjection(), serviceReportResponseList.get(1).getTotalObjection(), serviceReportResponseList.get(2).getTotalObjection(), serviceReportResponseList.get(3).getTotalObjection(), serviceReportResponseList.get(4).getTotalObjection(), serviceReportResponseList.get(5).getTotalObjection(), serviceReportResponseList.get(6).getTotalObjection()));
                data.add(new MultiCustomDataEntry("T11", serviceReportResponseList.get(0).getTotal(), serviceReportResponseList.get(1).getTotal(), serviceReportResponseList.get(2).getTotal(), serviceReportResponseList.get(3).getTotal(), serviceReportResponseList.get(4).getTotal(), serviceReportResponseList.get(5).getTotal(), serviceReportResponseList.get(6).getTotal()));
                data.add(new MultiCustomDataEntry("T12", serviceReportResponseList.get(0).getAverageProcessingTime(), serviceReportResponseList.get(1).getAverageProcessingTime(), serviceReportResponseList.get(2).getAverageProcessingTime(), serviceReportResponseList.get(3).getAverageProcessingTime(), serviceReportResponseList.get(4).getAverageProcessingTime(), serviceReportResponseList.get(5).getAverageProcessingTime(), serviceReportResponseList.get(6).getAverageProcessingTime()));
                data.add(new MultiCustomDataEntry("T13", serviceReportResponseList.get(0).getAverageDelaytime(), serviceReportResponseList.get(1).getAverageDelaytime(), serviceReportResponseList.get(2).getAverageDelaytime(), serviceReportResponseList.get(3).getAverageDelaytime(), serviceReportResponseList.get(4).getAverageDelaytime(), serviceReportResponseList.get(5).getAverageDelaytime(), serviceReportResponseList.get(6).getAverageDelaytime()));

                Set set = Set.instantiate();
                set.data(data);
                ServiceReportResponse totalServiceResponse = new ServiceReportResponse();
                totalServiceResponse.setDepartment("Total Request");
                int totalReceived = 0,
                        totalWithDrawn = 0, totalCompletedWithinTime = 0, totalCompletedBeyondTime = 0, totalPendingWithinTime = 0,
                        totalPendingMoreThanWeek = 0,
                        totalMoreThanFortNight = 0, totalMoreThanOneMonth = 0, totalReject = 0, totalObjection = 0, totalCount = 0,
                        totalAverageProcessingTime = 0, totalDelayTime = 0;
                for (int i = 0; i < serviceReportResponseList.size(); i++) {
                    totalReceived = totalReceived + serviceReportResponseList.get(i).getTotalReceived();
                    totalWithDrawn = totalWithDrawn + serviceReportResponseList.get(i).getWithDrawn();
                    totalCompletedWithinTime = totalCompletedWithinTime + serviceReportResponseList.get(i).getCompletedWithinTime();
                    totalCompletedBeyondTime = totalCompletedBeyondTime + serviceReportResponseList.get(i).getCompletedBeyondTime();
                    totalPendingWithinTime = totalPendingWithinTime + serviceReportResponseList.get(i).getPendingWithTime();
                    totalPendingMoreThanWeek = totalPendingMoreThanWeek + serviceReportResponseList.get(i).getPendingMoreThanWeek();
                    totalMoreThanFortNight = totalMoreThanFortNight + serviceReportResponseList.get(i).getPendingMoreThanFortNight();
                    totalMoreThanOneMonth = totalMoreThanOneMonth + serviceReportResponseList.get(i).getPendingMoreThanOneMonth();
                    totalReject = totalReject + serviceReportResponseList.get(i).getTotalReject();
                    totalObjection = totalObjection + serviceReportResponseList.get(i).getTotalObjection();
                    totalCount = totalCount + serviceReportResponseList.get(i).getTotal();
                    totalAverageProcessingTime = totalAverageProcessingTime + serviceReportResponseList.get(i).getAverageProcessingTime();
                    totalDelayTime = totalDelayTime + serviceReportResponseList.get(i).getAverageDelaytime();
                }
                totalServiceResponse.setTotalReceived(totalReceived);
                totalServiceResponse.setWithDrawn(totalWithDrawn);
                totalServiceResponse.setCompletedWithinTime(totalCompletedWithinTime);
                totalServiceResponse.setCompletedBeyondTime(totalCompletedBeyondTime);
                totalServiceResponse.setPendingWithTime(totalPendingWithinTime);
                totalServiceResponse.setPendingMoreThanWeek(totalPendingMoreThanWeek);
                totalServiceResponse.setPendingMoreThanFortNight(totalMoreThanFortNight);
                totalServiceResponse.setPendingMoreThanOneMonth(totalMoreThanOneMonth);
                totalServiceResponse.setTotalReject(totalReject);
                totalServiceResponse.setTotalObjection(totalObjection);
                totalServiceResponse.setTotal(totalCount);
                totalServiceResponse.setAverageProcessingTime(totalAverageProcessingTime);
                totalServiceResponse.setAverageDelaytime(totalDelayTime);
                serviceReportResponseList.add(totalServiceResponse);

                reportViewLayout.setVisibility(View.VISIBLE);
                reportsAdapter = new ReportsAdapter(this, serviceReportResponseList, 1);
                reportGrid.setAdapter(reportsAdapter);


                Mapping lineData = set.mapAs("{ x: 'x', value: 'value' }");
                Mapping column1Data = set.mapAs("{ x: 'x', value: 'value2' }");
                Mapping column2Data = set.mapAs("{ x: 'x', value: 'value3' }");
                Mapping column3Data = set.mapAs("{ x: 'x', value: 'value4' }");
                Mapping column4Data = set.mapAs("{ x: 'x', value: 'value5' }");
                Mapping column5Data = set.mapAs("{ x: 'x', value: 'value6' }");
                Mapping column6Data = set.mapAs("{ x: 'x', value: 'value7' }");

                cartesian.bar(lineData).name("Institutional").color("#FFC0CB");
                cartesian.bar(column1Data).name("Commercial").color("#FFA07A");
                cartesian.bar(column2Data).name("Residential").color("#00FFFF");
                cartesian.bar(column3Data).name("Industrial").color("#00BFFF");
                cartesian.bar(column4Data).name("Housing").color("#2F4F4F");
                cartesian.bar(column5Data).name("Group Housing").color("#4169E1");
                cartesian.bar(column6Data).name("5% Abadi").color("#4169E1");
                cartesian.tooltip().enabled(true);
                cartesian.tooltip().displayMode(TooltipDisplayMode.UNION).positionMode(TooltipPositionMode.FLOAT)
                        .anchor(Anchor.LEFT_CENTER);


                cartesian.interactivity().hoverMode(HoverMode.BY_X);
                cartesian.legend().enabled(true);
                cartesian.legend().inverted(false);
                cartesian.legend().fontSize(13d);
                cartesian.legend().padding(0d, 0d, 20d, 0d);

                cartesian.credits().enabled(false);
                cartesian.credits().text("Noida Authority");
                anyChartView.setChart(cartesian);
            }
        }
        if(ServiceCode == Constants.GRID_REQUEST){
            List<ServiceTimeLineModel> serviceTimeLineResponseList = (List<ServiceTimeLineModel>) response;
            ServiceTimeLineModel totalServiceResponse = new ServiceTimeLineModel();
            totalServiceResponse.setServiceName("Total Request");
            int totalReceived = 0,
                    totalWithDrawn = 0, totalCompletedWithinTime = 0, totalCompletedBeyondTime = 0, totalPendingWithinTime = 0,
                    totalPendingMoreThanWeek = 0,
                    totalMoreThanFortNight = 0, totalMoreThanOneMonth = 0, totalReject = 0, totalObjection = 0, totalCount = 0,
                    totalAverageProcessingTime = 0, totalDelayTime = 0;

            for (int i = 0; i < serviceReportResponseList.size(); i++) {
                totalReceived = totalReceived + serviceReportResponseList.get(i).getTotalReceived();
                totalWithDrawn = totalWithDrawn + serviceReportResponseList.get(i).getWithDrawn();
                totalCompletedWithinTime = totalCompletedWithinTime + serviceReportResponseList.get(i).getCompletedWithinTime();
                totalCompletedBeyondTime = totalCompletedBeyondTime + serviceReportResponseList.get(i).getCompletedBeyondTime();
                totalPendingWithinTime = totalPendingWithinTime + serviceReportResponseList.get(i).getPendingWithTime();
                totalPendingMoreThanWeek = totalPendingMoreThanWeek + serviceReportResponseList.get(i).getPendingMoreThanWeek();
                totalMoreThanFortNight = totalMoreThanFortNight + serviceReportResponseList.get(i).getPendingMoreThanFortNight();
                totalMoreThanOneMonth = totalMoreThanOneMonth + serviceReportResponseList.get(i).getPendingMoreThanOneMonth();
                totalReject = totalReject + serviceReportResponseList.get(i).getTotalReject();
                totalObjection = totalObjection + serviceReportResponseList.get(i).getTotalObjection();
                totalCount = totalCount + serviceReportResponseList.get(i).getTotal();
                totalAverageProcessingTime = totalAverageProcessingTime + serviceReportResponseList.get(i).getAverageProcessingTime();
                totalDelayTime = totalDelayTime + serviceReportResponseList.get(i).getAverageDelaytime();
            }
            totalServiceResponse.setTotalReceived(totalReceived);
            totalServiceResponse.setWithDrawn(totalWithDrawn);
            totalServiceResponse.setCompletedWithinTime(totalCompletedWithinTime);
            totalServiceResponse.setCompletedBeyondTime(totalCompletedBeyondTime);
            totalServiceResponse.setPendingWithTime(totalPendingWithinTime);
            totalServiceResponse.setPendingMoreThanWeek(totalPendingMoreThanWeek);
            totalServiceResponse.setPendingMoreThanFortNight(totalMoreThanFortNight);
            totalServiceResponse.setPendingMoreThanOneMonth(totalMoreThanOneMonth);
            totalServiceResponse.setTotalReject(totalReject);
            totalServiceResponse.setTotalObjection(totalObjection);
            totalServiceResponse.setTotal(totalCount);
            totalServiceResponse.setAverageProcessingTime(totalAverageProcessingTime);
            totalServiceResponse.setAverageDelaytime(totalDelayTime);
            serviceTimeLineResponseList.add(totalServiceResponse);



            ServiceTimeLineAdapter adapter = new ServiceTimeLineAdapter(this, serviceTimeLineResponseList, new ServiceTimeLineAdapter.ServiceTimeClickListener() {
                @Override
                public void onItemClickListener(int position, String tag) {

                    if(position < serviceTimeLineResponseList.size()) {

                        ServiceTimeLineModel smodel = serviceTimeLineResponseList.get(position - 1);
                        Intent in = new Intent(OfficerFilteredReportActivity.this, TimeLineReportActivity.class);
                        in.putExtra("deptID", selectedposition);
                        in.putExtra("StartDate", selectedStartDate);
                        in.putExtra("EndDate", selectedEndDate);
                        in.putExtra("requestthrough", requestthrough);
                        in.putExtra("type", tag);
                        in.putExtra("serviceid", String.valueOf(smodel.getServiceId()));
                        startActivity(in);
                    }

                }
            });
            reportViewLayout.setVisibility(View.VISIBLE);
            reportGrid.setAdapter(adapter);

        }
    }



    private class MultiCustomDataEntry extends ValueDataEntry {
        MultiCustomDataEntry(String x, Number value, Number value2, Number value3, Number value4, Number value5, Number value6, Number value7) {
            super(x, value);
            setValue("value2", value2);
            setValue("value3", value3);
            setValue("value4", value4);
            setValue("value5", value5);
            setValue("value6", value6);
            setValue("value7", value7);
        }
    }

    private class CustomDataEntry extends ValueDataEntry {
        public CustomDataEntry(String x, Number value, String jumpLine) {
            super(x, value);
            setValue("jumpLine", jumpLine);
        }
    }


    public void ExportToExcel(View view)
    {
        if (checkPermission()) {

            exportExcel();
        } else {
            requestPermission();
        }
    }


    private boolean checkPermission() {
        int result = ContextCompat.checkSelfPermission(OfficerFilteredReportActivity.this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (result == PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            return false;
        }
    }

    private void requestPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(OfficerFilteredReportActivity.this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            Toast.makeText(OfficerFilteredReportActivity.this, "Write External Storage permission allows us to save files. Please allow this permission in App Settings.", Toast.LENGTH_LONG).show();
        } else {
            ActivityCompat.requestPermissions(OfficerFilteredReportActivity.this, new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, PERMISSION_REQUEST_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_REQUEST_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Log.e("value", "Permission Granted, Now you can use local drive .");
                    exportExcel();
                } else {
                    Log.e("value", "Permission Denied, You cannot use local drive .");

                }
                break;
        }
    }

    public void exportExcel()
    {
        File sd = Environment.getExternalStorageDirectory();
        String csvFile = "Report.xls";

        File directory = new File(sd.getAbsolutePath());
        //create directory if not exist
        if (!directory.isDirectory()) {
            directory.mkdirs();
        }
        try {

            //file path
            File file = new File(directory, csvFile);
            WorkbookSettings wbSettings = new WorkbookSettings();
            wbSettings.setLocale(new Locale("en", "EN"));
            WritableWorkbook workbook;
            workbook = Workbook.createWorkbook(file, wbSettings);
            //Excel sheet name. 0 represents first sheet
            WritableSheet sheet = workbook.createSheet("ReportList", 0);

            // column and row
            sheet.addCell(new Label(0, 0, "Department"));
            sheet.addCell(new Label(1, 0, "Total Request"));
            sheet.addCell(new Label(2, 0, "Within Time"));
            sheet.addCell(new Label(3, 0, "Beyond Time"));
            sheet.addCell(new Label(4, 0, "Within Time"));
            sheet.addCell(new Label(5, 0, "More Than a Week"));
            sheet.addCell(new Label(6, 0, "More Than Fortnight"));
            sheet.addCell(new Label(7, 0, "More Than a Month"));
            sheet.addCell(new Label(8, 0, "Objection"));
            sheet.addCell(new Label(9, 0, "Average Processing Time"));
            sheet.addCell(new Label(10, 0, "Average Delaytime"));
            for(int i = 1; i < serviceReportResponseList.size(); i++)
            {
                ServiceReportResponse serviceReportResponse = serviceReportResponseList.get(i);
                sheet.addCell(new Label(0, i, serviceReportResponse.getDepartment()));
                sheet.addCell(new Label(1, i, String.valueOf(serviceReportResponse.getTotal())));
                sheet.addCell(new Label(2, i, String.valueOf(serviceReportResponse.getCompletedWithinTime())));
                sheet.addCell(new Label(3, i, String.valueOf(serviceReportResponse.getCompletedBeyondTime())));
                sheet.addCell(new Label(4, i, String.valueOf(serviceReportResponse.getPendingWithTime())));
                sheet.addCell(new Label(5, i, String.valueOf(serviceReportResponse.getPendingMoreThanWeek())));
                sheet.addCell(new Label(6, i, String.valueOf(serviceReportResponse.getPendingMoreThanFortNight())));
                sheet.addCell(new Label(7, i, String.valueOf(serviceReportResponse.getPendingMoreThanOneMonth())));
                sheet.addCell(new Label(8, i, String.valueOf(serviceReportResponse.getTotalObjection())));
                sheet.addCell(new Label(9, i, String.valueOf(serviceReportResponse.getAverageProcessingTime())));
                sheet.addCell(new Label(10, i, String.valueOf(serviceReportResponse.getAverageDelaytime())));

            }

            workbook.write();
            workbook.close();
            callAlertDialog(String.valueOf(file));
            //Toast.makeText(getApplication(),
            //        "Data Exported in a Excel Sheet and Saved in location : "+String.valueOf(file), Toast.LENGTH_SHORT).show();
        } catch(Exception e){
            Toast.makeText(getApplication(), "Exception: "+e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            Log.d("Exception :",e.getLocalizedMessage());
            e.printStackTrace();
        }

    }

    public void callAlertDialog(final String filelocation)
    {
        //Setting message manually and performing action on button click
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Do you want to mail this xls?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //finish();
                        sendEmailWithAttachment(getApplicationContext(),"abc@xyz.com","Test Subject", "Test Message", filelocation);


                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //  Action for 'NO' Button
                        dialog.cancel();

                    }
                });
        //Creating dialog box
        AlertDialog alert = builder.create();
        //Setting the title manually
        alert.setTitle("Export Completed");
        alert.show();
    }

    public void sendEmailWithAttachment(Context ctx, String to, String subject, String message, String fileAndLocation)
    {
        Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
        emailIntent.setType("text/excel");
        emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[] {to});

        emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,  subject);
        emailIntent.putExtra(android.content.Intent.EXTRA_TEXT,  message);


        File file = new File(fileAndLocation);
        //File file = getFileStreamPath();
        if (file.exists())
        {
            Log.d("Noida Authority", "Email file_exists!" );
        }
        else
        {
            Log.d("Noida Authority", "Email file does not exist!" );
        }

        //Uri uri = FileProvider.getUriForFile(getApplicationContext(), getPackageName() + ".provider", file);
        Uri uri = FileProvider.getUriForFile(this,
                "com.noida.authority.fileprovider", // Over here
                file);
        emailIntent .putExtra(Intent.EXTRA_STREAM, uri);

        //need this to prompts email client only
        emailIntent.setType("message/rfc822");
        startActivity(Intent.createChooser(emailIntent, "Choose an Email client :"));

    }


}
