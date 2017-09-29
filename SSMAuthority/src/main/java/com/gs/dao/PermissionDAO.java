package com.gs.dao;

import com.gs.bean.Permission;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/9/25.
 */
@Repository
public interface PermissionDAO {

    /**
     * 根据角色id和权限字符串查找权限，如果返回的Permission不为空，则有些权限，否则没有权限
     * @param roleIds
     * @param permission
     * @return
     */
    Permission getByPermissionRole(@Param("roleIds") List<Integer> roleIds, @Param("permission") String permission);

}
