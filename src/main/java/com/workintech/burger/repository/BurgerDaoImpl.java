package com.workintech.burger.repository;

import com.workintech.burger.dao.BurgerDao;
import com.workintech.burger.entity.Burger;
import com.workintech.burger.exceptions.BurgerException;
import com.workintech.burger.util.BreadType;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BurgerDaoImpl implements BurgerDao {
    private EntityManager entityManager;

    @Transactional
    @Override
    public Burger save(Burger burger) {
        entityManager.persist(burger);
        return burger;
    }

    @Override
    public Burger findById(Long id) {
        Burger burger = entityManager.find(Burger.class, id);
        if (burger == null) throw new BurgerException("Burger with given id not exist", HttpStatus.BAD_REQUEST);
        else return burger;
    }

    @Override
    public List<Burger> findAll() {
        TypedQuery<Burger> query = entityManager.createQuery("SELECT b FROM Burger b", Burger.class);
        return query.getResultList();
    }

    @Override
    public List<Burger> findByPrice(Double price) {
        TypedQuery<Burger> query = entityManager
                .createQuery("SELECT b FROM Burger b WHERE b.price > :price ORDER BY b.price DESC", Burger.class);
        query.setParameter("price", price);
        return query.getResultList();
    }

    @Override
    public List<Burger> findByBreadType(BreadType breadType) {
        TypedQuery<Burger> query = entityManager
                .createQuery("SELECT b FROM Burger b WHERE b.breadType = :breadType ORDER BY b.name ASC", Burger.class);
        query.setParameter("breadType", breadType);
        return query.getResultList();
    }

    @Override
    public List<Burger> findByContent(String content) {
        TypedQuery<Burger> query = entityManager
                .createQuery("SELECT b FROM Burger b WHERE b.content LIKE :content", Burger.class);
        query.setParameter("content", "%" + content + "%");
        return query.getResultList();
    }

    @Override
    public Burger update(Burger burger) {
        return entityManager.merge(burger);
    }

    @Override
    public Burger remove(Long id) {
        Optional<Burger> employee = Optional.ofNullable(findById(id));
        if(employee.isPresent()){
            entityManager.remove(employee.get());
            return employee.get();
        }
        return null;
    }
}
