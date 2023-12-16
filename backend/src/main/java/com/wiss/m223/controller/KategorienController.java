package com.wiss.m223.controller;

import com.wiss.m223.service.KategorienService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kategorien")
public class KategorienController<KategorieDTO> {
    private final KategorienService kategorienService;

    public KategorienController(KategorienService kategorienService) {
        this.kategorienService = kategorienService;
    }

    @PostMapping("/neu")
    public ResponseEntity<String> createKategorie(@RequestBody KategorieDTO kategorieDTO) {
        kategorienService.createKategorie(kategorieDTO);
        return ResponseEntity.ok("Neue Kategorie erstellt!");
    }

    @DeleteMapping("/{kategorieId}")
    public ResponseEntity<String> deleteKategorie(@PathVariable Long kategorieId) {
        kategorienService.deleteKategorie(kategorieId);
        return ResponseEntity.ok("Kategorie gelöscht!");
    }
}
