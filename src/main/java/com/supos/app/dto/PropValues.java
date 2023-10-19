package com.supos.app.dto;

import com.alibaba.fastjson.JSONObject;
import com.supos.app.pojo.Dto;
import lombok.Getter;
import lombok.Setter;

/**
 * @Description
 * @Author chenfei
 * @Date 2021/4/15 12:10
 */
@Getter
@Setter
public class PropValues extends Dto {

    private Double outerWeigh;

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
