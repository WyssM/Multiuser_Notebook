package com.wiss.m223.service;

import com.wiss.m223.repository.BenutzerRepository;
import org.springframework.stereotype.Service;

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
}
