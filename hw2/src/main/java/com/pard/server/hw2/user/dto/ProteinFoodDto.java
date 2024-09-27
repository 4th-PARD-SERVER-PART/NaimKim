package com.pard.server.hw2.user.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProteinFoodDto {
    private Long id;
    private String name;
    private double proteinGrams;
    private double calories;
}
