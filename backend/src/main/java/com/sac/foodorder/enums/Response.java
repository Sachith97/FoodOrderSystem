package com.sac.foodorder.enums;

public enum Response {

    SUCCESS(1, "Success"),
    FAILED(2, "Failed"),
    INSUFFICIENT_DETAILS(3, "Every fields require to proceed");

    private int responseCode;
    private String responseMessage;

    Response(int responseCode, String responseMessage) {
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
    }

    public int getResponseCode() {
        return this.responseCode;
    }

    public String getResponseMessage() {
        return this.responseMessage;
    }
}
