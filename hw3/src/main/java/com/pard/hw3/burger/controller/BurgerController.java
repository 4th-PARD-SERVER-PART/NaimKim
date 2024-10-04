package com.pard.hw3.burger.controller;

import com.pard.hw3.burger.dto.BurgerDto;
import com.pard.hw3.burger.service.BurgerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/burger")
public class BurgerController {
    private final BurgerService burgerService;

    @PostMapping("")
    public void addBurger(@RequestBody BurgerDto burgerDto) {
        burgerService.saveBurger(burgerDto);
    }

    @GetMapping("")
    public List<BurgerDto> readAll() {
        return burgerService.readAll();
    }


    @PatchMapping("/{burgerId}")
    public void updateBurger(@PathVariable Long burgerId, @RequestBody BurgerDto burgerDto) {
        burgerService.updateBurger(burgerId, burgerDto);
    }

    @DeleteMapping("/{burgerId}")
    public void deleteBurger(@PathVariable Long burgerId) {
        burgerService.deleteBurger(burgerId);
    }

    @GetMapping("/price-range")
    public List<BurgerDto> findBurgersByPriceRangeOrdered(@RequestParam Double minPrice, @RequestParam Double maxPrice) {
        return burgerService.findBurgersByPriceRangeOrdered(minPrice, maxPrice);
    }

    @GetMapping("/search")
    public List<BurgerDto> findBurgersByNameOrTypeOrdered(@RequestParam String keyword) {
        return burgerService.findBurgersByNameOrTypeOrdered(keyword);
    }

    @GetMapping("/cheaper-than")
    public List<BurgerDto> findBurgersCheaperThanSortedByTypeAndRecent(@RequestParam Double price) {
        return burgerService.findBurgersCheaperThanSortedByTypeAndRecent(price);
    }



}
