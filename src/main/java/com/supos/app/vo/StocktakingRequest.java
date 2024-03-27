package com.supos.app.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.supos.app.entity.WmsMaterialTransaction;

import java.util.Date;
import java.util.Optional;

public class StocktakingRequest {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("ref_id")
    private String refId;

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

    public StocktakingRequest(WmsMaterialTransaction transaction) {
        this.id = Optional.ofNullable(transaction.getStocktaking_id()).orElse(0L);
        this.refId = transaction.getRf_id();
        this.type = "Dynamic";
        this.source = transaction.getSource();
        this.note = transaction.getNote();
        this.operator = transaction.getOperator();
        this.status = "Done";
        this.createTime = transaction.getCreate_time();
        this.updateTime = transaction.getUpdate_time();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
