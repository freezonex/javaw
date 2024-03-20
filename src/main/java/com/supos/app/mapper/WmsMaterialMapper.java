package com.supos.app.mapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.supos.app.entity.WmsMaterial;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * @author Wenhao
 * @description 针对表【wms_material】的数据库操作Mapper
 * @createDate 2024-03-16 07:54:43
 * @Entity com.supos.app.entity.WmsMaterial
 */
@Mapper
public interface WmsMaterialMapper extends BaseMapper<WmsMaterial> {

    int insertSelective(WmsMaterial wmsMaterial);

    int updateSelective(WmsMaterial wmsMaterial);

    int deleteWmsMaterialById(WmsMaterial wmsMaterial);

    List<WmsMaterial> selectAll(WmsMaterial wmsMaterial);

}




