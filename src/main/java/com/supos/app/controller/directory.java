package com.supos.app.controller;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@Api(tags = "目录相关")
@Slf4j
@RestController
@RequestMapping(value = "directory")
public class directory {

    String jsonString = "[{\"name\":\"Directory 1\",\"subdirectories\":[{\"name\":\"Subdirectory 1.1\",\"subdirectories\":[{\"name\":\"Subdirectory 1.1.1\",\"subdirectories\":[]},{\"name\":\"Subdirectory 1.1.1\",\"subdirectories\":[]}]},{\"name\":\"Subdirectory 1.2\",\"files\":[]}]},{\"name\":\"Directory 2\",\"subdirectories\":[{\"name\":\"Subdirectory 2.1\",\"files\":[]},{\"name\":\"Subdirectory 2.2\",\"files\":[]}]},{\"name\":\"Directory 3\",\"subdirectories\":[{\"name\":\"Subdirectory 3.1\",\"files\":[]},{\"name\":\"Subdirectory 3.2\",\"files\":[]}]}]";

    @ApiOperation(value = "当前", notes = "当前数据查询")
    @GetMapping("/current")
    public JSONArray current() {
        return new JSONArray(jsonString);
    }

    @PostMapping("/insert")
    public JSONArray insert(@RequestBody Map<String, String> requestData) {
        JSONArray jsonArray = new JSONArray(jsonString);
        String[] pathParts = requestData.get("currentPath").substring(1).split("/");
        addDirectory(jsonArray, pathParts, 0, requestData.get("newName"));
        // 更新你的 jsonString 或者保存到数据库等
        jsonString = jsonArray.toString();
        return jsonArray;
    }

    private void addDirectory(JSONArray jsonArray, String[] pathParts, int index, String newName) {
        if (index >= pathParts.length) {
            return; // 路径遍历完成
        }

        for (Object obj : jsonArray) {
            JSONObject jsonObject = (JSONObject) obj;
            if (jsonObject.getStr("name").equals(pathParts[index])) {
                if (index == pathParts.length - 1) {
                    // 当前是要插入的路径
                    JSONArray subdirectories = jsonObject.getJSONArray("subdirectories");
                    if (subdirectories == null) {
                        subdirectories = new JSONArray();
                        jsonObject.put("subdirectories", subdirectories);
                    }
                    JSONObject newDirectory = new JSONObject();
                    newDirectory.put("name", newName);
                    newDirectory.put("subdirectories", new JSONArray());
                    subdirectories.add(newDirectory);
                } else {
                    // 继续遍历子目录
                    JSONArray nextArray = jsonObject.getJSONArray("subdirectories");
                    if (nextArray != null) {
                        addDirectory(nextArray, pathParts, index + 1, newName);
                    }
                }
                break; // 匹配到路径，结束当前循环
            }
        }
    }



}
