package com.workintech.burger.dao;

import com.workintech.burger.entity.Burger;
import com.workintech.burger.util.BreadType;

import java.util.List;

public interface BurgerDao {
    Burger save(Burger burger);
    Burger findById(Long id);
    List<Burger> findAll();
    List<Burger> findByPrice(Double price);
    List<Burger> findByBreadType(BreadType breadType);
    List<Burger> findByContent(String content);
    Burger update(Burger burger);
    Burger remove(Long id);


}
