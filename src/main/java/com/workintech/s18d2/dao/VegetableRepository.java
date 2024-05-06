package com.workintech.s18d2.dao;

import com.workintech.s18d2.entity.Vegetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

//value = "SELECT v.id,v.name,v.price,v.type FROM grocery.vegetables v ORDER BY v.price ASC", nativeQuery = true
@Repository
public interface VegetableRepository extends JpaRepository<Vegetable, Long> {

     @Query(value = "SELECT v.id,v.name,v.price,v.type FROM grocery.vegetables v ORDER BY v.price ASC", nativeQuery = true)
     List<Vegetable> getByPriceAsc();
     @Query(value = "SELECT v.id,v.name,v.price,v.type FROM grocery.vegetables v ORDER BY v.price DESC", nativeQuery = true)
     List<Vegetable> getByPriceDesc();
     @Query(value = "SELECT v FROM Vegetable v WHERE v.name LIKE %:name%", nativeQuery = true)
     List<Vegetable> searchByName(String name);

}
