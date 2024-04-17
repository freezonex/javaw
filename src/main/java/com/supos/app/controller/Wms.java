package com.supos.app.controller;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.supos.app.config.ApiResponse;
import com.supos.app.vo.ShelfColModel;
import com.supos.app.vo.ShelfModel;
import com.supos.app.entity.*;
import com.supos.app.service.impl.*;
import com.supos.app.vo.*;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
@RestController
public class Wms {

    @Autowired
    WmsWarehouseServiceImpl wmsWarehouseServiceImpl;

    @Autowired
    WmsRfidMaterialServiceImpl wmsRfidMaterialServiceImpl;

    @Autowired
    WmsStorageLocationServiceImpl wmsStorageLocationServiceImpl;

    @Autowired
    WmsMaterialServiceImpl wmsMaterialServiceImpl;

    @Autowired
    WmsMaterialTransactionServiceImpl wmsMaterialTransactionServiceImpl;

    @Autowired
    WmsThreedWarehouseServiceImpl wmsThreedWarehouseServiceImpl;

    @ApiOperation(value = "wmsllmask",notes = "wmsllmask")
    @PostMapping("wmsllmask")
    public ResponseEntity<String> wmsllmask(@RequestBody Map<String, Object> requestBody) {
        // 在方法内创建RestTemplate实例
        RestTemplate restTemplate = new RestTemplate();
        // 目标URL
        String targetUrl = "http://office.unibutton.com:6589/wmsllmask";
        // 设置HTTP头信息
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        // 创建请求实体对象
        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(requestBody, headers);
        // 使用RestTemplate将请求转发到目标URL，并接收响应
        ResponseEntity<String> response = restTemplate.exchange(targetUrl, HttpMethod.POST, entity, String.class);
        // 返回响应给客户端
        return response;
    }

    @ApiOperation(value = "today/outbound/done",notes = "today/outbound/done")
    @PostMapping("today/outbound/done")
    public ApiResponse<Map<String, String>> todayOunboundDone() {
        Map<String, String> responseData = new HashMap<>();
        try {
            responseData.put("count", String.valueOf(wmsMaterialTransactionServiceImpl.selectAllByCreateTimeGroupByOutboundId(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()),"done")));
            return new ApiResponse<>(responseData);
        }catch (Exception e){
            log.info(e.getMessage());
            return new ApiResponse<>( null,"Error occurred while processing the request: " + e.getMessage());
        }
    }

    @ApiOperation(value = "today/outbound",notes = "today/outbound")
    @PostMapping("today/outbound")
    public ApiResponse<Map<String, String>> todayOubound() {
        Map<String, String> responseData = new HashMap<>();
        try {
            responseData.put("count", String.valueOf(wmsMaterialTransactionServiceImpl.selectAllByCreateTimeGroupByOutboundId(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()),null)));
            return new ApiResponse<>(responseData);
        }catch (Exception e){
            log.info(e.getMessage());
            return new ApiResponse<>( null,"Error occurred while processing the request: " + e.getMessage());
        }
    }

    @ApiOperation(value = "today/inbound/done",notes = "today/inbound/done")
    @PostMapping("today/inbound/done")
    public ApiResponse<Map<String, String>> todayInboundDone() {
        Map<String, String> responseData = new HashMap<>();
        try {
            responseData.put("count", String.valueOf(wmsMaterialTransactionServiceImpl.selectAllByCreateTimeGroupByInboundId(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()),"done")));
            return new ApiResponse<>(responseData);
        }catch (Exception e){
            log.info(e.getMessage());
            return new ApiResponse<>( null,"Error occurred while processing the request: " + e.getMessage());
        }
    }

    @ApiOperation(value = "today/inbound",notes = "today/inbound")
    @PostMapping("today/inbound")
    public ApiResponse<Map<String, String>> todayInbound() {
        Map<String, String> responseData = new HashMap<>();
        try {
            responseData.put("count", String.valueOf(wmsMaterialTransactionServiceImpl.selectAllByCreateTimeGroupByInboundId(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()),null)));
            return new ApiResponse<>(responseData);
        }catch (Exception e){
            log.info(e.getMessage());
            return new ApiResponse<>( null,"Error occurred while processing the request: " + e.getMessage());
        }
    }

    @ApiOperation(value = "warehouse/namemap", notes = "warehouse/namemap")
    @PostMapping("/wms/warehouse/namemap")
    public ApiResponse<PageInfo<WarehouseNamemap>> warehouseNamemap(@RequestBody(required = false) WmsWarehouse wmsWarehouse, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize) {
        try {
            PageInfo<WmsWarehouse> pageInfo = PageHelper.startPage(pageNum, pageSize)
                    .doSelectPageInfo(() -> wmsWarehouseServiceImpl.selectAll(wmsWarehouse));
            List<WarehouseNamemap> mappedList = pageInfo.getList().stream()
                    .map(a -> {
                        WarehouseNamemap warehouseNamemapTmp = new WarehouseNamemap();
                        warehouseNamemapTmp.setName(a.getName());
                        warehouseNamemapTmp.setId(a.getId());
                        return warehouseNamemapTmp;
                    })
                    .collect(Collectors.toList());

            PageInfo<WarehouseNamemap> responsePageInfo = new PageInfo<>();
            BeanUtils.copyProperties(pageInfo, responsePageInfo); // Copy pagination details
            responsePageInfo.setList(mappedList); // Set the transformed list

            return new ApiResponse<>(responsePageInfo);

        } catch (Exception e) {
            log.info(e.getMessage());
            return new ApiResponse<>(null, "Error occurred while processing the request: " + e.getMessage());
        }
    }

    @ApiOperation(value = "storagelocation/namemap", notes = "storagelocation/namemap")
    @PostMapping("/wms/storagelocation/namemap")
    public ApiResponse<PageInfo<WarehouseNamemap>> storagelocationNamemap(@RequestBody(required = false) WmsStorageLocation wmsStorageLocation, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize) {
        try {
            PageInfo<WmsStorageLocation> pageInfo = PageHelper.startPage(pageNum, pageSize)
                    .doSelectPageInfo(() -> wmsStorageLocationServiceImpl.selectAll(wmsStorageLocation));
            List<WarehouseNamemap> mappedList = pageInfo.getList().stream()
                    .map(a -> {
                        WarehouseNamemap warehouseNamemapTmp = new WarehouseNamemap();
                        warehouseNamemapTmp.setName(a.getName());
                        warehouseNamemapTmp.setId(a.getId());
                        return warehouseNamemapTmp;
                    })
                    .collect(Collectors.toList());

            PageInfo<WarehouseNamemap> responsePageInfo = new PageInfo<>();
            BeanUtils.copyProperties(pageInfo, responsePageInfo); // Copy pagination details
            responsePageInfo.setList(mappedList); // Set the transformed list

            return new ApiResponse<>(responsePageInfo);

        } catch (Exception e) {
            log.info(e.getMessage());
            return new ApiResponse<>(null, "Error occurred while processing the request: " + e.getMessage());
        }
    }

    @ApiOperation(value = "warehousestoragelocation/idmap", notes = "warehousestoragelocation/idmap")
    @PostMapping("/wms/warehousestoragelocation/idmap")
    public ApiResponse<PageInfo<WarehousestoragelocationIdmap>> warehousestoragelocationIdmap(@RequestBody(required = false) WmsStorageLocation wmsStorageLocation, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize) {
        try {
            PageInfo<WmsStorageLocation> pageInfo = PageHelper.startPage(pageNum, pageSize)
                    .doSelectPageInfo(() -> wmsStorageLocationServiceImpl.selectAll(wmsStorageLocation));
            List<WarehousestoragelocationIdmap> mappedList = pageInfo.getList().stream()
                    .collect(Collectors.groupingBy(WmsStorageLocation::getWarehouse_id)) // Assuming getWarehouseId is the correct method name.
                    .entrySet().stream()
                    .map(entry -> {
                        WarehousestoragelocationIdmap idmap = new WarehousestoragelocationIdmap();
                        idmap.setId(entry.getKey());
                        WmsWarehouse wmsWarehouse = new WmsWarehouse();
                        wmsWarehouse.setId(entry.getKey());
                        idmap.setName(wmsWarehouseServiceImpl.selectAll(wmsWarehouse).get(0).getName());

                        List<WarehouseNamemap> namemaps = entry.getValue().stream().map(storageLocation -> {
                            WarehouseNamemap namemap = new WarehouseNamemap();
                            namemap.setId(storageLocation.getId());
                            namemap.setName(storageLocation.getName());
                            return namemap;
                        }).collect(Collectors.toList());
                        idmap.setWarehouseNamemap(namemaps); // Assuming setWarehouseNamemap accepts a list of WarehouseNamemap
                        return idmap;
                    })
                    .collect(Collectors.toList());

            PageInfo<WarehousestoragelocationIdmap> responsePageInfo = new PageInfo<>(mappedList);
            BeanUtils.copyProperties(pageInfo, responsePageInfo, "list"); // Copy pagination details except the list
            return new ApiResponse<>(responsePageInfo);

        } catch (Exception e) {
            log.info(e.getMessage());
            return new ApiResponse<>(null, "Error occurred while processing the request: " + e.getMessage());
        }
    }

    @ApiOperation(value = "warehouse/add",notes = "warehouse/add")
    @PostMapping("/wms/warehouse/add")
    public ApiResponse<Map<String, String>> warehouseInsert(@RequestBody(required = false) WmsWarehouse wmsWarehouse) {
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
    public ApiResponse<Map<String, String>> warehouseUpdate(@RequestBody(required = false) WmsWarehouse wmsWarehouse) {
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
    public ApiResponse<Map<String, String>> warehouseDelete(@RequestBody(required = false) ID id) {
        Map<String, String> responseData = new HashMap<>();
        try {
            WmsWarehouse wmsWarehouse = new WmsWarehouse();
            wmsWarehouse.setId(id.getID());
            responseData.put("id", String.valueOf(wmsWarehouseServiceImpl.deleteWarehouseById(wmsWarehouse)));
        }catch (Exception e){
            log.info(e.getMessage());
            return new ApiResponse<>( null,"Error occurred while processing the request: " + e.getMessage());
        }
        return new ApiResponse<>(responseData);
    }

    @ApiOperation(value = "warehouse/get", notes = "warehouse/get")
    @PostMapping("/wms/warehouse/get")
    public ApiResponse<PageInfo<WarehouseSelectAllResponse>> warehouseSelectAll(@RequestBody(required = false) WmsWarehouse wmsWarehouse, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize) {
        try {
            PageInfo<WmsWarehouse> pageInfo = PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(() -> wmsWarehouseServiceImpl.selectAll(wmsWarehouse));

            List<WmsWarehouse> wmsWarehouseList = pageInfo.getList();
                List<WarehouseSelectAllResponse> warehouseSelectAllResponses = wmsWarehouseList.stream()
                    .map(warehouse -> {
//                        WmsStorageLocation query = new WmsStorageLocation();
//                        query.setWarehouse_id(warehouse.getId());
//                        List<WmsStorageLocation> storageLocations = wmsStorageLocationServiceImpl.selectAll(query);
//
////                        List<WarehouseSelectAllLocations> warehouseSelectAllLocationsList = storageLocations.stream().map(storageLocation -> {
////                                    WmsMaterialTransaction materialTransactionquery = new WmsMaterialTransaction();
////                                    materialTransactionquery.setWarehouse_id(storageLocation.getWarehouse_id());
////                                    materialTransactionquery.setStock_location_id(storageLocation.getId());
////
////                                    List<WmsMaterialTransaction> MaterialTransactions = wmsMaterialTransactionServiceImpl.selectAllGroupByMaterialCode(materialTransactionquery);
////
////                                    List<WarehouseSelectAllMaterial> warehouseMaterials = MaterialTransactions.stream()
////                                            .map(transaction -> {
////                                                WarehouseSelectAllMaterial warehouseMaterial = new WarehouseSelectAllMaterial(transaction);
////                                                WmsMaterial wmsMaterial = new WmsMaterial();
////                                                wmsMaterial.setProduct_code(transaction.getMaterial_code());
////                                                List<WmsMaterial> materials = wmsMaterialServiceImpl.selectAll(wmsMaterial);
////                                                if (!materials.isEmpty()) {
////                                                    warehouseMaterial.setMaterial_name(materials.get(0).getName());
////                                                }
////                                                return warehouseMaterial;
////                                            })
////                                            .collect(Collectors.toList());
////
////                                    WarehouseSelectAllLocations warehouseSelectAllLocation = new WarehouseSelectAllLocations(storageLocation);
////                                    warehouseSelectAllLocation.setMaterials(warehouseMaterials);
////                                    return warehouseSelectAllLocation;
////                                }
////                        ).collect(Collectors.toList());
//
                        WarehouseSelectAllResponse response = new WarehouseSelectAllResponse(warehouse);
//                        response.setStore_locations(warehouseSelectAllLocationsList);
                        return response;
                    })
                    .collect(Collectors.toList());

            PageInfo<WarehouseSelectAllResponse> responsePageInfo = new PageInfo<>(warehouseSelectAllResponses);
            BeanUtils.copyProperties(pageInfo, responsePageInfo, "list"); // Copy pagination details except the list
            return new ApiResponse<>(responsePageInfo);
        } catch (Exception e) {
            log.info(e.getMessage());
            return new ApiResponse<>(null, "Error occurred while processing the request: " + e.getMessage());
        }
    }

    @ApiOperation(value = "storagelocation/add",notes = "storagelocation/add")
    @PostMapping("/wms/storagelocation/add")
    public ApiResponse<Map<String, String>> storagelocationInsert(@RequestBody(required = false) WmsStorageLocation wmsStorageLocation) {
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
    public ApiResponse<Map<String, String>> storagelocationUpdate(@RequestBody(required = false) WmsStorageLocation wmsStorageLocation) {
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
    public ApiResponse<Map<String, String>> storagelocationDelete(@RequestBody(required = false) ID id) {
        Map<String, String> responseData = new HashMap<>();
        try {
            WmsStorageLocation wmsStorageLocation = new WmsStorageLocation();
            wmsStorageLocation.setId(id.getID());
            responseData.put("id", String.valueOf(wmsStorageLocationServiceImpl.deleteStorageLocationById(wmsStorageLocation)));
            return new ApiResponse<>(responseData);
        }catch (Exception e){
            log.info(e.getMessage());
            return new ApiResponse<>( null,"Error occurred while processing the request: " + e.getMessage());
        }
    }

    @ApiOperation(value = "storagelocation/get", notes = "storagelocation/get")
    @PostMapping("/wms/storagelocation/get")
    public ApiResponse<PageInfo<StorageLocationSelectAllResponse>> storagelocationSelectAll(@RequestBody(required = false) WmsStorageLocation wmsStorageLocation,@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize) {

        try {
            PageInfo<WmsStorageLocation> pageInfo = PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(() -> wmsStorageLocationServiceImpl.selectAll(wmsStorageLocation));

            List<StorageLocationSelectAllResponse> StorageLocationSelectAllResponses = pageInfo.getList().stream().map(
                    storageLocation -> {
                        StorageLocationSelectAllResponse storageLocationSelectAllResponse = new StorageLocationSelectAllResponse(storageLocation);

                        WmsMaterialTransaction materialTransactionquery = new WmsMaterialTransaction();
                        materialTransactionquery.setWarehouse_id(storageLocation.getWarehouse_id());
                        materialTransactionquery.setStock_location_id(storageLocation.getId());

                        List<WmsMaterialTransaction> MaterialTransactions = wmsMaterialTransactionServiceImpl.selectAllGroupByMaterialCode(materialTransactionquery);

                        List<StorageLocationSelectAllMaterial> storageLocationMaterials = MaterialTransactions.stream()
                                .map(transaction -> {
                                    StorageLocationSelectAllMaterial locationMaterial = new StorageLocationSelectAllMaterial(transaction);
                                    WmsMaterial wmsMaterial = new WmsMaterial();
                                    wmsMaterial.setProduct_code(transaction.getMaterial_code());
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
            PageInfo<StorageLocationSelectAllResponse> responsePageInfo = new PageInfo<>(StorageLocationSelectAllResponses);
            BeanUtils.copyProperties(pageInfo, responsePageInfo, "list"); // Copy pagination details except the list
            return new ApiResponse<>(responsePageInfo);

        } catch (Exception e) {
            log.info(e.getMessage());
            return new ApiResponse<>(null, "Error occurred while processing the request: " + e.getMessage());
        }
    }

    @ApiOperation(value = "storagelocation/getPlaneLocations", notes = "storagelocation/getPlaneLocations")
    @PostMapping("/wms/storagelocation/getPlaneLocations")
    public ApiResponse<PageInfo<ShelfModel>> getPlaneLocations(@RequestBody(required = false) WmsStorageLocation wmsStorageLocation,@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize) {
        try {
            List<WmsStorageLocation> locations=wmsStorageLocationServiceImpl.selectAll(wmsStorageLocation);

            List<ShelfModel> shelfModels = new ArrayList<ShelfModel>();
            String shelfName=null;
            String shelfColName=null;
            ShelfModel lastshelfModel = null;
            for (int i = 0; i <locations.size() ; i++) {
                WmsStorageLocation location = locations.get(i);
                String[]  sections=location.getName().split("-");

                ShelfModel shelfModel = new ShelfModel();
                if(sections.length>2)
                {
                    if(shelfName==null || (shelfName!=null&&!shelfName.equals(sections[0])))
                    {
                        shelfModel.setSn(i+1);
                        shelfModel.setShelfId(i+1);
                        shelfModel.setShelfName(sections[0]);
                        shelfName=shelfModel.getShelfName();

                        shelfColName=sections[1];
                        String locationName=location.getName();

                        List<ShelfColModel> shelfColModels=new ArrayList<ShelfColModel>();
                        ShelfColModel shelfColModel =null;
                        List<Long> items=new ArrayList<Long>();

                        for (int j = i; j < locations.size(); j++) {
                            String[]  sectionLoop=locations.get(j).getName().split("-");
                            if(!sectionLoop[0].equals(shelfName))
                            {
                                shelfColModel.setItems(items);
                                shelfColModels.add(shelfColModel);
                                shelfModel.setShelfCols(shelfColModels);
                                shelfModels.add(shelfModel);
                                items=new ArrayList<>();
                                break;
                            }
                            if(sectionLoop[0].equals(shelfName)&&!(sectionLoop[1].equals(shelfColName)))
                            {
                                if(!Objects.isNull(shelfColModel)){
                                    shelfColModel.setItems(items);
                                    shelfColModels.add(shelfColModel);
                                    shelfModel.setShelfCols(shelfColModels);
                                }
                                shelfColName=sectionLoop[1];
                                locationName=locations.get(j).getName();
                                items=new ArrayList<>();
                            }
                            if(sectionLoop[0].equals(shelfName)){
                                if(locations.get(j).getName().equals(locationName)){
                                    shelfColModel= new ShelfColModel();
                                    shelfColModel.setShelfId(shelfModel.getShelfId());
                                    shelfColModel.setColId(j+1);
                                    shelfColModel.setColName(shelfColName);
                                }
                                if(sectionLoop[1].equals(shelfColName))
                                {
                                    items.add(locations.get(j).getId());
                                }
                                if(j==locations.size()-1){
                                    lastshelfModel=new ShelfModel();
                                    shelfColModel.setItems(items);
                                    shelfColModels.add(shelfColModel);
                                    shelfModel.setShelfCols(shelfColModels);
                                    lastshelfModel=shelfModel;
                                }
                            }
                        }
                    }

                    if(i==locations.size()-1&&!Objects.isNull(lastshelfModel))
                    {
                        shelfModels.add(lastshelfModel);
                    }
                }
            }
            PageInfo<ShelfModel> responsePageInfo = new PageInfo<ShelfModel>(shelfModels);
            return new ApiResponse<>(responsePageInfo);

        } catch (Exception e) {
            log.info(e.getMessage());
            return new ApiResponse<>(null, "Error occurred while processing the request: " + e.getMessage());
        }
    }

    @ApiOperation(value = "material/add",notes = "material/add")
    @PostMapping("/wms/material/add")
    public ApiResponse<Map<String, String>> materialInsert(@RequestBody(required = false) WmsMaterial wmsMaterial) {
        Map<String, String> responseData = new HashMap<>();
        try {
            Long[] locations=wmsMaterial.getLocations();
            if(locations!=null && locations.length>0){
                for(Long locationId:locations){
                    wmsMaterial.setExpact_stock_location_id(locationId);
                    responseData.put("id", String.valueOf(wmsMaterialServiceImpl.insertSelective(wmsMaterial)));
                }
                }
            return new ApiResponse<>(responseData);
        }catch (Exception e){
            log.info(e.getMessage());
            return new ApiResponse<>( null,"Error occurred while processing the request: " + e.getMessage());
        }
    }

    @ApiOperation(value = "material/update",notes = "material/update")
    @PostMapping("/wms/material/update")
    public ApiResponse<Map<String, String>> materialUpdate(@RequestBody(required = false) WmsMaterial wmsMaterial) {
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
    public ApiResponse<Map<String, String>> materialDelete(@RequestBody(required = false) ID id) {
        Map<String, String> responseData = new HashMap<>();
        try {
            WmsMaterial wmsMaterial = new WmsMaterial();
            wmsMaterial.setId(id.getID());
            responseData.put("id", String.valueOf(wmsMaterialServiceImpl.deleteWmsMaterialById(wmsMaterial)));
            return new ApiResponse<>(responseData);
        }catch (Exception e){
            log.info(e.getMessage());
            return new ApiResponse<>( null,"Error occurred while processing the request: " + e.getMessage());
        }
    }

//    @ApiOperation(value = "material/get", notes = "material/get")
//    @PostMapping("/wms/material/get")
//    public ApiResponse<PageInfo<MaterialSelectAllResponse>> materialSelectAll(@RequestBody(required = false) WmsMaterial wmsMaterial, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize) {
//        try {
//            PageInfo<WmsMaterial> pageInfo = PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(() -> wmsMaterialServiceImpl.selectAll(wmsMaterial));
//            List<MaterialSelectAllResponse> materialSelectAllResponses = pageInfo.getList().stream().map(material -> {
//                WmsMaterialTransaction wmsMaterialTransactionQuery = new WmsMaterialTransaction();
//                wmsMaterialTransactionQuery.setMaterial_code(material.getProduct_code());
//                List<WmsMaterialTransaction> transactions = wmsMaterialTransactionServiceImpl.selectAllGroupByMaterialCodeStockLocationId(wmsMaterialTransactionQuery);
//
//                List<String> ids = new ArrayList<>();
//                List<String> names = new ArrayList<>();
//
//                transactions.forEach(transaction -> {
//                    ids.add(String.valueOf(transaction.getId()));
//                    WmsStorageLocation wmsStorageLocationQuery = new WmsStorageLocation();
//                    wmsStorageLocationQuery.setId(transaction.getStock_location_id());
//                    List<WmsStorageLocation> locations = wmsStorageLocationServiceImpl.selectAll(wmsStorageLocationQuery);
//                    if (!locations.isEmpty()) {
//                        names.add(locations.get(0).getName());
//                    }
//                });
//
//                MaterialSelectAllResponse response = new MaterialSelectAllResponse(material);
//                response.setStorage_location_id(ids);
//                response.setStorage_location(names);
//                return response;
//            }).collect(Collectors.toList());
//            PageInfo<MaterialSelectAllResponse> responsePageInfo = new PageInfo<>(materialSelectAllResponses);
//            BeanUtils.copyProperties(pageInfo, responsePageInfo, "list"); // Copy pagination details except the list
//            return new ApiResponse<>(responsePageInfo);
//
//        } catch (Exception e) {
//            log.info(e.getMessage());
//            return new ApiResponse<>(null, "Error occurred while processing the request: " + e.getMessage());
//        }
//    }

    @ApiOperation(value = "material/get", notes = "material/get")
    @PostMapping("/wms/material/get")
    public ApiResponse<PageInfo<MaterialSelectAllResponse>> materialSelectAll(@RequestBody(required = false) WmsMaterial wmsMaterial, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize) {
        try {
            return new ApiResponse<>(PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(() -> wmsMaterialServiceImpl.selectAll(wmsMaterial)));

        } catch (Exception e) {
            log.info(e.getMessage());
            return new ApiResponse<>(null, "Error occurred while processing the request: " + e.getMessage());
        }
    }

//    @ApiOperation(value = "inbound/add", notes = "inbound/add")
//    @PostMapping("/wms/inbound/add")
//    public ApiResponse<Map<String, String>> inboundInsert(@RequestBody(required = false) AddInboundRequest addInboundRequest) {
//        try {
//            Map<String, String> responseData = new HashMap<>();
//
//            if ("PDA".equals(addInboundRequest.getSource())) {
//                long newInboundId = System.nanoTime() + ThreadLocalRandom.current().nextLong(1_000_000L, 10_000_000L);
//                addInboundRequest.getShelfRecords().forEach(shelfInventory -> {
//                    shelfInventory.getInventory().forEach(inventory -> {
//
//                        WmsMaterialTransaction wmsMaterialTransaction = new WmsMaterialTransaction();
//                        wmsMaterialTransaction.setType(addInboundRequest.getType());
//                        wmsMaterialTransaction.setSource(addInboundRequest.getSource());
//                        wmsMaterialTransaction.setStatus(addInboundRequest.getStatus());
//                        wmsMaterialTransaction.setRf_id(inventory.getRfid());
//                        wmsMaterialTransaction.setInbound_id(newInboundId);
//                        wmsMaterialTransaction.setStock_location_id(Long.valueOf(shelfInventory.getStorageLocationId()));
//
//                        WmsRfidMaterial wmsRfidMaterial = new WmsRfidMaterial();
//                        wmsRfidMaterial.setRf_id(inventory.getRfid());
//
//                        wmsMaterialTransaction.setMaterial_code(wmsRfidMaterialServiceImpl.selectall(wmsRfidMaterial).get(0).getMaterial_code());
//                        wmsMaterialTransaction.setQuantity(inventory.getQuantity());
//
//                        IntStream.range(0, inventory.getQuantity())
//                                .forEach(i -> responseData.put("id", String.valueOf(wmsMaterialTransactionServiceImpl.insertSelective(wmsMaterialTransaction))));
//                    });
//                });
//            } else if ("manual".equals(addInboundRequest.getSource())) {
//                long newInboundId = System.nanoTime() + ThreadLocalRandom.current().nextLong(1_000_000L, 10_000_000L);
//                addInboundRequest.getShelfRecords().forEach(shelfInventory -> {
//                    shelfInventory.getInventory().forEach(inventory -> {
//
//                        WmsMaterialTransaction wmsMaterialTransaction = new WmsMaterialTransaction();
//                        wmsMaterialTransaction.setType(addInboundRequest.getType());
//                        wmsMaterialTransaction.setSource(addInboundRequest.getSource());
//                        wmsMaterialTransaction.setStatus(addInboundRequest.getStatus());
//                        wmsMaterialTransaction.setRf_id(inventory.getRfid());
//                        wmsMaterialTransaction.setInbound_id(newInboundId);
//                        wmsMaterialTransaction.setStock_location_id(Long.valueOf(shelfInventory.getStorageLocationId()));
//                        wmsMaterialTransaction.setMaterial_code(inventory.getMaterialCode());
//                        wmsMaterialTransaction.setQuantity(inventory.getQuantity());
//
//                        IntStream.range(0, inventory.getQuantity())
//                                .forEach(i -> responseData.put("id", String.valueOf(wmsMaterialTransactionServiceImpl.insertSelective(wmsMaterialTransaction))));
//                    });
//                });
//            }
//            return new ApiResponse<>(responseData);
//        } catch (Exception e) {
//            log.info("Error occurred while processing the request: " + e.getMessage(), e); // 使用日志记录异常堆栈
//            return new ApiResponse<>(null, "Error occurred while processing the request: " + e.getMessage());
//        }
//    }

    @ApiOperation(value = "inbound/add", notes = "inbound/add")
    @PostMapping("/wms/inbound/add")
    public ApiResponse<Map<String, String>> inboundInsert(@RequestBody(required = false) AddInboundRequestNew addInboundRequestNew) {
        try {
            long ID = IdWorker.getId();

            Map<String, String> responseData = new HashMap<>();
            if ("PDA".equals(addInboundRequestNew.getSource())) {

                addInboundRequestNew.getAddInboundRequestDetail().forEach(addInboundRequestDetail -> {

                    WmsMaterialTransaction wmsMaterialTransaction = new WmsMaterialTransaction();
                    wmsMaterialTransaction.setInbound_creator(addInboundRequestNew.getCreator());
                    wmsMaterialTransaction.setInbound_purchase_order_no(addInboundRequestNew.getPurchase_order_no());
                    wmsMaterialTransaction.setInbound_supplier(addInboundRequestNew.getSupplier());
                    wmsMaterialTransaction.setInbound_delivery_date(addInboundRequestNew.getDelivery_date());

                    WmsRfidMaterial wmsRfidMaterial = new WmsRfidMaterial();
                    wmsRfidMaterial.setRf_id(addInboundRequestDetail.getRf_id());
                    wmsMaterialTransaction.setMaterial_code(wmsRfidMaterialServiceImpl.selectall(wmsRfidMaterial).get(0).getMaterial_code());

                    wmsMaterialTransaction.setWarehouse_id(addInboundRequestDetail.getWh_id());

                    if (addInboundRequestDetail.getWh_id() == 11) {
                        WmsThreedWarehouse wmsThreedWarehouse = new WmsThreedWarehouse();
                        wmsThreedWarehouse.setLocation_id(addInboundRequestDetail.getStock_location_id());
                        wmsThreedWarehouse.setMaterial_name(wmsRfidMaterialServiceImpl.selectall(wmsRfidMaterial).get(0).getMaterial_code());
                        wmsThreedWarehouseServiceImpl.updateSelectiveByLocationId(wmsThreedWarehouse);
                    }

                    wmsMaterialTransaction.setStock_location_id(addInboundRequestDetail.getStock_location_id());
                    wmsMaterialTransaction.setInbound_id(ID);
                    wmsMaterialTransaction.setSource(addInboundRequestNew.getSource());
                    wmsMaterialTransaction.setInbound_status("pending");
                    wmsMaterialTransaction.setCreate_time(new Date());

                    IntStream.range(0, addInboundRequestDetail.getQuantity())
                            .forEach(i -> responseData.put("id", String.valueOf(wmsMaterialTransactionServiceImpl.insertSelective(wmsMaterialTransaction))));
                });

            } else if ("manual".equals(addInboundRequestNew.getSource())) {
                addInboundRequestNew.getAddInboundRequestDetail().forEach(addInboundRequestDetail -> {

                    WmsMaterialTransaction wmsMaterialTransaction = new WmsMaterialTransaction();
                    wmsMaterialTransaction.setInbound_creator(addInboundRequestNew.getCreator());
                    wmsMaterialTransaction.setInbound_purchase_order_no(addInboundRequestNew.getPurchase_order_no());
                    wmsMaterialTransaction.setInbound_supplier(addInboundRequestNew.getSupplier());
                    wmsMaterialTransaction.setInbound_delivery_date(addInboundRequestNew.getDelivery_date());
                    wmsMaterialTransaction.setMaterial_code(addInboundRequestDetail.getMaterial_code());
                    wmsMaterialTransaction.setWarehouse_id(addInboundRequestDetail.getWh_id());
                    wmsMaterialTransaction.setStock_location_id(addInboundRequestDetail.getStock_location_id());
                    wmsMaterialTransaction.setInbound_id(ID);
                    wmsMaterialTransaction.setSource(addInboundRequestNew.getSource());
                    wmsMaterialTransaction.setInbound_status("pending");
                    wmsMaterialTransaction.setCreate_time(new Date());

                    if (addInboundRequestDetail.getWh_id() == 11) {
                        WmsThreedWarehouse wmsThreedWarehouse = new WmsThreedWarehouse();
                        wmsThreedWarehouse.setLocation_id(addInboundRequestDetail.getStock_location_id());
                        wmsThreedWarehouse.setMaterial_name(addInboundRequestDetail.getMaterial_code());
                        wmsThreedWarehouseServiceImpl.updateSelectiveByLocationId(wmsThreedWarehouse);
                    }

                    IntStream.range(0, addInboundRequestDetail.getQuantity())
                            .forEach(i -> responseData.put("id", String.valueOf(wmsMaterialTransactionServiceImpl.insertSelective(wmsMaterialTransaction))));
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
    public ApiResponse<Map<String, String>> inboundUpdate(@RequestBody(required = false) UpdateInboundRequest updateInboundRequest) {
        Map<String, String> responseData = new HashMap<>();
        try {
            updateInboundRequest.setUpdate_time(new Date());
            responseData.put("id", String.valueOf(wmsMaterialTransactionServiceImpl.updateByInboundId(updateInboundRequest)));
            return new ApiResponse<>(responseData);
        }catch (Exception e){
            log.info(e.getMessage());
            return new ApiResponse<>( null,"Error occurred while processing the request: " + e.getMessage());
        }
    }

    @ApiOperation(value = "inbound/delete", notes = "inbound/delete")
    @PostMapping("/wms/inbound/delete")
    public ApiResponse<Map<String, String>> inboundDelete(@RequestBody(required = false)ID id) {
        Map<String, String> responseData = new HashMap<>();
        try {
            UpdateInboundRequest updateInboundRequest = new UpdateInboundRequest();
            updateInboundRequest.setId(id.getID());
            responseData.put("id", String.valueOf(wmsMaterialTransactionServiceImpl.deleteForInbound(updateInboundRequest)));
            return new ApiResponse<>(responseData);
        }catch (Exception e){
            log.info(e.getMessage());
            return new ApiResponse<>( null,"Error occurred while processing the request: " + e.getMessage());
        }
    }

    @ApiOperation(value = "inbound/get", notes = "inbound/get")
    @PostMapping("/wms/inbound/get")
    public ApiResponse<PageInfo<InboundDetail>> inboundGet(@RequestBody(required = false) InboundDetail inboundDetail,@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize) {
        try {
            return new ApiResponse<>(PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(() ->  wmsMaterialTransactionServiceImpl.selectByInboundRfidType(inboundDetail)));
        }catch (Exception e){
            log.info(e.getMessage());
            return new ApiResponse<>( null,"Error occurred while processing the request: " + e.getMessage());
        }
    }

//    @ApiOperation(value = "outbound/add", notes = "outbound/add")
//    @PostMapping("/wms/outbound/add")
//    public ApiResponse<Map<String, String>> outboundInsert(@RequestBody(required = false) AddInboundRequest addInboundRequest) {
//        try {
//            Map<String, String> responseData = new HashMap<>();
//
//            if ("PDA".equals(addInboundRequest.getSource())) {
//                long newOutboundId = System.nanoTime() + ThreadLocalRandom.current().nextLong(1_000_000L, 10_000_000L);
//                addInboundRequest.getShelfRecords().forEach(shelfInventory -> {
//                    shelfInventory.getInventory().forEach(inventory -> {
//                        int updated = wmsMaterialTransactionServiceImpl.updateForTopNTransactionsOutboundPDA(
//                                addInboundRequest.getType(),
//                                addInboundRequest.getSource(),
//                                addInboundRequest.getStatus(),
//                                inventory.getRfid(),
//                                newOutboundId,
//                                shelfInventory.getStorageLocationId(),
//                                inventory.getMaterialCode(),
//                                inventory.getQuantity()
//                        );
//                        responseData.put("id", String.valueOf(updated));
//                    });
//                });
//            } else if ("manual".equals(addInboundRequest.getSource())) {
//                long newOutboundId = System.nanoTime() + ThreadLocalRandom.current().nextLong(1_000_000L, 10_000_000L);
//                addInboundRequest.getShelfRecords().forEach(shelfInventory -> {
//                    shelfInventory.getInventory().forEach(inventory -> {
//                        int updated = wmsMaterialTransactionServiceImpl.updateForTopNTransactionsOutboundManual(
//                                addInboundRequest.getType(),
//                                addInboundRequest.getSource(),
//                                addInboundRequest.getStatus(),
//                                inventory.getRfid(),
//                                newOutboundId,
//                                shelfInventory.getStorageLocationId(),
//                                inventory.getMaterialCode(),
//                                inventory.getQuantity()
//                        );
//                        responseData.put("id", String.valueOf(updated));
//                    });
//                });
//            }
//            return new ApiResponse<>(responseData);
//        } catch (Exception e) {
//            log.info("Error occurred while processing the request: " + e.getMessage(), e); // 使用日志记录异常堆栈
//            return new ApiResponse<>(null, "Error occurred while processing the request: " + e.getMessage());
//        }
//    }

    @ApiOperation(value = "outbound/add", notes = "outbound/add")
    @PostMapping("/wms/outbound/add")
    public ApiResponse<Map<String, String>> outboundInsert(@RequestBody(required = false) AddInboundRequestNew addInboundRequestNew) {
        try {
            long ID = IdWorker.getId();
            Map<String, String> responseData = new HashMap<>();

            if ("PDA".equals(addInboundRequestNew.getSource())) {
                addInboundRequestNew.getAddInboundRequestDetail().forEach(addInboundRequestDetail -> {

                    WmsRfidMaterial wmsRfidMaterial = new WmsRfidMaterial();
                    wmsRfidMaterial.setRf_id(addInboundRequestDetail.getRf_id());

                    if (addInboundRequestDetail.getWh_id() == 11) {
                        WmsThreedWarehouse wmsThreedWarehouse = new WmsThreedWarehouse();
                        wmsThreedWarehouse.setLocation_id(addInboundRequestDetail.getStock_location_id());
                        wmsThreedWarehouseServiceImpl.updateSelectiveByLocationId(wmsThreedWarehouse);
                    }

                    int updated = wmsMaterialTransactionServiceImpl.updateForTopNTransactionsOutboundPDA(
                            addInboundRequestNew.getDelivery_date(),
                            addInboundRequestNew.getCreator(),
                            addInboundRequestNew.getPurchase_order_no(),
                            addInboundRequestNew.getSupplier(),
                            null,
                            addInboundRequestNew.getSource(),
                            "pending",
                            addInboundRequestDetail.getRf_id(),
                            ID,
                            addInboundRequestDetail.getStock_location_id(),
                            wmsRfidMaterialServiceImpl.selectall(wmsRfidMaterial).get(0).getMaterial_code(),
                            addInboundRequestDetail.getQuantity()
                    );
                    responseData.put("id", String.valueOf(updated));
                });
            } else if ("manual".equals(addInboundRequestNew.getSource())) {
                addInboundRequestNew.getAddInboundRequestDetail().forEach(addInboundRequestDetail -> {

                    if (addInboundRequestDetail.getWh_id() == 11) {
                        WmsThreedWarehouse wmsThreedWarehouse = new WmsThreedWarehouse();
                        wmsThreedWarehouse.setLocation_id(addInboundRequestDetail.getStock_location_id());
                        wmsThreedWarehouseServiceImpl.updateSelectiveByLocationId(wmsThreedWarehouse);
                    }

                    int updated = wmsMaterialTransactionServiceImpl.updateForTopNTransactionsOutboundManual(
                            addInboundRequestNew.getDelivery_date(),
                            addInboundRequestNew.getCreator(),
                            addInboundRequestNew.getPurchase_order_no(),
                            addInboundRequestNew.getSupplier(),
                            null,
                            addInboundRequestNew.getSource(),
                            "pending",
                            addInboundRequestDetail.getRf_id(),
                            ID,
                            addInboundRequestDetail.getStock_location_id(),
                            addInboundRequestDetail.getMaterial_code(),
                            addInboundRequestDetail.getQuantity()
                    );
                    responseData.put("id", String.valueOf(updated));
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
    public ApiResponse<Map<String, String>> outboundUpdate(@RequestBody(required = false) UpdateInboundRequest updateInboundRequest) {
        Map<String, String> responseData = new HashMap<>();
        try {
            responseData.put("id", String.valueOf(wmsMaterialTransactionServiceImpl.updateByOutboundId(updateInboundRequest)));
            return new ApiResponse<>(responseData);
        }catch (Exception e){
            log.info(e.getMessage());
            return new ApiResponse<>( null,"Error occurred while processing the request: " + e.getMessage());
        }
    }

    @ApiOperation(value = "outbound/delete", notes = "outbound/delete")
    @PostMapping("/wms/outbound/delete")
    public ApiResponse<Map<String, String>> outboundDelete(@RequestBody(required = false) ID id) {
        Map<String, String> responseData = new HashMap<>();
        try {
            UpdateInboundRequest updateInboundRequest = new UpdateInboundRequest();
            updateInboundRequest.setId(id.getID());
            responseData.put("id", String.valueOf(wmsMaterialTransactionServiceImpl.deleteForOutbound(updateInboundRequest)));
            return new ApiResponse<>(responseData);
        }catch (Exception e){
            log.info(e.getMessage());
            return new ApiResponse<>( null,"Error occurred while processing the request: " + e.getMessage());
        }
    }

    @ApiOperation(value = "outbound/get", notes = "outbound/get")
    @PostMapping("/wms/outbound/get")
    public ApiResponse<PageInfo<InboundDetail>> outboundGet(@RequestBody(required = false) InboundDetail inboundDetail,@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize) {
        try {
            return new ApiResponse<>(PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(() ->  wmsMaterialTransactionServiceImpl.selectByOutboundRfidType(inboundDetail)));
        }catch (Exception e){
            log.info(e.getMessage());
            return new ApiResponse<>( null,"Error occurred while processing the request: " + e.getMessage());
        }
    }

    @ApiOperation(value = "rfidmaterial/add",notes = "rfidmaterial/add")
    @PostMapping("/wms/rfidmaterial/add")
    public ApiResponse<Map<String, String>> rfidmaterialInsert(@RequestBody(required = false) WmsRfidMaterial wmsRfidMaterial) {
        Map<String, String> responseData = new HashMap<>();
        try {
            responseData.put("id", String.valueOf(wmsRfidMaterialServiceImpl.insertSelective(wmsRfidMaterial)));
            return new ApiResponse<>(responseData);
        }catch (Exception e){
            log.info(e.getMessage());
            return new ApiResponse<>( null,"Error occurred while processing the request: " + e.getMessage());
        }
    }

    @ApiOperation(value = "rfidmaterial/update", notes = "rfidmaterial/update")
    @PostMapping("/wms/rfidmaterial/update")
    public ApiResponse<Map<String, String>> rfidmaterialUpdate(@RequestBody(required = false) WmsRfidMaterial wmsRfidMaterial) {
        Map<String, String> responseData = new HashMap<>();
        try {
                responseData.put("id",String.valueOf(wmsRfidMaterialServiceImpl.updateSelective(wmsRfidMaterial)));
            return new ApiResponse<>(responseData);
        } catch (Exception e) {
            log.info(e.getMessage());
            return new ApiResponse<>(null, "Error occurred while processing the request: " + e.getMessage());
        }
    }

    @ApiOperation(value = "rfidmaterial/delete",notes = "rfidmaterial/delete")
    @PostMapping("/wms/rfidmaterial/delete")
    public ApiResponse<Map<String, String>> rfidmaterialDelete(@RequestBody(required = false) ID id) {
        Map<String, String> responseData = new HashMap<>();
        try {
            WmsRfidMaterial wmsRfidMaterial = new WmsRfidMaterial();
            wmsRfidMaterial.setId(id.getID());
            responseData.put("id", String.valueOf(wmsRfidMaterialServiceImpl.deleteSelective(wmsRfidMaterial)));
            return new ApiResponse<>(responseData);
        }catch (Exception e){
            log.info(e.getMessage());
            return new ApiResponse<>( null,"Error occurred while processing the request: " + e.getMessage());
        }
    }
    @ApiOperation(value = "rfidmaterial/get", notes = "rfidmaterial/get")
    @PostMapping("/wms/rfidmaterial/get")
    public ApiResponse<PageInfo<WmsRfidMaterial>> rfidmaterialGet(@RequestBody(required = false) WmsRfidMaterial wmsRfidMaterial,@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize) {
        try {
            return new ApiResponse<>(PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(() -> wmsRfidMaterialServiceImpl.selectall(wmsRfidMaterial)));
        } catch (Exception e) {
            log.info("Error occurred while processing the request: " + e.getMessage(), e);
            return new ApiResponse<>(null, "Error occurred while processing the request: " + e.getMessage());
        }
    }

//    @ApiOperation(value = "inbound/detail", notes = "inbound/detail")
//    @PostMapping("/wms/inbound/detail")
//    public ApiResponse<PageInfo<ShelfInventory>> inboundDetailGet(@RequestBody(required = false) InboundRecordDetailRequest inboundRecordDetailRequest,@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize) {
//        try {
//            WmsMaterialTransaction wmsMaterialTransaction = new WmsMaterialTransaction();
//            wmsMaterialTransaction.setRf_id(inboundRecordDetailRequest.getRfid());
//            wmsMaterialTransaction.setInbound_id(inboundRecordDetailRequest.getInboundId());
//
//            PageInfo<WmsMaterialTransaction> pageInfo = PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(() -> wmsMaterialTransactionServiceImpl.selectAllInboundGroupByMaterialCode(wmsMaterialTransaction));
//
//            List<ShelfInventory> shelfInventoryList =pageInfo.getList()
//                    .stream()
//                    .filter(transaction -> transaction.getStock_location_id() != null) // 过滤掉stock_location_id为null的记录
//                    .collect(Collectors.groupingBy(WmsMaterialTransaction::getStock_location_id)) // 根据stock_location_id进行分组
//                    .entrySet().stream()
//                    .map(entry -> {
//                        ShelfInventory shelfInventory = new ShelfInventory();
//                        shelfInventory.setStorageLocationId(String.valueOf(entry.getKey())); // 设置storage_location_id
//
//                        // 获取对应的storage location名称
//                        WmsStorageLocation wmsStorageLocation = new WmsStorageLocation();
//                        wmsStorageLocation.setId(entry.getKey());
//                        List<WmsStorageLocation> wmsStorageLocationList = wmsStorageLocationServiceImpl.selectAll(wmsStorageLocation);
//                        if (!wmsStorageLocationList.isEmpty()) {
//                            shelfInventory.setStorageLocation(wmsStorageLocationList.get(0).getName());
//                        }
//
//                        // 将分组内的每个物料数据转换为Inventory对象
//                        List<Inventory> inventoryList = entry.getValue().stream()
//                                .map(transaction -> {
//                                    Inventory inventory = new Inventory();
//                                    inventory.setRfid(transaction.getRf_id());
//                                    inventory.setMaterialCode(String.valueOf(transaction.getMaterial_code()));
//                                    inventory.setQuantity(transaction.getQuantity());
//
//                                    WmsMaterial wmsMaterial = new WmsMaterial();
//                                    wmsMaterial.setProduct_code(transaction.getMaterial_code());
//                                    List<WmsMaterial> wmsMaterialList = wmsMaterialServiceImpl.selectAll(wmsMaterial);
//                                    if (!wmsMaterialList.isEmpty()) {
//                                        WmsMaterial material = wmsMaterialList.get(0);
//                                        inventory.setMaterialName(material.getName());
//                                    }
//                                    return inventory;
//                                })
//                                .collect(Collectors.toList());
//
//                        shelfInventory.setInventory(inventoryList);
//                        return shelfInventory;
//                    })
//                    .collect(Collectors.toList());
//            PageInfo<ShelfInventory> responsePageInfo = new PageInfo<>(shelfInventoryList);
//            BeanUtils.copyProperties(pageInfo, responsePageInfo, "list"); // Copy pagination details except the list
//            return new ApiResponse<>(responsePageInfo);
//        } catch (Exception e) {
//            log.error("Error occurred while processing the request: " + e.getMessage(), e);
//            return new ApiResponse<>(null, "Error occurred while processing the request: " + e.getMessage());
//        }
//    }

    @ApiOperation(value = "inbound/detail", notes = "inbound/detail")
    @PostMapping("/wms/inbound/detail")
    public ApiResponse<PageInfo<InboundDetail>> inboundDetailGet(@RequestBody(required = false) InboundRecordDetailRequest inboundRecordDetailRequest, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize) {
        try {
            WmsMaterialTransaction queryCondition = new WmsMaterialTransaction();
            queryCondition.setRf_id(inboundRecordDetailRequest.getRfid());
            queryCondition.setInbound_id(inboundRecordDetailRequest.getId());

            PageInfo<WmsMaterialTransaction> pageInfo = PageHelper.startPage(pageNum, pageSize)
                    .doSelectPageInfo(() -> wmsMaterialTransactionServiceImpl.selectAllInboundGroupByMaterialCode(queryCondition));

            List<InboundDetail> details = pageInfo.getList().stream().map(transaction -> {
                WmsMaterial wmsMaterial = new WmsMaterial();
                wmsMaterial.setProduct_code(transaction.getMaterial_code());
                WmsMaterial material = wmsMaterialServiceImpl.selectAll(wmsMaterial).get(0);
                return new InboundDetail(transaction, material);
            }).collect(Collectors.toList());

            PageInfo<InboundDetail> resultPageInfo = new PageInfo<>(details);
            BeanUtils.copyProperties(pageInfo, resultPageInfo, "list");
            return new ApiResponse<>(resultPageInfo);
        } catch (Exception e) {
            log.error("Error occurred while processing the request: " + e.getMessage(), e);
            return new ApiResponse<>(null, "Error occurred while processing the request: " + e.getMessage());
        }
    }

//    @ApiOperation(value = "outbound/detail", notes = "outbound/detail")
//    @PostMapping("/wms/outbound/detail")
//    public ApiResponse<PageInfo<ShelfInventory>> outboundDetailGet(@RequestBody(required = false) OutboundRecordDetailRequest outboundRecordDetailRequest,@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize) {
//        try {
//            WmsMaterialTransaction wmsMaterialTransaction = new WmsMaterialTransaction();
//            wmsMaterialTransaction.setRf_id(outboundRecordDetailRequest.getRfid());
//            wmsMaterialTransaction.setOutbound_id(outboundRecordDetailRequest.getOutboundId());
//
//            PageInfo<WmsMaterialTransaction> pageInfo = PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(() -> wmsMaterialTransactionServiceImpl.selectAllOutboundGroupByMaterialCodeRfid(wmsMaterialTransaction));
//
//            List<ShelfInventory> shelfInventoryList = pageInfo.getList()
//                    .stream()
//                    .filter(transaction -> transaction.getStock_location_id() != null) // 过滤掉stock_location_id为null的记录
//                    .collect(Collectors.groupingBy(WmsMaterialTransaction::getStock_location_id)) // 根据stock_location_id进行分组
//                    .entrySet().stream()
//                    .map(entry -> {
//                        ShelfInventory shelfInventory = new ShelfInventory();
//                        shelfInventory.setStorageLocationId(String.valueOf(entry.getKey())); // 设置storage_location_id
//
//                        // 获取对应的storage location名称
//                        WmsStorageLocation wmsStorageLocation = new WmsStorageLocation();
//                        wmsStorageLocation.setId(entry.getKey());
//                        List<WmsStorageLocation> wmsStorageLocationList = wmsStorageLocationServiceImpl.selectAll(wmsStorageLocation);
//                        if (!wmsStorageLocationList.isEmpty()) {
//                            shelfInventory.setStorageLocation(wmsStorageLocationList.get(0).getName());
//                        }
//
//                        // 将分组内的每个物料数据转换为Inventory对象
//                        List<Inventory> inventoryList = entry.getValue().stream()
//                                .map(transaction -> {
//                                    Inventory inventory = new Inventory();
//                                    inventory.setRfid(transaction.getRf_id());
//                                    inventory.setMaterialCode(String.valueOf(transaction.getMaterial_code()));
//                                    inventory.setQuantity(transaction.getQuantity());
//
//                                    WmsMaterial wmsMaterial = new WmsMaterial();
//                                    wmsMaterial.setProduct_code(transaction.getMaterial_code());
//                                    List<WmsMaterial> wmsMaterialList = wmsMaterialServiceImpl.selectAll(wmsMaterial);
//                                    if (!wmsMaterialList.isEmpty()) {
//                                        WmsMaterial material = wmsMaterialList.get(0);
//                                        inventory.setMaterialName(material.getName());
//                                    }
//                                    return inventory;
//                                })
//                                .collect(Collectors.toList());
//
//                        shelfInventory.setInventory(inventoryList);
//                        return shelfInventory;
//                    })
//                    .collect(Collectors.toList());
//            PageInfo<ShelfInventory> responsePageInfo = new PageInfo<>(shelfInventoryList);
//            BeanUtils.copyProperties(pageInfo, responsePageInfo, "list"); // Copy pagination details except the list
//            return new ApiResponse<>(responsePageInfo);
//        } catch (Exception e) {
//            log.error("Error occurred while processing the request: " + e.getMessage(), e);
//            return new ApiResponse<>(null, "Error occurred while processing the request: " + e.getMessage());
//        }
//    }

    @ApiOperation(value = "outbound/detail", notes = "outbound/detail")
    @PostMapping("/wms/outbound/detail")
    public ApiResponse<PageInfo<InboundDetail>> outboundDetailGet(@RequestBody(required = false) InboundRecordDetailRequest inboundRecordDetailRequest, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize) {
        try {
            WmsMaterialTransaction queryCondition = new WmsMaterialTransaction();
            queryCondition.setRf_id(inboundRecordDetailRequest.getRfid());
            queryCondition.setOutbound_id(inboundRecordDetailRequest.getId());

            PageInfo<WmsMaterialTransaction> pageInfo = PageHelper.startPage(pageNum, pageSize)
                    .doSelectPageInfo(() -> wmsMaterialTransactionServiceImpl.selectAllOutboundGroupByMaterialCodeRfid(queryCondition));

            List<InboundDetail> details = pageInfo.getList().stream().map(transaction -> {
                WmsMaterial wmsMaterial = new WmsMaterial();
                wmsMaterial.setProduct_code(transaction.getMaterial_code());
                WmsMaterial material = wmsMaterialServiceImpl.selectAll(wmsMaterial).get(0);
                return new InboundDetail(transaction, material);
            }).collect(Collectors.toList());

            PageInfo<InboundDetail> resultPageInfo = new PageInfo<>(details);
            BeanUtils.copyProperties(pageInfo, resultPageInfo, "list");
            return new ApiResponse<>(resultPageInfo);
        } catch (Exception e) {
            log.error("Error occurred while processing the request: " + e.getMessage(), e);
            return new ApiResponse<>(null, "Error occurred while processing the request: " + e.getMessage());
        }
    }

    @ApiOperation(value = "stocktaking/add", notes = "stocktaking/add")
    @PostMapping("/wms/stocktaking/add")
    public ApiResponse<Map<String, String>> stocktakingInsert(@RequestBody(required = false) AddInboundRequest addInboundRequest) {
        try {
            Map<String, String> responseData = new HashMap<>();
            long ID = IdWorker.getId();
            addInboundRequest.getShelfRecords().forEach(
                    i -> {
                        i.getInventory().forEach(
                                b -> {
                                    if (b.getQuantity() > 0) {
                                        int tmp = wmsMaterialTransactionServiceImpl.updateForTopNTransactionsStocktaking(ID, b.getMaterialCode(), b.getQuantity(), i.getStorageLocationId());
                                        if (b.getQuantity() - tmp == 0) {
                                            responseData.put("id", String.valueOf(ID));
                                        } else {
                                            for (int j = 0; j < b.getQuantity() - tmp; j++) {
                                                WmsMaterialTransaction wmsMaterialTransaction = new WmsMaterialTransaction();
                                                wmsMaterialTransaction.setStocktaking_id(ID);
                                                wmsMaterialTransaction.setMaterial_code(b.getMaterialCode());
                                                wmsMaterialTransaction.setStock_location_id(Long.valueOf(i.getStorageLocationId()));
                                                wmsMaterialTransactionServiceImpl.insertSelective(wmsMaterialTransaction);
                                                responseData.put("id", String.valueOf(b.getQuantity()));
                                            }
                                        }
                                    }
                                }
                        );
                    }
            );
            return new ApiResponse<>(responseData);
        } catch (Exception e) {
            log.error("Error occurred while processing the request: " + e.getMessage(), e);
            return new ApiResponse<>(null, "Error occurred while processing the request: " + e.getMessage());
        }
    }

    @ApiOperation(value = "stocktaking/update", notes = "stocktaking/update")
    @PostMapping("/wms/stocktaking/update")
    public ApiResponse<Map<String, String>> stocktakingUpdate(@RequestBody(required = false) AddInboundRequest addInboundRequest) {
        try {
            Map<String, String> responseData = new HashMap<>();
            addInboundRequest.getShelfRecords().stream().forEach(
                    i->{
                        i.getInventory().stream().forEach(
                                b->{
                                    wmsMaterialTransactionServiceImpl.updateForTopNTransactionsStocktaking(IdWorker.getId(),b.getMaterialCode(),b.getQuantity(),i.getStorageLocationId());
                                }
                        );
                    }
            );
            responseData.put("id", "1");
            return new ApiResponse<>(responseData);
        } catch (Exception e) {
            log.error("Error occurred while processing the request: " + e.getMessage(), e);
            return new ApiResponse<>(null, "Error occurred while processing the request: " + e.getMessage());
        }
    }

    @ApiOperation(value = "stocktaking/delete", notes = "stocktaking/delete")
    @PostMapping("/wms/stocktaking/delete")
    public ApiResponse<Map<String, String>> stocktakingDelete(@RequestBody(required = false) ID id) {
        try {
            Map<String, String> responseData = new HashMap<>();
            wmsMaterialTransactionServiceImpl.deleteForTopNTransactionsStocktaking(id.getID());
            responseData.put("id", "1");
            return new ApiResponse<>(responseData);
        } catch (Exception e) {
            log.error("Error occurred while processing the request: " + e.getMessage(), e);
            return new ApiResponse<>(null, "Error occurred while processing the request: " + e.getMessage());
        }
    }

    @ApiOperation(value = "stocktaking/get", notes = "stocktaking/get")
    @PostMapping("/wms/stocktaking/get")
    public ApiResponse<PageInfo<StocktakingRequest>> stocktakingGet(@RequestBody(required = false) GetStocktakingRequest getStocktakingRequest, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize) {
        try {

            WmsMaterialTransaction wmsMaterialTransaction = new WmsMaterialTransaction();
            wmsMaterialTransaction.setStocktaking_id(getStocktakingRequest.getID());
            wmsMaterialTransaction.setRf_id(getStocktakingRequest.getRfid());
            wmsMaterialTransaction.setType(getStocktakingRequest.getType());

            PageInfo<WmsMaterialTransaction> pageInfo = PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(() -> wmsMaterialTransactionServiceImpl.selectAllGroupByStocktakingId(wmsMaterialTransaction,getStocktakingRequest.getWarehouseName()));

            List<StocktakingRequest> stocktakingRequestList = pageInfo.getList().stream().map(StocktakingRequest::new).collect(Collectors.toList());

            PageInfo<StocktakingRequest> responsePageInfo = new PageInfo<>(stocktakingRequestList);
            BeanUtils.copyProperties(pageInfo, responsePageInfo, "list"); // Copy pagination details except the list
            return new ApiResponse<>(responsePageInfo);
        } catch (Exception e) {
            log.error("Error occurred while processing the request: " + e.getMessage(), e);
            return new ApiResponse<>(null, "Error occurred while processing the request: " + e.getMessage());
        }
    }

    @ApiOperation(value = "stocktaking/get/detail", notes = "stocktaking/get/detail")
    @PostMapping("/wms/stocktaking/detail")
    public ApiResponse<PageInfo<ShelfInventory>> stocktakingDetailGet(@RequestBody(required = false) GetStocktakingRequest getStocktakingRequest, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize) {
        try {

            WmsMaterialTransaction wmsMaterialTransaction = new WmsMaterialTransaction();
            wmsMaterialTransaction.setStocktaking_id(getStocktakingRequest.getID());
            wmsMaterialTransaction.setRf_id(getStocktakingRequest.getRfid());

            PageInfo<WmsMaterialTransaction> pageInfo = PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(() -> wmsMaterialTransactionServiceImpl.selectAllGroupByStocktakingId(wmsMaterialTransaction, getStocktakingRequest.getWarehouseName()));

            List<ShelfInventory> shelfInventoryList = pageInfo.getList()
                    .stream()
                    .filter(transaction -> transaction.getStock_location_id() != null) // 过滤掉stock_location_id为null的记录
                    .collect(Collectors.groupingBy(WmsMaterialTransaction::getStock_location_id)) // 根据stock_location_id进行分组
                    .entrySet().stream()
                    .map(entry -> {
                        ShelfInventory shelfInventory = new ShelfInventory();
                        shelfInventory.setStorageLocationId(String.valueOf(entry.getKey())); // 设置storage_location_id

                        // 获取对应的storage location名称
                        WmsStorageLocation wmsStorageLocation = new WmsStorageLocation();
                        wmsStorageLocation.setId(entry.getKey());
                        List<WmsStorageLocation> wmsStorageLocationList = wmsStorageLocationServiceImpl.selectAll(wmsStorageLocation);
                        if (!wmsStorageLocationList.isEmpty()) {
                            shelfInventory.setStorageLocation(wmsStorageLocationList.get(0).getName());
                        }

                        // 将分组内的每个物料数据转换为Inventory对象
                        List<Inventory> inventoryList = entry.getValue().stream()
                                .map(transaction -> {
                                    Inventory inventory = new Inventory();
                                    inventory.setMaterialCode(String.valueOf(transaction.getMaterial_code()));
                                    inventory.setQuantity(wmsMaterialTransactionServiceImpl.getQuantityForInbound(inventory.getRfid(), inventory.getMaterialCode(), String.valueOf(entry.getKey())));
                                    inventory.setStockQuantity(wmsMaterialTransactionServiceImpl.getQuantityForStocktaking(inventory.getRfid(), inventory.getMaterialCode(), String.valueOf(entry.getKey())));
                                    inventory.setDiscrepancy(wmsMaterialTransactionServiceImpl.getQuantityForStocktaking(inventory.getRfid(), inventory.getMaterialCode(), String.valueOf(entry.getKey())) - wmsMaterialTransactionServiceImpl.getQuantityForInbound(inventory.getRfid(), inventory.getMaterialCode(), String.valueOf(entry.getKey())));

                                    WmsMaterial wmsMaterial = new WmsMaterial();
                                    wmsMaterial.setProduct_code(transaction.getMaterial_code());
                                    List<WmsMaterial> wmsMaterialList = wmsMaterialServiceImpl.selectAll(wmsMaterial);
                                    if (!wmsMaterialList.isEmpty()) {
                                        WmsMaterial material = wmsMaterialList.get(0);
                                        inventory.setMaterialName(material.getName());
                                    }
                                    inventory.setRfid(transaction.getRf_id());
                                    return inventory;
                                })
                                .collect(Collectors.toList());

                        shelfInventory.setInventory(inventoryList);
                        return shelfInventory;
                    })
                    .collect(Collectors.toList());

            PageInfo<ShelfInventory> responsePageInfo = new PageInfo<>(shelfInventoryList);
            BeanUtils.copyProperties(pageInfo, responsePageInfo, "list"); // Copy pagination details except the list
            return new ApiResponse<>(responsePageInfo);
        } catch (Exception e) {
            log.error("Error occurred while processing the request: " + e.getMessage(), e);
            return new ApiResponse<>(null, "Error occurred while processing the request: " + e.getMessage());
        }
    }

}
