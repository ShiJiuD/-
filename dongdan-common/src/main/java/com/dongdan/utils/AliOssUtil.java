package com.dongdan.utils;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import java.io.ByteArrayInputStream;

@Data
@AllArgsConstructor
@Slf4j
public class AliOssUtil {

    private String endpoint;
    private String accessKeyId;
    private String accessKeySecret;
    private String bucketName;

    /**
     * 文件上传到阿里云 OSS
     * @param bytes      文件字节数组
     * @param objectName 对象名（路径+文件名）
     * @param contentType 文件 MIME 类型
     * @return 公网访问 URL
     */
    public String upload(byte[] bytes, String objectName, String contentType) {
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        try {
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentType(contentType);
            PutObjectRequest request = new PutObjectRequest(bucketName, objectName,
                    new ByteArrayInputStream(bytes), metadata);
            ossClient.putObject(request);
        } catch (OSSException oe) {
            log.error("OSS 错误：ErrorCode={}, ErrorMessage={}", oe.getErrorCode(), oe.getErrorMessage());
            throw new RuntimeException("OSS 上传失败", oe);
        } catch (ClientException ce) {
            log.error("OSS 客户端错误：{}", ce.getMessage());
            throw new RuntimeException("OSS 客户端异常", ce);
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
        String url = "https://" + bucketName + "." + endpoint + "/" + objectName;
        log.info("文件上传到:{}", url);
        return url;
    }
}