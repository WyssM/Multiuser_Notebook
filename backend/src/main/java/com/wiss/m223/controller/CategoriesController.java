package com.wiss.m223.controller;

import com.wiss.m223.service.CategoriesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
public class CategoriesController<CategoryDTO> {
    private final CategoriesService categoriesService;

    public CategoriesController(CategoriesService categoriesService) {
        this.categoriesService = categoriesService;
    }

    @PostMapping("/new")
    public ResponseEntity<String> createCategory(@RequestBody CategoryDTO categoryDTO) {
        categoriesService.createCategory(categoryDTO);
        return ResponseEntity.ok("New category created!");
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long categoryId) {
        categoriesService.deleteCategory(categoryId);
        return ResponseEntity.ok("Category deleted!");
    }
}