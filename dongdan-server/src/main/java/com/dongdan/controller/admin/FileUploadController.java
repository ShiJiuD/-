package com.dongdan.controller.admin;

import com.dongdan.constant.MessageConstant;
import com.dongdan.result.Result;
import com.dongdan.utils.AliOssUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Tag(name = "文件上传")
@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
@Slf4j
public class FileUploadController {

    private final AliOssUtil aliOssUtil;

    @Operation(summary = "图片上传")
    @PostMapping("/upload")
    public Result<String> upload(@RequestParam("file") MultipartFile file) throws IOException {
        log.info("文件上传：name={}, size={}", file.getOriginalFilename(), file.getSize());

        // 1. 校验文件类型
        String originalFilename = file.getOriginalFilename();
        if (originalFilename == null || !isImage(originalFilename)) {
            return Result.error("仅支持 jpg / png / gif / webp 格式");
        }

        // 2. 生成 OSS 存储路径
        String today = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM"));
        String ext = originalFilename.substring(originalFilename.lastIndexOf(".")).toLowerCase();
        String objectName = "uploads/" + today + "/" + UUID.randomUUID().toString().replace("-", "") + ext;

        // 3. 上传到阿里云 OSS
        String contentType = file.getContentType();
        if (contentType == null) {
            contentType = "application/octet-stream";
        }
        String url = aliOssUtil.upload(file.getBytes(), objectName, contentType);
        log.info("上传成功：{}", url);
        return Result.success(url);
    }

    private boolean isImage(String filename) {
        String lower = filename.toLowerCase();
        return lower.endsWith(".jpg") || lower.endsWith(".jpeg")
                || lower.endsWith(".png") || lower.endsWith(".gif")
                || lower.endsWith(".webp");
    }
}
