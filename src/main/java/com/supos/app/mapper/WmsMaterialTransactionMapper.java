package com.supos.app.mapper;
import org.apache.ibatis.annotations.Param;

import cn.hutool.core.lang.UUID;
import com.supos.app.entity.WmsMaterialTransaction;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.supos.app.vo.SelectInboundResponse;
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

    List<WmsMaterialTransaction> selectAllGroupByMaterialID(WmsMaterialTransaction wmsMaterialTransaction);

    List<WmsMaterialTransaction> selectAllGroupByMaterialIDStockLocationId(WmsMaterialTransaction wmsMaterialTransaction);

    int updateForTopNTransactionsInboundManual(String type, String source, String status, String rfid, long inboundId, String storageLocationId, String materialId, int quantity);

    int updateForTopNTransactionsInboundPDA(String type, String source, String status, String rfid, long inboundId, String storageLocationId, String materialId, int quantity);

    int updateByRfid(UpdateInboundRequest updateInboundRequest);

    int deleteByRfid(UpdateInboundRequest updateInboundRequest);

    List<WmsMaterialTransaction> selectByInboundRfidType(String rfid,String type);

    int updateForTopNTransactionsOutboundPDA(String type, String source, String status, String rfid, long outboundId, String storageLocationId, String materialId, int quantity);

    int updateForTopNTransactionsOutboundManual(String type, String source, String status, String rfid, long outboundId, String storageLocationId, String materialId, int quantity);

    List<WmsMaterialTransaction> selectByOutboundRfidType(String rfid, String type);

    int insertSelective(WmsMaterialTransaction wmsMaterialTransaction);

    List<WmsMaterialTransaction> selectAllGroupByMaterialIDRfid(WmsMaterialTransaction wmsMaterialTransaction);

    int deleteByRfidMaterialIDLimitOne(WmsMaterialTransaction wmsMaterialTransaction);

    List<WmsMaterialTransaction> selectAll(WmsMaterialTransaction wmsMaterialTransaction);

}




