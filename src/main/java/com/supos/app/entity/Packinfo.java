package com.supos.app.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @TableName packinfo
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel(value="Packinfo",description="Packinfo")
public class Packinfo implements Serializable {
    /**
     *
     */
    @ApiModelProperty(value = "id",required = true,example = "1")
    private Integer id;

    /**
     *
     */
    @ApiModelProperty(value = "desciption",required = true,example = "abcd")
    private String desciption;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "submissionDate",required = true,example = "2024-01-22")
    private Date submissionDate;

    /**
     *
     */
    @ApiModelProperty(value = "delFlag",required = true,example = "0")
    private Integer delFlag;
    /**
     *
     */
    @ApiModelProperty(value = "familyname",required = true,example = "abcdefg")
    private String familyname;

    @ApiModelProperty(hidden = true)
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(hidden = true)
    @TableField(exist = false)
    private int year;

    @ApiModelProperty(hidden = true)
    @TableField(exist = false)
    private int month;

    @ApiModelProperty(hidden = true)
    @TableField(exist = false)
    private int increase;

    @ApiModelProperty(hidden = true)
    @TableField(exist = false)
    private int total;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getIncrease() {
        return increase;
    }

    public void setIncrease(int increase) {
        this.increase = increase;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }


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
        Packinfo other = (Packinfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId())) && (this.getDesciption() == null ? other.getDesciption() == null : this.getDesciption().equals(other.getDesciption())) && (this.getSubmissionDate() == null ? other.getSubmissionDate() == null : this.getSubmissionDate().equals(other.getSubmissionDate())) && (this.getDelFlag() == null ? other.getDelFlag() == null : this.getDelFlag().equals(other.getDelFlag())) && (this.getFamilyname() == null ? other.getFamilyname() == null : this.getFamilyname().equals(other.getFamilyname()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getDesciption() == null) ? 0 : getDesciption().hashCode());
        result = prime * result + ((getSubmissionDate() == null) ? 0 : getSubmissionDate().hashCode());
        result = prime * result + ((getDelFlag() == null) ? 0 : getDelFlag().hashCode());
        result = prime * result + ((getFamilyname() == null) ? 0 : getFamilyname().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", desciption=").append(desciption);
        sb.append(", submissionDate=").append(submissionDate);
        sb.append(", delFlag=").append(delFlag);
        sb.append(", familyname=").append(familyname);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

}