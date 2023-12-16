package com.wiss.m223.controller;
/**
 * In diesen Controllern können Endpunkte definiert werden,
 * um auf die entsprechenden Service-Klassen zuzugreifen und Daten abzurufen, zu erstellen,
 * zu aktualisieren oder zu löschen.
 */

import com.wiss.m223.service.BenutzerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/benutzer")
public class BenutzerController<BenutzerDTO, Berechtigungen> {
    private final BenutzerService benutzerService;

    public BenutzerController(BenutzerService benutzerService) {
        this.benutzerService = benutzerService;
    }

    @PostMapping("/neu")
    public ResponseEntity<String> createBenutzer(@RequestBody BenutzerDTO benutzerDTO) {
        benutzerService.createBenutzer(benutzerDTO);
        return ResponseEntity.ok("Neuer Benutzer erstellt!");
    }

    @PutMapping("/{benutzerId}/berechtigungen")
    public ResponseEntity<String> changeBerechtigungen(@PathVariable Long benutzerId, @RequestBody Berechtigungen berechtigungenDTO) {
         benutzerService.changeBerechtigungen(benutzerId, berechtigungenDTO);
        return ResponseEntity.ok("Berechtigungen aktualisiert!");
    }

    @DeleteMapping("/{benutzerId}")
    public ResponseEntity<String> deleteBenutzer(@PathVariable Long benutzerId) {
        benutzerService.deleteBenutzer(benutzerId);
        return ResponseEntity.ok("Benutzer gelöscht!");
    }
}
