package com.supos.app.mapper;
import java.util.List;

import com.supos.app.entity.Packinfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Wenhao
* @description 针对表【packinfo】的数据库操作Mapper
* @createDate 2023-12-21 10:22:54
* @Entity com.supos.app.entity.Packinfo
*/

@Mapper
public interface PackinfoMapper extends BaseMapper<Packinfo> {

    List<Packinfo> selectAll();

    List<Packinfo> selectAllWithDel();

     int updateById(int id);

    void updateAll();

    List<Packinfo> charts();
}




