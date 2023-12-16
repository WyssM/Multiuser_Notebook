package com.wiss.m223.controller;

import com.wiss.m223.service.NotizenService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notizen")
public class NotizenController {
    private final NotizenService notizenService;

    public NotizenController(NotizenService notizenService) {
        this.notizenService = notizenService;
    }
}