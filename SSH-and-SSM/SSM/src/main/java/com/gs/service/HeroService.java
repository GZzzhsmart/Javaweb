package com.gs.service;

import com.gs.common.Pager;
import com.gs.mapping.Hero;

import java.util.List;


public interface HeroService {

    List<Hero> listByPager(Pager pager);
}
