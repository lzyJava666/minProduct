package com.java.crawler;

public enum PathEnum {
    笔趣阁("http://www.xbiquge.la","GET"),
    笔趣阁_搜索("/modules/article/waps.php","POST");

   private String value;
    private String type;

    /**
     * 私有构造,防止被外部调用
     * @param value
     */
    private PathEnum(String value,String type){
        this.value=value;
        this.type=type;
    }
}
