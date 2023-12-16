package com.wiss.m223.service;

import com.wiss.m223.repository.KategorienRepository;
import org.springframework.stereotype.Service;

@Service
public class KategorienService {
    private final KategorienRepository kategorienRepository;

    public KategorienService(KategorienRepository kategorienRepository) {
        this.kategorienRepository = kategorienRepository;
    }

}
