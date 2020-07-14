package com.noida.authority.response_model;

public class ServiceTimeLineModel {
    
    int TotalReceived;
    int WithDrawn ;
    int CompletedWithinTime ;
    int CompletedBeyondTime ;
    int PendingWithTime ;

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

    public int getDepartmentId() {
        return DepartmentId;
    }

    public void setDepartmentId(int departmentId) {
        DepartmentId = departmentId;
    }

    public String getServiceName() {
        return ServiceName;
    }

    public void setServiceName(String serviceName) {
        ServiceName = serviceName;
    }

    public int getServiceId() {
        return ServiceId;
    }

    public void setServiceId(int serviceId) {
        ServiceId = serviceId;
    }

    public int getRequestId() {
        return RequestId;
    }

    public void setRequestId(int requestId) {
        RequestId = requestId;
    }

    public int getActionTypeId() {
        return ActionTypeId;
    }

    public void setActionTypeId(int actionTypeId) {
        ActionTypeId = actionTypeId;
    }

    public int getTotalCompleted() {
        return TotalCompleted;
    }

    public void setTotalCompleted(int totalCompleted) {
        TotalCompleted = totalCompleted;
    }

    public int getTotalPending() {
        return TotalPending;
    }

    public void setTotalPending(int totalPending) {
        TotalPending = totalPending;
    }

    int PendingMoreThanWeek ;
    int PendingMoreThanFortNight ;
    int PendingMoreThanOneMonth ;
    int TotalReject ;
    int TotalObjection;
    int Total ;
    int AverageProcessingTime ;
    int AverageDelaytime ;
    int DepartmentId ;
    String ServiceName;
    int ServiceId ;
    int RequestId ;
    int ActionTypeId ;
    int TotalCompleted ;
    int TotalPending ;

    public int getTotalReceived() {
        return TotalReceived;
    }

    public void setTotalReceived(int totalReceived) {
        TotalReceived = totalReceived;
    }
}
