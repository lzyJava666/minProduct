package com.java.crawler.resource.service;

import com.java.crawler.resource.entity.Content;
import com.java.crawler.resource.entity.Novel;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 定义一些小说阅读器的基本功能
 */
public interface BaseService {

    /**
     * 获取目录
     * @return
     */
    List<Map<String,String>> getDirectory(String url);

    /**
     *搜索功能
     */
    List<Novel> search(String name) throws IOException;

    /**
     * 获取当前章节的全部内容  title 标题，content 内容 index 当前为第几章
     * @param url 指定章节
     */
    Content getContent(String url);

}
