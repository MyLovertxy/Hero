package com.wuyong.service;

import com.wuyong.domain.Hero;

import java.util.List;

public interface HeroService {
    List<Hero> getAllHero();

    void addHero(Hero hero);

    Hero getHeroById(long id);

    void updateHero(Hero hero);

    void deleteHero(Long id);
}
