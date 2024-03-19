package com.supos.app.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetStocktakingRequest {
    @JsonProperty("id")
    private Long ID;

    @JsonProperty("ref_id")
    private String Rfid;

    @JsonProperty("type")
    private String Type;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getRfid() {
        return Rfid;
    }

    public void setRfid(String rfid) {
        Rfid = rfid;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }
}
