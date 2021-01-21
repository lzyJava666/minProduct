package com.java.crawler.resource.entity;

/**
 * 小说封装类
 */
public class Novel {
    private String name;
    private String author;
    private String url;
    private Integer number;
    private String newContent;
    private String describe;
    private String img;

    @Override
    public String toString() {
        return "Novel{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", url='" + url + '\'' +
                ", number=" + number +
                ", newContent='" + newContent + '\'' +
                ", describe='" + describe + '\'' +
                ", img='" + img + '\'' +
                '}';
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getNewContent() {
        return newContent;
    }

    public void setNewContent(String newContent) {
        this.newContent = newContent;
    }

    public Novel() {
    }

    public Novel(String name, String author, String url, Integer number, String newContent, String describe, String img) {
        this.name = name;
        this.author = author;
        this.url = url;
        this.number = number;
        this.newContent = newContent;
        this.describe = describe;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
