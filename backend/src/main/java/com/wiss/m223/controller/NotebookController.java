/*
Verantwortlich für die Verwaltung von Notizbüchern in der Anwendung.
Stellt Endpunkte bereit, um Notizbücher zu erstellen, abzurufen und zu bearbeiten.
 */

package com.wiss.m223.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.wiss.m223.service.NotebookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// Ich markiere diese Klasse als REST-Controller mit einem Basispfad für Notizbuch-bezogene Anfragen.
@RestController
@RequestMapping("/notebook")
public class NotebookController<NotebookDTO> {
    private final NotebookService notebookService; // Ich deklariere eine Variable für den NotebookService, der die Logik für Notizbücher enthält.

    public NotebookController(NotebookService notebookService) { // Der Konstruktor der Klasse nimmt einen NotebookService entgegen und weist ihn der lokalen Variable zu.
        this.notebookService = notebookService;
    }

    // Ein POST-Endpunkt zum Erstellen eines neuen Notizbuchs. Nimmt Notizbuch-Daten im Request-Body entgegen.

    @PostMapping("/new")
    public ResponseEntity<String> createNotebook(@RequestBody NotebookDTO notebookDTO) {
        notebookService.createNotebook(notebookDTO);// Ruft die Methode createNotebook des NotebookService auf, um das Notizbuch zu erstellen.
        return ResponseEntity.ok("New notebook created!");// Gibt eine Erfolgsmeldung zurück, wenn das Notizbuch erstellt wurde.
    }
    // Ein DELETE-Endpunkt zum Löschen eines Notizbuchs. Nimmt die ID des Notizbuchs als Pfadvariable entgegen.
    @DeleteMapping("/{notebookId}")
    public ResponseEntity<String> deleteNotebook(@PathVariable Long notebookId) {
        notebookService.deleteNotebook(notebookId); // Ruft die Methode deleteNotebook des NotebookService auf, um das Notizbuch zu löschen.
        return ResponseEntity.ok("Notebook deleted!");// Gibt eine Erfolgsmeldung zurück, wenn das Notizbuch gelöscht wurde.
    }
}
