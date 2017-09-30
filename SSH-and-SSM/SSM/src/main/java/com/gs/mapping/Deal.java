package com.gs.mapping;


import java.util.Date;

public class Deal {

    private int dealid;
    private int userid;
    private Date created_time;

    private Users users;
    public int getDealid() {
        return dealid;
    }

    public void setDealid(int dealid) {
        this.dealid = dealid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public Date getCreated_time() {
        return created_time;
    }

    public void setCreated_time(Date created_time) {
        this.created_time = created_time;
    }
}
