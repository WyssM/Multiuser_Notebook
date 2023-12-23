package com.wiss.m223.controller;

import com.wiss.m223.service.NotesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notes")
public class NotesController<NoteDTO> {
    private final NotesService notesService;

    public NotesController(NotesService notesService) {
        this.notesService = notesService;
    }

    @PostMapping("/new")
    public ResponseEntity<String> createNote(@RequestBody NoteDTO noteDTO) {
        notesService.createNote(noteDTO);
        return ResponseEntity.ok("New note created!");
    }

    @DeleteMapping("/{noteId}")
    public ResponseEntity<String> deleteNote(@PathVariable Long noteId) {
        notesService.deleteNote(noteId);
        return ResponseEntity.ok("Note deleted!");
    }
}
