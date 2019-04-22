package cn.tqktqk.springboot.springbootminio.service;

import io.minio.MinioClient;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * ___________ ________     ____  __.
 * \__    ___/ \_____  \   |    |/ _|
 * |    |     /  / \  \  |      <
 * |    |    /   \_/.  \ |    |  \
 * |____|    \_____\ \_/ |____|__ \
 *
 * @Author: tuqikang
 * @Date: 2019-04-20 17:10
 */
@Service
public class MinioService {

    private static Logger logger = LoggerFactory.getLogger(MinioService.class);

    public final String BUCKET = "data1";

    @Autowired
    private MinioClient minioClient;

    @SneakyThrows
    public String upload(){
        //检查给定存储桶是否存在且是否具有读访问权限。
        boolean isExist = minioClient.bucketExists("data1");
        if(isExist) {
            logger.info("Bucket already exists.");
        } else {
            //创建具有默认区域的存储桶。
            minioClient.makeBucket(BUCKET);
        }
        //bucketName - 桶名、objectName - 要在存储桶中创建的对象名称、fileName - 要上传的文件名。
        minioClient.putObject(BUCKET,"test2.docx", "/Users/tuqikang/Desktop/学习笔记/spring.docx");
        return "成功";
    }

    @SneakyThrows
    public void upload(MultipartFile file){
        //检查给定存储桶是否存在且是否具有读访问权限。
        boolean isExist = minioClient.bucketExists(BUCKET);
        if(isExist) {
            logger.info("Bucket already exists.");
        } else {
            //创建具有默认区域的存储桶。
            minioClient.makeBucket(BUCKET);
        }
        minioClient.putObject(BUCKET,file.getOriginalFilename(),file.getInputStream(),"application/octet-stream");
    }

    @SneakyThrows
    public void uploadPlus(MultipartFile file){
        //相同内容的文件的MD5值是相同的
        String fileName =DigestUtils.md5DigestAsHex(file.getBytes())+file.getOriginalFilename();
        try {
            minioClient.putObject(BUCKET,fileName,file.getInputStream(),"application/octet-stream");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @SneakyThrows
    public void download(String path,HttpServletResponse response){
        //相同内容的文件的MD5值是相同的
        try (InputStream inputStream= minioClient.getObject(BUCKET,path)){
            response.setContentType("application/octet-stream; charset=UTF-8");
            response.setHeader("Content-Disposition", "attachment;filename="+path);
            byte[] buff = new byte[1024];
            BufferedInputStream bis = null;
            OutputStream os = null;
            try {
                os = response.getOutputStream();
                bis = new BufferedInputStream(inputStream);
                int i = bis.read(buff);
                while (i != -1) {
                    os.write(buff, 0, buff.length);
                    os.flush();
                    i = bis.read(buff);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (bis != null) {
                    try {
                        bis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @SneakyThrows
    public String getFileURL(String bucketName, String objectName){
        return minioClient.getObjectUrl(bucketName, objectName);
    }
}
