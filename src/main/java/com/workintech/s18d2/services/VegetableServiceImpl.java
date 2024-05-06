package com.workintech.s18d2.services;

import com.workintech.s18d2.dao.VegetableRepository;
import com.workintech.s18d2.entity.Vegetable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VegetableServiceImpl implements VegetableService{
    private final VegetableRepository vegetableRepository;


    @Autowired
    public VegetableServiceImpl(VegetableRepository vegetableRepository) {
        this.vegetableRepository = vegetableRepository;
    }


    @Override
    public List<Vegetable> getByPriceAsc() {
        return vegetableRepository.getByPriceAsc();
    }


    @Override
    public List<Vegetable> getByPriceDesc() {
        return vegetableRepository.getByPriceDesc();
    }


    @Override
    public List<Vegetable> searchByName(String name) {
        return vegetableRepository.searchByName(name);
    }


    @Override
    public Vegetable save(Vegetable vegetable) {
        return vegetableRepository.save(vegetable);
    }


    @Override
    public Vegetable delete(Long id) {
        Vegetable vegetable = vegetableRepository.findById(id).orElseThrow(() -> new RuntimeException("Vegetable not found"));
        vegetableRepository.delete(vegetable);
        return vegetable;
    }


    @Override
    public Vegetable update(Vegetable vegetable) {
        return vegetableRepository.save(vegetable);
    }


    @Override
    public Vegetable getById(Long id) {
        return vegetableRepository.findById(id).orElseThrow(() -> new RuntimeException("Vegetable not found"));
    }

}
