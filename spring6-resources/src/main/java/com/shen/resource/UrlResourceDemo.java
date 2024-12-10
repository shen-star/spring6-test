package com.shen.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.UrlResource;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * 演示UrlResource访问网络资源
 */
public class UrlResourceDemo {
    private static final Logger logger = LoggerFactory.getLogger(UrlResourceDemo.class);


    public static void main(String[] args) throws IOException {
        //http前缀
        loadUrlResource("http://www.baidu.com");
        //file前缀
        loadUrlResource("file:resources-test.txt");
    }

    /**
     * 访问前缀为http或file的资源
     *
     * @param path /
     */
    public static void loadUrlResource(String path) throws IOException {
        //创建Resource实现类的对象UrlResource
        UrlResource urlResource = new UrlResource(path);
        //获取资源信息
        logger.info("获取文件名:{}", urlResource.getFilename());
        logger.info("获取URI:{}", urlResource.getURI());
        logger.info("获取URL的描述:{}", urlResource.getDescription());
        InputStream inputStream = urlResource.getInputStream();
        byte[] bytes = new byte[1024];
        int len;
        while ((len = inputStream.read(bytes)) != -1) {
            String s = new String(bytes, 0, len, StandardCharsets.UTF_8);
            logger.info("读取流的内容：{}", s);
        }
        inputStream.close();
    }
}
