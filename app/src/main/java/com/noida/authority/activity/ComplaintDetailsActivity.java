package com.noida.authority.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.noida.authority.R;
import com.noida.authority.body_model.PropertyResponse;
import com.noida.authority.databinding.ActivityComplaintDetailsBinding;
import com.noida.authority.response_model.ComplaintResponse;
import com.noida.authority.utils.BaseActivity;

public class ComplaintDetailsActivity extends BaseActivity {

    TextView title;
    ImageView back_arrow;
    ActivityComplaintDetailsBinding complaintDetailsBinding;
    ComplaintResponse complaintResponse;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        complaintDetailsBinding = DataBindingUtil.setContentView(this, R.layout.activity_complaint_details);
        complaintDetailsBinding.setClickHandler(new EventHandler(this));
        complaintDetailsBinding.setActivity(this);
        setToolbarTitle("Complaint Details");

        if (getIntent().getExtras() != null) {

            if (getIntent().hasExtra("data")) {
                //if (getIntent().getExtras().getString("data").equalsIgnoreCase("data")) {

                    complaintResponse = (ComplaintResponse) getIntent().getSerializableExtra("data");
                    if (complaintResponse != null) {
                        complaintDetailsBinding.setComplaintDetail(complaintResponse);

              //      }
                }

            }
        }



    }

    public class EventHandler {
        Activity mContext;

        public EventHandler(Activity mContext) {
            this.mContext = mContext;
        }
    }

}
