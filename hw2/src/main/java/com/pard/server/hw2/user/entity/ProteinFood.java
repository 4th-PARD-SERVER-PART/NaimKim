package com.pard.server.hw2.user.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProteinFood {
    private Long id;
    private String name;
    private double proteinGrams;
    private double calories;
}
