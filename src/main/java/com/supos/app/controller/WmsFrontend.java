package com.supos.app.controller;

import com.supos.app.entity.SuposApi;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class WmsFrontend {
    @ApiOperation(value = "3D Warehouse",
            notes = "Returns an HTML page for **3D Warehouse visualization**.  " +
                    "\n\nResponse details are not elaborated since the response is HTML content.  " +
                    "\n\n*This is italicized text.* " +
                    "\n" +
                    "Layout Introduction:  \n" +
                    "- Left side data table \n" +
                    "- Right side 3d modelling  \n" +
                    "\n" +
                    "`Individual materials can be selected for display`")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK")
            // Do not add other status codes if you do not want them documented
    })
    @GetMapping("/apps/wenhao-javaw/analysis/3d")
    public String view30() {
        return "forward:/apps/wenhao-javaw/analysis/3d.html";
    }

    @ApiOperation(value = "Material Inbound",
            notes = "Returns an HTML page for Material Inbound. " +
            "\n\nResponse details are not elaborated since the response is HTML content.")
    @GetMapping("/apps/wenhao-javaw/operation/inbound")
    public String view31() {
        return "forward:/apps/wenhao-javaw/operation/inbound.html";
    }

    @ApiOperation(value = "Material Inbound Create",
            notes = "Returns an HTML page for Material Inbound Create. " +
            "\n\nResponse details are not elaborated since the response is HTML content.")
    @GetMapping("/apps/wenhao-javaw/operation/inbound/create")
    public String view32() {
        return "forward:/apps/wenhao-javaw/operation/inbound/create.html";
    }

    @ApiOperation(value = "Material Outbound",
            notes = "Returns an HTML page for Material Inbound. " +
                    "\n\nResponse details are not elaborated since the response is HTML content.")
    @GetMapping("/apps/wenhao-javaw/operation/outbound")
    public String view33() {
        return "forward:/apps/wenhao-javaw/operation/outbound.html";
    }
    @ApiOperation(value = "Material Outbound Create",
            notes = "Returns an HTML page for Material Inbound. " +
                    "\n\nResponse details are not elaborated since the response is HTML content.")
    @GetMapping("/apps/wenhao-javaw/operation/outbound/create")
    public String view34() {
        return "forward:/apps/wenhao-javaw/operation/outbound/create.html";
    }

    @ApiOperation(value = "Material",
            notes = "Returns an HTML page for Material Display. " +
                    "\n\nDisplay material information. " +
                    "\n\nResponse details are not elaborated since the response is HTML content.")
    @GetMapping("/apps/wenhao-javaw/warehouse/material")
    public String view35() {
        return "forward:/apps/wenhao-javaw/warehouse/material.html";
    }

    @ApiOperation(value = "Material Create",notes = "Returns an HTML page for Material Create." +
            " \n\nCreating a new material. " +
            "\n\nResponse details are not elaborated since the response is HTML content.")
    @GetMapping("/apps/wenhao-javaw/warehouse/material/create")
    public String view36() {
        return "forward:/apps/wenhao-javaw/warehouse/material/create.html";
    }

    @ApiOperation(value = "Rfid Material",notes = "Returns an HTML page for Rfid Material. " +
            "\n\nDisplay the rfid of  materials. " +
            "\n\nResponse details are not elaborated since the response is HTML content.")
    @GetMapping("/apps/wenhao-javaw/warehouse/material/rfid")
    public String view37() {
        return "forward:/apps/wenhao-javaw/warehouse/material/rfid.html";
    }

    @ApiOperation(value = "Rfid Material Create",notes = "Returns an HTML page for Rfid Material Crreate. " +
            "\n\nUsing Rfid create a material. " +
            "\n\nResponse details are not elaborated since the response is HTML content.")
    @GetMapping("/apps/wenhao-javaw/warehouse/material/rfid/create")
    public String view38() {
        return "forward:/apps/wenhao-javaw/warehouse/material/rfid/create.html";
    }

    @ApiOperation(value = "Warehouse",notes = "Returns an HTML page for warehouse. " +
            "\n\nDisplay warehouse information. " +
            "\n\nResponse details are not elaborated since the response is HTML content.")
    @GetMapping("/apps/wenhao-javaw/warehouse")
    public String view39() {
        return "forward:/apps/wenhao-javaw/warehouse.html";
    }
    @ApiOperation(value = "Login",notes = "Returns an HTML page for **Login**. " +
            "\n\nLogin page ." +
            "\n\nResponse details are not elaborated since the response is HTML content.")
    @GetMapping("/apps/wenhao-javaw/login")
    public String view40() {
        return "forward:/apps/wenhao-javaw/login.html";
    }

    @ApiOperation(value = "Analysis",notes = "Returns an HTML page for **analysis**. " +
            "\n\nDashboard for showing information display. " +
            "\n\nResponse details are not elaborated since the response is HTML content." +
            "Layout Introduction:  \n" +
            "- Top side record information \n" +
            "- middle side supplier information  \n" +
            "\n" )
    @GetMapping("/apps/wenhao-javaw/analysis")
    public String view41() {
        return "forward:/apps/wenhao-javaw/analysis.html";
    }

    @ApiOperation(value = "404",
            notes = "Returns an HTML page for **404 not found**. " +
                    "\n\n Response details are not elaborated since the response is HTML content.")
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "404 not found",response = SuposApi.class)
    })
    @GetMapping("/apps/wenhao-javaw/404")
    public String view42() {
        return "forward:/apps/wenhao-javaw/404.html";
    }

    @ApiOperation(value = "Stocktaking",notes = "Returns an HTML page for Stocktaking. " +
            "\n\nMaterial inventory information display. " +
            "\n\nResponse details are not elaborated since the response is HTML content.")
    @GetMapping("/apps/wenhao-javaw/operation/stocktaking")
    public String view43() {
        return "forward:/apps/wenhao-javaw/operation/stocktaking.html";
    }

    @ApiOperation(value = "Stocktaking Create",notes = "Returns an HTML page for Stocktaking Create. " +
            "\n\nCreating new stocktaking task. " +
            "\n\nResponse details are not elaborated since the response is HTML content.")
    @GetMapping("/apps/wenhao-javaw/operation/stocktaking/create")
    public String view44() {
        return "forward:/apps/wenhao-javaw/operation/stocktaking/create.html";
    }

    @ApiOperation(value = "Index",notes = "Returns an HTML page for index. " +
            "\n\nIndex of all the pages. " +
            "\n\nResponse details are not elaborated since the response is HTML content.")
    @GetMapping("/apps/wenhao-javaw/index")
    public String view45() {
        return "forward:/apps/wenhao-javaw/index.html";
    }
}
