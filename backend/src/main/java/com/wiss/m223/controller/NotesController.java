/*
Fokussiert sich auf die Verwaltung von Notizen.
Bietet Funktionen zum Erstellen, Abrufen, Aktualisieren und Löschen von Notizen.
 */

package com.wiss.m223.controller;

import com.wiss.m223.service.NotesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// Ich markiere diese Klasse als REST-Controller und definiere "/notes" als Basispfad.
@RestController
@RequestMapping("/notes")
public class NotesController<NoteDTO> {
    private final NotesService notesService;// Eine Instanz von NotesService, um die logik für Notizen zu handhaben.

    public NotesController(NotesService notesService) {// Der Konstruktor der Klasse, der eine Instanz von NotesService entgegennimmt.
        this.notesService = notesService;
    }

    // Ein POST-Endpunkt zum Erstellen einer neuen Notiz. Nimmt Notizdaten im Request-Body entgegen.
    @PostMapping("/new")
    public ResponseEntity<String> createNote(@RequestBody NoteDTO noteDTO) {
        notesService.createNote(noteDTO);// Ruft die Methode createNote des NotesService auf, um die Notiz zu erstellen.
        return ResponseEntity.ok("New note created!"); // Gibt eine Erfolgsmeldung zurück, wenn die Notiz erstellt wurde.
    }

    // Ein DELETE-Endpunkt zum Löschen einer Notiz. Nimmt die ID der Notiz als Pfadvariable entgegen.
    @DeleteMapping("/{noteId}")
    public ResponseEntity<String> deleteNote(@PathVariable Long noteId) {
        notesService.deleteNote(noteId);// Ruft die Methode deleteNote des NotesService auf, um die Notiz zu löschen.
        return ResponseEntity.ok("Note deleted!");// Gibt eine Erfolgsmeldung zurück, wenn die Notiz gelöscht wurde
    }
}
