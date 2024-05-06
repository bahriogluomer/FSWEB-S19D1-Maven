package com.workintech.s18d2.controller;

import com.workintech.s18d2.entity.Vegetable;
import com.workintech.s18d2.services.VegetableService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vegetable")
@Validated
public class VegetableController {
    private final VegetableService vegetableService;


    @Autowired
    public VegetableController(VegetableService vegetableService) {
        this.vegetableService = vegetableService;
    }


    @GetMapping
    public List<Vegetable> get() {
        return vegetableService.getByPriceAsc();
    }


    @GetMapping("/desc")
    public List<Vegetable> getDesc() {
        return vegetableService.getByPriceDesc();
    }


    @GetMapping("/{id}")
    public Vegetable getById(@Validated @PathVariable("id") Long id) {
        return vegetableService.getById(id);
    }


    @GetMapping("/name/{name}")
    public List<Vegetable> getByName(@PathVariable("name") String name) {
        return vegetableService.searchByName(name);
    }


    @PostMapping
    public Vegetable save(@Validated @RequestBody Vegetable vegetable) {
        return vegetableService.save(vegetable);
    }


    @DeleteMapping("/delete/{id}")
    public Vegetable delete(@PathVariable("id") Long id) {
        return vegetableService.delete(id);
    }


    @PutMapping
    public Vegetable update(@Validated @RequestBody Vegetable vegetable) {
        return vegetableService.update(vegetable);
    }
}
