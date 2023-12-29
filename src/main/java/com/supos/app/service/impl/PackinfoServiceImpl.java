package com.supos.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.supos.app.entity.Packinfo;
import com.supos.app.service.PackinfoService;
import com.supos.app.mapper.PackinfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Wenhao
 * @description 针对表【packinfo】的数据库操作Service实现
 * @createDate 2023-12-21 10:22:54
 */
@Service
@Slf4j
public class PackinfoServiceImpl extends ServiceImpl<PackinfoMapper, Packinfo>
        implements PackinfoService {

//    private SqlSessionTemplate sqlSession;
//
//    @Override
//    public List<Packinfo> selectAll() {
//        PackinfoMapper mapper = sqlSession.getMapper(PackinfoMapper.class);
//        return mapper.selectAll();
//    }

    @Autowired
    private PackinfoMapper packinfoMapper;

    public List<Packinfo> selectAll() {
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

    public String formatData() throws JsonProcessingException {
        List<Packinfo> stats = packinfoMapper.charts();
        List<Object[]> formattedData = new ArrayList<>();
        List<Object[]> result = new ArrayList<>();
        result.add(new Object[]{"no", "pack", "month"});

        for (Packinfo stat : stats) {
            formattedData.add(new Object[]{stat.getIncrease(), "increase", stat.getMonth()});
            formattedData.add(new Object[]{stat.getTotal(), "total", stat.getMonth()});
        }

        ObjectMapper objectMapper = new ObjectMapper();
        result.addAll(formattedData.subList(Math.max(formattedData.size() - 24, 0), formattedData.size()));
        String jsonData = objectMapper.writeValueAsString(result);
        return jsonData;
    }

    public String formatPieData() throws JsonProcessingException {
        List<Packinfo> stats = packinfoMapper.charts();
        List<Map<String, Object>> formattedData = new ArrayList<>();
        List<String> dataList = new ArrayList<>();

        for (Packinfo stat : stats) {
            formattedData.add(new HashMap<String, Object>() {{
                put("value", stat.getIncrease());
                put("name", stat.getMonth() + "月");
            }});
            dataList.add(stat.getMonth() + "月");
        }
        Map<String, Object> result = new HashMap<String, Object>() {{
            put("data", formattedData.subList(Math.max(formattedData.size() - 12, 0), formattedData.size()));
            put("dataList", dataList.subList(Math.max(dataList.size() - 12, 0), dataList.size()));
        }};

        return new ObjectMapper().writeValueAsString(result);
    }

}




