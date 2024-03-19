package com.supos.app.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import com.supos.app.vo.StorageLocationSelectAllMaterial;
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
    private String material_code;

    /**
     * 
     */
    private String type;

    /**
     * 
     */
    private String source;


    private Long stocktaking_id;
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

    List<StorageLocationSelectAllMaterial>Materials;


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


    public String getMaterial_code() {
        return material_code;
    }

    public void setMaterial_code(String material_code) {
        this.material_code = material_code;
    }

    public Long getStocktaking_id() {
        return stocktaking_id;
    }

    public void setStocktaking_id(Long stocktaking_id) {
        this.stocktaking_id = stocktaking_id;
    }

    public List<StorageLocationSelectAllMaterial> getMaterials() {
        return Materials;
    }

    public void setMaterials(List<StorageLocationSelectAllMaterial> materials) {
        Materials = materials;
    }
}