package com.supos.app.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.supos.app.entity.WmsRfidMaterial;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Wenhao
* @description 针对表【wms_rfid_material】的数据库操作Mapper
* @createDate 2024-03-18 18:33:12
* @Entity com.supos.app.entity.WmsRfidMaterial
*/
@Mapper
public interface WmsRfidMaterialMapper extends BaseMapper<WmsRfidMaterial> {

    int insertSelective(WmsRfidMaterial wmsRfidMaterial);

    int updateSelective(WmsRfidMaterial wmsRfidMaterial);

    int deleteSelective(WmsRfidMaterial wmsRfidMaterial);

    List<WmsRfidMaterial> selectall(WmsRfidMaterial wmsRfidMaterial);


}




