package com.gs.service;

import com.gs.common.Pager;
import com.gs.mapping.Player;

import java.util.List;

/**
 * Created by Administrator on 2017/9/18.
 */
public interface PlayerService {

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
