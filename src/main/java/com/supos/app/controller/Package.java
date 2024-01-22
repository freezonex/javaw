package com.supos.app.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.supos.app.dto.sampleMailDto;
import com.supos.app.entity.Packinfo;
import com.supos.app.impl.emailSender;
import com.supos.app.service.impl.PackinfoServiceImpl;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/package")
public class Package {

    @Autowired
    PackinfoServiceImpl packinfoServiceImpl;
    String sender = "ywhzhushou@163.com";
    String passwordSender = "LXNWXIXJDJUTTTDT";
    String host = "smtp.163.com";
    String port = "465";
    @ApiOperation(value = "历史",notes = "历史数据查询")
    @GetMapping("/history")
    public List<Packinfo> history() {
        return packinfoServiceImpl.selectAll();
    }
    @ApiOperation(value = "当前",notes = "当前数据查询")
    @GetMapping("/current")
    public List<Packinfo> current() {
        return packinfoServiceImpl.selectAllWithDel();
    }
    @ApiOperation(value = "删除",notes = "删除当前数据")
    @GetMapping("/delete")
    public Integer delete(@RequestParam int id) {
        return packinfoServiceImpl.updateById(id);
    }

    @ApiOperation(value = "全部删除",notes = "数据全部删除")
    @GetMapping("/deleteAll")
    public String deleteAll() {
        packinfoServiceImpl.updateAll();
        return "good";
    }
    @ApiOperation(value = "图表数据",notes = "图表数据")
    @GetMapping("/chart")
    public String chart() throws JsonProcessingException {
        return packinfoServiceImpl.formatData();
    }
    @ApiOperation(value = "饼状图表数据",notes = "饼状图表数据")
    @GetMapping("/pieChart")
    public String pieChart() throws JsonProcessingException {
        return packinfoServiceImpl.formatPieData();
    }
    @ApiOperation(value = "数据新增",notes = "数据新增")
    @ApiImplicitParams({@ApiImplicitParam(name = "packinfo", dataType = "Packinfo", required = true, paramType = "body")})
    @PostMapping("/insert")
    public String insert(@ApiParam(hidden = true) @RequestBody String requestBody) throws JsonProcessingException {
        Packinfo packinfo = new ObjectMapper().readValue(requestBody,Packinfo.class);
        System.out.println(packinfo);
        packinfoServiceImpl.insert(packinfo);
//        emailSender.SendEmail(sender, passwordSender, host, port);
        return "good";
    }

}
