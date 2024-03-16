package com.supos.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.supos.app.entity.WmsMaterialTransaction;
import com.supos.app.service.WmsMaterialTransactionService;
import com.supos.app.mapper.WmsMaterialTransactionMapper;
import com.supos.app.vo.UpdateInboundRequest;
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

    public List<WmsMaterialTransaction> selectAllGroupByMaterialIDStockLocationId(WmsMaterialTransaction wmsMaterialTransaction){
        return wmsMaterialTransactionMapper.selectAllGroupByMaterialIDStockLocationId(wmsMaterialTransaction);
    }

    public int updateForTopNTransactionsManual(String type, String source, String status, String rfid, long inboundId, String storageLocationId, String materialId, int quantity) {
        return wmsMaterialTransactionMapper.updateForTopNTransactionsManual( type,  source,  status,  rfid,  inboundId,  storageLocationId,  materialId,  quantity);
    }

    public int updateForTopNTransactionsPDA(String type, String source, String status, String rfid, long inboundId, String storageLocationId, String materialId, int quantity) {
        return wmsMaterialTransactionMapper.updateForTopNTransactionsPDA( type,  source,  status,  rfid,  inboundId,  storageLocationId,  materialId,  quantity);
    }

    public int updateByRfid(UpdateInboundRequest updateInboundRequest) {
        return wmsMaterialTransactionMapper.updateByRfid(updateInboundRequest);
    }

    public int deleteByRfid(UpdateInboundRequest updateInboundRequest) {
        return wmsMaterialTransactionMapper.deleteByRfid(updateInboundRequest);
    }

    public List<WmsMaterialTransaction> selectByRfidType(String rfid, String type) {
        return wmsMaterialTransactionMapper.selectByRfidType( rfid, type);
    }
}




