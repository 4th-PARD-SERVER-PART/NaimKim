package com.pard.hw3.burger.repository;

import com.pard.hw3.burger.entity.Burger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BurgerRepo extends JpaRepository<Burger, Long> {

    @Query("SELECT b FROM Burger b WHERE b.price BETWEEN :minPrice AND :maxPrice ORDER BY b.price ASC")
    List<Burger> findBurgersByPriceRangeOrdered(@Param("minPrice") Double minPrice, @Param("maxPrice") Double maxPrice);

    @Query("SELECT b FROM Burger b WHERE LOWER(b.name) LIKE LOWER(CONCAT('%', :keyword, '%')) OR LOWER(b.type) LIKE LOWER(CONCAT('%', :keyword, '%')) ORDER BY b.name ASC")
    List<Burger> findBurgersByNameOrTypeOrdered(@Param("keyword") String keyword);

    @Query("SELECT b FROM Burger b WHERE b.price < :price ORDER BY b.type ASC, b.addedTimestamp DESC")
    List<Burger> findBurgersCheaperThanSortedByTypeAndRecent(@Param("price") Double price);
}
