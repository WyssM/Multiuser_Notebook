package com.wiss.m223.controller;

import com.wiss.m223.service.NotebookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notebook")
public class NotebookController<NotebookDTO> {
    private final NotebookService notebookService;

    public NotebookController(NotebookService notebookService) {
        this.notebookService = notebookService;
    }

    @PostMapping("/new")
    public ResponseEntity<String> createNotebook(@RequestBody NotebookDTO notebookDTO) {
        notebookService.createNotebook(notebookDTO);
        return ResponseEntity.ok("New notebook created!");
    }

    @DeleteMapping("/{notebookId}")
    public ResponseEntity<String> deleteNotebook(@PathVariable Long notebookId) {
        notebookService.deleteNotebook(notebookId);
        return ResponseEntity.ok("Notebook deleted!");
    }
}
