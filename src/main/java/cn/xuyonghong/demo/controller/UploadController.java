package cn.xuyonghong.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * 测试上传
 */
@RestController
@RequestMapping("/upload")
public class UploadController {

    @PostMapping("/uploadFile")
    public String uploadFile(@RequestPart("file") MultipartFile uploadResource) {
        if (uploadResource != null) {
            String fileName = uploadResource.getOriginalFilename();
            File destFile = new File("/Users/xuyonghong/Desktop/JAVA", fileName);
            try {
                uploadResource.transferTo(destFile);
                return "上传成功";
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "上传失败";
    }
}
