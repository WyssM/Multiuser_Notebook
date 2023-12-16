package com.wiss.m223.service;

import com.wiss.m223.repository.NotizbuchRepository;
import org.springframework.stereotype.Service;

@Service
public class NotizbuchService {
    private final NotizbuchRepository notizbuchRepository;

    public NotizbuchService(NotizbuchRepository notizbuchRepository) {
        this.notizbuchRepository = notizbuchRepository;
    }


}
