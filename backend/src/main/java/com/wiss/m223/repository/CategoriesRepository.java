package com.wiss.m223.repository;

import com.wiss.m223.model.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// Ich markiere es als Repository und erweitere JpaRepository, um CRUD-Operationen und mehr zu ermöglichen.
@Repository
public interface CategoriesRepository extends JpaRepository<Categories, Long> {

    List<Categories> findByNameContaining(String name);// Eine Methode, um Kategorien anhand eines Namensfragments zu finden. // Nützlich, um Kategorien nach einem Stichwort zu durchsuchen.
}