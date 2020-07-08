package com.noida.authority.pojo;

import java.io.Serializable;

public class KyaCommunication implements Serializable {

    String addressline1, addressline2, area, state;
    String pincode;

    public String getAddressline1() {
        return addressline1;
    }

    public String getAddressline2() {
        return addressline2;
    }

    public String getArea() {
        return area;
    }

    public String getState() {
        return state;
    }

    public String getPincode() {
        return pincode;
    }

    public void setAddressline1(String addressline1) {
        this.addressline1 = addressline1;
    }

    public void setAddressline2(String addressline2) {
        this.addressline2 = addressline2;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

}
