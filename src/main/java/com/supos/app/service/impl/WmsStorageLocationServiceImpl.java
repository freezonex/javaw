package com.supos.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.supos.app.entity.WmsStorageLocation;
import com.supos.app.service.WmsStorageLocationService;
import com.supos.app.mapper.WmsStorageLocationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Wenhao
* @description 针对表【wms_storage_location】的数据库操作Service实现
* @createDate 2024-03-15 23:19:11
*/
@Service
public class WmsStorageLocationServiceImpl extends ServiceImpl<WmsStorageLocationMapper, WmsStorageLocation>
    implements WmsStorageLocationService{

    @Autowired
    private WmsStorageLocationMapper wmsStorageLocationMapper;

    public int insertSelective(WmsStorageLocation wmsStorageLocation) {
        return wmsStorageLocationMapper.insertSelective(wmsStorageLocation);
    }

    public int updateStorageLocationById(WmsStorageLocation wmsStorageLocation) {
        return wmsStorageLocationMapper.updateStorageLocationById(wmsStorageLocation);
    }

    public int deleteStorageLocationById(WmsStorageLocation wmsStorageLocation) {
        return wmsStorageLocationMapper.deleteStorageLocationById(wmsStorageLocation);
    }

    public List<WmsStorageLocation> selectAll(WmsStorageLocation wmsStorageLocation) {
        return wmsStorageLocationMapper.selectAll(wmsStorageLocation);
    }
}




