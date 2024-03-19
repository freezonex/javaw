package com.supos.app.mapper;

import com.supos.app.entity.WmsMaterialTransaction;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.supos.app.vo.UpdateInboundRequest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author Wenhao
* @description 针对表【wms_material_transaction】的数据库操作Mapper
* @createDate 2024-03-16 09:06:46
* @Entity com.supos.app.entity.WmsMaterialTransaction
*/
@Mapper
public interface WmsMaterialTransactionMapper extends BaseMapper<WmsMaterialTransaction> {

    List<WmsMaterialTransaction> selectAllGroupByMaterialCode(WmsMaterialTransaction wmsMaterialTransaction);

    List<WmsMaterialTransaction> selectAllGroupByMaterialCodeStockLocationId(WmsMaterialTransaction wmsMaterialTransaction);

    int updateForTopNTransactionsInboundManual(String type, String source, String status, String rfid, long inboundId, String storageLocationId, String materialCode, int quantity);

    int updateForTopNTransactionsInboundPDA(String type, String source, String status, String rfid, long inboundId, String storageLocationId, String materialCode, int quantity);

    int updateByInboundId(UpdateInboundRequest updateInboundRequest);

    int updateByOutboundId(UpdateInboundRequest updateInboundRequest);

    int deleteByRfid(UpdateInboundRequest updateInboundRequest);

    int deleteForOutbound(UpdateInboundRequest updateInboundRequest);

    int deleteForInbound(UpdateInboundRequest updateInboundRequest);

    List<WmsMaterialTransaction> selectByInboundRfidType(String rfid, String type, Long inboundId);

    int updateForTopNTransactionsOutboundPDA(String type, String source, String status, String rfid, long outboundId, String storageLocationId, String materialCode, int quantity);

    int updateForTopNTransactionsOutboundManual(String type, String source, String status, String rfid, long outboundId, String storageLocationId, String materialCode, int quantity);

    List<WmsMaterialTransaction> selectByOutboundRfidType(String rfid, String type, Long outboundId);

    int insertSelective(WmsMaterialTransaction wmsMaterialTransaction);

    List<WmsMaterialTransaction> selectAllGroupByMaterialCodeRfid(WmsMaterialTransaction wmsMaterialTransaction);

    int deleteByRfidMaterialCodeLimitOne(WmsMaterialTransaction wmsMaterialTransaction);

    List<WmsMaterialTransaction> selectAll(WmsMaterialTransaction wmsMaterialTransaction);

    List<WmsMaterialTransaction> selectAllInboundGroupByMaterialCode(WmsMaterialTransaction wmsMaterialTransaction);

    List<WmsMaterialTransaction> selectAllOutboundGroupByMaterialCodeRfid(WmsMaterialTransaction wmsMaterialTransaction);

    int updateForTopNTransactionsStocktaking(long stocktakingId, String materialCode, int quantity, String storageLocationId);

    int deleteForTopNTransactionsStocktaking(long stocktakingId);

    int getQuantityForStocktaking(String Rfid, String materialCode,String StringStorageLocationId);

    int getQuantityForInbound(String Rfid, String materialCode,String StringStorageLocationId);

    List<WmsMaterialTransaction> selectAllGroupByStocktakingId(WmsMaterialTransaction wmsMaterialTransaction);

}




