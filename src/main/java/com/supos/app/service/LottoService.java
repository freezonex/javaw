package com.supos.app.service;

import com.github.pagehelper.PageInfo;
import com.supos.app.entity.Lotto;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author Wenhao
* @description 针对表【lotto】的数据库操作Service
* @createDate 2024-02-24 14:09:42
*/
public interface LottoService extends IService<Lotto> {

    PageInfo<Lotto> selectAll(int pageNum, int pageSize, String name);

    void insert(Lotto lotto);

}
