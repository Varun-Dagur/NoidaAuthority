package com.noida.authority.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.databinding.DataBindingUtil;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.noida.authority.R;
import com.noida.authority.body_model.PropertyResponse;
import com.noida.authority.databinding.ActivityKyaAllotteeInfoBinding;
import com.noida.authority.utils.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class KyaAllotteeInfo extends BaseActivity {

    Spinner spinner_gender; //, spinner_sector, spinner_block, spinner_plot_flat;
    List<String> genderList;
    ActivityKyaAllotteeInfoBinding binding;
    PropertyResponse propertyResponse;
    String genderValue = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_kya_allottee_info);
        binding.setClickHandler(new EventHandler(this));


        if (getIntent().getExtras() != null) {

            if (getIntent().hasExtra("Type")) {

                if (getIntent().getExtras().getString("Type").equalsIgnoreCase("WithData")) {

                    propertyResponse = (PropertyResponse) getIntent().getSerializableExtra("data");
                    if (propertyResponse != null) {
                        binding.setKyaInfo(propertyResponse);

                    }
                }

                spinner_gender = findViewById(R.id.spinner_gender);
                genderList = new ArrayList<>();
                genderList.add("M");
                genderList.add("F");
                genderList.add("O");

                ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.spinner_textview, genderList);
                spinner_gender.setAdapter(adapter);

                callGenderValue(spinner_gender.getSelectedItem().toString());


                spinner_gender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        genderValue = parent.getSelectedItem().toString();
                        callGenderValue(genderValue);

                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                        callGenderValue(parent.getSelectedItem().toString());

                    }
                });
            }
        }
    }

    private void callGenderValue(String genderValue) {
        PropertyResponse propertyResponse = new PropertyResponse();
        propertyResponse.setGender(genderValue);
        binding.setGender(propertyResponse);
    }

    public class EventHandler {
        Activity mContext;

        public EventHandler(Activity mContext) {
            this.mContext = mContext;
        }

        public void allotteInfoNext(PropertyResponse propertyResponse, String gender) {

            AwesomeValidation validation = new AwesomeValidation(ValidationStyle.BASIC);
            validation.addValidation(mContext, R.id.email_id, Patterns.EMAIL_ADDRESS, R.string.email_error);
            validation.addValidation(mContext, R.id.pan_number, "[a-zA-Z0-9_-]+", R.string.pan_error);

            if (validation.validate()) {
                propertyResponse.setGender(gender);
                Intent intent = new Intent(mContext, KyaCommunicationInfo.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("data", propertyResponse);
                intent.putExtra("Type", "PropertyResponse");
                intent.putExtras(bundle);
                mContext.startActivity(intent);
            }
        }
    }
}