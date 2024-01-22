package com.supos.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Map;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel(value="SuposApi",description="suposAPI对象")
public class SuposApi {

    @ApiModelProperty(value = "uri",required = true,example = "/open-api/organization/v2/persons")
    String uri;
    @ApiModelProperty(value = "methodName",required = true,example = "GET")
    String methodName;
    @ApiModelProperty(value = "queryJson",required = true,example = "NULL")
    Map<String, String> queryJson;
    @ApiModelProperty(value = "headerJson",required = true,example = "NULL")
    Map<String, String> headerJson;
    @ApiModelProperty(value = "ak",required = true,example = "415ed3fc72b533713244dcd553159642")
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

    @ApiModelProperty(value = "sk",required = true,example = "10999785ab1c5f475c6d9c8b728e28a3")
    String sk;
}
