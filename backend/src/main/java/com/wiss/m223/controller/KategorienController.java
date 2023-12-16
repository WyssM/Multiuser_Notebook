package com.wiss.m223.controller;

import com.wiss.m223.service.KategorienService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kategorien")
public class KategorienController {
    private final KategorienService kategorienService;

    public KategorienController(KategorienService kategorienService) {
        this.kategorienService = kategorienService;
    }
}