package com.supos.app.vo;

import com.supos.app.entity.WmsMaterial;
import com.supos.app.entity.WmsStorageLocation;

import java.util.Date;
import java.util.List;

public class MaterialSelectAllResponse {
    /**
     *
     */
    private Long id;

    /**
     *
     */
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
    private String note;

    /**
     *
     */
    private Boolean del_flag;

    /**
     *
     */
    private Date create_time;

    /**
     *
     */
    private Date update_time;

    List<String> storage_location_id;
    List<String> storage_location;

    private static final long serialVersionUID = 1L;

    public MaterialSelectAllResponse(WmsMaterial material) {
        this.id = material.getId();
        this.product_code = material.getProduct_code();
        this.name = material.getName();
        this.product_type = material.getProduct_type();
        this.unit = material.getUnit();
        this.note = material.getNote();
        this.del_flag = material.getDel_flag();
        this.create_time = material.getCreate_time();
        this.update_time = material.getUpdate_time();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Boolean getDel_flag() {
        return del_flag;
    }

    public void setDel_flag(Boolean del_flag) {
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

    public List<String> getStorage_location_id() {
        return storage_location_id;
    }

    public void setStorage_location_id(List<String> storage_location_id) {
        this.storage_location_id = storage_location_id;
    }

    public List<String> getStorage_location() {
        return storage_location;
    }

    public void setStorage_location(List<String> storage_location) {
        this.storage_location = storage_location;
    }
}
