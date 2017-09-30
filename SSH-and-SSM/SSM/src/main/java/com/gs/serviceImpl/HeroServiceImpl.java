package com.gs.serviceImpl;

import com.gs.common.Pager;
import com.gs.dao.HeroDAO;
import com.gs.mapping.Hero;
import com.gs.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeroServiceImpl implements HeroService {

    @Autowired
    private HeroDAO heroDAO;

    public List<Hero> listByPager(Pager pager) {
        return heroDAO.listByPager(pager);
    }
}

