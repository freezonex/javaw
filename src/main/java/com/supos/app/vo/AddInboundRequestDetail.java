package com.supos.app.vo;

public class AddInboundRequestDetail {
    private String material_code;
    private Integer quantity;
    private Long wh_id;
    private Long stock_location_id;
    private String rf_id;

    public String getMaterial_code() {
        return material_code;
    }

    public void setMaterial_code(String material_code) {
        this.material_code = material_code;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Long getWh_id() {
        return wh_id;
    }

    public void setWh_id(Long wh_id) {
        this.wh_id = wh_id;
    }

    public Long getStock_location_id() {
        return stock_location_id;
    }

    public void setStock_location_id(Long stock_location_id) {
        this.stock_location_id = stock_location_id;
    }

    public String getRf_id() {
        return rf_id;
    }

    public void setRf_id(String rf_id) {
        this.rf_id = rf_id;
    }
}
