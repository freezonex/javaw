package com.supos.app.service;

import com.supos.app.entity.Lotto;
import com.baomidou.mybatisplus.extension.service.IService;
import com.supos.app.entity.Packinfo;

import java.util.List;

/**
* @author Wenhao
* @description 针对表【lotto】的数据库操作Service
* @createDate 2024-02-24 14:09:42
*/
public interface LottoService extends IService<Lotto> {

    List<Lotto> selectAll();

    void insert(Lotto lotto);

}
