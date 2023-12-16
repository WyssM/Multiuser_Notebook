package com.wiss.m223.service;

import com.wiss.m223.model.Benutzer;
import com.wiss.m223.repository.BenutzerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Diese Service-Klassen enthalten die Geschäftslogik der Anwendung. Sie können Methoden enthalten,
 * die Operationen auf den Repository-Klassen ausführen und die Ergebnisse entsprechend weiterverarbeiten oder manipulieren.
 * Ich füge Methoden hinzu
 * die spezifische Logik für jede Entität ausführen, wie z. B. das Erstellen, Bearbeiten oder Löschen von Daten.
 */
@Service
public class BenutzerService {
    private final BenutzerRepository benutzerRepository;

    public BenutzerService(BenutzerRepository benutzerRepository) {
        this.benutzerRepository = benutzerRepository;
    }
    public <BenutzerDTO> void createBenutzer(BenutzerDTO benutzerDTO) {

        Benutzer benutzer = new Benutzer();
        benutzerRepository.save(benutzer);
    }

    public <Berechtigungen> void changeBerechtigungen(Long benutzerId, Berechtigungen berechtigungen) {

        Optional<Benutzer> optionalBenutzer = benutzerRepository.findById(benutzerId);
        if (optionalBenutzer.isPresent()) {
            Benutzer benutzer = optionalBenutzer.get();
            benutzer.setBerechtigungen(berechtigungen);
            benutzerRepository.save(benutzer);
        }
    }

    public void deleteBenutzer(Long benutzerId) {

        benutzerRepository.deleteById(benutzerId);
    }
}

