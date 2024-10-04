package com.pard.hw3.burger.service;

import com.pard.hw3.burger.dto.BurgerDto;
import com.pard.hw3.burger.entity.Burger;
import com.pard.hw3.burger.repository.BurgerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BurgerService {
    private final BurgerRepo burgerRepo;

    // Find burgers by price range and order by price (cheapest to most expensive)
    public List<BurgerDto> findBurgersByPriceRangeOrdered(Double minPrice, Double maxPrice) {
        List<Burger> burgers = burgerRepo.findBurgersByPriceRangeOrdered(minPrice, maxPrice);
        return burgers.stream().map(burger ->
                        BurgerDto.builder()
                                .name(burger.getName())
                                .type(burger.getType())
                                .price(burger.getPrice())
                                .build())
                .toList();
    }

    // Find burgers by name or type and order alphabetically
    public List<BurgerDto> findBurgersByNameOrTypeOrdered(String keyword) {
        List<Burger> burgers = burgerRepo.findBurgersByNameOrTypeOrdered(keyword);
        return burgers.stream().map(burger ->
                        BurgerDto.builder()
                                .name(burger.getName())
                                .type(burger.getType())
                                .price(burger.getPrice())
                                .build())
                .toList();
    }

    // Find burgers cheaper than a specific price, sorted by type and recent orders
    public List<BurgerDto> findBurgersCheaperThanSortedByTypeAndRecent(Double price) {
        List<Burger> burgers = burgerRepo.findBurgersCheaperThanSortedByTypeAndRecent(price);
        return burgers.stream().map(burger ->
                        BurgerDto.builder()
                                .name(burger.getName())
                                .type(burger.getType())
                                .price(burger.getPrice())
                                .build())
                .toList();
    }

    public List<BurgerDto> readAll() {
        List<Burger> burgers = burgerRepo.findAll();
        return burgers.stream().map(burger ->
                        BurgerDto.builder()
                                .name(burger.getName())
                                .type(burger.getType())
                                .price(burger.getPrice())
                                .build())
                .toList();
    }

    // Save a new burger to the database
    public void saveBurger(BurgerDto burgerDto) {
        Burger burger = Burger.builder()
                .name(burgerDto.getName())
                .type(burgerDto.getType())
                .price(burgerDto.getPrice())
                .build();
        burgerRepo.save(burger);
    }



    // Update an existing burger by ID
    public void updateBurger(Long burgerId, BurgerDto burgerDto) {
        Burger burger = burgerRepo.findById(burgerId).orElseThrow(() -> new IllegalArgumentException("Burger not found"));
        burger.setName(burgerDto.getName());
        burger.setType(burgerDto.getType());
        burger.setPrice(burgerDto.getPrice());
        burgerRepo.save(burger);
    }

    // Delete a burger by ID
    public void deleteBurger(Long burgerId) {
        burgerRepo.deleteById(burgerId);
    }
}
