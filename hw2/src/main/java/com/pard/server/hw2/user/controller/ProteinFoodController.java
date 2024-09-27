package com.pard.server.hw2.user.controller;

import com.pard.server.hw2.user.dto.ProteinFoodDto;
import com.pard.server.hw2.user.service.ProteinFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/protein-foods")
public class ProteinFoodController {

    @Autowired
    private ProteinFoodService proteinFoodService;

    // Get all protein foods
    @GetMapping
    public List<ProteinFoodDto> getAllProteinFoods() {
        return proteinFoodService.getAllProteinFoods();
    }

    // Add a new protein food
    @PostMapping
    public ResponseEntity<String> addProteinFood(@RequestBody ProteinFoodDto proteinFoodDto) {
        proteinFoodService.addProteinFood(proteinFoodDto);
        return ResponseEntity.ok("Protein food added successfully");
    }

    // Update an existing protein food
    @PutMapping("/{id}")
    public ResponseEntity<String> updateProteinFood(@PathVariable Long id, @RequestBody ProteinFoodDto proteinFoodDto) {
        proteinFoodService.updateProteinFood(id, proteinFoodDto);
        return ResponseEntity.ok("Protein food updated successfully");
    }

    // Delete a protein food
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProteinFood(@PathVariable Long id) {
        proteinFoodService.deleteProteinFood(id);
        return ResponseEntity.ok("Protein food deleted successfully");
    }
}
