package com.supos.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

import com.supos.app.entity.Lotto;
import com.supos.app.service.LottoService;
import com.supos.app.mapper.LottoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
* @author Wenhao
* @description 针对表【lotto】的数据库操作Service实现
* @createDate 2024-02-24 14:09:42
*/
@Service
@Slf4j
public class LottoServiceImpl extends ServiceImpl<LottoMapper, Lotto>
    implements LottoService{

    @Autowired
    private LottoMapper lottoMapper;

    public PageInfo<Lotto> selectAll(int pageNum, int pageSize, String name) {
        return PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(() -> lottoMapper.selectAll(name));
    }

    @Override
    public void insert(Lotto lotto) {
        Gson gson = new Gson();
        // 将number字段转换为JSON字符串
        String jsonNumbers = gson.toJson(lotto.getNumber());

        // 将JSON字符串转换回List<List<String>>类型
        Type listType = new TypeToken<List<List<String>>>() {
        }.getType();
        List<List<String>> numbersList = gson.fromJson(jsonNumbers, listType);

        // 迭代每个号码组
        for (List<String> numbers : numbersList) {
            // 将当前号码组转换回JSON字符串，以便存储到数据库
            String currentNumberAsJson = gson.toJson(numbers);
            System.out.println(currentNumberAsJson);

            // 创建一个新的Lotto对象，用于插入操作
            // 注意：根据你的需求，某些字段可能需要调整或使用默认值
            Lotto newLotto = new Lotto(
                    null, // ID通常由数据库自动生成
                    lotto.getPeriod(),
                    currentNumberAsJson, // 使用当前号码组的JSON字符串
                    lotto.getEmail(),
                    lotto.getResult(),
                    lotto.getName(),
                    lotto.getTime(), // 如果time为null，数据库应默认设置当前时间
                    0, // send_flag默认为0
                    0  // del_flag默认为0
            );

            // 插入新的Lotto对象到数据库
            lottoMapper.insert(newLotto);
        }
    }

    public List<Lotto> selectAllWithoutSend() {
        return lottoMapper.selectAllWithoutSend();
    }

    public int update(Lotto lotto) {
        return lottoMapper.updateByIdForLotto(lotto);
    }


}




