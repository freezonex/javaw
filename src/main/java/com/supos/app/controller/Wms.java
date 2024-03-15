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
import com.supos.app.vo.WarehouseSelectAllResponse;
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
import java.util.stream.Collectors;

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
    public ApiResponse<List<WarehouseSelectAllResponse>> warehouseSelectAll(@RequestBody WmsWarehouse wmsWarehouse) {
        try {
            List<WmsWarehouse> wmsWarehouseList = wmsWarehouseServiceImpl.selectAll(wmsWarehouse);
            List<WarehouseSelectAllResponse> warehouseSelectAllResponses = wmsWarehouseList.stream()
                    .map(warehouse -> {
                        WmsStorageLocation query = new WmsStorageLocation();
                        query.setWarehouse_id(warehouse.getId());
                        List<WmsStorageLocation> storageLocations = wmsStorageLocationServiceImpl.selectAll(query);

                        WarehouseSelectAllResponse response = new WarehouseSelectAllResponse();
                        response.setId(warehouse.getId());
                        response.setWarehouse_id(warehouse.getWarehouse_id());
                        response.setName(warehouse.getName());
                        response.setType(warehouse.getType());
                        response.setManager(warehouse.getManager());
                        response.setDepartment(warehouse.getDepartment());
                        response.setEmail(warehouse.getEmail());
                        response.setProject_group(warehouse.getProject_group());
                        response.setNote(warehouse.getNote());
                        response.setDel_flag(warehouse.getDel_flag());
                        response.setCreate_time(warehouse.getCreate_time());
                        response.setUpdate_time(warehouse.getUpdate_time());
                        response.setStore_locations(storageLocations);
                        return response;
                    })
                    .collect(Collectors.toList());

            return new ApiResponse<>(warehouseSelectAllResponses);
        } catch (Exception e) {
            log.info(e.getMessage());
            return new ApiResponse<>( null,"Error occurred while processing the request: " + e.getMessage());
        }
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
    @ApiOperation(value = "storagelocation/update",notes = "storagelocation/update")
    @PostMapping("/wms/storagelocation/update")
    public ApiResponse<Map<String, String>> storagelocationUpdate(@RequestBody WmsStorageLocation wmsStorageLocation) {
        Map<String, String> responseData = new HashMap<>();
        try {
            responseData.put("id", String.valueOf(wmsStorageLocationServiceImpl.updateStorageLocationById(wmsStorageLocation)));
            return new ApiResponse<>(responseData);
        }catch (Exception e){
            log.info(e.getMessage());
            return new ApiResponse<>( null,"Error occurred while processing the request: " + e.getMessage());
        }
    }

    @ApiOperation(value = "storagelocation/delete",notes = "storagelocation/delete")
    @PostMapping("/wms/storagelocation/delete")
    public ApiResponse<Map<String, String>> storagelocationDelete(@RequestBody WmsStorageLocation wmsStorageLocation) {
        Map<String, String> responseData = new HashMap<>();
        try {
            responseData.put("id", String.valueOf(wmsStorageLocationServiceImpl.deleteStorageLocationById(wmsStorageLocation)));
            return new ApiResponse<>(responseData);
        }catch (Exception e){
            log.info(e.getMessage());
            return new ApiResponse<>( null,"Error occurred while processing the request: " + e.getMessage());
        }
    }

    @ApiOperation(value = "storagelocation/get",notes = "storagelocation/get")
    @PostMapping("/wms/storagelocation/get")
    public ApiResponse<List<WmsStorageLocation>> storagelocationSelectAll(@RequestBody WmsStorageLocation wmsStorageLocation) {
        List<WmsStorageLocation> wmsStorageLocationList;

        try {
            wmsStorageLocationList= wmsStorageLocationServiceImpl.selectAll(wmsStorageLocation);
            return new ApiResponse<>(wmsStorageLocationList);
        }catch (Exception e){
            log.info(e.getMessage());
            return new ApiResponse<>( null,"Error occurred while processing the request: " + e.getMessage());
        }
    }

}
