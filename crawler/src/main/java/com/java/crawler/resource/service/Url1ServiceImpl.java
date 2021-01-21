package com.java.crawler.resource.service;

import com.java.crawler.resource.Url1;
import com.java.crawler.resource.entity.Content;
import com.java.crawler.resource.entity.Novel;
import com.java.crawler.resource.utils.HttpClientUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import java.util.*;

@Service("Url1Service")
public class Url1ServiceImpl implements BaseService {

    private Url1 url1 = Url1.getInstance();

    @Override
    public List<Map<String,String>> getDirectory(String url) {
        Document parse = Jsoup.parse(HttpClientUtil.Get(url));
        List<Map<String,String>> directorys=new ArrayList<>();
        Map<String,String> directory;
        Element list = parse.getElementById("list");
        Elements dd = list.select("dd");
        Element a=null;
        for (Element element : dd) {
            directory=new HashMap<>();
            a=element.select("a").get(0);
            directory.put("url",a.attr("href"));
            directory.put("name",a.text());
            directorys.add(directory);
        }
        System.out.println(directorys);
        return directorys;
    }

    @Override
    public List<Novel> search(String name) {
        List<Novel> novels=new ArrayList<>();
        Novel novel;
        Map<String, String> json = new HashMap<>();
        json.put("searchkey", name);
        String html = HttpClientUtil.sendPostByForm(url1.getSearch(), json, 3);
        Document document = Jsoup.parse(html);
        Elements table = document.getElementsByTag("table");
        Elements tr = table.select("tr");
        //System.out.println(tr);
        Elements td = null;
        for (int i = 0; i < tr.size(); i++) {
            if (i == 0) {
                continue;
            }
            td = tr.get(i).select("td");
            novel=new Novel();
            novel.setName(td.get(0).select("a").get(0).text());
            novel.setUrl(td.get(0).select("a").get(0).attr("href"));
            novel.setAuthor(td.get(2).text());
            novel.setNewContent(td.get(1).select("a").get(0).text());
            novels.add(novel);
        }
        System.out.println(novels);
        return novels;
    }

    public static void main(String[] args) {
        Content content = new Url1ServiceImpl().getContent("/13/13959/5939025.html");
        System.out.println("---------------");
        new Url1ServiceImpl().getContent(content.getNextUrl());

    }

    @Override
    public Content getContent(String url) {
        Content content=new Content();
        String html = HttpClientUtil.Get(Url1.getInstance().getUrl()+url);
        Document document = Jsoup.parse(html);
        String title = document.getElementsByClass("bookname").get(0).select("h1").get(0).text();
        content.setName(title);
        content.setUrl(url);
        content.setContent(document.getElementById("content").html());
        content.setUpUrl(document.getElementsByClass("bottem1").get(0)
            .select("a").get(1).attr("href"));
        content.setNextUrl(document.getElementsByClass("bottem1").get(0)
                .select("a").get(3).attr("href"));
        System.out.println(content);
        return content;
    }
}
