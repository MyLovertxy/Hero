package com.wuyong.service.Impl;

import com.wuyong.domain.Hero;
import com.wuyong.mapper.HeroMapper;
import com.wuyong.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeroServiceImpl implements HeroService {
    @Autowired
    private HeroMapper heroMapper;
    @Override
    public List<Hero> getAllHero() {
        return heroMapper.selectAll();
    }

    @Override
    public void addHero(Hero hero) {
        heroMapper.insert(hero);
    }

    @Override
    public Hero getHeroById(long id) {
        return heroMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateHero(Hero hero) {
        heroMapper.updateByPrimaryKey(hero);
    }

    @Override
    public void deleteHero(Long id) {
        heroMapper.deleteByPrimaryKey(id);
    }
}
