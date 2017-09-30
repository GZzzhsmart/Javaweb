package com.gs.common.bean;

/**
 * Created by WangGenshen on 7/18/15.
 */
public class Pager {
    private int pageSize;
    private int pageNo;
    private int beginIndex;
    private int endIndex;

    private int totalRecords;
    private int totalPages;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getBeginIndex() {
        return (pageNo - 1) * pageSize;
    }

    public int getEndIndex() {
        return pageNo * pageSize;
    }

    public int getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(int totalRecords) {
        this.totalRecords = totalRecords;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
}
