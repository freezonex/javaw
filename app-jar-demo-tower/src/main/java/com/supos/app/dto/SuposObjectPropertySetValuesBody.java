package com.supos.app.dto;

import com.alibaba.fastjson.JSONObject;
import com.supos.app.pojo.Dto;
import lombok.Getter;
import lombok.Setter;

/**
 * @Description
 * @Author chenfei
 * @Date 2021/4/15 12:04
 */
@Getter
@Setter
public class SuposObjectPropertySetValuesBody extends Dto {

    private String propValues;

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}