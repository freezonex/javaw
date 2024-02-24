package com.supos.app.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.FastjsonTypeHandler;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @TableName lotto
 */
@Data
@TableName(value = "lotto",autoResultMap = true)
@NoArgsConstructor
public class Lotto implements Serializable {


    public Lotto(Integer id, String period, Object number, String email, String result, String name, Date time, Integer send_flag, Integer del_flag) {
        this.id = id;
        this.period = period;
        this.number = number;
        this.email = email;
        this.result = result;
        this.name = name;
        this.time = time;
        this.send_flag = send_flag;
        this.del_flag = del_flag;
    }

    /**
     * 
     */
    private Integer id;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public Object getNumber() {
        return number;
    }

    public void setNumber(Object number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getSend_flag() {
        return send_flag;
    }

    public void setSend_flag(Integer send_flag) {
        this.send_flag = send_flag;
    }

    public Integer getDel_flag() {
        return del_flag;
    }

    public void setDel_flag(Integer del_flag) {
        this.del_flag = del_flag;
    }

    /**
     * 
     */
    private String period;

    /**
     * 
     */
    @TableField(typeHandler = FastjsonTypeHandler.class)
    private Object number;

    /**
     * 
     */
    private String email;
    /**
     *
     */
    private String result;
    /**
     *
     */
    private String name;
    /**
     * 创建时间
     */
    private Date time;

    /**
     * 
     */
    private Integer send_flag;

    /**
     * 
     */
    private Integer del_flag;

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
        Lotto other = (Lotto) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPeriod() == null ? other.getPeriod() == null : this.getPeriod().equals(other.getPeriod()))
            && (this.getNumber() == null ? other.getNumber() == null : this.getNumber().equals(other.getNumber()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getTime() == null ? other.getTime() == null : this.getTime().equals(other.getTime()))
            && (this.getSend_flag() == null ? other.getSend_flag() == null : this.getSend_flag().equals(other.getSend_flag()))
            && (this.getDel_flag() == null ? other.getDel_flag() == null : this.getDel_flag().equals(other.getDel_flag()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPeriod() == null) ? 0 : getPeriod().hashCode());
        result = prime * result + ((getNumber() == null) ? 0 : getNumber().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getTime() == null) ? 0 : getTime().hashCode());
        result = prime * result + ((getSend_flag() == null) ? 0 : getSend_flag().hashCode());
        result = prime * result + ((getDel_flag() == null) ? 0 : getDel_flag().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", period=").append(period);
        sb.append(", number=").append(number);
        sb.append(", email=").append(email);
        sb.append(", time=").append(time);
        sb.append(", send_flag=").append(send_flag);
        sb.append(", del_flag=").append(del_flag);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}