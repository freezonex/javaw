package com.supos.app.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InboundRecordDetailRequest {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("ref_id")
    private String rfid;

    public String getRfid() {
        return rfid;
    }

    public void setRfid(String rfid) {
        this.rfid = rfid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
