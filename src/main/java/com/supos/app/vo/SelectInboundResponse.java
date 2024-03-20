package com.supos.app.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.supos.app.entity.WmsMaterialTransaction;

import java.util.Date;

public class SelectInboundResponse {
    @JsonProperty("id")
    private long id;

    @JsonProperty("purchase_order_no")
    private String purchase_order_no;

    @JsonProperty("supplier")
    private String supplier;

    @JsonProperty("source")
    private String source;

    @JsonProperty("note")
    private String note;

    @JsonProperty("operator")
    private String operator;

    @JsonProperty("status")
    private String status;

    @JsonProperty("create_time")
    private Date createTime;

    @JsonProperty("update_time")
    private Date updateTime;

    // Getters and Setters

    public SelectInboundResponse(WmsMaterialTransaction wmsMaterialTransaction) {
        this.id = wmsMaterialTransaction.getInbound_id();
        this.purchase_order_no = wmsMaterialTransaction.getInbound_purchase_order_no();
        this.supplier = wmsMaterialTransaction.getInbound_supplier();
        this.source = wmsMaterialTransaction.getSource();
        this.note = wmsMaterialTransaction.getNote();
        this.operator = wmsMaterialTransaction.getInbound_creator();
        this.status = wmsMaterialTransaction.getInbound_status();
        this.createTime = wmsMaterialTransaction.getCreate_time();
        this.updateTime = wmsMaterialTransaction.getUpdate_time();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
