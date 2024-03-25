package com.supos.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.supos.app.entity.WmsMaterialTransaction;
import com.supos.app.service.WmsMaterialTransactionService;
import com.supos.app.mapper.WmsMaterialTransactionMapper;
import com.supos.app.vo.InboundDetail;
import com.supos.app.vo.UpdateInboundRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    public List<WmsMaterialTransaction> selectAllGroupByMaterialCode(WmsMaterialTransaction wmsMaterialTransaction){
        return wmsMaterialTransactionMapper.selectAllGroupByMaterialCode(wmsMaterialTransaction);
    }

    public List<WmsMaterialTransaction> selectAllGroupByMaterialCodeStockLocationId(WmsMaterialTransaction wmsMaterialTransaction){
        return wmsMaterialTransactionMapper.selectAllGroupByMaterialCodeStockLocationId(wmsMaterialTransaction);
    }

    public int updateForTopNTransactionsInboundManual(String type, String source, String status, String rfid, long inboundId, String storageLocationId, String materialCode, int quantity) {
        return wmsMaterialTransactionMapper.updateForTopNTransactionsInboundManual( type,  source,  status,  rfid,  inboundId,  storageLocationId,  materialCode,  quantity);
    }

    public int updateForTopNTransactionsInboundPDA(String type, String source, String status, String rfid, long inboundId, String storageLocationId, String materialCode, int quantity) {
        return wmsMaterialTransactionMapper.updateForTopNTransactionsInboundPDA( type,  source,  status,  rfid,  inboundId,  storageLocationId,  materialCode,  quantity);
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

    public List<InboundDetail> selectByInboundRfidType(InboundDetail inboundDetail) {
        return wmsMaterialTransactionMapper.selectByInboundRfidType(inboundDetail);
    }

    public int updateForTopNTransactionsOutboundPDA(Date outboundDeliveryDate,String outboundCreator,String outboundPurchaseOrderNo,String outboundSupplier,String type, String source, String status, String rfid, long OutboundId, Long storageLocationId, String materialCode, int quantity) {
        return wmsMaterialTransactionMapper.updateForTopNTransactionsOutboundPDA( outboundDeliveryDate,  outboundCreator, outboundPurchaseOrderNo, outboundSupplier,type,  source,  status,  rfid,  OutboundId,  storageLocationId,  materialCode,  quantity);
    }

    public int updateForTopNTransactionsOutboundManual(Date outboundDeliveryDate,String outboundCreator, String outboundPurchaseOrderNo, String outboundSupplier, String type, String source, String status, String rfid, long OutboundId, Long storageLocationId, String materialCode, int quantity) {
        return wmsMaterialTransactionMapper.updateForTopNTransactionsOutboundManual(outboundDeliveryDate, outboundCreator, outboundPurchaseOrderNo, outboundSupplier, type,  source,  status,  rfid,  OutboundId,  storageLocationId,  materialCode,  quantity);
    }

    public List<WmsMaterialTransaction> selectByOutboundRfidType(InboundDetail inboundDetail) {
        return wmsMaterialTransactionMapper.selectByOutboundRfidType(inboundDetail);

    }

    public List<WmsMaterialTransaction> selectAllGroupByMaterialCodeRfid(WmsMaterialTransaction wmsMaterialTransaction) {
        return wmsMaterialTransactionMapper.selectAllGroupByMaterialCodeRfid(wmsMaterialTransaction);
    }

    public int deleteByRfidMaterialCodeLimitOne(WmsMaterialTransaction wmsMaterialTransaction) {
        return wmsMaterialTransactionMapper.deleteByRfidMaterialCodeLimitOne(wmsMaterialTransaction);
    }
    public List<WmsMaterialTransaction> selectAll(WmsMaterialTransaction wmsMaterialTransaction) {
        return wmsMaterialTransactionMapper.selectAll(wmsMaterialTransaction);
    }

    public List<WmsMaterialTransaction> selectAllInboundGroupByMaterialCode(WmsMaterialTransaction wmsMaterialTransaction) {
        return wmsMaterialTransactionMapper.selectAllInboundGroupByMaterialCode(wmsMaterialTransaction);
    }

    public List<WmsMaterialTransaction> selectAllOutboundGroupByMaterialCodeRfid(WmsMaterialTransaction wmsMaterialTransaction) {
        return wmsMaterialTransactionMapper.selectAllOutboundGroupByMaterialCodeRfid(wmsMaterialTransaction);
    }
    public int updateForTopNTransactionsStocktaking(long stocktakingId, String materialCode, int quantity, String storageLocationId) {
        return wmsMaterialTransactionMapper.updateForTopNTransactionsStocktaking(stocktakingId,  materialCode,  quantity,storageLocationId);
    }

    public int deleteForTopNTransactionsStocktaking(long id) {
        return wmsMaterialTransactionMapper.deleteForTopNTransactionsStocktaking(id);
    }

    public int getQuantityForStocktaking(String Rfid, String materialCode,String StringStorageLocationId) {
        return wmsMaterialTransactionMapper.getQuantityForStocktaking( Rfid,  materialCode, StringStorageLocationId);
    }

    public int getQuantityForInbound(String Rfid, String materialCode,String StringStorageLocationId) {
        return wmsMaterialTransactionMapper.getQuantityForInbound( Rfid,  materialCode, StringStorageLocationId);
    }

    public List<WmsMaterialTransaction> selectAllGroupByStocktakingId(WmsMaterialTransaction wmsMaterialTransaction, String warehouseName) {
        return wmsMaterialTransactionMapper.selectAllGroupByStocktakingId(wmsMaterialTransaction,warehouseName);
    }

    public int selectAllByCreateTimeGroupByInboundId(Date create_time,String inbound_status) {
        return wmsMaterialTransactionMapper.selectAllByCreateTimeGroupByInboundId(create_time,inbound_status);
    }

    public int selectAllByCreateTimeGroupByOutboundId(Date create_time,String outbound_status) {
        return wmsMaterialTransactionMapper.selectAllByCreateTimeGroupByOutboundId(create_time,outbound_status);
    }

}




