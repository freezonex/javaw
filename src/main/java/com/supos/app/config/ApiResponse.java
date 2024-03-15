package com.supos.app.config;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ApiResponse<T> {
    @JsonProperty("base_resp")
    private BaseResponse baseResp;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String errorMessage;

    public ApiResponse(T data) {
        this.baseResp = new BaseResponse(200, "OK");
        this.data = data;
    }

    public ApiResponse(T data, String errorMessage) {
        this.baseResp = new BaseResponse(500, "Error");
        this.data = data;
        this.errorMessage = errorMessage;
    }

    public BaseResponse getBaseResp() {
        return baseResp;
    }

    public void setBaseResp(BaseResponse baseResp) {
        this.baseResp = baseResp;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
