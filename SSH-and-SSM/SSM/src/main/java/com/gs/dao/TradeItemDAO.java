package com.gs.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TradeItemDAO {

    /**
     * 保存用户道具购买记录的详情，一个交易信息可以增加多个道具
     * @param tradeId
     * @param propIds
     */
    void saveTradeItems(@Param("tradeId") int tradeId, @Param("propIds") int[] propIds);
}

