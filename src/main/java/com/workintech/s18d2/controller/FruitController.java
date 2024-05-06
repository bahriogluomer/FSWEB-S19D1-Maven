package com.workintech.s18d2.controller;


import com.workintech.s18d2.dto.FruitResponse;
import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.services.FruitService;
import jakarta.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fruit")
@Validated
public class FruitController {
    private final FruitService fruitService;


    @Autowired
    public FruitController(FruitService fruitService) {

        this.fruitService = fruitService;
    }

    @GetMapping
    public List<Fruit> getByPriceAsc() {
        return fruitService.getByPriceAsc();
    }

    @GetMapping("/desc")
    public List<Fruit> getByPriceDesc() {
        return fruitService.getByPriceDesc();
    }

    @GetMapping("/{id}")
    public FruitResponse getById(@Positive @PathVariable("id") Long id) {
        return new FruitResponse("Fruit found", fruitService.getById(id));
    }

    @GetMapping("/name/{name}")
    public List<Fruit> getByName(@PathVariable("name") String name) {
        return fruitService.searchByName(name);
    }

    @PostMapping
    public Fruit save( @RequestBody Fruit fruit) {
        return fruitService.save(fruit);
    }

    @DeleteMapping("/{id}")
    public Fruit delete(@PathVariable("id") Long id) {
        return fruitService.delete(id);
    }

    @PutMapping
    public Fruit update(@RequestBody Fruit fruit) {
        return fruitService.update(fruit);
    }
}
