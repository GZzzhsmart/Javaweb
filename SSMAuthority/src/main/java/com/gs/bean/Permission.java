package com.gs.bean;

/**
 * Created by Administrator on 2017/9/25.
 */
public class Permission {

    private Integer id;
    private String name;
    private String desZh;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesZh() {
        return desZh;
    }

    public void setDesZh(String desZh) {
        this.desZh = desZh;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", desZh='" + desZh + '\'' +
                '}';
    }
}
