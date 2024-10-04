package com.pard.hw3.burger.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BurgerDto {
    private String name;
    private String type;
    private Double price;
}
