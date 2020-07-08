package com.noida.authority.response_model;

public class ServiceReportResponse {

    public int getTotalReceived() {
        return TotalReceived;
    }

    public void setTotalReceived(int totalReceived) {
        TotalReceived = totalReceived;
    }

    public int getWithDrawn() {
        return WithDrawn;
    }

    public void setWithDrawn(int withDrawn) {
        WithDrawn = withDrawn;
    }

    public int getCompletedWithinTime() {
        return CompletedWithinTime;
    }

    public void setCompletedWithinTime(int completedWithinTime) {
        CompletedWithinTime = completedWithinTime;
    }

    public int getCompletedBeyondTime() {
        return CompletedBeyondTime;
    }

    public void setCompletedBeyondTime(int completedBeyondTime) {
        CompletedBeyondTime = completedBeyondTime;
    }

    public int getPendingWithTime() {
        return PendingWithTime;
    }

    public void setPendingWithTime(int pendingWithTime) {
        PendingWithTime = pendingWithTime;
    }

    public int getPendingMoreThanWeek() {
        return PendingMoreThanWeek;
    }

    public void setPendingMoreThanWeek(int pendingMoreThanWeek) {
        PendingMoreThanWeek = pendingMoreThanWeek;
    }

    public int getPendingMoreThanFortNight() {
        return PendingMoreThanFortNight;
    }

    public void setPendingMoreThanFortNight(int pendingMoreThanFortNight) {
        PendingMoreThanFortNight = pendingMoreThanFortNight;
    }

    public int getPendingMoreThanOneMonth() {
        return PendingMoreThanOneMonth;
    }

    public void setPendingMoreThanOneMonth(int pendingMoreThanOneMonth) {
        PendingMoreThanOneMonth = pendingMoreThanOneMonth;
    }

    public int getTotalReject() {
        return TotalReject;
    }

    public void setTotalReject(int totalReject) {
        TotalReject = totalReject;
    }

    public int getTotalObjection() {
        return TotalObjection;
    }

    public void setTotalObjection(int totalObjection) {
        TotalObjection = totalObjection;
    }

    public int getTotal() {
        return Total;
    }

    public void setTotal(int total) {
        Total = total;
    }

    public int getAverageProcessingTime() {
        return AverageProcessingTime;
    }

    public void setAverageProcessingTime(int averageProcessingTime) {
        AverageProcessingTime = averageProcessingTime;
    }

    public int getAverageDelaytime() {
        return AverageDelaytime;
    }

    public void setAverageDelaytime(int averageDelaytime) {
        AverageDelaytime = averageDelaytime;
    }

    int TotalReceived,
            WithDrawn, CompletedWithinTime, CompletedBeyondTime, PendingWithTime, PendingMoreThanWeek,
            PendingMoreThanFortNight,
            PendingMoreThanOneMonth,
            TotalReject,
            TotalObjection,
            Total,
            AverageProcessingTime,
            AverageDelaytime,DepartmentId;

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }

    String Department;




    public int getDepartmentId() {
        return DepartmentId;
    }

    public void setDepartmentId(int departmentId) {
        DepartmentId = departmentId;
    }


}
