package com.supos.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.supos.app.entity.WmsThreedWarehouse;
import com.supos.app.mapper.WmsWarehouseMapper;
import com.supos.app.service.WmsThreedWarehouseService;
import com.supos.app.mapper.WmsThreedWarehouseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author Wenhao
* @description 针对表【wms_threed_warehouse】的数据库操作Service实现
* @createDate 2024-03-28 17:03:15
*/
@Service
public class WmsThreedWarehouseServiceImpl extends ServiceImpl<WmsThreedWarehouseMapper, WmsThreedWarehouse>
    implements WmsThreedWarehouseService{

    @Autowired
    WmsThreedWarehouseMapper wmsThreedWarehouseMapper;

    public int updateSelectiveByLocationId(WmsThreedWarehouse wmsThreedWarehouse) {
        return wmsThreedWarehouseMapper.updateSelectiveByLocationId(wmsThreedWarehouse);
    }
}




