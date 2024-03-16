package com.supos.app.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName wms_material_transaction
 */
@Data
public class WmsMaterialTransaction implements Serializable {
    private int quantity;

    /**
     * 
     */
    private Long id;

    /**
     * 
     */
    private Long material_id;

    /**
     * 
     */
    private String type;

    /**
     * 
     */
    private String source;

    /**
     * 
     */
    private Long inbound_id;

    /**
     * 
     */
    private Long outbound_id;

    /**
     * 
     */
    private Long warehouse_id;

    /**
     * 
     */
    private Long stock_location_id;

    /**
     * 
     */
    private String rf_id;

    /**
     * 
     */
    private String operator;

    /**
     * 
     */
    private String status;

    /**
     * 
     */
    private String note;

    /**
     * 
     */
    private Integer del_flag;

    /**
     * 
     */
    private Date create_time;

    /**
     * 
     */
    private Date update_time;

    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        WmsMaterialTransaction other = (WmsMaterialTransaction) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getMaterial_id() == null ? other.getMaterial_id() == null : this.getMaterial_id().equals(other.getMaterial_id()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getSource() == null ? other.getSource() == null : this.getSource().equals(other.getSource()))
            && (this.getInbound_id() == null ? other.getInbound_id() == null : this.getInbound_id().equals(other.getInbound_id()))
            && (this.getOutbound_id() == null ? other.getOutbound_id() == null : this.getOutbound_id().equals(other.getOutbound_id()))
            && (this.getWarehouse_id() == null ? other.getWarehouse_id() == null : this.getWarehouse_id().equals(other.getWarehouse_id()))
            && (this.getStock_location_id() == null ? other.getStock_location_id() == null : this.getStock_location_id().equals(other.getStock_location_id()))
            && (this.getRf_id() == null ? other.getRf_id() == null : this.getRf_id().equals(other.getRf_id()))
            && (this.getOperator() == null ? other.getOperator() == null : this.getOperator().equals(other.getOperator()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getNote() == null ? other.getNote() == null : this.getNote().equals(other.getNote()))
            && (this.getDel_flag() == null ? other.getDel_flag() == null : this.getDel_flag().equals(other.getDel_flag()))
            && (this.getCreate_time() == null ? other.getCreate_time() == null : this.getCreate_time().equals(other.getCreate_time()))
            && (this.getUpdate_time() == null ? other.getUpdate_time() == null : this.getUpdate_time().equals(other.getUpdate_time()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getMaterial_id() == null) ? 0 : getMaterial_id().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getSource() == null) ? 0 : getSource().hashCode());
        result = prime * result + ((getInbound_id() == null) ? 0 : getInbound_id().hashCode());
        result = prime * result + ((getOutbound_id() == null) ? 0 : getOutbound_id().hashCode());
        result = prime * result + ((getWarehouse_id() == null) ? 0 : getWarehouse_id().hashCode());
        result = prime * result + ((getStock_location_id() == null) ? 0 : getStock_location_id().hashCode());
        result = prime * result + ((getRf_id() == null) ? 0 : getRf_id().hashCode());
        result = prime * result + ((getOperator() == null) ? 0 : getOperator().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getNote() == null) ? 0 : getNote().hashCode());
        result = prime * result + ((getDel_flag() == null) ? 0 : getDel_flag().hashCode());
        result = prime * result + ((getCreate_time() == null) ? 0 : getCreate_time().hashCode());
        result = prime * result + ((getUpdate_time() == null) ? 0 : getUpdate_time().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", material_id=").append(material_id);
        sb.append(", type=").append(type);
        sb.append(", source=").append(source);
        sb.append(", inbound_id=").append(inbound_id);
        sb.append(", outbound_id=").append(outbound_id);
        sb.append(", warehouse_id=").append(warehouse_id);
        sb.append(", stock_location_id=").append(stock_location_id);
        sb.append(", rf_id=").append(rf_id);
        sb.append(", operator=").append(operator);
        sb.append(", status=").append(status);
        sb.append(", note=").append(note);
        sb.append(", del_flag=").append(del_flag);
        sb.append(", create_time=").append(create_time);
        sb.append(", update_time=").append(update_time);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getInbound_id() {
        return inbound_id;
    }

    public void setInbound_id(Long inbound_id) {
        this.inbound_id = inbound_id;
    }

    public Long getOutbound_id() {
        return outbound_id;
    }

    public void setOutbound_id(Long outbound_id) {
        this.outbound_id = outbound_id;
    }

    public Long getWarehouse_id() {
        return warehouse_id;
    }

    public void setWarehouse_id(Long warehouse_id) {
        this.warehouse_id = warehouse_id;
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getDel_flag() {
        return del_flag;
    }

    public void setDel_flag(Integer del_flag) {
        this.del_flag = del_flag;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public Long getMaterial_id() {
        return material_id;
    }

    public void setMaterial_id(Long material_id) {
        this.material_id = material_id;
    }
}