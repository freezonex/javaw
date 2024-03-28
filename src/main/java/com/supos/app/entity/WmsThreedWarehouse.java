package com.supos.app.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName wms_threed_warehouse
 */
@Data
public class WmsThreedWarehouse implements Serializable {
    /**
     * 
     */
    private Long id;

    /**
     * 
     */
    private Long location_id;

    /**
     * 
     */
    private String location_name;

    /**
     * 
     */
    private String material_name;

    /**
     * 
     */
    private Boolean del_flag;

    /**
     * 
     */
    private Date update_time;

    /**
     * 
     */
    private Date create_time;

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
        WmsThreedWarehouse other = (WmsThreedWarehouse) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getLocation_id() == null ? other.getLocation_id() == null : this.getLocation_id().equals(other.getLocation_id()))
            && (this.getLocation_name() == null ? other.getLocation_name() == null : this.getLocation_name().equals(other.getLocation_name()))
            && (this.getMaterial_name() == null ? other.getMaterial_name() == null : this.getMaterial_name().equals(other.getMaterial_name()))
            && (this.getDel_flag() == null ? other.getDel_flag() == null : this.getDel_flag().equals(other.getDel_flag()))
            && (this.getUpdate_time() == null ? other.getUpdate_time() == null : this.getUpdate_time().equals(other.getUpdate_time()))
            && (this.getCreate_time() == null ? other.getCreate_time() == null : this.getCreate_time().equals(other.getCreate_time()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getLocation_id() == null) ? 0 : getLocation_id().hashCode());
        result = prime * result + ((getLocation_name() == null) ? 0 : getLocation_name().hashCode());
        result = prime * result + ((getMaterial_name() == null) ? 0 : getMaterial_name().hashCode());
        result = prime * result + ((getDel_flag() == null) ? 0 : getDel_flag().hashCode());
        result = prime * result + ((getUpdate_time() == null) ? 0 : getUpdate_time().hashCode());
        result = prime * result + ((getCreate_time() == null) ? 0 : getCreate_time().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", location_id=").append(location_id);
        sb.append(", location_name=").append(location_name);
        sb.append(", material_name=").append(material_name);
        sb.append(", del_flag=").append(del_flag);
        sb.append(", update_time=").append(update_time);
        sb.append(", create_time=").append(create_time);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}