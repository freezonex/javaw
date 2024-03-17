package com.supos.app.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InboundRecordDetailRequest {

    @JsonProperty("inbound_id")
    private long inboundId;
    @JsonProperty("ref_id")
    private String rfid;

    public String getRfid() {
        return rfid;
    }

    public void setRfid(String rfid) {
        this.rfid = rfid;
    }

    public long getInboundId() {
        return inboundId;
    }

    public void setInboundId(long inboundId) {
        this.inboundId = inboundId;
    }
}
