package com.noida.authority.response_model;

public class LoginResponse {

    String UserName, Mobile,Message;
    int UserRefId;

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }

    public int getUserRefId() {
        return UserRefId;
    }

    public void setUserRefId(int userRefId) {
        UserRefId = userRefId;
    }
}
