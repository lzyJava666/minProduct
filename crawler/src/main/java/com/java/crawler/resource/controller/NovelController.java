package com.java.crawler.resource.controller;

import com.java.crawler.resource.entity.Content;
import com.java.crawler.resource.entity.Novel;
import com.java.crawler.resource.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
public class NovelController {

    @Autowired
    BaseService url1Service;

    /**
     * 获取内容资源
     * @param data
     * @return
     */
    @PostMapping("/get")
    public Content get(@RequestBody Map<String, String> data) {
        String url = data.get("url");
        Content content = url1Service.getContent(url);
        if (content == null) {
            throw new RuntimeException("获取资源失败");
        }
        return content;
    }


    /**
     * 查看目录
     * @param data
     * @return
     */
    @PostMapping("/getDirectory")
    public List<Map<String, String>> getDirectory(@RequestBody Map<String, String> data) {
        String url = data.get("url");
        List<Map<String, String>> directory = url1Service.getDirectory(url);
        if (directory == null || directory.size() == 0) {
            throw new RuntimeException("获取目录列表失败");
        }
        return directory;
    }

    /**
     * 搜索小说功能
     * @param name
     * @return
     * @throws IOException
     */
    @GetMapping("/search")
    public List<Novel> search(@RequestParam("name") String name) throws IOException {
        List<Novel> search = url1Service.search(name);
        if (search.size() == 0) {
            return null;
        }
        return search;
    }
}
