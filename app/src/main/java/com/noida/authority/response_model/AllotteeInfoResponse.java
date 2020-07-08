package com.noida.authority.response_model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;

import com.noida.authority.body_model.PropertyResponse;


public class AllotteeInfoResponse extends BaseObservable {

    String registration_id;
    PropertyResponse propertyResponse;

    @Bindable
    public String getRegistration_id() {
        return registration_id;
    }


    public void setRegistration_id(String registration_id) {
        this.registration_id = registration_id;

        notifyPropertyChanged(BR.registration_id);
    }

    public void setResponse(PropertyResponse propertyResponse) {

        this.propertyResponse = propertyResponse;
    }
}
