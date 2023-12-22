package com.supos.app.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.supos.app.dto.sampleMailDto;
import com.supos.app.entity.Packinfo;
import com.supos.app.service.impl.PackinfoServiceImpl;
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

    @RequestMapping("/history")
    public List<Packinfo> history() {
        return packinfoServiceImpl.selectAll();
    }

    @RequestMapping("/current")
    public List<Packinfo> current() {
        return packinfoServiceImpl.selectAllWithDel();
    }

    @RequestMapping("/delete")
    public Integer delete(@RequestParam int id) {
        return packinfoServiceImpl.updateById(id);
    }

    @RequestMapping("/deleteAll")
    public String deleteAll() {
        packinfoServiceImpl.updateAll();
        return "good";
    }

    @PostMapping("/insert")
    public String insert(@RequestBody String requestBody) throws JsonProcessingException {
        Packinfo packinfo = new ObjectMapper().readValue(requestBody,Packinfo.class);
        System.out.println(packinfo);
        packinfoServiceImpl.insert(packinfo);
        return "good";
    }

}
