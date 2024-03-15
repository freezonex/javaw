package com.supos.app.vo;

import com.supos.app.entity.WmsStorageLocation;

import java.util.Date;
import java.util.List;

public class WarehouseSelectAllResponse {
    /**
     *
     */
    private Long id;

    /**
     *
     */
    private String warehouse_id;

    /**
     *
     */
    private String name;

    /**
     *
     */
    private String type;

    /**
     *
     */
    private String manager;

    /**
     *
     */
    private String department;

    /**
     *
     */
    private String email;

    /**
     *
     */
    private String project_group;

    /**
     *
     */
    private String note;

    private List<WmsStorageLocation> store_locations;


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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWarehouse_id() {
        return warehouse_id;
    }

    public void setWarehouse_id(String warehouse_id) {
        this.warehouse_id = warehouse_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProject_group() {
        return project_group;
    }

    public void setProject_group(String project_group) {
        this.project_group = project_group;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public List<WmsStorageLocation> getStore_locations() {
        return store_locations;
    }

    public void setStore_locations(List<WmsStorageLocation> store_locations) {
        this.store_locations = store_locations;
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
}
