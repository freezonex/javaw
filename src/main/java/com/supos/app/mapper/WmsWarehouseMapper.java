package com.supos.app.mapper;

import com.supos.app.entity.WmsWarehouse;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author Wenhao
* @description 针对表【wms_warehouse】的数据库操作Mapper
* @createDate 2024-03-15 20:05:41
* @Entity com.supos.app.entity.WmsWarehouse
*/
@Mapper
public interface WmsWarehouseMapper extends BaseMapper<WmsWarehouse> {
    int insertSelective(WmsWarehouse wmsWarehouse);

    int updateWarehouseById(WmsWarehouse wmsWarehouse);

    int deleteWarehouseById(WmsWarehouse wmsWarehouse);

    List<WmsWarehouse> selectAll(WmsWarehouse wmsWarehouse);
}




