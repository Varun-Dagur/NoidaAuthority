package com.noida.authority.activity;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.provider.Settings;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;
import android.os.Handler;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.databinding.DataBindingUtil;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.noida.authority.R;
import com.noida.authority.Service.AppLocationService;
import com.noida.authority.body_model.PropertyResponse;
import com.noida.authority.databinding.ActivityLodgeNewComplaintBinding;
import com.noida.authority.mernretrofit.MernApiManager;
import com.noida.authority.mernretrofit.MernApiResponseInterface;
import com.noida.authority.pojo.LodgeNewComplaintPojo;
import com.noida.authority.response_model.BlockResponse;
import com.noida.authority.response_model.DepartmentResponse;
import com.noida.authority.response_model.SectorResponse;
import com.noida.authority.response_model.ServiceResponse;
import com.noida.authority.retrofit.ApiManager;
import com.noida.authority.retrofit.ApiResponseInterface;
import com.noida.authority.utils.BaseActivity;
import com.noida.authority.utils.Constants;
import com.noida.authority.utils.LocationAddress;

import java.util.ArrayList;
import java.util.List;

import static com.basgeekball.awesomevalidation.ValidationStyle.BASIC;
import static com.basgeekball.awesomevalidation.ValidationStyle.UNDERLABEL;
import static com.noida.authority.activity.LoginActivity.token;

public class LodgeNewComplaint extends BaseActivity implements ApiResponseInterface, MernApiResponseInterface {
    AppLocationService appLocationService;
    List<SectorResponse> sectorList;
    List<BlockResponse> blockList;
    List<DepartmentResponse> deptList;
    List<ServiceResponse> serviceList;
    ActivityLodgeNewComplaintBinding newComplaintbinding;
    ApiManager apiManager;
    MernApiManager mernApiManager;
    protected Context context;
    String location;

    private static final int CAMERA_REQUEST = 1888;
    private static final int MY_CAMERA_PERMISSION_CODE = 100;
    private static final int MY_CURRENT_LOCATION_CODE = 101;

    private static final int IMAGE_REQUEST_FIRST = 1801;
    private static final int IMAGE_REQUEST_SECOND = 1802;
    private static final int IMAGE_REQUEST_THIRD = 1803;
    private static final int IMAGE_REQUEST_FOURTH = 1804;




    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        newComplaintbinding = DataBindingUtil.setContentView(this, R.layout.activity_lodge_new_complaint);
        newComplaintbinding.setClickListener(new EventHandler(this));
        newComplaintbinding.setActivity(this);
        setToolbarTitle("Lodge a New Complaint");


        apiManager = new ApiManager(this, this);
        apiManager.getSectorList(token);
        apiManager.getBlockList(token);


        mernApiManager = new MernApiManager(this, this);
        mernApiManager.getDepartments();
        mernApiManager.getServices(1);





        if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED)
        {


                requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, MY_CURRENT_LOCATION_CODE);

        }
        else
        {
               setCurrentLocation();
        }


        newComplaintbinding.departmentSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(
                    AdapterView<?> adapterView, View view,
                    int i, long l) {

                DepartmentResponse deptResponse = deptList.get(i);
                mernApiManager.getServices(deptResponse.getId());



            }

            public void onNothingSelected(
                    AdapterView<?> adapterView) {

            }
        });








//        newComplaintbinding.complaintimage1.setOnClickListener(new View.OnClickListener() {
//            @RequiresApi(api = Build.VERSION_CODES.M)
//            @Override
//            public void onClick(View view) {
//                CallCamera(view, IMAGE_REQUEST_FIRST);
//            }
//        });
//
//        newComplaintbinding.complaintimage2.setOnClickListener(new View.OnClickListener() {
//            @RequiresApi(api = Build.VERSION_CODES.M)
//            @Override
//            public void onClick(View view) {
//                CallCamera(view, IMAGE_REQUEST_SECOND);
//            }
//        });
//
//        newComplaintbinding.complaintimage3.setOnClickListener(new View.OnClickListener() {
//            @RequiresApi(api = Build.VERSION_CODES.M)
//            @Override
//            public void onClick(View view) {
//                CallCamera(view, IMAGE_REQUEST_THIRD);
//            }
//        });
//
//        newComplaintbinding.complaintimage4.setOnClickListener(new View.OnClickListener() {
//            @RequiresApi(api = Build.VERSION_CODES.M)
//            @Override
//            public void onClick(View view) {
//
//                CallCamera(view, IMAGE_REQUEST_FOURTH);
//
//            }
//        });
    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    public void CallCamera(View view, int REQUEST_CODE)
    {
        if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED)
        {
            requestPermissions(new String[]{Manifest.permission.CAMERA}, MY_CAMERA_PERMISSION_CODE);
        }
        else
        {
            Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(cameraIntent, REQUEST_CODE);
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults)
    {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);




        if(requestCode == MY_CURRENT_LOCATION_CODE)
        {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED)
            {
                setCurrentLocation();
            }
            else
            {
                Toast.makeText(this, "Location permission denied", Toast.LENGTH_LONG).show();
            }
        }








        if (requestCode == MY_CAMERA_PERMISSION_CODE)
        {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED)
            {
                Toast.makeText(this, "Camera permission granted", Toast.LENGTH_LONG).show();
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, IMAGE_REQUEST_FIRST);
            }
            else
            {
                Toast.makeText(this, "Camera permission denied", Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

//        if (requestCode == IMAGE_REQUEST_FIRST && resultCode == Activity.RESULT_OK) {
//            Bitmap photo = (Bitmap) data.getExtras().get("data");
//            newComplaintbinding.complaintimage1.setImageBitmap(photo);
//        }
//        if (requestCode == IMAGE_REQUEST_SECOND && resultCode == Activity.RESULT_OK) {
//            Bitmap photo = (Bitmap) data.getExtras().get("data");
//            newComplaintbinding.complaintimage2.setImageBitmap(photo);
//        }
//        if (requestCode == IMAGE_REQUEST_THIRD && resultCode == Activity.RESULT_OK) {
//            Bitmap photo = (Bitmap) data.getExtras().get("data");
//            newComplaintbinding.complaintimage3.setImageBitmap(photo);
//        }
//        if (requestCode == IMAGE_REQUEST_FOURTH && resultCode == Activity.RESULT_OK) {
//            Bitmap photo = (Bitmap) data.getExtras().get("data");
//            newComplaintbinding.complaintimage4.setImageBitmap(photo);
//        }
    }


    public void showSettingsAlert() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(
                LodgeNewComplaint.this);
        alertDialog.setTitle("SETTINGS");
        alertDialog.setMessage("Enable Location Provider! Go to settings menu?");
        alertDialog.setPositiveButton("Settings",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(
                                Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                        LodgeNewComplaint.this.startActivity(intent);
                    }
                });

        alertDialog.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        alertDialog.show();
    }

    @Override
    public void isServerError(String errorCode) {

    }

    @Override
    public void isServerSuccess(Object response, int ServiceCode) {

        if (ServiceCode == Constants.GET_DEPARTMENT) {
            deptList = (List<DepartmentResponse>) response;
            setDepartmentList(deptList);
        }

        if (ServiceCode == Constants.GET_SERVICE) {
            serviceList = (List<ServiceResponse>) response;
            setServiceList(serviceList);
        }

    }

    private class GeocoderHandler extends Handler {
        @Override
        public void handleMessage(Message message) {
            String locationAddress;
            switch (message.what) {
                case 1:
                    Bundle bundle = message.getData();
                    locationAddress = bundle.getString("address");
                    break;
                default:
                    locationAddress = null;
            }
            LodgeNewComplaintPojo lodgeNewComplaint = new LodgeNewComplaintPojo();
            lodgeNewComplaint.setLocation(locationAddress);
            setLocation(locationAddress);
            //binding.setGender(propertyResponse);


        }
    }

    @Override
    public void isError(String errorCode) {

    }

    @Override
    public void isSuccess(Object response, int ServiceCode) {
        if (ServiceCode == Constants.GET_SECTOR) {
            sectorList = (List<SectorResponse>) response;
            setSectorList(sectorList);

        }

        else if (ServiceCode == Constants.GET_BLOCK) {
            blockList = (List<BlockResponse>) response;
            setBlockList(blockList);

        }
        else if (ServiceCode == Constants.REGISTER_COMPLAINT) {
            Toast.makeText(LodgeNewComplaint.this, String.valueOf(response), Toast.LENGTH_SHORT).show();

        }

    }


    void setBlockList(List<BlockResponse> blockList) {
        List<String> blockNames = new ArrayList<>();
        for (int i = 0; i < this.blockList.size(); i++) {
            blockNames.add(this.blockList.get(i).getText());
        }

        newComplaintbinding.setBlockList(blockNames);
    }

    void setDepartmentList(List<DepartmentResponse> departmentList) {
        List<String> departmentNames = new ArrayList<>();
        for (int i = 0; i < this.deptList.size(); i++) {
            departmentNames.add(this.deptList.get(i).getName());
        }
        newComplaintbinding.setDepartmentList(departmentNames);
    }

    void setServiceList(List<ServiceResponse> serviceList) {
        List<String> serviceNames = new ArrayList<>();
        for (int i = 0; i < this.serviceList.size(); i++) {
            serviceNames.add(this.serviceList.get(i).getName());
        }
        newComplaintbinding.setServiceList(serviceNames);
    }



    void setSectorList(List<SectorResponse> sectorList) {
        List<String> sectorNames = new ArrayList<>();
        for (int i = 0; i < this.sectorList.size(); i++) {
            sectorNames.add(this.sectorList.get(i).getText());
        }
        newComplaintbinding.setSectorList(sectorNames);
    }



    void setLocation(String location)
    {
        this.location = location;
        newComplaintbinding.setLocation(location);

    }



    public void setCurrentLocation()
    {
        appLocationService = new AppLocationService(LodgeNewComplaint.this);
        Location gpsLocation = appLocationService.getLocation(LocationManager.GPS_PROVIDER);

        if (gpsLocation != null) {
            double latitude = gpsLocation.getLatitude();
            double longitude = gpsLocation.getLongitude();
            String result = "Latitude: " + gpsLocation.getLatitude() + " Longitude: " + gpsLocation.getLongitude();

        } else {
            showSettingsAlert();
        }



        Location location = appLocationService.getLocation(LocationManager.GPS_PROVIDER);
        if (location != null) {
            double latitude = location.getLatitude();
            double longitude = location.getLongitude();
            LocationAddress locationAddress = new LocationAddress();
            locationAddress.getAddressFromLocation(latitude, longitude, getApplicationContext(), new GeocoderHandler());

        } else {
            showSettingsAlert();
        }
    }




    public class EventHandler {
        Activity mContext;

        public EventHandler(Activity mContext) {
            this.mContext = mContext;
        }

        public void lodgeNewComplaint() {
            AwesomeValidation validation = new AwesomeValidation(ValidationStyle.BASIC);

            DepartmentResponse departmentResponse = deptList.get(newComplaintbinding.departmentSpinner.getSelectedItemPosition());
            ServiceResponse serviceResponse = serviceList.get(newComplaintbinding.complaintTypeSpinner.getSelectedItemPosition());


            validation.addValidation(LodgeNewComplaint.this, R.id.complaintSubject, "\\A(?!\\s*\\Z).+", R.string.subject_error);
            validation.addValidation(LodgeNewComplaint.this, R.id.complaintMessage, "\\A(?!\\s*\\Z).+", R.string.message_error);

            validation.addValidation(LodgeNewComplaint.this, R.id.complainantName, "\\A(?!\\s*\\Z).+", R.string.subject_error);
            validation.addValidation(LodgeNewComplaint.this, R.id.complainantMobile, "[a-zA-Z0-9_-]+", R.string.mobile_error);

            validation.addValidation(LodgeNewComplaint.this, R.id.complainantEmail, Patterns.EMAIL_ADDRESS, R.string.email_error);
            validation.addValidation(LodgeNewComplaint.this, R.id.complainantAddress, "\\A(?!\\s*\\Z).+", R.string.comAddress_error);
            validation.addValidation(LodgeNewComplaint.this, R.id.complainantIDProof, "\\A(?!\\s*\\Z).+", R.string.id_proof_error);
            validation.addValidation(LodgeNewComplaint.this, R.id.complainantVillage, "\\A(?!\\s*\\Z).+", R.string.village_error);
            validation.addValidation(LodgeNewComplaint.this, R.id.complainantPlot, "\\A(?!\\s*\\Z).+", R.string.plot_error);
            validation.addValidation(LodgeNewComplaint.this, R.id.complainantLocation, "\\A(?!\\s*\\Z).+", R.string.address_error);
            if (validation.validate()) {
                Toast.makeText(mContext, String.valueOf(newComplaintbinding.departmentSpinner.getSelectedItemPosition()), Toast.LENGTH_SHORT).show();

                mernApiManager.registerComplaint(departmentResponse.getId(),
                        serviceResponse.getId(),
                        newComplaintbinding.complaintSubject.getText().toString(),
                        newComplaintbinding.complaintMessage.getText().toString(),
                        newComplaintbinding.complaintLocation.getText().toString(),
                        newComplaintbinding.complainantName.getText().toString(),
                        newComplaintbinding.complainantMobile.getText().toString(),
                        newComplaintbinding.complainantEmail.getText().toString(),
                        newComplaintbinding.complainantAddress.getText().toString(),
                        newComplaintbinding.complainantIDProof.getText().toString(),
                        newComplaintbinding.sectorSpinner.getSelectedItem().toString(),
                        newComplaintbinding.blockSpinner.getSelectedItem().toString(),
                        newComplaintbinding.complainantVillage.getText().toString(),
                        newComplaintbinding.complainantPlot.getText().toString(),
                        newComplaintbinding.complainantAddress.getText().toString()
                        );

//                mernApiManager.registerComplaint(1,1,"test","test",
//                        "test","test","9871620829",
//                        "varun@gmail.com","test","test",
//                        "test","test","test","test","test");
            }


        }

    }


}
