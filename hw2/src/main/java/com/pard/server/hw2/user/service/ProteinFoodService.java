package com.pard.server.hw2.user.service;

import com.pard.server.hw2.user.dto.ProteinFoodDto;
import com.pard.server.hw2.user.entity.ProteinFood;
import com.pard.server.hw2.user.repository.ProteinFoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProteinFoodService {

    @Autowired
    private ProteinFoodRepository proteinFoodRepository;

    // Retrieve all protein foods
    public List<ProteinFoodDto> getAllProteinFoods() {
        return proteinFoodRepository.findAll();
    }

    // Add a new protein food
    public void addProteinFood(ProteinFoodDto proteinFoodDto) {
        proteinFoodDto.setId(generateNewId());  // Generate a new ID for the protein food
        proteinFoodRepository.save(proteinFoodDto);
    }

    // Find a protein food by its ID
    public ProteinFoodDto getProteinFoodById(Long id) {
        return proteinFoodRepository.findById(id);
    }

    // Update an existing protein food
    public void updateProteinFood(Long id, ProteinFoodDto proteinFoodDto) {
        proteinFoodRepository.update(id, proteinFoodDto);
    }

    // Delete a protein food by its ID
    public void deleteProteinFood(Long id) {
        proteinFoodRepository.delete(id);
    }

    // Helper method to generate a new unique ID
    private Long generateNewId() {
        List<ProteinFoodDto> allFoods = proteinFoodRepository.findAll();
        if (allFoods.isEmpty()) {
            return 1L;
        } else {
            Long maxId = allFoods.stream()
                    .mapToLong(ProteinFoodDto::getId)
                    .max()
                    .orElse(0L);
            return maxId + 1;
        }
    }
}
