package com.gs.dao;

import com.gs.common.Pager;
import com.gs.mapping.Hero;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HeroDAO {

    /**
     *
     * @param pager
     * @return
     */
    List<Hero> listByPager(Pager pager);
}
