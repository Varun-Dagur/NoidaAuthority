package com.noida.authority.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;
import com.noida.authority.BuildConfig;
import com.noida.authority.MainActivity;
import com.noida.authority.R;
import com.noida.authority.activity.complaintview.ComplaintBasic;
import com.noida.authority.databinding.ActivityLandingBinding;
import com.noida.authority.generated.callback.OnClickListener;

import java.util.HashMap;

public class LandingActivity extends AppCompatActivity {

//    TextView title;
//    ImageView back_arrow;
    private FirebaseRemoteConfig mFirebaseRemoteConfig = FirebaseRemoteConfig.getInstance();

    private HashMap<String, Object> firebaseDefaultMap;

    public static final String VERSION_CODE_KEY = "latest_app_version";
    private static final String TAG = "MainActivity";


    private ActivityLandingBinding binding;

    private LandingClickHandlers handlers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_landing);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_landing);


//        title = findViewById(R.id.title);
//        back_arrow = findViewById(R.id.back_arrow);
//        back_arrow.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onBackPressed();
//            }
//        });
//        back_arrow.setVisibility(View.INVISIBLE);
//        title.setText("Noida Authority");

        handlers = new LandingClickHandlers(this);
        binding.setHandlers(handlers);


        //This is default Map
        firebaseDefaultMap = new HashMap<>();
        //Setting the Default Map Value with the current version code
        firebaseDefaultMap.put(VERSION_CODE_KEY, getCurrentVersionCode());

        //Setting that default Map to Firebase Remote Config
        //mFirebaseRemoteConfig.setDefaults(firebaseDefaultMap);
        mFirebaseRemoteConfig.setDefaultsAsync(firebaseDefaultMap);

        //Setting Developer Mode enabled to fast retrieve the values
        mFirebaseRemoteConfig.setConfigSettings(
                new FirebaseRemoteConfigSettings.Builder().setDeveloperModeEnabled(BuildConfig.DEBUG)
                        .build());

        //Fetching the values here
        mFirebaseRemoteConfig.fetch().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    mFirebaseRemoteConfig.activateFetched();
                    Log.d(TAG, "Fetched value: " + mFirebaseRemoteConfig.getString(VERSION_CODE_KEY));
                    //calling function to check if new version is available or not
                    checkForUpdate();
                } else {
                    Toast.makeText(LandingActivity.this, "Someting went wrong please try again", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Log.d(TAG, "Default value: " + mFirebaseRemoteConfig.getString(VERSION_CODE_KEY));
    }

    public class LandingClickHandlers {

        Context context;

        public LandingClickHandlers(Context context) {
            this.context = context;
        }

//        public void callAdmin(View view) {
//            //Toast.makeText(LandingActivity.this, "Work In Progress", Toast.LENGTH_SHORT).show();
//            Intent callCustomer = new Intent(LandingActivity.this, ComplaintBasic.class);
//            startActivity(callCustomer);
//        }

        public void callCustomer(View view) {
//            Intent callCustomer = new Intent(LandingActivity.this, MainActivity.class);
//            startActivity(callCustomer);

            Intent callCustomer = new Intent(LandingActivity.this, MainActivity.class);
            startActivity(callCustomer);
        }


        public void callOfficer(View view) {
//            Intent callOfficer = new Intent(LandingActivity.this, OfficerDashBoardActivity.class);
//            startActivity(callOfficer);

            Intent callOfficer = new Intent(LandingActivity.this, LoginActivity.class);
            startActivity(callOfficer);
        }
    }


    private void checkForUpdate() {
        int latestAppVersion = (int) mFirebaseRemoteConfig.getDouble(VERSION_CODE_KEY);
        if (latestAppVersion > getCurrentVersionCode()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Please Update the App");
            builder.setMessage("A new version of this app is available. Please update it.");
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(LandingActivity.this, "Take user to Google Play Store", Toast.LENGTH_SHORT).show();

                }
            });
            builder.setCancelable(false);
            builder.show();
        } else {
            Toast.makeText(this,"This app is already upto date", Toast.LENGTH_SHORT).show();
        }
    }

    private int getCurrentVersionCode() {
        try {
            return getPackageManager().getPackageInfo(getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return -1;
    }

}
