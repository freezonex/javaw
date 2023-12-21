package com.supos.app.service;

import com.supos.app.entity.Packinfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author Wenhao
* @description 针对表【packinfo】的数据库操作Service
* @createDate 2023-12-21 10:22:54
*/

public interface PackinfoService extends IService<Packinfo> {

    List<Packinfo> selectAll();

    List<Packinfo> selectAllWithDel();

    Integer updateById(int id);

    void updateAll();

    void insert(Packinfo packinfo);
}
