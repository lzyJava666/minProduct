package entity;

/**
 * 玩家
 */
public class Number {
    //姓名
    private String name;
    //类型
    private String type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Number(String name, String type) {
        this.name = name;
        this.type = type;
    }
}
