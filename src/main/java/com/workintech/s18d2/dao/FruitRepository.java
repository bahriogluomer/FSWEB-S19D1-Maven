package com.workintech.s18d2.dao;

import com.workintech.s18d2.entity.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

//SELECT f.id,f.name,f.price,f.type FROM grocery.fruits f ORDER BY f.price DESC", nativeQuery = true
@Repository
public interface FruitRepository extends JpaRepository<Fruit, Long> {
    @Query(value = "SELECT f.id,f.name,f.price,f.type FROM grocery.fruits f ORDER BY f.price ASC", nativeQuery = true)
    List<Fruit> getByPriceAsc();
    @Query(value = "SELECT f.id,f.name,f.price,f.type FROM grocery.fruits f ORDER BY f.price DESC", nativeQuery = true)
    List<Fruit> getByPriceDesc();

    @Query(value = "SELECT * FROM grocery.fruits f WHERE f.name LIKE %:name%", nativeQuery = true)
    List<Fruit> searchByName(String name);
    }
