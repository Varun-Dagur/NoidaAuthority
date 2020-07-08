package com.noida.authority.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.noida.authority.R;
import com.noida.authority.body_model.PropertyResponse;
import com.noida.authority.databinding.ActivitySearchBinding;
import com.noida.authority.response_model.BlockResponse;
import com.noida.authority.response_model.SectorResponse;
import com.noida.authority.retrofit.ApiManager;
import com.noida.authority.retrofit.ApiResponseInterface;
import com.noida.authority.utils.BaseActivity;
import com.noida.authority.utils.Constants;

import java.util.ArrayList;
import java.util.List;

import static com.basgeekball.awesomevalidation.ValidationStyle.BASIC;
import static com.noida.authority.activity.LoginActivity.token;

public class SearchActivity extends BaseActivity implements ApiResponseInterface {

    RadioGroup searchByGroup;
    ApiManager apiManager;
    List<SectorResponse> sectorList;
    List<BlockResponse> blockList;
    ActivitySearchBinding searchBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        searchBinding = DataBindingUtil.setContentView(this, R.layout.activity_search);
        searchBinding.setClickListener(new EventHandler(this));
        searchBinding.setActivity(this);
        setToolbarTitle("KYA Form");


        searchByGroup = findViewById(R.id.search_by_group);
        searchByGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (group.getCheckedRadioButtonId() == R.id.search_reg_id) {
                    searchBinding.propertyContainer.setVisibility(View.GONE);
                    searchBinding.registerContainer.setVisibility(View.VISIBLE);

                } else {
                    searchBinding.propertyContainer.setVisibility(View.VISIBLE);
                    searchBinding.registerContainer.setVisibility(View.GONE);
                }
            }
        });

        apiManager = new ApiManager(this, this);
        apiManager.getBlockList(token);
        apiManager.getSectorList(token);
    }

    @Override
    public void isError(String errorCode) {
        Toast.makeText(this, errorCode, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void isSuccess(Object response, int ServiceCode) {
        if (ServiceCode == Constants.GET_BLOCK) {
            blockList = (List<BlockResponse>) response;
            setBlockList(blockList);

        } else if (ServiceCode == Constants.GET_SECTOR) {
            sectorList = (List<SectorResponse>) response;
            setSectorList(sectorList);

        } else if (ServiceCode == Constants.SEARCH_KYA_WITH_RegId) {
            PropertyResponse propertyResponse = (PropertyResponse) response;
            sendDataIntent(propertyResponse);

        } else if (ServiceCode == Constants.SEARCH_KYA_PROPERTY) {
            PropertyResponse propertyResponse = (PropertyResponse) response;
            sendDataIntent(propertyResponse);
        }
    }

    void sendDataIntent(PropertyResponse response) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("data", response);

        Intent intent = new Intent(SearchActivity.this, KyaAllotteeInfo.class);
        intent.putExtra("Type", "WithData");

        intent.putExtras(bundle);
        startActivity(intent);
    }

    void setBlockList(List<BlockResponse> blockList) {
        List<String> blockNames = new ArrayList<>();
        for (int i = 0; i < this.blockList.size(); i++) {
            blockNames.add(this.blockList.get(i).getText());
        }

        searchBinding.setBlockList(blockNames);
    }

    void setSectorList(List<SectorResponse> sectorList) {
        List<String> sectorNames = new ArrayList<>();
        for (int i = 0; i < this.sectorList.size(); i++) {
            sectorNames.add(this.sectorList.get(i).getText());
        }

        searchBinding.setSectorList(sectorNames);
    }

    public class EventHandler {
        Context mContext;

        public EventHandler(Context mContext) {
            this.mContext = mContext;
        }

        public void searchProperty() {
            AwesomeValidation validation = new AwesomeValidation(BASIC);

            if (searchByGroup.getCheckedRadioButtonId() == R.id.search_reg_id) {
                validation.addValidation(SearchActivity.this, R.id.edtRegisterId, "[a-zA-Z0-9_-]+", R.string.registration_id_error);

                if (validation.validate()) {
                    apiManager.searchKyaByRegId("Bearer " + token, searchBinding.edtRegisterId.getText().toString());
                }

            } else {
                validation.addValidation(SearchActivity.this, R.id.plot_flat_ed, "\\A(?!\\s*\\Z).+", R.string.plot_flat_error);

                if (validation.validate()) {
                    apiManager.searchKyaByProperty("Bearer " + token, searchBinding.sectorSpinner.getSelectedItem().toString()
                            , searchBinding.blockSpinner.getSelectedItem().toString()
                            , searchBinding.plotFlatEd.getText().toString());
                }
            }
        }
    }
}