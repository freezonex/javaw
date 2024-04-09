package com.supos.app.mapper;
import com.supos.app.entity.Packinfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.supos.app.entity.WmsThreedWarehouse;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author Wenhao
* @description 针对表【wms_threed_warehouse】的数据库操作Mapper
* @createDate 2024-03-28 17:03:15
* @Entity com.supos.app.entity.WmsThreedWarehouse
*/
@Mapper
public interface WmsThreedWarehouseMapper extends BaseMapper<WmsThreedWarehouse> {

    int updateSelectiveByLocationId(WmsThreedWarehouse wmsThreedWarehouse);

    List<WmsThreedWarehouse> selectAllStocked();
}


