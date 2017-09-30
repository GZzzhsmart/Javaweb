package com.gs.common;

/**
 * 分页Javabean
 * */
public class Pager {

    private int pageNo;
    private int pageSize;
    private int beginIndex;

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getBeginIndex() {
        return (pageNo - 1) * pageSize;
    }
}
