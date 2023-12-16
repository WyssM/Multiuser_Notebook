package com.wiss.m223.service;

import com.wiss.m223.model.Notizbuch;
import com.wiss.m223.repository.NotizbuchRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class NotizbuchService<NotizbuchDTO> {
    private final NotizbuchRepository notizbuchRepository;

    public NotizbuchService(NotizbuchRepository notizbuchRepository) {
        this.notizbuchRepository = notizbuchRepository;
    }

    public void createNotizbuch(NotizbuchDTO notizbuchDTO) {
        Notizbuch notizbuch = new Notizbuch();
        notizbuch.setTitel(notizbuch.getTitel());
        notizbuch.setBeschreibung(notizbuch.getBeschreibung());
        notizbuch.setErstellungsdatum(new Date());

        notizbuchRepository.save(notizbuch);
    }

    public void deleteNotizbuch(Long notizbuchId) {
        Optional<Notizbuch> optionalNotizbuch = notizbuchRepository.findById(notizbuchId);
        if (optionalNotizbuch.isPresent()) {
            Notizbuch notizbuch = optionalNotizbuch.get();

            notizbuchRepository.delete(notizbuch);
        } else {

            throw new NoSuchElementException("Notizbuch mit der ID " + notizbuchId + " wurde nicht gefunden.");
        }
    }
}
