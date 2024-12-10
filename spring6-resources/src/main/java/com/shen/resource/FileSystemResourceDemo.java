package com.shen.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.FileSystemResource;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * 访问文件系统的资源
 */
public class FileSystemResourceDemo {
    private static final Logger logger = LoggerFactory.getLogger(FileSystemResourceDemo.class);

    public static void main(String[] args) throws IOException {
        loadFileResource("resources-test.txt");
        loadFileResource("F:\\test.txt");
    }

    public static void loadFileResource(String filePath) throws IOException {
        //创建FileSystemResource对象
        FileSystemResource fileSystemResource = new FileSystemResource(filePath);
        //获取资源信息
        logger.info("获取文件名:{}", fileSystemResource.getFilename());
        logger.info("获取描述:{}", fileSystemResource.getDescription());
        InputStream inputStream = fileSystemResource.getInputStream();
        byte[] bytes = new byte[1024];
        int len;
        while ((len = inputStream.read(bytes)) != -1) {
            String s = new String(bytes, 0, len, StandardCharsets.UTF_8);
            logger.info("读取流的内容：{}", s);
        }
        inputStream.close();
    }
}
