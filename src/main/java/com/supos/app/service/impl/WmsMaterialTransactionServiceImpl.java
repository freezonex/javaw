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

    public int insertSelective(WmsMaterialTransaction wmsMaterialTransaction){
        return wmsMaterialTransactionMapper.insertSelective(wmsMaterialTransaction);
    }

    public List<WmsMaterialTransaction> selectAllGroupByMaterialID(WmsMaterialTransaction wmsMaterialTransaction){
        return wmsMaterialTransactionMapper.selectAllGroupByMaterialID(wmsMaterialTransaction);
    }

    public List<WmsMaterialTransaction> selectAllGroupByMaterialIDStockLocationId(WmsMaterialTransaction wmsMaterialTransaction){
        return wmsMaterialTransactionMapper.selectAllGroupByMaterialIDStockLocationId(wmsMaterialTransaction);
    }

    public int updateForTopNTransactionsInboundManual(String type, String source, String status, String rfid, long inboundId, String storageLocationId, String materialId, int quantity) {
        return wmsMaterialTransactionMapper.updateForTopNTransactionsInboundManual( type,  source,  status,  rfid,  inboundId,  storageLocationId,  materialId,  quantity);
    }

    public int updateForTopNTransactionsInboundPDA(String type, String source, String status, String rfid, long inboundId, String storageLocationId, String materialId, int quantity) {
        return wmsMaterialTransactionMapper.updateForTopNTransactionsInboundPDA( type,  source,  status,  rfid,  inboundId,  storageLocationId,  materialId,  quantity);
    }

    public int updateByInboundId(UpdateInboundRequest updateInboundRequest) {
        return wmsMaterialTransactionMapper.updateByInboundId(updateInboundRequest);
    }

    public int updateByOutboundId(UpdateInboundRequest updateInboundRequest) {
        return wmsMaterialTransactionMapper.updateByOutboundId(updateInboundRequest);
    }

    public int deleteByRfid(UpdateInboundRequest updateInboundRequest) {
        return wmsMaterialTransactionMapper.deleteByRfid(updateInboundRequest);
    }

    public int deleteForOutbound(UpdateInboundRequest updateInboundRequest) {
        return wmsMaterialTransactionMapper.deleteForOutbound(updateInboundRequest);
    }

    public int deleteForInbound(UpdateInboundRequest updateInboundRequest) {
        return wmsMaterialTransactionMapper.deleteForInbound(updateInboundRequest);
    }

    public List<WmsMaterialTransaction> selectByInboundRfidType(String rfid, String type, Long inboundId) {
        return wmsMaterialTransactionMapper.selectByInboundRfidType( rfid, type,inboundId);
    }

    public int updateForTopNTransactionsOutboundPDA(String type, String source, String status, String rfid, long OutboundId, String storageLocationId, String materialId, int quantity) {
        return wmsMaterialTransactionMapper.updateForTopNTransactionsOutboundPDA( type,  source,  status,  rfid,  OutboundId,  storageLocationId,  materialId,  quantity);
    }

    public int updateForTopNTransactionsOutboundManual(String type, String source, String status, String rfid, long OutboundId, String storageLocationId, String materialId, int quantity) {
        return wmsMaterialTransactionMapper.updateForTopNTransactionsOutboundManual( type,  source,  status,  rfid,  OutboundId,  storageLocationId,  materialId,  quantity);
    }

    public List<WmsMaterialTransaction> selectByOutboundRfidType(String rfid, String type, Long outboundId) {
        return wmsMaterialTransactionMapper.selectByOutboundRfidType( rfid, type,outboundId);

    }

    public List<WmsMaterialTransaction> selectAllGroupByMaterialIDRfid(WmsMaterialTransaction wmsMaterialTransaction) {
        return wmsMaterialTransactionMapper.selectAllGroupByMaterialIDRfid(wmsMaterialTransaction);
    }

    public int deleteByRfidMaterialIDLimitOne(WmsMaterialTransaction wmsMaterialTransaction) {
        return wmsMaterialTransactionMapper.deleteByRfidMaterialIDLimitOne(wmsMaterialTransaction);
    }
    public List<WmsMaterialTransaction> selectAll(WmsMaterialTransaction wmsMaterialTransaction) {
        return wmsMaterialTransactionMapper.selectAll(wmsMaterialTransaction);
    }

    public List<WmsMaterialTransaction> selectAllInboundGroupByMaterialIDRfid(WmsMaterialTransaction wmsMaterialTransaction) {
        return wmsMaterialTransactionMapper.selectAllInboundGroupByMaterialIDRfid(wmsMaterialTransaction);
    }

    public List<WmsMaterialTransaction> selectAllOutboundGroupByMaterialIDRfid(WmsMaterialTransaction wmsMaterialTransaction) {
        return wmsMaterialTransactionMapper.selectAllOutboundGroupByMaterialIDRfid(wmsMaterialTransaction);
    }
    public int updateForTopNTransactionsStocktaking(long stocktakingId, String materialId, int quantity, String storageLocationId) {
        return wmsMaterialTransactionMapper.updateForTopNTransactionsStocktaking(stocktakingId,  materialId,  quantity,storageLocationId);
    }

    public int deleteForTopNTransactionsStocktaking(long id) {
        return wmsMaterialTransactionMapper.deleteForTopNTransactionsStocktaking(id);
    }

    public int getQuantityForStocktaking(String Rfid, String MaterialId,String StringStorageLocationId) {
        return wmsMaterialTransactionMapper.getQuantityForStocktaking( Rfid,  MaterialId, StringStorageLocationId);
    }
}




