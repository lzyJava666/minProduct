package com.java.crawler.resource;

/**
 * 笔趣阁资源
 */
public class Url1 {

    private String url="http://www.xbiquge.la";
    private String name="笔趣阁";
    private boolean defaultUrl=true;
    private String search=url+"/modules/article/waps.php";

    public String getSearch() {
        return search;
    }

    private  final static Url1 url1=new Url1();

    // 饿汉式单例模式
    public static Url1 getInstance(){
        return url1;
    }

    private Url1() {
    }


    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }

    public boolean isDefaultUrl() {
        return defaultUrl;
    }
}
