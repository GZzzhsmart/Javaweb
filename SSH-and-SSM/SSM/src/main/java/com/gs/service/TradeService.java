package com.gs.service;


import com.gs.common.Pager;
import com.gs.mapping.Trade;

import java.util.List;

public interface TradeService {

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
     * 保存用户的道具购买记录，保存购买记录时一定要保存购买记录的条目
     * 此方法将来需要调用TradeDAO， TradeItemDAO
     * @param playerId
     * @param propIds
     */
    void saveTrade(int playerId, int[] propIds);
}
