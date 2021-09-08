package com.sac.foodorder.enums;

/**
 * @author Sachith Harshamal
 */
public enum Response {

    SUCCESS(1, "Success"),
    FAILED(2, "Failed"),
    INSUFFICIENT_DETAILS(3, "Every fields require to proceed!"),
    INVALID_EMAIL(4, "Invalid email address, enter valid email address!"),
    AVAILABLE_USERNAME(5, "Username available, try another username!"),
    AVAILABLE_EMAIL(6, "This email has already registered, try to login or reset password!");

    private final int responseCode;
    private final String responseMessage;

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
