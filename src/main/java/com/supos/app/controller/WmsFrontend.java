package com.supos.app.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class WmsFrontend {
    @ApiOperation(value = "资产库存用例展示",notes = "资产库存用例展示")
    @GetMapping("/apps/wenhao-javaw/3d")
    public String view30() {
        return "forward:/apps/wenhao-javaw/3d.html";
    }

    @ApiOperation(value = "资产库存用例展示",notes = "资产库存用例展示")
    @GetMapping("/apps/wenhao-javaw/operation/inbound")
    public String view31() {
        return "forward:/apps/wenhao-javaw/operation/inbound.html";
    }

    @ApiOperation(value = "资产库存用例展示",notes = "资产库存用例展示")
    @GetMapping("/apps/wenhao-javaw/operation/inbound/create")
    public String view32() {
        return "forward:/apps/wenhao-javaw/operation/inbound/create.html";
    }


    @ApiOperation(value = "资产库存用例展示",notes = "资产库存用例展示")
    @GetMapping("/apps/wenhao-javaw/operation/outbound")
    public String view33() {
        return "forward:/apps/wenhao-javaw/operation/outbound.html";
    }
    @ApiOperation(value = "资产库存用例展示",notes = "资产库存用例展示")
    @GetMapping("/apps/wenhao-javaw/operation/outbound/create")
    public String view34() {
        return "forward:/apps/wenhao-javaw/operation/outbound/create.html";
    }


    @ApiOperation(value = "资产库存用例展示",notes = "资产库存用例展示")
    @GetMapping("/apps/wenhao-javaw/warehouse/material")
    public String view35() {
        return "forward:/apps/wenhao-javaw/warehouse/material.html";
    }
    @ApiOperation(value = "资产库存用例展示",notes = "资产库存用例展示")
    @GetMapping("/apps/wenhao-javaw/warehouse/material/create")
    public String view36() {
        return "forward:/apps/wenhao-javaw/warehouse/material/create.html";
    }

    @ApiOperation(value = "资产库存用例展示",notes = "资产库存用例展示")
    @GetMapping("/apps/wenhao-javaw/warehouse/material/rfid")
    public String view37() {
        return "forward:/apps/wenhao-javaw/warehouse/material/rfid.html";
    }

    @ApiOperation(value = "资产库存用例展示",notes = "资产库存用例展示")
    @GetMapping("/apps/wenhao-javaw/warehouse/material/rfid/create")
    public String view38() {
        return "forward:/apps/wenhao-javaw/warehouse/material/rfid/create.html";
    }

    @ApiOperation(value = "资产库存用例展示",notes = "资产库存用例展示")
    @GetMapping("/apps/wenhao-javaw/warehouse")
    public String view39() {
        return "forward:/apps/wenhao-javaw/warehouse.html";
    }
    @ApiOperation(value = "资产库存用例展示",notes = "资产库存用例展示")
    @GetMapping("/apps/wenhao-javaw/login")
    public String view40() {
        return "forward:/apps/wenhao-javaw/login.html";
    }

    @ApiOperation(value = "资产库存用例展示",notes = "资产库存用例展示")
    @GetMapping("/apps/wenhao-javaw/analysis")
    public String view41() {
        return "forward:/apps/wenhao-javaw/analysis.html";
    }


    @ApiOperation(value = "资产库存用例展示",notes = "资产库存用例展示")
    @GetMapping("/apps/wenhao-javaw/404")
    public String view42() {
        return "forward:/apps/wenhao-javaw/404.html";
    }


    @ApiOperation(value = "资产库存用例展示",notes = "资产库存用例展示")
    @GetMapping("/apps/wenhao-javaw/operation/stocktaking")
    public String view43() {
        return "forward:/apps/wenhao-javaw/operation/stocktaking.html";
    }

    @ApiOperation(value = "资产库存用例展示",notes = "资产库存用例展示")
    @GetMapping("/apps/wenhao-javaw/operation/stocktaking/create")
    public String view44() {
        return "forward:/apps/wenhao-javaw/operation/stocktaking/create.html";
    }
}
