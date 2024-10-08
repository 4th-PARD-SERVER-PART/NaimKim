package com.pard.server.hw1;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/food")
public class WhatToEatController {

    private final List<String> meals = new ArrayList<>();

    public WhatToEatController() {
        // 기본으로 들어가는 meals list
        meals.add("명성제육");
        meals.add("버거킹");
        meals.add("학관");
        meals.add("라운지");
        meals.add("웅짬뽕");
    }

    // GET meal list http://localhost:8080/food/list
    @GetMapping("/list")
    public List<String> getAllMeals() {
        return meals;
    }

    // GET random recommendation http://localhost:8080/food/recommend
    @GetMapping("/recommend")
    public String getRandomMeal() {
        if (meals.isEmpty()) {
            return "뭐 추가하고 돌려.. 아무것도 없는데 어케 추천함!!!!";
        }
        Random random = new Random();
        return "오저는: " + meals.get(random.nextInt(meals.size()));
    }

    // POST add meal http://localhost:8080/food/add?meal=초밥
    @PostMapping("/add")
    public String addMeal(@RequestParam String meal) {
        meals.add(meal);
        return meal + " 추가됨!";
    }

    // PUT update a meal by index http://localhost:8080/food/update/2?newMeal=굶어라그냥
    @PutMapping("/update/{index}")
    public String updateMeal(@PathVariable int index, @RequestParam String newMeal) {
        if (index < 0 || index >= meals.size()) {
            return index + "번은 없음..;;";
        }
        meals.set(index, newMeal);
        return  index + "번 " + newMeal + " 으로바꿈!";
    }

    // DELETE a meal by index http://localhost:8080/food/delete/2
    @DeleteMapping("/delete/{index}")
    public String deleteMeal(@PathVariable int index) {
        if (index < 0 || index >= meals.size()) {
            return index + "번은 없음..;;";
        }
        String removedMeal = meals.remove(index);
        return removedMeal + " 지웠다~" ;

    }


}
