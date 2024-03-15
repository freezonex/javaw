package com.supos.app.config;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BaseResponse {
    @JsonProperty("status_code")
    private int statusCode;
    @JsonProperty("status_message")
    private String statusMessage;

    public BaseResponse(int statusCode, String statusMessage) {
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }
}
