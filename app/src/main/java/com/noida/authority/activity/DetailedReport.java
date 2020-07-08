package com.noida.authority.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.noida.authority.R;
import com.noida.authority.adapter.ReportsAdapter;

import java.io.File;
import java.util.Locale;

import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class DetailedReport extends AppCompatActivity {


    TextView title;
    ImageView back_arrow;


    RecyclerView rvReports;
    ReportsAdapter reportsAdapter;

    private static final int PERMISSION_REQUEST_CODE = 100;

    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_report);

        title = findViewById(R.id.title);
        back_arrow = findViewById(R.id.back_arrow);
        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        title.setText("Detailed Reports");

        builder = new AlertDialog.Builder(this);
        rvReports  = findViewById(R.id.reportsRecycler);
        //rvReports.setLayoutManager(new LinearLayoutManager(this));

        /*GridLayoutManager mLayoutManager = new GridLayoutManager(getApplicationContext(),2);
        HorizontalLayout
                = new LinearLayoutManager(
                Reports.this,
                LinearLayoutManager.HORIZONTAL,
                false);
        rvReports.setLayoutManager(HorizontalLayout);
        rvReports.addItemDecoration(new SpacesItemDecoration(10));*/

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this) {
            @Override
            public boolean canScrollVertically() {
                return true;
            }
        };
        rvReports.setLayoutManager(linearLayoutManager);


    }


    public void ExportToExcel(View View)
    {

        if (checkPermission()) {

            exportExcel();
        } else {
            requestPermission();
        }

    }

    private boolean checkPermission() {
        int result = ContextCompat.checkSelfPermission(DetailedReport.this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (result == PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            return false;
        }
    }

    private void requestPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(DetailedReport.this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            Toast.makeText(DetailedReport.this, "Write External Storage permission allows us to save files. Please allow this permission in App Settings.", Toast.LENGTH_LONG).show();
        } else {
            ActivityCompat.requestPermissions(DetailedReport.this, new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, PERMISSION_REQUEST_CODE);
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
            sheet.addCell(new Label(0, 0, "Ref No."));
            sheet.addCell(new Label(1, 0, "RId"));
            sheet.addCell(new Label(2, 0, "Department"));
            sheet.addCell(new Label(3, 0, "Service Name"));
            for(int i = 1; i < 20; i++)
            {
                sheet.addCell(new Label(0, i, "111280"));
                sheet.addCell(new Label(1, i, "50008454"));
                sheet.addCell(new Label(2, i, "Housing"));
                sheet.addCell(new Label(3, i, "Transfer of Flat/House"));
            }

            workbook.write();
            workbook.close();
            callAlertDialog(String.valueOf(file));
            //Toast.makeText(getApplication(),
            //        "Data Exported in a Excel Sheet and Saved in location : "+String.valueOf(file), Toast.LENGTH_SHORT).show();
        } catch(Exception e){
            Toast.makeText(getApplication(), "Exception: "+e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }

    }

    public void callAlertDialog(final String filelocation)
    {
        //Setting message manually and performing action on button click
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

        Uri uri = FileProvider.getUriForFile(getApplicationContext(), getPackageName() + ".provider", file);
        emailIntent .putExtra(Intent.EXTRA_STREAM, uri);

        //need this to prompts email client only
        emailIntent.setType("message/rfc822");
        startActivity(Intent.createChooser(emailIntent, "Choose an Email client :"));

    }
}
