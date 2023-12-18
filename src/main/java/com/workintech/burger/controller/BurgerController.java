package com.workintech.burger.controller;

import com.workintech.burger.dao.BurgerDao;
import com.workintech.burger.entity.Burger;
import com.workintech.burger.util.BreadType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/burgers")
public class BurgerController {
    private BurgerDao burgerDao;

    @Autowired
    public BurgerController(BurgerDao burgerDao) {
        this.burgerDao = burgerDao;
    }

    @GetMapping
    public List<Burger> findAll() {
        return burgerDao.findAll();
    }

    @GetMapping("/{id}")
    public Burger findById(@PathVariable Long id) {
        Optional<Burger> burger = Optional.ofNullable(burgerDao.findById(id));
        return burger.orElse(null);
    }

    @PostMapping
    public Burger save(@RequestBody Burger burger) {
        return burgerDao.save(burger);
    }

    @PutMapping("/{id}")
    public Burger update(@PathVariable Long id, @RequestBody Burger burger) {
        return burgerDao.update(burger);
        /*where to use id*/
    }

    @DeleteMapping("/{id}")
    public Burger remove(@PathVariable Long id) {
        return burgerDao.remove(id);
    }

    @GetMapping("/findByPrice")
    public List<Burger> findByPrice(Double price) {
        return burgerDao.findByPrice(price);
    }

    @GetMapping("/findByBreadType")
    public List<Burger> findByBreadType(BreadType breadType) {
        return burgerDao.findByBreadType(breadType);
    }
    @GetMapping("/findByContent")
    public List<Burger> findByContent(String content) {
        return burgerDao.findByContent(content);
    }
}
