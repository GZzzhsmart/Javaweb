package com.gs.service;

import com.gs.bean.Permission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2017/9/25.
 */
public interface PermissionService {

    /**
     * 根据角色id和权限字符串查找权限，如果返回的Permission不为空，则有些权限，否则没有权限
     * @param roleIds
     * @param permission
     * @return
     */
    Permission getByPermissionRole(List<Integer> roleIds, String permission);

}
