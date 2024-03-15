package com.supos.app.mapper;

import com.supos.app.entity.WmsStorageLocation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.supos.app.entity.WmsWarehouse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author Wenhao
* @description 针对表【wms_storage_location】的数据库操作Mapper
* @createDate 2024-03-15 23:19:11
* @Entity com.supos.app.entity.WmsStorageLocation
*/
@Mapper
public interface WmsStorageLocationMapper extends BaseMapper<WmsStorageLocation> {

    int insertSelective(WmsStorageLocation wmsStorageLocation);

    int updateStorageLocationById(WmsStorageLocation wmsStorageLocation);

    int deleteStorageLocationById(WmsStorageLocation wmsStorageLocation);

    List<WmsStorageLocation> selectAll(WmsStorageLocation wmsStorageLocation);
}




