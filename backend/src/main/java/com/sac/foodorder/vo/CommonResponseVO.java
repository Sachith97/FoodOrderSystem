package com.sac.foodorder.vo;

import com.sac.foodorder.enums.Response;

public class CommonResponseVO {

    private int responseCode;
    private String responseMessage;

    public CommonResponseVO() {
    }

    public CommonResponseVO(Response response) {
        this.responseCode = response.getResponseCode();
        this.responseMessage = response.getResponseMessage();
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }
}
