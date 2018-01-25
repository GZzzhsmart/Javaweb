package top.zzh.service;


import top.zzh.common.PageQuery;
import top.zzh.common.StatusQuery;

import java.util.List;

/**
 * Created by 曾志湖 on 2017/9/6.
 */
public interface BaseService<T> {
    public T queryById(long id);

    public void update(T t);

    public void add(T t);

    public void delete(long id);

    public List<T> pagelist(PageQuery pageQuery);

    public void updateStatus(StatusQuery statusQuery);

    public int count();

    public List<T> listAll();
}
