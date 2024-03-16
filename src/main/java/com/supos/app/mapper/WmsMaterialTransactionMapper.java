package com.supos.app.mapper;

import cn.hutool.core.lang.UUID;
import com.supos.app.entity.WmsMaterialTransaction;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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

    int updateForTopNTransactions(String type, String source, String status, String rfid, long inboundId, String storageLocationId, String materialId, int quantity);
}




