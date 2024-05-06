package com.workintech.s18d2.services;

import com.workintech.s18d2.entity.Vegetable;

import java.util.List;


public interface VegetableService {
    List<Vegetable> getByPriceAsc();
    Vegetable getById(Long id);
    List<Vegetable> getByPriceDesc();
    List<Vegetable> searchByName(String name);
    Vegetable save(Vegetable fruit);
    Vegetable delete(Long id);
    Vegetable update(Vegetable fruit);
}
