package cn.tqktqk.springboot.springbootminio.service;

import io.minio.MinioClient;
import io.minio.Result;
import io.minio.errors.*;
import io.minio.messages.Bucket;
import io.minio.messages.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * ___________ ________     ____  __.
 * \__    ___/ \_____  \   |    |/ _|
 * |    |     /  / \  \  |      <
 * |    |    /   \_/.  \ |    |  \
 * |____|    \_____\ \_/ |____|__ \
 *
 * @Author: tuqikang
 * @Date: 2019-05-17 10:13
 */
@Service
public class MinioNormalService {

    private static Logger logger = LoggerFactory.getLogger(MinioNormalService.class);

    @Autowired
    private MinioClient minioClient;

    public final String BUCKET_NAME = "blog";

    public void bucketOperation() throws IOException, InvalidKeyException, NoSuchAlgorithmException, InsufficientDataException, InternalException, NoResponseException, InvalidBucketNameException, XmlPullParserException, ErrorResponseException, RegionConflictException, BucketPolicyTooLargeException, InvalidObjectPrefixException {
        //判断桶是否存在
        boolean hasBucket = minioClient.bucketExists(BUCKET_NAME);
        if (hasBucket) {
            logger.info("存在");
            //删除名为BUCKET_NAME的存储桶
            minioClient.removeBucket(BUCKET_NAME);
        } else {
            logger.info("不存在");
            logger.info("创建桶：" + BUCKET_NAME);
            // 创建名为BUCKET_NAME的存储桶。
            minioClient.makeBucket(BUCKET_NAME);
        }

        //列出所有桶
        List<Bucket> buckets = minioClient.listBuckets();

        //String:bucketName存储桶名称,String:prefix对象名称的前缀,布尔:recursive是否递归查找，如果假的英文，就模拟文件夹结构查找。布尔：useVersion1如果是true，使用版本1 REST API
        Iterable<Result<Item>> results = minioClient.listObjects(BUCKET_NAME, "", false, false);

        //获得存储桶策略。
        System.out.println("" + minioClient.getBucketPolicy(BUCKET_NAME));
    }

    public void objectOperation() throws IOException, InvalidKeyException, NoSuchAlgorithmException, InsufficientDataException, InvalidArgumentException, InternalException, NoResponseException, InvalidBucketNameException, XmlPullParserException, ErrorResponseException {
        //指定桶 指定桶内文件名字
        InputStream var1 = minioClient.getObject(BUCKET_NAME, "file_name");
        // 读取输入流直到EOF并打印到控制台。
        byte[] buf = new byte[16384];
        int bytesRead;
        while ((bytesRead = var1.read(buf, 0, buf.length)) >= 0) {
            System.out.println(new String(buf, 0, bytesRead));
        }
        // 关闭流，此处为示例，流关闭最好放在finally块。
        var1.close();

        //offset 从哪个位置开始 第四个参数：length 如果length没有一直到最后
        InputStream var2 = minioClient.getObject(BUCKET_NAME, "file_name", 0);

        //下载到本地/User/....下
        minioClient.getObject(BUCKET_NAME, "file_name", "/User/....");

        //通过InputStream的上传对象 3:文件大小,4:文件类型
        minioClient.putObject(BUCKET_NAME,"test",var1,var1.available(),"application/octet-stream");

        //上传本地文件到桶内中。
        minioClient.putObject(BUCKET_NAME,"test","/User/..");

        //删除一个对象
        minioClient.removeObject(BUCKET_NAME,"test");
    }
}
