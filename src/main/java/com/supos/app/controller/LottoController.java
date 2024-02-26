package com.supos.app.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.supos.app.entity.Lotto;
import com.supos.app.service.impl.LottoServiceImpl;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/lotto")
public class LottoController {

    @Autowired
    LottoServiceImpl lottoServiceImpl;

    @ApiOperation(value = "乐透历史展示", notes = "乐透历史展示")
    @GetMapping("/history")
    public List<Lotto> history() {
       return lottoServiceImpl.selectAll();
    }

    @ApiOperation(value = "数据新增",notes = "数据新增")
    @PostMapping("/insert")
    public ResponseEntity<Lotto> insert(@RequestBody Lotto lotto) throws JsonProcessingException {

        // 判断 lotto.name
        if ("Wenhao".equals(lotto.getName())) {
            // 如果 lotto.name 等于 "Wenhao"，设置 email 为 "yuwenhao@freezonex.io"
            lotto.setEmail("yuwenhao@freezonex.io");
        } else if ("Crystal".equals(lotto.getName())) {
            // 如果 lotto.name 等于 "Crystal"，设置 email 为 "Crystal@freezonex.io"
            lotto.setEmail("zhxfirst@163.com");
        }else if ("Zhanzhan".equals(lotto.getName())) {
            // 如果 lotto.name 等于 "Crystal"，设置 email 为 "Crystal@freezonex.io"
            lotto.setEmail("renzhanxiang@freezonex.io");
        }else if ("Shimu".equals(lotto.getName())) {
            // 如果 lotto.name 等于 "Crystal"，设置 email 为 "Crystal@freezonex.io"
            lotto.setEmail("zhujianan@freezonex.io");
        }

        lottoServiceImpl.insert(lotto);
        return ResponseEntity.ok(lotto);
    }
}