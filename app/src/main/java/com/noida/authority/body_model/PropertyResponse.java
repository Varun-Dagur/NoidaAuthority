package com.noida.authority.body_model;

import java.io.Serializable;

public class PropertyResponse implements Serializable{

    private String RegistrationId;
    private String Department;
    private String SectorName;
    private String BlockName;
    private String PlotNo;
    private String Applicant;
    private String ApplicantAddress;
    private String MobileNo;
    private String EmailId;
    private String PanNumber;
    private Float TotalArea;
    private String gender;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRegistrationId() {
        return RegistrationId;
    }

    public String getPanNumber() {
        return PanNumber;
    }

    public void setEmailId(String emailId) {
        EmailId = emailId;
    }

    public void setPanNumber(String panNumber) {
        PanNumber = panNumber;
    }

    public String getDepartment() {
        return Department;
    }

    public String getSectorName() {
        return SectorName;
    }

    public String getBlockName() {
        return BlockName;
    }

    public String getPlotNo() {
        return PlotNo;
    }

    public String getApplicant() {
        return Applicant;
    }

    public String getApplicantAddress() {
        return ApplicantAddress;
    }

    public String getMobileNo() {
        return MobileNo;
    }

    public Float getTotalArea() {
        return TotalArea;
    }

    public String getEmailId() {
        return EmailId;
    }


    public void setRegistrationId(String registrationId) {
        RegistrationId = registrationId;
    }

    public void setDepartment(String department) {
        Department = department;
    }

    public void setSectorName(String sectorName) {
        SectorName = sectorName;
    }

    public void setBlockName(String blockName) {
        BlockName = blockName;
    }

    public void setPlotNo(String plotNo) {
        PlotNo = plotNo;
    }

    public void setApplicant(String applicant) {
        Applicant = applicant;
    }

    public void setApplicantAddress(String applicantAddress) {
        ApplicantAddress = applicantAddress;
    }

    public void setMobileNo(String mobileNo) {
        MobileNo = mobileNo;
    }

    public void setTotalArea(Float totalArea) {
        TotalArea = totalArea;
    }
}
