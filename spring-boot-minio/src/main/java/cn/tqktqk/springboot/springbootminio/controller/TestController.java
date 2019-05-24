package cn.tqktqk.springboot.springbootminio.controller;

import cn.tqktqk.springboot.springbootminio.service.MinioTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * ___________ ________     ____  __.
 * \__    ___/ \_____  \   |    |/ _|
 * |    |     /  / \  \  |      <
 * |    |    /   \_/.  \ |    |  \
 * |____|    \_____\ \_/ |____|__ \
 *
 * @Author: tuqikang
 * @Date: 2019-05-17 10:53
 */
@RestController
@RequestMapping("/picture")
public class TestController {

    @Autowired
    private MinioTemplate minioTemplate;

    @PostMapping("/upload")
    @ResponseBody
    public Map<String,Object> uploadFile(MultipartFile file) throws Exception {
        return minioTemplate.uploadImage(file);
    }

    @GetMapping("/download/{path}")
    @ResponseBody
    public ResponseEntity<Object> downloadFile(@PathVariable(name = "path") String path) throws Exception {
        return minioTemplate.downloadFile(path);
    }
}
