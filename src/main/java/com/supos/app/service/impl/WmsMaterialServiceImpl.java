package com.supos.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.supos.app.entity.WmsMaterial;
import com.supos.app.service.WmsMaterialService;
import com.supos.app.mapper.WmsMaterialMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Wenhao
 * @description 针对表【wms_material】的数据库操作Service实现
 * @createDate 2024-03-16 07:54:43
 */
@Service
public class WmsMaterialServiceImpl extends ServiceImpl<WmsMaterialMapper, WmsMaterial>
        implements WmsMaterialService{

    @Autowired
    private WmsMaterialMapper wmsMaterialMapper;

    public int insertSelective(WmsMaterial wmsMaterial) {
        return wmsMaterialMapper.insertSelective(wmsMaterial);
    }
    public int updateWmsMaterialById(WmsMaterial wmsMaterial) {
        return wmsMaterialMapper.updateSelective(wmsMaterial);
    }

    public int deleteWmsMaterialById(WmsMaterial wmsMaterial) {
        return wmsMaterialMapper.deleteWmsMaterialById(wmsMaterial);
    }

    public List<WmsMaterial> selectAll(WmsMaterial wmsMaterial) {
        return wmsMaterialMapper.selectAll(wmsMaterial);
    }
}




