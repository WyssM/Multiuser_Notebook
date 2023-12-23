package com.wiss.m223.service;

import com.wiss.m223.model.Categories;
import com.wiss.m223.repository.CategoriesRepository;
import org.springframework.stereotype.Service;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CategoriesService<CategoryDTO> {
    private final CategoriesRepository categoriesRepository;

    public CategoriesService(CategoriesRepository categoriesRepository) {
        this.categoriesRepository = categoriesRepository;
    }

    public void createCategory(CategoryDTO categoryDTO) {
        Categories category = new Categories();
        category.setName(category.getName());
        category.setDescription(category.getDescription());
        categoriesRepository.save(category);
    }

    public void deleteCategory(Long categoryId) {
        Optional<Categories> optionalCategory = categoriesRepository.findById(categoryId);
        if (optionalCategory.isPresent()) {
            Categories category = optionalCategory.get();
            categoriesRepository.delete(category);
        } else {
            throw new NoSuchElementException("Category with ID " + categoryId + " not found.");
        }
    }
}