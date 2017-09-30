package com.gs.mapping;


public class Player {
    private Integer id;
    private String realname;
    private Integer gender;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", realname='" + realname + '\'' +
                ", gender=" + gender +
                '}';
    }
}
