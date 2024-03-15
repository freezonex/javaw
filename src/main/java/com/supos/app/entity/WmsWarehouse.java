package com.supos.app.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName wms_warehouse
 */
@Data
public class WmsWarehouse implements Serializable {
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
        WmsWarehouse other = (WmsWarehouse) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getWarehouse_id() == null ? other.getWarehouse_id() == null : this.getWarehouse_id().equals(other.getWarehouse_id()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getManager() == null ? other.getManager() == null : this.getManager().equals(other.getManager()))
            && (this.getDepartment() == null ? other.getDepartment() == null : this.getDepartment().equals(other.getDepartment()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getProject_group() == null ? other.getProject_group() == null : this.getProject_group().equals(other.getProject_group()))
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
        result = prime * result + ((getWarehouse_id() == null) ? 0 : getWarehouse_id().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getManager() == null) ? 0 : getManager().hashCode());
        result = prime * result + ((getDepartment() == null) ? 0 : getDepartment().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getProject_group() == null) ? 0 : getProject_group().hashCode());
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
        sb.append(", warehouse_id=").append(warehouse_id);
        sb.append(", name=").append(name);
        sb.append(", type=").append(type);
        sb.append(", manager=").append(manager);
        sb.append(", department=").append(department);
        sb.append(", email=").append(email);
        sb.append(", project_group=").append(project_group);
        sb.append(", note=").append(note);
        sb.append(", del_flag=").append(del_flag);
        sb.append(", create_time=").append(create_time);
        sb.append(", update_time=").append(update_time);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}