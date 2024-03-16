package com.supos.app.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;

public class Inventory {
    @JsonProperty("rfid")
    private String rfid;

    @JsonProperty("material_id")
    private String materialId;

    @JsonProperty("quantity")
    private int quantity;

    @JsonProperty("material_name")
    private String materialName;

    @JsonProperty("stock_quantity")
    private int stockQuantity;

    @JsonProperty("discrepancy")
    private int discrepancy;

    // Getters and Setters

    public String getRfid() {
        return rfid;
    }

    public void setRfid(String rfid) {
        this.rfid = rfid;
    }

    public String getMaterialId() {
        return materialId;
    }

    public void setMaterialId(String materialId) {
        this.materialId = materialId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public int getDiscrepancy() {
        return discrepancy;
    }

    public void setDiscrepancy(int discrepancy) {
        this.discrepancy = discrepancy;
    }
}

