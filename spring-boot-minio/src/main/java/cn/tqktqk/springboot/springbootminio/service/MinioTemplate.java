package cn.tqktqk.springboot.springbootminio.service;

import io.minio.MinioClient;
import io.minio.errors.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * ___________ ________     ____  __.
 * \__    ___/ \_____  \   |    |/ _|
 * |    |     /  / \  \  |      <
 * |    |    /   \_/.  \ |    |  \
 * |____|    \_____\ \_/ |____|__ \
 *
 * @Author: tuqikang
 * @Date: 2019-05-17 10:46
 */
@Component
public class MinioTemplate {

    public final String BUCKET = "blog";

    @Autowired
    private MinioClient minioClient;


    public Map<String, Object> uploadImage(MultipartFile file) throws Exception {
        return upload(file, "image/jpeg");
    }

    //文件上传
    public Map<String, Object> upload(MultipartFile file, String contentType) throws Exception {
        Map<String, Object> map = new HashMap<>();
        String fileName = DigestUtils.md5DigestAsHex(file.getBytes()) + file.getOriginalFilename();
        minioClient.putObject(BUCKET, fileName, file.getInputStream(), contentType);
//        String url = minioClient.getObjectUrl(BUCKET, fileName);
        String url = minioClient.presignedGetObject(BUCKET, fileName);
        map.put("flag", "0");
        map.put("mess", "上传成功");
        map.put("url", url);
        map.put("path", BUCKET + "/" + fileName);
        return map;
    }

    //文件下载
    public ResponseEntity<Object> downloadFile(String path) throws Exception {

        InputStream file = minioClient.getObject(BUCKET, path);
        InputStreamResource resource = new InputStreamResource(file);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", String.format("attachment;filename=\"%s", path));
        headers.add("Cache-Control", "no-cache,no-store,must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");

        ResponseEntity<Object> responseEntity = ResponseEntity.ok()
                .headers(headers)
//                .contentLength ( String.valueOf(f.available()))
                .contentType(MediaType.parseMediaType("image/jpeg"))
                .body(resource);

        return responseEntity;
    }
}
