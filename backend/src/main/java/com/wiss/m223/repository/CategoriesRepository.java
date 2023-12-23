package com.wiss.m223.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoriesRepository extends JpaRepository<Categories, Long> {
    // Finds categories by name
    List<Categories> findByNameContaining(String name);
}