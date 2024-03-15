package com.supos.app.controller;

import cn.hutool.core.lang.UUID;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.supos.app.config.ApiResponse;
import com.supos.app.entity.Lotto;
import com.supos.app.entity.WmsWarehouse;
import com.supos.app.entity.WmsStorageLocation;
import com.supos.app.service.impl.LottoServiceImpl;
import com.supos.app.service.impl.WmsStorageLocationServiceImpl;
import com.supos.app.service.impl.WmsWarehouseServiceImpl;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
public class Wms {

    @Autowired
    WmsWarehouseServiceImpl wmsWarehouseServiceImpl;

    @Autowired
    WmsStorageLocationServiceImpl wmsStorageLocationServiceImpl;

    @ApiOperation(value = "warehouse/add",notes = "warehouse/add")
    @PostMapping("/wms/warehouse/add")
    public ApiResponse<Map<String, String>> warehouseInsert(@RequestBody WmsWarehouse wmsWarehouse) {
        Map<String, String> responseData = new HashMap<>();
        try {
            responseData.put("id", String.valueOf(wmsWarehouseServiceImpl.insertSelective(wmsWarehouse)));
            return new ApiResponse<>(responseData);
        }catch (Exception e){
            log.info(e.getMessage());
            return new ApiResponse<>( null,"Error occurred while processing the request: " + e.getMessage());
        }
    }

    @ApiOperation(value = "warehouse/update",notes = "warehouse/update")
    @PostMapping("/wms/warehouse/update")
    public ApiResponse<Map<String, String>> warehouseUpdate(@RequestBody WmsWarehouse wmsWarehouse) {
        Map<String, String> responseData = new HashMap<>();
        try {
            responseData.put("id", String.valueOf(wmsWarehouseServiceImpl.updateWarehouseById(wmsWarehouse)));
        }catch (Exception e){
            log.info(e.getMessage());
            return new ApiResponse<>( null,"Error occurred while processing the request: " + e.getMessage());
        }
        return new ApiResponse<>(responseData);
    }

    @ApiOperation(value = "warehouse/delete",notes = "warehouse/delete")
    @PostMapping("/wms/warehouse/delete")
    public ApiResponse<Map<String, String>> warehouseDelete(@RequestBody WmsWarehouse wmsWarehouse) {
        Map<String, String> responseData = new HashMap<>();
        try {
            responseData.put("id", String.valueOf(wmsWarehouseServiceImpl.deleteWarehouseById(wmsWarehouse)));
        }catch (Exception e){
            log.info(e.getMessage());
            return new ApiResponse<>( null,"Error occurred while processing the request: " + e.getMessage());
        }
        return new ApiResponse<>(responseData);
    }

    @ApiOperation(value = "warehouse/get",notes = "warehouse/get")
    @PostMapping("/wms/warehouse/get")
    public ApiResponse<List<WmsWarehouse>> warehouseSelectAll(@RequestBody WmsWarehouse wmsWarehouse) {
        List<WmsWarehouse> wmsWarehouseList;
        try {
            wmsWarehouseList = wmsWarehouseServiceImpl.selectAll(wmsWarehouse);
        } catch (Exception e) {
            log.info(e.getMessage());
            return new ApiResponse<>( null,"Error occurred while processing the request: " + e.getMessage());
        }
        return new ApiResponse<>(wmsWarehouseList);
    }

    @ApiOperation(value = "storagelocation/add",notes = "storagelocation/add")
    @PostMapping("/wms/storagelocation/add")
    public ApiResponse<Map<String, String>> storagelocationInsert(@RequestBody WmsStorageLocation wmsStorageLocation) {
        Map<String, String> responseData = new HashMap<>();
        try {
            responseData.put("id", String.valueOf(wmsStorageLocationServiceImpl.insertSelective(wmsStorageLocation)));
            return new ApiResponse<>(responseData);
        }catch (Exception e){
            log.info(e.getMessage());
            return new ApiResponse<>( null,"Error occurred while processing the request: " + e.getMessage());
        }
    }
}
