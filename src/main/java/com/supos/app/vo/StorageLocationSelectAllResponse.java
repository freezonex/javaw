package com.supos.app.vo;

import com.supos.app.entity.WmsStorageLocation;

import java.util.Date;
import java.util.List;

public class StorageLocationSelectAllResponse {
    public StorageLocationSelectAllResponse(WmsStorageLocation wmsStorageLocation) {
        this.id = wmsStorageLocation.getId();
        this.warehouse_id = wmsStorageLocation.getWarehouse_id();
        this.name = wmsStorageLocation.getName();
        this.occupied = wmsStorageLocation.getOccupied();
        this.del_flag = wmsStorageLocation.getDel_flag();
        this.update_time = wmsStorageLocation.getUpdate_time();
        this.create_time = wmsStorageLocation.getCreate_time();
    }

    private Long id;

    /**
     *
     */
    private Long warehouse_id;

    /**
     *
     */
    private String name;

    /**
     *
     */
    private Boolean occupied;

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

    List<StorageLocationSelectAllMaterial> materials;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getWarehouse_id() {
        return warehouse_id;
    }

    public void setWarehouse_id(Long warehouse_id) {
        this.warehouse_id = warehouse_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getOccupied() {
        return occupied;
    }

    public void setOccupied(Boolean occupied) {
        this.occupied = occupied;
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

    public List<StorageLocationSelectAllMaterial> getMaterials() {
        return materials;
    }

    public void setMaterials(List<StorageLocationSelectAllMaterial> materials) {
        this.materials = materials;
    }

}
