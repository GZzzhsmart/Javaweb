package com.gs.dao;

import com.gs.common.Pager;
import com.gs.mapping.Player;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * PlayerDAO接口，实现玩家的CRUD
 * 创建时间：2017-09-18
 *
 * @author XXX
 * @version 1.0
 */
@Repository
public interface PlayerDAO {

    /**
     * 根据用户查找玩家
     * @param realname 用户名
     * @return 指定用户名的玩家
     */
    Player getByName(String realname);

    /**
     * 分页查找玩家
     * @return 指定页码指定项数的玩家列表
     */
    List<Player> listByPager(Pager pager);
}
