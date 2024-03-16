package com.supos.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.supos.app.entity.WmsMaterialTransaction;
import com.supos.app.service.WmsMaterialTransactionService;
import com.supos.app.mapper.WmsMaterialTransactionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Wenhao
* @description 针对表【wms_material_transaction】的数据库操作Service实现
* @createDate 2024-03-16 09:06:46
*/
@Service
public class WmsMaterialTransactionServiceImpl extends ServiceImpl<WmsMaterialTransactionMapper, WmsMaterialTransaction>
    implements WmsMaterialTransactionService{

    @Autowired
    private WmsMaterialTransactionMapper wmsMaterialTransactionMapper;

    public List<WmsMaterialTransaction> selectAllGroupByMaterialID(WmsMaterialTransaction wmsMaterialTransaction){
        return wmsMaterialTransactionMapper.selectAllGroupByMaterialID(wmsMaterialTransaction);
    }

}




