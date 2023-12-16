package com.wiss.m223.controller;

import com.wiss.m223.service.NotizenService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notizen")
public class NotizenController<NotizDTO> {
    private final NotizenService notizenService;

    public NotizenController(NotizenService notizenService) {
        this.notizenService = notizenService;
    }

    @PostMapping("/neu")
    public ResponseEntity<String> createNotiz(@RequestBody NotizDTO notizDTO) {
        notizenService.createNotiz(notizDTO);
        return ResponseEntity.ok("Neue Notiz erstellt!");
    }

    @DeleteMapping("/{notizId}")
    public ResponseEntity<String> deleteNotiz(@PathVariable Long notizId) {
        notizenService.deleteNotiz(notizId);
        return ResponseEntity.ok("Notiz gelöscht!");
    }
}
