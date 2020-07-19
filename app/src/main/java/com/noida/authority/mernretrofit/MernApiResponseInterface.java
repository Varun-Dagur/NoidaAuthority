package com.noida.authority.mernretrofit;

public interface MernApiResponseInterface {

    public void isServerError(String errorCode);

    public void isServerSuccess(Object response, int ServiceCode);
}
