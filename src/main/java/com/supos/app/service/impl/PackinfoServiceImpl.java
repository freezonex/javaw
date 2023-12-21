package com.supos.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.supos.app.entity.Packinfo;
import com.supos.app.service.PackinfoService;
import com.supos.app.mapper.PackinfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Wenhao
* @description 针对表【packinfo】的数据库操作Service实现
* @createDate 2023-12-21 10:22:54
*/
@Service
public class PackinfoServiceImpl extends ServiceImpl<PackinfoMapper, Packinfo>
    implements PackinfoService{

//    private SqlSessionTemplate sqlSession;
//
//    @Override
//    public List<Packinfo> selectAll() {
//        PackinfoMapper mapper = sqlSession.getMapper(PackinfoMapper.class);
//        return mapper.selectAll();
//    }

    @Autowired
    private PackinfoMapper packinfoMapper;

    public List<Packinfo> selectAll(){
        return packinfoMapper.selectAll();
    }

    @Override
    public List<Packinfo> selectAllWithDel() {
        return packinfoMapper.selectAllWithDel();
    }

    public Integer updateById(int id) {
        return packinfoMapper.updateById(id);
    }

    public void updateAll() {
        packinfoMapper.updateAll();
    }

    @Override
    public void insert(Packinfo packinfo) {
        packinfoMapper.insert(packinfo);
    }

}




