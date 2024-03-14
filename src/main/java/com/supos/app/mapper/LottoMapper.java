package com.supos.app.mapper;

import com.supos.app.entity.Lotto;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author Wenhao
* @description 针对表【lotto】的数据库操作Mapper
* @createDate 2024-02-24 14:09:42
* @Entity com.supos.app.entity.Lotto
*/
@Mapper
public interface LottoMapper extends BaseMapper<Lotto> {

    List<Lotto> selectAll(String name);

    List<Lotto> selectAllWithoutSend();

    int updateByIdForLotto(Lotto lotto);
}




