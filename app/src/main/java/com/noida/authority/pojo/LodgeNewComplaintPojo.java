package com.noida.authority.pojo;

import java.io.Serializable;

public class LodgeNewComplaintPojo implements Serializable {

    int deptId, complaintId;
    String complaintMessage, allotteeName, allotteeMobile, allotteeEmail,
            allotteeCommAddress, sectorName, village, plotNo, address, location;

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public int getComplaintId() {
        return complaintId;
    }

    public void setComplaintId(int complaintId) {
        this.complaintId = complaintId;
    }

    public String getComplaintMessage() {
        return complaintMessage;
    }

    public void setComplaintMessage(String complaintMessage) {
        this.complaintMessage = complaintMessage;
    }

    public String getAllotteeName() {
        return allotteeName;
    }

    public void setAllotteeName(String allotteeName) {
        this.allotteeName = allotteeName;
    }

    public String getAllotteeMobile() {
        return allotteeMobile;
    }

    public void setAllotteeMobile(String allotteeMobile) {
        this.allotteeMobile = allotteeMobile;
    }

    public String getAllotteeEmail() {
        return allotteeEmail;
    }

    public void setAllotteeEmail(String allotteeEmail) {
        this.allotteeEmail = allotteeEmail;
    }

    public String getAllotteeCommAddress() {
        return allotteeCommAddress;
    }

    public void setAllotteeCommAddress(String allotteeCommAddress) {
        this.allotteeCommAddress = allotteeCommAddress;
    }

    public String getSectorName() {
        return sectorName;
    }

    public void setSectorName(String sectorName) {
        this.sectorName = sectorName;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getPlotNo() {
        return plotNo;
    }

    public void setPlotNo(String plotNo) {
        this.plotNo = plotNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
