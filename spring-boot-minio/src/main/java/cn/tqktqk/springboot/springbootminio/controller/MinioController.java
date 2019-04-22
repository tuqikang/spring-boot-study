package cn.tqktqk.springboot.springbootminio.controller;

import cn.tqktqk.springboot.springbootminio.service.MinioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
 * ___________ ________     ____  __.
 * \__    ___/ \_____  \   |    |/ _|
 * |    |     /  / \  \  |      <
 * |    |    /   \_/.  \ |    |  \
 * |____|    \_____\ \_/ |____|__ \
 *
 * @Author: tuqikang
 * @Date: 2019-04-20 17:45
 */
@RestController
@RequestMapping("/minio")
public class MinioController {

    @Autowired
    private MinioService minioService;

    @PostMapping
    public void uploadStreamFile(@RequestParam MultipartFile file){
        minioService.upload(file);
    }

    @PostMapping("/plus")
    public void uploadPlus(@RequestParam MultipartFile file){
        minioService.uploadPlus(file);
    }

    @RequestMapping("/download")
    public void download(HttpServletResponse res, String path){
        minioService.download(path,res);
    }

    @GetMapping("/geturl")
    public String getFileURL(String bucketName, String objectName){
        return minioService.getFileURL(bucketName,objectName);
    }
}
