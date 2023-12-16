package com.wiss.m223.controller;

import com.wiss.m223.service.NotizbuchService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notizbuch")
public class NotizbuchController {
    private final NotizbuchService notizbuchService;

    public NotizbuchController(NotizbuchService notizbuchService) {
        this.notizbuchService = notizbuchService;
    }


}
