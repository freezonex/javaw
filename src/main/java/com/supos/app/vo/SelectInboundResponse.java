package com.supos.app.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.supos.app.entity.WmsMaterialTransaction;

import java.util.Date;

public class SelectInboundResponse {
    @JsonProperty("id")
    private long id;

    @JsonProperty("ref_id")
    private String refId; // 注意JSON属性名与proto中一致

    @JsonProperty("type")
    private String type;

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
        this.refId = wmsMaterialTransaction.getRf_id();
        this.type = wmsMaterialTransaction.getType();
        this.source = wmsMaterialTransaction.getSource();
        this.note = wmsMaterialTransaction.getNote();
        this.operator = wmsMaterialTransaction.getOperator();
        this.status = wmsMaterialTransaction.getStatus();
        this.createTime = wmsMaterialTransaction.getCreate_time();
        this.updateTime = wmsMaterialTransaction.getUpdate_time();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRefId() {
        return refId;
    }

    public void setRefId(String refId) {
        this.refId = refId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
