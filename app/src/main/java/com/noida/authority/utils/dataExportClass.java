package com.noida.authority.utils;

import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import com.noida.authority.response_model.ServiceReportResponse;

import java.io.File;
import java.util.List;
import java.util.Locale;

import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class dataExportClass {

    public boolean exportExcel(List<ServiceReportResponse> serviceReportResponseList) {
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
            for (int i = 1; i < serviceReportResponseList.size(); i++) {
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
            return true;
            //callAlertDialog(String.valueOf(file));
            //Toast.makeText(getApplication(),
            //        "Data Exported in a Excel Sheet and Saved in location : "+String.valueOf(file), Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            //Toast.makeText(getApplication(), "Exception: "+e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            Log.d("Exception :", e.getLocalizedMessage());
            e.printStackTrace();
            return false;
        }
    }


}
