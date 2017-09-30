package com.gs.service;


public interface PlayerHeroService {

    /**
     * 玩家一次性选择多个英雄
     * @param playerId
     * @param heroIds
     */
    void saveHeros(int playerId, int[] heroIds);
}
