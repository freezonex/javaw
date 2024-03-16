package com.supos.app.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddRfidMaterialRequest {
    @JsonProperty("rfid")
    private String rfid;

    @JsonProperty("material_id")
    private long materialId;

    @JsonProperty("quantity")
    private int quantity;

    public String getRfid() {
        return rfid;
    }

    public void setRfid(String rfid) {
        this.rfid = rfid;
    }

    public long getMaterialId() {
        return materialId;
    }

    public void setMaterialId(long materialId) {
        this.materialId = materialId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
