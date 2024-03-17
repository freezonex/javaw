package com.supos.app.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OutboundRecordDetailRequest {

    @JsonProperty("outbound_id")
    private Long outboundId;
    @JsonProperty("ref_id")
    private String rfid;

    public Long getOutboundId() {
        return outboundId;
    }

    public void setOutboundId(Long outboundId) {
        this.outboundId = outboundId;
    }

    public String getRfid() {
        return rfid;
    }

    public void setRfid(String rfid) {
        this.rfid = rfid;
    }
}
