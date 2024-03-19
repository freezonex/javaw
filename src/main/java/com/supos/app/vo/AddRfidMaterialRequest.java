package com.supos.app.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddRfidMaterialRequest {
    private Long id;

    @JsonProperty("rfid")
    private String rfid;

    @JsonProperty("material_code")
    private String materialCode;


    public String getRfid() {
        return rfid;
    }

    public void setRfid(String rfid) {
        this.rfid = rfid;
    }

    public String getMaterialCode() {
        return materialCode;
    }

    public void setMaterialCode(String materialCode) {
        this.materialCode = materialCode;
    }

}
