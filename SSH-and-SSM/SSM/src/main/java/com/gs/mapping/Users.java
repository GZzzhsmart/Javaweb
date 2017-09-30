package com.gs.mapping;


import java.util.List;

public class Users {

    private int userid;
    private String username;
    private String password;
    private String email;
    private String phone;
    private int heroid;
    private int propid;
    private int current;//当前页面号
    private int rowCount;//每页行数
    private int total;//总行数
    private List<Users> rows;
    private Hero hero;
    private Prop prop;
    private List<Deal> dealList;

    public List <Deal> getDealList() {
        return dealList;
    }

    public void setDealList(List <Deal> dealList) {
        this.dealList = dealList;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public int getRowCount() {
        return rowCount;
    }

    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List <Users> getRows() {
        return rows;
    }

    public void setRows(List <Users> rows) {
        this.rows = rows;
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public Prop getProp() {
        return prop;
    }

    public void setProp(Prop prop) {
        this.prop = prop;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getHeroid() {
        return heroid;
    }

    public void setHeroid(int heroid) {
        this.heroid = heroid;
    }

    public int getPropid() {
        return propid;
    }

    public void setPropid(int propid) {
        this.propid = propid;
    }
}
