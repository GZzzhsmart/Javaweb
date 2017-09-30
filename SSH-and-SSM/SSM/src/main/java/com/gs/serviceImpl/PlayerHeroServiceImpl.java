package com.gs.serviceImpl;

import com.gs.dao.PlayerHeroDAO;
import com.gs.service.PlayerHeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PlayerHeroServiceImpl implements PlayerHeroService {

    @Autowired
    private PlayerHeroDAO playerHeroDAO;

    @Transactional(rollbackFor = java.lang.Exception.class)
    public void saveHeros(int playerId, int[] heroIds) {
        playerHeroDAO.saveHeros(playerId, heroIds);
    }
}