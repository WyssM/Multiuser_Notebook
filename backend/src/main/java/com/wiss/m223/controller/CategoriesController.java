/*
Spezialisiert auf die Verwaltung von Kategorien innerhalb der Anwendung.
Ermöglicht es Benutzern, Kategorien hinzuzufügen, zu bearbeiten und abzufragen.
*/
package com.wiss.m223.controller;


import com.wiss.m223.service.CategoriesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// Ich kennzeichne diese Klasse als REST-Controller mit einem Basispfad für Kategorien.
@RestController
@RequestMapping("/categories")
public class CategoriesController<CategoryDTO> {
    private final CategoriesService categoriesService;// Eine Instanz des CategoriesService, um Geschäftslogiken für Kategorien zu verarbeiten.

    public CategoriesController(CategoriesService categoriesService) {// Der Konstruktor nimmt einen CategoriesService entgegen und weist ihn der lokalen Variable zu.
        this.categoriesService = categoriesService;
    }

    // Ein POST-Endpunkt zum Erstellen einer neuen Kategorie. Akzeptiert Kategoriedaten im Request-Body.
    @PostMapping("/new/")
    public ResponseEntity<String> createCategory(@RequestBody CategoryDTO categoryDTO) {
        categoriesService.createCategory(categoryDTO);// Ruft die Methode createCategory des CategoriesService auf, um die Kategorie zu erstellen.
        return ResponseEntity.ok("New category created!");// Gibt eine Erfolgsmeldung zurück, wenn die Kategorie erstellt wurde.
    }

    // Ein DELETE-Endpunkt zum Löschen einer Kategorie. Nimmt die ID der Kategorie als Pfadvariable entgegen.
    @DeleteMapping("/{categoryId}/")
    public ResponseEntity<String> deleteCategory(@PathVariable Long categoryId) {
        categoriesService.deleteCategory(categoryId);// Ruft die Methode deleteCategory des CategoriesService auf, um die Kategorie zu löschen.
        return ResponseEntity.ok("Category deleted!"); // Gibt eine Erfolgsmeldung zurück, wenn die Kategorie gelöscht wurde.
    }
}