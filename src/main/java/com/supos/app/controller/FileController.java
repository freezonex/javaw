package com.supos.app.controller;

import com.supos.app.config.MinioConfig;
import com.supos.app.impl.MinioUtil;
import io.minio.messages.Bucket;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.web.util.UriUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

@Api(tags = "文件相关接口")
@Slf4j
@RestController
@RequestMapping(value = "product/file")
public class FileController {

    @Value("${minio.endpoint}")
    private String minioEndpoint;

    @Autowired
    private MinioUtil minioUtil;
    @Autowired
    private MinioConfig prop;


    @ApiOperation(value = "查看存储bucket是否存在")
    @GetMapping("/bucketExists")
    public ResponseEntity<?> bucketExists(@RequestParam("bucketName") String bucketName) {
        return ResponseEntity.ok().body("bucketName"+ minioUtil.bucketExists(bucketName));
    }

    @ApiOperation(value = "创建存储bucket")
    @GetMapping("/makeBucket")
    public ResponseEntity<?> makeBucket(String bucketName) {
        return ResponseEntity.ok().body("bucketName"+ minioUtil.makeBucket(bucketName));
    }

    @ApiOperation(value = "删除存储bucket")
    @GetMapping("/removeBucket")
    public ResponseEntity<?> removeBucket(String bucketName) {
        return ResponseEntity.ok().body("bucketName"+ minioUtil.removeBucket(bucketName));
    }

    @ApiOperation(value = "获取全部bucket")
    @GetMapping("/getAllBuckets")
    public ResponseEntity<?> getAllBuckets() {
        List<String> allBuckets = minioUtil.getAllBuckets();
        return ResponseEntity.ok().body(allBuckets);
    }

    @ApiOperation(value = "获取全部bucket内的文件")
    @GetMapping("/getAllFilesInBucket")
    public ResponseEntity<?> getAllFilesInBucket(@RequestParam("bucketName") String bucketName) {
        List<String> allFiles = minioUtil.getAllFilesInBucket(bucketName);
        return ResponseEntity.ok().body(allFiles);
    }

    @ApiOperation(value = "文件上传返回url")
    @PostMapping("/upload")
    public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file) {
        String objectName = minioUtil.upload(file);
        if (null != objectName) {
            return ResponseEntity.ok().body((prop.getEndpoint() + "/" + prop.getBucketName() + "/" + objectName));
        }
        return (ResponseEntity<?>) ResponseEntity.badRequest();
    }

    @ApiOperation(value = "图片/视频预览")
    @GetMapping("/preview")
    public ResponseEntity<?> preview(@RequestParam("fileName") String fileName) {
        return ResponseEntity.ok().body(minioUtil.preview(fileName));
    }

    @ApiOperation(value = "文件下载")
    @GetMapping("/download")
    public ResponseEntity<?> download(@RequestParam("fileName") String fileName, HttpServletResponse res) {
        minioUtil.download(fileName,res);
        return (ResponseEntity<?>) ResponseEntity.badRequest();
    }

    @ApiOperation(value = "删除文件", notes = "根据url地址删除文件")
    @PostMapping("/delete")
    public ResponseEntity<?> remove(String url) {
        String objName = url.substring(url.lastIndexOf(prop.getBucketName()+"/") + prop.getBucketName().length()+1);
        minioUtil.remove(objName);
        return ResponseEntity.ok().body("objName"+objName);
    }

}
