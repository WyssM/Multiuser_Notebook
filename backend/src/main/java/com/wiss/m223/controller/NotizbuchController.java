package com.wiss.m223.controller;

import com.wiss.m223.service.NotizbuchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notizbuch")
public class NotizbuchController<NotizbuchDTO> {
    private final NotizbuchService notizbuchService;

    public NotizbuchController(NotizbuchService notizbuchService) {
        this.notizbuchService = notizbuchService;
    }

    @PostMapping("/neu")
    public ResponseEntity<String> createNotizbuch(@RequestBody NotizbuchDTO notizbuchDTO) {
        notizbuchService.createNotizbuch(notizbuchDTO);
        return ResponseEntity.ok("Neues Notizbuch erstellt!");
    }

    @DeleteMapping("/{notizbuchId}")
    public ResponseEntity<String> deleteNotizbuch(@PathVariable Long notizbuchId) {
        notizbuchService.deleteNotizbuch(notizbuchId);
        return ResponseEntity.ok("Notizbuch gelöscht!");
    }
}

