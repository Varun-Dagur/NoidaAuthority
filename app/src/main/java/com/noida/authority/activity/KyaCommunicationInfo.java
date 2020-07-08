package com.noida.authority.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.noida.authority.R;
import com.noida.authority.body_model.PropertyResponse;
import com.noida.authority.databinding.ActivityKyaCommunicationInfoBinding;
import com.noida.authority.pojo.KyaCommunication;
import com.noida.authority.utils.BaseActivity;

import static com.basgeekball.awesomevalidation.ValidationStyle.BASIC;

public class KyaCommunicationInfo extends BaseActivity {

    ActivityKyaCommunicationInfoBinding binding;
    PropertyResponse propertyResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_kya_communication_info);
        binding.setClickHandler(new EventHandler(this));

        if (getIntent().getExtras() != null) {

            if (getIntent().hasExtra("Type")) {

                if (getIntent().getExtras().getString("Type").equalsIgnoreCase("PropertyResponse")) {

                    propertyResponse = (PropertyResponse) getIntent().getSerializableExtra("data");
                    if (propertyResponse != null) {

                        binding.setKyaInfo(propertyResponse);

                    }
                }
            }
        }
    }

    public class EventHandler {
        Activity mContext;

        public EventHandler(Activity mContext) {
            this.mContext = mContext;
        }

        public void kyaCommunication(KyaCommunication kyaCommunication, PropertyResponse propertyResponse) {

            AwesomeValidation validation = new AwesomeValidation(BASIC);
            validation.addValidation(mContext, R.id.address_line1, "\\A(?!\\s*\\Z).+", R.string.address_error);
            validation.addValidation(mContext, R.id.area_locality, "\\A(?!\\s*\\Z).+", R.string.locality_error);
            validation.addValidation(mContext, R.id.state, "\\A(?!\\s*\\Z).+", R.string.state_error);
            validation.addValidation(mContext, R.id.pin_code, "[a-zA-Z0-9_-]+", R.string.pincode_error);

            if (validation.validate()) {
                Intent intent = new Intent(mContext, KyaDocumentUpload.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("data", propertyResponse);
                bundle.putSerializable("dataCommunication", kyaCommunication);
                intent.putExtra("Type", "PropertyResponse");
                intent.putExtras(bundle);

                mContext.startActivity(intent);
            }
        }

        public void kyaDocumentUpload(String id) {
            Toast.makeText(mContext, id + "Document upload", Toast.LENGTH_SHORT).show();

        }
    }
}
