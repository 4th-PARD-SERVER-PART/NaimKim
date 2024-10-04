package com.pard.hw3.burger.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Burger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long burgerId;

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "type", length = 255)
    private String type;

    @Column(name = "price")
    private Double price;

    @CreationTimestamp
    private Timestamp addedTimestamp;
}
