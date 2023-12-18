package com.workintech.burger.dao;

import com.workintech.burger.entity.Burger;

import java.util.List;
import java.util.Optional;

public interface BurgerDao {
    Burger save(Burger burger);
    Optional<Burger> findById(Long id);
    List<Burger> findAll();
    List<Burger> findByPrice(Double price);
    List<Burger> findByContent(String content);
    Burger update(Burger burger);
    Burger remove(Long id);


}
