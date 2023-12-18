package com.workintech.burger.repository;

import com.workintech.burger.dao.BurgerDao;
import com.workintech.burger.entity.Burger;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Optional;

public class BurgerDaoImpl implements BurgerDao {
    private EntityManager entityManager;

    @Override
    public Burger save(Burger burger) {
        entityManager.persist(burger);
        return Burger;
    }

    @Override
    public Optional<Burger> findById(Long id) {
        return Optional.ofNullable(entityManager.find(Burger.class, id));
    }

    @Override
    public List<Burger> findAll() {
        TypedQuery<Burger> query = entityManager.createQuery("SELECT b FROM Burger b", Burger.class);
        return query.getResultList();
    }

    @Override
    public List<Burger> findByPrice(Double price) {
        return null;
    }

    @Override
    public List<Burger> findByContent(String content) {
        return null;
    }

    @Override
    public Burger update(Burger burger) {
        return null;
    }

    @Override
    public Burger remove(Long id) {
        return null;
    }
}
