package com.supos.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.supos.app.entity.WmsWarehouse;
import com.supos.app.service.WmsWarehouseService;
import com.supos.app.mapper.WmsWarehouseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Wenhao
* @description 针对表【wms_warehouse】的数据库操作Service实现
* @createDate 2024-03-15 20:05:41
*/
@Service
public class WmsWarehouseServiceImpl extends ServiceImpl<WmsWarehouseMapper, WmsWarehouse>
        implements WmsWarehouseService {

    @Autowired
    private WmsWarehouseMapper wmsWarehouseMapper;

    public int insertSelective(WmsWarehouse wmsWarehouse) {
        return wmsWarehouseMapper.insertSelective(wmsWarehouse);
    }

    public int updateWarehouseById(WmsWarehouse wmsWarehouse) {
        return wmsWarehouseMapper.updateWarehouseById(wmsWarehouse);
    }

    public int deleteWarehouseById(WmsWarehouse wmsWarehouse) {
        return wmsWarehouseMapper.deleteWarehouseById(wmsWarehouse);
    }

    public List<WmsWarehouse> selectAll(WmsWarehouse wmsWarehouse) {
        return wmsWarehouseMapper.selectAll(wmsWarehouse);
    }

}




