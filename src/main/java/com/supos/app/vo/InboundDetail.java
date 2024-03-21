package com.supos.app.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.supos.app.entity.WmsMaterial;
import com.supos.app.entity.WmsMaterialTransaction;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName wms_material_transaction
 */
@Data
public class InboundDetail implements Serializable {
    public InboundDetail() {}

    public InboundDetail(WmsMaterialTransaction transaction, WmsMaterial material) {
        this.product_code = material.getProduct_code();
        this.name = material.getName();
        this.product_type = material.getProduct_type();
        this.unit = material.getUnit();
        this.note = material.getNote();
        this.specification = material.getSpecification();
        this.max = material.getMax();
        this.min = material.getMin();
        this.status = material.getStatus();
        this.expect_wh_id = material.getExpect_wh_id();
        this.expact_stock_location_id = material.getExpact_stock_location_id();
        this.quantity = transaction.getQuantity();
        this.id = transaction.getId();
        this.material_code = transaction.getMaterial_code();
        this.type = material.getProduct_type();
        this.source = transaction.getSource();
        this.inbound_id = transaction.getInbound_id();
        this.stocktaking_id = transaction.getStocktaking_id();
        this.outbound_id = transaction.getOutbound_id();
        this.warehouse_id = transaction.getWarehouse_id();
        this.stock_location_id = transaction.getStock_location_id();
        this.rf_id = transaction.getRf_id();
        this.operator = transaction.getOperator();
        this.inbound_status = transaction.getInbound_status();
        this.outbound_status = transaction.getOutbound_status();
        this.inbound_creator = transaction.getInbound_creator();
        this.outbound_creator = transaction.getOutbound_creator();
        this.inbound_purchase_order_no = transaction.getInbound_purchase_order_no();
        this.outbound_purchase_order_no = transaction.getOutbound_purchase_order_no();
        this.inbound_supplier = transaction.getInbound_supplier();
        this.outbound_supplier = transaction.getOutbound_supplier();
        this.inbound_delivery_date = transaction.getInbound_delivery_date();
        this.outbound_delivery_date = transaction.getOutbound_delivery_date();
        this.del_flag = transaction.getDel_flag();
        this.update_time = transaction.getUpdate_time();
        this.create_time = transaction.getCreate_time();
    }

    private String product_code;


    /**
     *
     */
    private String name;

    /**
     *
     */
    private String product_type;

    /**
     *
     */
    private String unit;

    /**
     *
     */

    /**
     *
     */
    private String specification;

    /**
     *
     */
    private Long max;

    /**
     *
     */
    private Long min;

    /**
     *
     */
    private String status;

    /**
     *
     */
    private Long expect_wh_id;

    /**
     *
     */
    private Long expact_stock_location_id;

    private int quantity;

    /**
     * 
     */
    @JsonIgnore
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

    /**
     * 
     */
    private Long inbound_id;

    /**
     * 
     */
    private Long stocktaking_id;

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
    private String inbound_status;
    private String outbound_status;


    /**
     * 
     */
    private String note;

    /**
     * 
     */
    private String inbound_creator;

    /**
     * 
     */
    private String outbound_creator;

    /**
     * 
     */
    private String inbound_purchase_order_no;

    /**
     * 
     */
    private String outbound_purchase_order_no;

    /**
     * 
     */
    private String inbound_supplier;

    /**
     * 
     */
    private String outbound_supplier;

    /**
     * 
     */
    private Date inbound_delivery_date;

    /**
     * 
     */
    private Date outbound_delivery_date;
    /**
     * 
     */
    private Integer del_flag;

    /**
     * 
     */
    private Date update_time;

    /**
     * 
     */
    private Date create_time;

    private static final long serialVersionUID = 1L;


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

    public String getMaterial_code() {
        return material_code;
    }

    public void setMaterial_code(String material_code) {
        this.material_code = material_code;
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

    public Long getStocktaking_id() {
        return stocktaking_id;
    }

    public void setStocktaking_id(Long stocktaking_id) {
        this.stocktaking_id = stocktaking_id;
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


    public String getInbound_status() {
        return inbound_status;
    }

    public void setInbound_status(String inbound_status) {
        this.inbound_status = inbound_status;
    }

    public String getOutbound_status() {
        return outbound_status;
    }

    public void setOutbound_status(String outbound_status) {
        this.outbound_status = outbound_status;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getInbound_creator() {
        return inbound_creator;
    }

    public void setInbound_creator(String inbound_creator) {
        this.inbound_creator = inbound_creator;
    }

    public String getOutbound_creator() {
        return outbound_creator;
    }

    public void setOutbound_creator(String outbound_creator) {
        this.outbound_creator = outbound_creator;
    }

    public String getInbound_purchase_order_no() {
        return inbound_purchase_order_no;
    }

    public void setInbound_purchase_order_no(String inbound_purchase_order_no) {
        this.inbound_purchase_order_no = inbound_purchase_order_no;
    }

    public String getOutbound_purchase_order_no() {
        return outbound_purchase_order_no;
    }

    public void setOutbound_purchase_order_no(String outbound_purchase_order_no) {
        this.outbound_purchase_order_no = outbound_purchase_order_no;
    }

    public String getInbound_supplier() {
        return inbound_supplier;
    }

    public void setInbound_supplier(String inbound_supplier) {
        this.inbound_supplier = inbound_supplier;
    }

    public String getOutbound_supplier() {
        return outbound_supplier;
    }

    public void setOutbound_supplier(String outbound_supplier) {
        this.outbound_supplier = outbound_supplier;
    }

    public Date getInbound_delivery_date() {
        return inbound_delivery_date;
    }

    public void setInbound_delivery_date(Date inbound_delivery_date) {
        this.inbound_delivery_date = inbound_delivery_date;
    }

    public Date getOutbound_delivery_date() {
        return outbound_delivery_date;
    }

    public void setOutbound_delivery_date(Date outbound_delivery_date) {
        this.outbound_delivery_date = outbound_delivery_date;
    }

    public Integer getDel_flag() {
        return del_flag;
    }

    public void setDel_flag(Integer del_flag) {
        this.del_flag = del_flag;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public String getProduct_code() {
        return product_code;
    }

    public void setProduct_code(String product_code) {
        this.product_code = product_code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProduct_type() {
        return product_type;
    }

    public void setProduct_type(String product_type) {
        this.product_type = product_type;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public Long getMax() {
        return max;
    }

    public void setMax(Long max) {
        this.max = max;
    }

    public Long getMin() {
        return min;
    }

    public void setMin(Long min) {
        this.min = min;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getExpect_wh_id() {
        return expect_wh_id;
    }

    public void setExpect_wh_id(Long expect_wh_id) {
        this.expect_wh_id = expect_wh_id;
    }

    public Long getExpact_stock_location_id() {
        return expact_stock_location_id;
    }

    public void setExpact_stock_location_id(Long expact_stock_location_id) {
        this.expact_stock_location_id = expact_stock_location_id;
    }
}