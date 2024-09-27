package com.pard.server.hw2.user.repository;

import com.pard.server.hw2.user.dto.ProteinFoodDto;
import com.pard.server.hw2.user.entity.ProteinFood;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProteinFoodRepository {
    private static final Map<Long, ProteinFood> foodDatabase = new HashMap<>();

    // Save ProteinFood to the database
    public void save(ProteinFoodDto proteinFoodDto) {
        ProteinFood proteinFood = ProteinFood.builder()
                .id(proteinFoodDto.getId())
                .name(proteinFoodDto.getName())
                .proteinGrams(proteinFoodDto.getProteinGrams())
                .calories(proteinFoodDto.getCalories())
                .build();
        foodDatabase.put(proteinFoodDto.getId(), proteinFood);
    }

    // Find ProteinFood by ID
    public ProteinFoodDto findById(Long id) {
        ProteinFood proteinFood = foodDatabase.get(id);
        return ProteinFoodDto.builder()
                .id(proteinFood.getId())
                .name(proteinFood.getName())
                .proteinGrams(proteinFood.getProteinGrams())
                .calories(proteinFood.getCalories())
                .build();
    }

    // Retrieve all ProteinFood items
    public List<ProteinFoodDto> findAll() {
        return foodDatabase.values().stream()
                .map(proteinFood -> ProteinFoodDto.builder()
                        .id(proteinFood.getId())
                        .name(proteinFood.getName())
                        .proteinGrams(proteinFood.getProteinGrams())
                        .calories(proteinFood.getCalories())
                        .build())
                .toList();
    }

    // Update ProteinFood information
    public void update(Long id, ProteinFoodDto proteinFoodDto) {
        ProteinFood proteinFood = foodDatabase.get(id);
        proteinFood.setName(proteinFoodDto.getName());
        proteinFood.setProteinGrams(proteinFoodDto.getProteinGrams());
        proteinFood.setCalories(proteinFoodDto.getCalories());
    }

    // Delete ProteinFood from the database
    public void delete(Long id) {
        foodDatabase.remove(id);
    }
}
