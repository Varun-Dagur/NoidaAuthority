package com.noida.authority.activity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.noida.authority.R;
import com.noida.authority.utils.BaseActivity;

public class LodgeNewComplaint extends BaseActivity {

    private static final String[] sectorITEMS = {"Horticulture", "Sports", "Electrical", "Civil Engineering", "Land Management"};
    private static final String[] blockITEMS = {"Street Light", "Park Light not working", "Lift Maintenance", "NOIDA colony street light", "Water supply problem due to electricity"};
    private static final String[] genderITEMS = {"Sec 60", "Sec 61", "Sec 62", "Sec 63", "Sec 64"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lodge_new_complaint);
        setToolbarTitle("Lodge a New Complaint");


        Spinner sector_spinner = findViewById(R.id.sector_spinner);
        Spinner block_spinner = findViewById(R.id.block_spinner);
        Spinner spinner_gender = findViewById(R.id.spinner_gender);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, sectorITEMS);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<String> complainadapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, blockITEMS);
        complainadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<String> sectoradapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, genderITEMS);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        sector_spinner.setAdapter(adapter);
        block_spinner.setAdapter(complainadapter);
        spinner_gender.setAdapter(sectoradapter);







    }
}
