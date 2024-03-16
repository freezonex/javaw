package com.supos.app.controller;

import cn.hutool.core.lang.UUID;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.supos.app.config.ApiResponse;
import com.supos.app.entity.*;
import com.supos.app.service.WmsMaterialTransactionService;
import com.supos.app.service.impl.*;
import com.supos.app.utils.HttpUtils;
import com.supos.app.vo.*;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
@RestController
public class Wms {

    @Autowired
    WmsWarehouseServiceImpl wmsWarehouseServiceImpl;

    @Autowired
    WmsStorageLocationServiceImpl wmsStorageLocationServiceImpl;

    @Autowired
    WmsMaterialServiceImpl wmsMaterialServiceImpl;

    @Autowired
    WmsMaterialTransactionServiceImpl wmsMaterialTransactionServiceImpl;

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

    @ApiOperation(value = "warehouse/get", notes = "warehouse/get")
    @PostMapping("/wms/warehouse/get")
    public ApiResponse<List<WarehouseSelectAllResponse>> warehouseSelectAll(@RequestBody WmsWarehouse wmsWarehouse) {
        try {
            List<WmsWarehouse> wmsWarehouseList = wmsWarehouseServiceImpl.selectAll(wmsWarehouse);
            List<WarehouseSelectAllResponse> warehouseSelectAllResponses = wmsWarehouseList.stream()
                    .map(warehouse -> {
                        WmsStorageLocation query = new WmsStorageLocation();
                        query.setWarehouse_id(warehouse.getId());
                        List<WmsStorageLocation> storageLocations = wmsStorageLocationServiceImpl.selectAll(query);

                        List<WarehouseSelectAllLocations> warehouseSelectAllLocationsList = storageLocations.stream().map(storageLocation -> {
                                    WmsMaterialTransaction materialTransactionquery = new WmsMaterialTransaction();
                                    materialTransactionquery.setWarehouse_id(storageLocation.getWarehouse_id());
                                    materialTransactionquery.setStock_location_id(storageLocation.getId());

                                    List<WmsMaterialTransaction> MaterialTransactions = wmsMaterialTransactionServiceImpl.selectAllGroupByMaterialID(materialTransactionquery);

                                    List<WarehouseSelectAllMaterial> warehouseMaterials = MaterialTransactions.stream()
                                            .map(transaction -> {
                                                WarehouseSelectAllMaterial warehouseMaterial = new WarehouseSelectAllMaterial(transaction);
                                                WmsMaterial wmsMaterial = new WmsMaterial();
                                                wmsMaterial.setId(transaction.getMaterial_id());
                                                List<WmsMaterial> materials = wmsMaterialServiceImpl.selectAll(wmsMaterial);
                                                if (!materials.isEmpty()) {
                                                    warehouseMaterial.setMaterial_name(materials.get(0).getName());
                                                }
                                                return warehouseMaterial;
                                            })
                                            .collect(Collectors.toList());

                                    WarehouseSelectAllLocations warehouseSelectAllLocation = new WarehouseSelectAllLocations(storageLocation);
                                    warehouseSelectAllLocation.setMaterials(warehouseMaterials);
                                    return warehouseSelectAllLocation;
                                }
                        ).collect(Collectors.toList());

                        WarehouseSelectAllResponse response = new WarehouseSelectAllResponse(warehouse);
                        response.setStore_locations(warehouseSelectAllLocationsList);
                        return response;
                    })
                    .collect(Collectors.toList());

            return new ApiResponse<>(warehouseSelectAllResponses);
        } catch (Exception e) {
            log.info(e.getMessage());
            return new ApiResponse<>(null, "Error occurred while processing the request: " + e.getMessage());
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

    @ApiOperation(value = "storagelocation/get", notes = "storagelocation/get")
    @PostMapping("/wms/storagelocation/get")
    public ApiResponse<List<StorageLocationSelectAllResponse>> storagelocationSelectAll(@RequestBody WmsStorageLocation wmsStorageLocation) {
        try {
            List<StorageLocationSelectAllResponse> StorageLocationSelectAllResponses = wmsStorageLocationServiceImpl.selectAll(wmsStorageLocation).stream().map(
                    storageLocation -> {
                        StorageLocationSelectAllResponse storageLocationSelectAllResponse = new StorageLocationSelectAllResponse(storageLocation);

                        WmsMaterialTransaction materialTransactionquery = new WmsMaterialTransaction();
                        materialTransactionquery.setWarehouse_id(storageLocation.getWarehouse_id());
                        materialTransactionquery.setStock_location_id(storageLocation.getId());

                        List<WmsMaterialTransaction> MaterialTransactions = wmsMaterialTransactionServiceImpl.selectAllGroupByMaterialID(materialTransactionquery);

                        List<StorageLocationSelectAllMaterial> storageLocationMaterials = MaterialTransactions.stream()
                                .map(transaction -> {
                                    StorageLocationSelectAllMaterial locationMaterial = new StorageLocationSelectAllMaterial(transaction);
                                    WmsMaterial wmsMaterial = new WmsMaterial();
                                    wmsMaterial.setId(transaction.getMaterial_id());
                                    List<WmsMaterial> materials = wmsMaterialServiceImpl.selectAll(wmsMaterial);
                                    if (!materials.isEmpty()) {
                                        locationMaterial.setMaterial_name(materials.get(0).getName());
                                    }
                                    return locationMaterial;
                                })
                                .collect(Collectors.toList());

                        storageLocationSelectAllResponse.setMaterials(storageLocationMaterials);
                        return storageLocationSelectAllResponse;
                    }
            ).collect(Collectors.toList());
            return new ApiResponse<>(StorageLocationSelectAllResponses);
        } catch (Exception e) {
            log.info(e.getMessage());
            return new ApiResponse<>(null, "Error occurred while processing the request: " + e.getMessage());
        }
    }

    @ApiOperation(value = "material/add",notes = "material/add")
    @PostMapping("/wms/material/add")
    public ApiResponse<Map<String, String>> materialInsert(@RequestBody WmsMaterial wmsMaterial) {
        Map<String, String> responseData = new HashMap<>();
        try {
            responseData.put("id", String.valueOf(wmsMaterialServiceImpl.insertSelective(wmsMaterial)));
            return new ApiResponse<>(responseData);
        }catch (Exception e){
            log.info(e.getMessage());
            return new ApiResponse<>( null,"Error occurred while processing the request: " + e.getMessage());
        }
    }

    @ApiOperation(value = "material/update",notes = "material/update")
    @PostMapping("/wms/material/update")
    public ApiResponse<Map<String, String>> materialUpdate(@RequestBody WmsMaterial wmsMaterial) {
        Map<String, String> responseData = new HashMap<>();
        try {
            responseData.put("id", String.valueOf(wmsMaterialServiceImpl.updateWmsMaterialById(wmsMaterial)));
            return new ApiResponse<>(responseData);
        }catch (Exception e){
            log.info(e.getMessage());
            return new ApiResponse<>( null,"Error occurred while processing the request: " + e.getMessage());
        }
    }

    @ApiOperation(value = "material/delete",notes = "material/delete")
    @PostMapping("/wms/material/delete")
    public ApiResponse<Map<String, String>> materialDelete(@RequestBody WmsMaterial wmsMaterial) {
        Map<String, String> responseData = new HashMap<>();
        try {
            responseData.put("id", String.valueOf(wmsMaterialServiceImpl.deleteWmsMaterialById(wmsMaterial)));
            return new ApiResponse<>(responseData);
        }catch (Exception e){
            log.info(e.getMessage());
            return new ApiResponse<>( null,"Error occurred while processing the request: " + e.getMessage());
        }
    }

    @ApiOperation(value = "material/get", notes = "material/get")
    @PostMapping("/wms/material/get")
    public ApiResponse<List<MaterialSelectAllResponse>> materialSelectAll(@RequestBody WmsMaterial wmsMaterial) {
        try {
            List<MaterialSelectAllResponse> materialSelectAllResponses = wmsMaterialServiceImpl.selectAll(wmsMaterial).stream().map(material -> {
                WmsMaterialTransaction wmsMaterialTransactionQuery = new WmsMaterialTransaction();
                wmsMaterialTransactionQuery.setMaterial_id(material.getId());
                List<WmsMaterialTransaction> transactions = wmsMaterialTransactionServiceImpl.selectAllGroupByMaterialIDStockLocationId(wmsMaterialTransactionQuery);

                List<String> ids = new ArrayList<>();
                List<String> names = new ArrayList<>();

                transactions.forEach(transaction -> {
                    ids.add(String.valueOf(transaction.getId()));
                    WmsStorageLocation wmsStorageLocationQuery = new WmsStorageLocation();
                    wmsStorageLocationQuery.setId(transaction.getStock_location_id());
                    List<WmsStorageLocation> locations = wmsStorageLocationServiceImpl.selectAll(wmsStorageLocationQuery);
                    if (!locations.isEmpty()) {
                        names.add(locations.get(0).getName());
                    }
                });

                MaterialSelectAllResponse response = new MaterialSelectAllResponse(material);
                response.setStorage_location_id(ids);
                response.setStorage_location(names);
                return response;
            }).collect(Collectors.toList());
            return new ApiResponse<>(materialSelectAllResponses);
        } catch (Exception e) {
            log.info(e.getMessage());
            return new ApiResponse<>(null, "Error occurred while processing the request: " + e.getMessage());
        }
    }

    @ApiOperation(value = "inbound/add", notes = "inbound/add")
    @PostMapping("/wms/inbound/add")
    public ApiResponse<Map<String, String>> inboundInsert(@RequestBody AddInboundRequest addInboundRequest) {
        try {
            Map<String, String> responseData = new HashMap<>();

            if ("PDA".equals(addInboundRequest.getSource())) {
                long newInboundId = System.nanoTime() + ThreadLocalRandom.current().nextLong(1_000_000L, 10_000_000L);
                addInboundRequest.getShelfRecords().forEach(shelfInventory -> {
                    shelfInventory.getInventory().forEach(inventory -> {
                        int updated = wmsMaterialTransactionServiceImpl.updateForTopNTransactionsInboundPDA(
                                addInboundRequest.getType(),
                                addInboundRequest.getSource(),
                                addInboundRequest.getStatus(),
                                inventory.getRfid(),
                                newInboundId,
                                shelfInventory.getStorageLocationId(),
                                inventory.getMaterialId(),
                                inventory.getQuantity()
                        );
                        responseData.put("id", String.valueOf(updated));
                    });
                });
            } else if ("manual".equals(addInboundRequest.getSource())) {
                long newInboundId = System.nanoTime() + ThreadLocalRandom.current().nextLong(1_000_000L, 10_000_000L);
                addInboundRequest.getShelfRecords().forEach(shelfInventory -> {
                    shelfInventory.getInventory().forEach(inventory -> {
                        int updated = wmsMaterialTransactionServiceImpl.updateForTopNTransactionsInboundManual(
                                addInboundRequest.getType(),
                                addInboundRequest.getSource(),
                                addInboundRequest.getStatus(),
                                inventory.getRfid(),
                                newInboundId,
                                shelfInventory.getStorageLocationId(),
                                inventory.getMaterialId(),
                                inventory.getQuantity()
                        );
                        responseData.put("id", String.valueOf(updated));
                    });
                });
            }
            return new ApiResponse<>(responseData);
        } catch (Exception e) {
            log.info("Error occurred while processing the request: " + e.getMessage(), e); // 使用日志记录异常堆栈
            return new ApiResponse<>(null, "Error occurred while processing the request: " + e.getMessage());
        }
    }

    @ApiOperation(value = "inbound/update", notes = "inbound/update")
    @PostMapping("/wms/inbound/update")
    public ApiResponse<Map<String, String>> inboundUpdate(@RequestBody UpdateInboundRequest updateInboundRequest) {
        Map<String, String> responseData = new HashMap<>();
        try {
            responseData.put("id", String.valueOf(wmsMaterialTransactionServiceImpl.updateByRfid(updateInboundRequest)));
            return new ApiResponse<>(responseData);
        }catch (Exception e){
            log.info(e.getMessage());
            return new ApiResponse<>( null,"Error occurred while processing the request: " + e.getMessage());
        }
    }

    @ApiOperation(value = "inbound/delete", notes = "inbound/delete")
    @PostMapping("/wms/inbound/delete")
    public ApiResponse<Map<String, String>> inboundDelete(@RequestBody UpdateInboundRequest updateInboundRequest) {
        Map<String, String> responseData = new HashMap<>();
        try {
            responseData.put("id", String.valueOf(wmsMaterialTransactionServiceImpl.deleteByRfid(updateInboundRequest)));
            return new ApiResponse<>(responseData);
        }catch (Exception e){
            log.info(e.getMessage());
            return new ApiResponse<>( null,"Error occurred while processing the request: " + e.getMessage());
        }
    }

    @ApiOperation(value = "inbound/get", notes = "inbound/get")
    @PostMapping("/wms/inbound/get")
    public ApiResponse<List<SelectInboundResponse>> inboundGet(@RequestBody UpdateInboundRequest updateInboundRequest) {
        try {
            List<SelectInboundResponse> response= wmsMaterialTransactionServiceImpl.selectByInboundRfidType(updateInboundRequest.getRefId(),updateInboundRequest.getType()).stream()
                    .map(SelectInboundResponse::new)
                    .collect(Collectors.toList());
            return new ApiResponse<>(response);
        }catch (Exception e){
            log.info(e.getMessage());
            return new ApiResponse<>( null,"Error occurred while processing the request: " + e.getMessage());
        }
    }

    @ApiOperation(value = "outbound/add", notes = "outbound/add")
    @PostMapping("/wms/outbound/add")
    public ApiResponse<Map<String, String>> outboundInsert(@RequestBody AddInboundRequest addInboundRequest) {
        try {
            Map<String, String> responseData = new HashMap<>();

            if ("PDA".equals(addInboundRequest.getSource())) {
                long newOutboundId = System.nanoTime() + ThreadLocalRandom.current().nextLong(1_000_000L, 10_000_000L);
                addInboundRequest.getShelfRecords().forEach(shelfInventory -> {
                    shelfInventory.getInventory().forEach(inventory -> {
                        int updated = wmsMaterialTransactionServiceImpl.updateForTopNTransactionsOutboundPDA(
                                addInboundRequest.getType(),
                                addInboundRequest.getSource(),
                                addInboundRequest.getStatus(),
                                inventory.getRfid(),
                                newOutboundId,
                                shelfInventory.getStorageLocationId(),
                                inventory.getMaterialId(),
                                inventory.getQuantity()
                        );
                        responseData.put("id", String.valueOf(updated));
                    });
                });
            } else if ("manual".equals(addInboundRequest.getSource())) {
                long newOutboundId = System.nanoTime() + ThreadLocalRandom.current().nextLong(1_000_000L, 10_000_000L);
                addInboundRequest.getShelfRecords().forEach(shelfInventory -> {
                    shelfInventory.getInventory().forEach(inventory -> {
                        int updated = wmsMaterialTransactionServiceImpl.updateForTopNTransactionsOutboundManual(
                                addInboundRequest.getType(),
                                addInboundRequest.getSource(),
                                addInboundRequest.getStatus(),
                                inventory.getRfid(),
                                newOutboundId,
                                shelfInventory.getStorageLocationId(),
                                inventory.getMaterialId(),
                                inventory.getQuantity()
                        );
                        responseData.put("id", String.valueOf(updated));
                    });
                });
            }
            return new ApiResponse<>(responseData);
        } catch (Exception e) {
            log.info("Error occurred while processing the request: " + e.getMessage(), e); // 使用日志记录异常堆栈
            return new ApiResponse<>(null, "Error occurred while processing the request: " + e.getMessage());
        }
    }
    @ApiOperation(value = "outbound/update", notes = "outbound/update")
    @PostMapping("/wms/outbound/update")
    public ApiResponse<Map<String, String>> outboundUpdate(@RequestBody UpdateInboundRequest updateInboundRequest) {
        Map<String, String> responseData = new HashMap<>();
        try {
            responseData.put("id", String.valueOf(wmsMaterialTransactionServiceImpl.updateByRfid(updateInboundRequest)));
            return new ApiResponse<>(responseData);
        }catch (Exception e){
            log.info(e.getMessage());
            return new ApiResponse<>( null,"Error occurred while processing the request: " + e.getMessage());
        }
    }

    @ApiOperation(value = "outbound/delete", notes = "outbound/delete")
    @PostMapping("/wms/outbound/delete")
    public ApiResponse<Map<String, String>> outboundDelete(@RequestBody UpdateInboundRequest updateInboundRequest) {
        Map<String, String> responseData = new HashMap<>();
        try {
            responseData.put("id", String.valueOf(wmsMaterialTransactionServiceImpl.deleteByRfid(updateInboundRequest)));
            return new ApiResponse<>(responseData);
        }catch (Exception e){
            log.info(e.getMessage());
            return new ApiResponse<>( null,"Error occurred while processing the request: " + e.getMessage());
        }
    }

    @ApiOperation(value = "outbound/get", notes = "outbound/get")
    @PostMapping("/wms/outbound/get")
    public ApiResponse<List<SelectInboundResponse>> outboundGet(@RequestBody UpdateInboundRequest updateInboundRequest) {
        try {
            List<SelectInboundResponse> response= wmsMaterialTransactionServiceImpl.selectByOutboundRfidType(updateInboundRequest.getRefId(),updateInboundRequest.getType()).stream()
                    .map(SelectInboundResponse::new)
                    .collect(Collectors.toList());
            return new ApiResponse<>(response);
        }catch (Exception e){
            log.info(e.getMessage());
            return new ApiResponse<>( null,"Error occurred while processing the request: " + e.getMessage());
        }
    }

    @ApiOperation(value = "rfidmaterial/add",notes = "rfidmaterial/add")
    @PostMapping("/wms/rfidmaterial/add")
    public ApiResponse<Map<String, String>> rfidmaterialInsert(@RequestBody AddRfidMaterialRequest addRfidMaterialRequest) {
        Map<String, String> responseData = new HashMap<>();
        try {
            WmsMaterialTransaction wmsMaterialTransaction = new WmsMaterialTransaction();
            wmsMaterialTransaction.setRf_id(addRfidMaterialRequest.getRfid());
            wmsMaterialTransaction.setMaterial_id(addRfidMaterialRequest.getMaterialId());
            IntStream.range(0, addRfidMaterialRequest.getQuantity())
                    .forEach(i -> wmsMaterialTransactionServiceImpl.insertSelective(wmsMaterialTransaction));
            responseData.put("id", "1");
            return new ApiResponse<>(responseData);
        }catch (Exception e){
            log.info(e.getMessage());
            return new ApiResponse<>( null,"Error occurred while processing the request: " + e.getMessage());
        }
    }

    @ApiOperation(value = "rfidmaterial/update", notes = "rfidmaterial/update")
    @PostMapping("/wms/rfidmaterial/update")
    public ApiResponse<Map<String, String>> rfidmaterialUpdate(@RequestBody AddRfidMaterialRequest addRfidMaterialRequest) {
        Map<String, String> responseData = new HashMap<>();
        try {
            WmsMaterialTransaction wmsMaterialTransaction = new WmsMaterialTransaction();
            wmsMaterialTransaction.setRf_id(addRfidMaterialRequest.getRfid());
            wmsMaterialTransaction.setMaterial_id(addRfidMaterialRequest.getMaterialId());

            int existingQuantity = wmsMaterialTransactionServiceImpl.selectAllGroupByMaterialIDRfid(wmsMaterialTransaction)
                    .stream()
                    .findFirst()
                    .map(WmsMaterialTransaction::getQuantity)
                    .orElse(0);

            int difference = addRfidMaterialRequest.getQuantity() - existingQuantity;

            if (difference > 0) {
                IntStream.range(0, difference)
                        .forEach(i -> wmsMaterialTransactionServiceImpl.insertSelective(wmsMaterialTransaction));
                responseData.put("id", "1");
            } else {
                IntStream.range(difference, 0)
                        .forEach(i -> wmsMaterialTransactionServiceImpl.deleteByRfidMaterialIDLimitOne(wmsMaterialTransaction));
                responseData.put("id", "2");
            }
            return new ApiResponse<>(responseData);
        } catch (Exception e) {
            log.info(e.getMessage());
            return new ApiResponse<>(null, "Error occurred while processing the request: " + e.getMessage());
        }
    }

    @ApiOperation(value = "rfidmaterial/delete",notes = "rfidmaterial/delete")
    @PostMapping("/wms/rfidmaterial/delete")
    public ApiResponse<Map<String, String>> rfidmaterialDelete(@RequestBody AddRfidMaterialRequest addRfidMaterialRequest) {
        Map<String, String> responseData = new HashMap<>();
        try {
            WmsMaterialTransaction wmsMaterialTransaction = new WmsMaterialTransaction();
            wmsMaterialTransaction.setRf_id(addRfidMaterialRequest.getRfid());
            wmsMaterialTransaction.setMaterial_id(addRfidMaterialRequest.getMaterialId());
            wmsMaterialTransactionServiceImpl.deleteByRfidMaterialIDLimitOne(wmsMaterialTransaction);
            responseData.put("id", "1");
            return new ApiResponse<>(responseData);
        }catch (Exception e){
            log.info(e.getMessage());
            return new ApiResponse<>( null,"Error occurred while processing the request: " + e.getMessage());
        }
    }
    @ApiOperation(value = "rfidmaterial/get", notes = "rfidmaterial/get")
    @PostMapping("/wms/rfidmaterial/get")
    public ApiResponse<List<RfidmaterialGetResponse>> rfidmaterialGet(@RequestBody AddRfidMaterialRequest addRfidMaterialRequest) {
        try {
            WmsMaterialTransaction wmsMaterialTransaction = new WmsMaterialTransaction();
            wmsMaterialTransaction.setRf_id(addRfidMaterialRequest.getRfid());
            wmsMaterialTransaction.setMaterial_id(addRfidMaterialRequest.getMaterialId());

            List<RfidmaterialGetResponse> rfidmaterialGetResponses = wmsMaterialTransactionServiceImpl.selectAllGroupByMaterialIDRfid(wmsMaterialTransaction)
                    .stream()
                    .map(transaction -> {
                        RfidmaterialGetResponse rfidmaterialGetResponse = new RfidmaterialGetResponse();
                        rfidmaterialGetResponse.setRfid(transaction.getRf_id());
                        rfidmaterialGetResponse.setMaterialId(transaction.getMaterial_id());
                        rfidmaterialGetResponse.setQuantity(transaction.getQuantity());

                        WmsMaterial materialTemp= new WmsMaterial();
                        materialTemp.setId(transaction.getMaterial_id());
                        WmsMaterial wmsMaterial = wmsMaterialServiceImpl.selectAll(materialTemp).stream().findFirst().orElse(null);
                        if (wmsMaterial != null) {
                            rfidmaterialGetResponse.setMaterialName(wmsMaterial.getName());
                        }
                        rfidmaterialGetResponse.setCreateTime(transaction.getCreate_time());
                        rfidmaterialGetResponse.setUpdateTime(transaction.getUpdate_time());
                        return rfidmaterialGetResponse;
                    })
                    .collect(Collectors.toList());

            return new ApiResponse<>(rfidmaterialGetResponses);
        } catch (Exception e) {
            log.info("Error occurred while processing the request: " + e.getMessage(), e);
            return new ApiResponse<>(null, "Error occurred while processing the request: " + e.getMessage());
        }
    }

}
