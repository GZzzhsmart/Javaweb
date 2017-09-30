package top.zywork.service;

import java.util.List;

/**
 * Created by Wang Genshen on 2017-08-31.
 */
public interface TemplateService<T, PK> {

    void save(T t);
    T getById(PK id);
    List<T> listAll();
    List<T> listDOS();

}
