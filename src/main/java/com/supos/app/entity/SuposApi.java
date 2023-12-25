package com.supos.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.Map;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SuposApi {
    String uri;
    String methodName;
    Map<String, String> queryJson;
    Map<String, String> headerJson;
    String ak;

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getMethordName() {
        return methodName;
    }

    public void setMethordName(String methordName) {
        this.methodName = methordName;
    }

    public Map<String, String> getQueryJson() {
        return queryJson;
    }

    public void setQueryJson(Map<String, String> queryJson) {
        this.queryJson = queryJson;
    }

    public Map<String, String> getHeaderJson() {
        return headerJson;
    }

    public void setHeaderJson(Map<String, String> headerJson) {
        this.headerJson = headerJson;
    }

    public String getAk() {
        return ak;
    }

    public void setAk(String ak) {
        this.ak = ak;
    }

    public String getSk() {
        return sk;
    }

    public void setSk(String sk) {
        this.sk = sk;
    }

    String sk;
}
