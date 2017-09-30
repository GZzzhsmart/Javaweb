package com.gs.common.util;

import com.gs.common.bean.Pager;

/**
 * Created by WangGenshen on 7/20/15.
 */
public class PagerUtil {

    public static final String PAGE_SIZE = "pager.pageSize";

    public static Pager getPager(int pageNo) {
        return getPager(pageNo, 0);
    }

    public static Pager getPager(int pageNo, int pageSize) {
        Pager pager = new Pager();
        if (pageNo <= 0) {
            pageNo = 1;
        }
        if (pageSize <= 0) {
            pageSize = SingletonConfig.getInstance().getInt(PAGE_SIZE);
        }
        pager.setPageNo(pageNo);
        pager.setPageSize(pageSize);
        return pager;
    }

    public static void rebuildPager(Pager pager, int totalRecords) {
        pager.setTotalRecords(totalRecords);
        int result = totalRecords % pager.getPageSize();
        pager.setTotalPages(result == 0 ? totalRecords / pager.getPageSize() : totalRecords / pager.getPageSize() + 1);
    }

}
