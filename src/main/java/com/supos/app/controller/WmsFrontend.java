package com.supos.app.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class WmsFrontend {
    @ApiOperation(value = "3D Warehouse",notes = "Returns an HTML page for 3D Warehouse visualization. \nResponse details are not elaborated since the response is HTML content.")
    @GetMapping("/apps/wenhao-javaw/analysis/3d")
    public String view30() {
        return "forward:/apps/wenhao-javaw/analysis/3d.html";
    }

    @ApiOperation(value = "Material Inbound",notes = "Returns an HTML page for Material Inbound. \nResponse details are not elaborated since the response is HTML content.")
    @GetMapping("/apps/wenhao-javaw/operation/inbound")
    public String view31() {
        return "forward:/apps/wenhao-javaw/operation/inbound.html";
    }

    @ApiOperation(value = "Material Inbound Create",notes = "Returns an HTML page for Material Inbound Create. \nResponse details are not elaborated since the response is HTML content.")
    @GetMapping("/apps/wenhao-javaw/operation/inbound/create")
    public String view32() {
        return "forward:/apps/wenhao-javaw/operation/inbound/create.html";
    }

    @ApiOperation(value = "Material Outbound",notes = "Returns an HTML page for Material Inbound. \nResponse details are not elaborated since the response is HTML content.")
    @GetMapping("/apps/wenhao-javaw/operation/outbound")
    public String view33() {
        return "forward:/apps/wenhao-javaw/operation/outbound.html";
    }
    @ApiOperation(value = "Material Outbound Create",notes = "Returns an HTML page for Material Inbound. \nResponse details are not elaborated since the response is HTML content.")
    @GetMapping("/apps/wenhao-javaw/operation/outbound/create")
    public String view34() {
        return "forward:/apps/wenhao-javaw/operation/outbound/create.html";
    }

    @ApiOperation(value = "Material",notes = "Returns an HTML page for Material Display. Display material information. \nResponse details are not elaborated since the response is HTML content.")
    @GetMapping("/apps/wenhao-javaw/warehouse/material")
    public String view35() {
        return "forward:/apps/wenhao-javaw/warehouse/material.html";
    }

    @ApiOperation(value = "Material Create",notes = "Returns an HTML page for Material Create. Creating a new material. \nResponse details are not elaborated since the response is HTML content.")
    @GetMapping("/apps/wenhao-javaw/warehouse/material/create")
    public String view36() {
        return "forward:/apps/wenhao-javaw/warehouse/material/create.html";
    }

    @ApiOperation(value = "Rfid Material",notes = "Returns an HTML page for Rfid Material. Display the rfid of  materials. \nResponse details are not elaborated since the response is HTML content.")
    @GetMapping("/apps/wenhao-javaw/warehouse/material/rfid")
    public String view37() {
        return "forward:/apps/wenhao-javaw/warehouse/material/rfid.html";
    }

    @ApiOperation(value = "Rfid Material Crreate",notes = "Returns an HTML page for Rfid Material Crreate. Using Rfid create a material. \nResponse details are not elaborated since the response is HTML content.")
    @GetMapping("/apps/wenhao-javaw/warehouse/material/rfid/create")
    public String view38() {
        return "forward:/apps/wenhao-javaw/warehouse/material/rfid/create.html";
    }

    @ApiOperation(value = "Warehouse",notes = "Returns an HTML page for warehouse. Display warehouse information. \nResponse details are not elaborated since the response is HTML content.")
    @GetMapping("/apps/wenhao-javaw/warehouse")
    public String view39() {
        return "forward:/apps/wenhao-javaw/warehouse.html";
    }
    @ApiOperation(value = "Login",notes = "Returns an HTML page for Login. Login page .\nResponse details are not elaborated since the response is HTML content.")
    @GetMapping("/apps/wenhao-javaw/login")
    public String view40() {
        return "forward:/apps/wenhao-javaw/login.html";
    }

    @ApiOperation(value = "Analysis",notes = "Returns an HTML page for analysis. Dashboard for showing information display. \nResponse details are not elaborated since the response is HTML content.")
    @GetMapping("/apps/wenhao-javaw/analysis")
    public String view41() {
        return "forward:/apps/wenhao-javaw/analysis.html";
    }

    @ApiOperation(value = "404",notes = "Returns an HTML page for 404 not found. \n Response details are not elaborated since the response is HTML content.")
    @GetMapping("/apps/wenhao-javaw/404")
    public String view42() {
        return "forward:/apps/wenhao-javaw/404.html";
    }

    @ApiOperation(value = "Stocktaking",notes = "Returns an HTML page for Stocktaking. Material inventory information display. \nResponse details are not elaborated since the response is HTML content.")
    @GetMapping("/apps/wenhao-javaw/operation/stocktaking")
    public String view43() {
        return "forward:/apps/wenhao-javaw/operation/stocktaking.html";
    }

    @ApiOperation(value = "Stocktaking Create",notes = "Returns an HTML page for Stocktaking Create. Creating new stocktaking task. \nResponse details are not elaborated since the response is HTML content.")
    @GetMapping("/apps/wenhao-javaw/operation/stocktaking/create")
    public String view44() {
        return "forward:/apps/wenhao-javaw/operation/stocktaking/create.html";
    }

    @ApiOperation(value = "Index",notes = "Returns an HTML page for index. Index of all the pages. \nResponse details are not elaborated since the response is HTML content.")
    @GetMapping("/apps/wenhao-javaw/index")
    public String view45() {
        return "forward:/apps/wenhao-javaw/index.html";
    }
}
