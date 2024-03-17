package com.supos.app.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InboundRecordDetailRequest {

    @JsonProperty("inbound_id")
    private Long inboundId;
    @JsonProperty("ref_id")
    private String rfid;

    public String getRfid() {
        return rfid;
    }

    public void setRfid(String rfid) {
        this.rfid = rfid;
    }

    public Long getInboundId() {
        return inboundId;
    }

    public void setInboundId(Long inboundId) {
        this.inboundId = inboundId;
    }
}
