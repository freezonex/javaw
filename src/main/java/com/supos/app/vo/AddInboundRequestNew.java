package com.supos.app.vo;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

public class AddInboundRequestNew {
    private String creator;
    private String purchase_order_no;
    private String supplier;
    private Date delivery_date;
    private String source;
    @JsonProperty("request_detail")
    private List<AddInboundRequestDetail> addInboundRequestDetail;

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getPurchase_order_no() {
        return purchase_order_no;
    }

    public void setPurchase_order_no(String purchase_order_no) {
        this.purchase_order_no = purchase_order_no;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public Date getDelivery_date() {
        return delivery_date;
    }

    public void setDelivery_date(Date delivery_date) {
        this.delivery_date = delivery_date;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public List<AddInboundRequestDetail> getAddInboundRequestDetail() {
        return addInboundRequestDetail;
    }

    public void setAddInboundRequestDetail(List<AddInboundRequestDetail> addInboundRequestDetail) {
        this.addInboundRequestDetail = addInboundRequestDetail;
    }
}
