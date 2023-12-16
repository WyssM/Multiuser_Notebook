package com.wiss.m223.service;

import com.wiss.m223.repository.NotizenRepository;
import org.springframework.stereotype.Service;

@Service
public class NotizenService {
    private final NotizenRepository notizenRepository;

    public NotizenService(NotizenRepository notizenRepository) {
        this.notizenRepository = notizenRepository;
    }
}