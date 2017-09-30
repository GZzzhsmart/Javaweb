package com.gs.dao;

import com.gs.common.Pager;
import com.gs.mapping.Trade;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TradeDAO {

    /**
     *
     * @return
     */
    List<Trade> listByPager(Pager pager);

    /**
     *
     * @param id
     * @return
     */
    Trade getById(int id);

    /**
     * 保存用户的道具购买记录
     * @param playerId
     */
    int saveTrade(int playerId);

}
