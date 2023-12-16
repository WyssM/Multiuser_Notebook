package com.wiss.m223.controller;
/**
 * In diesen Controllern können Endpunkte definiert werden,
 * um auf die entsprechenden Service-Klassen zuzugreifen und Daten abzurufen, zu erstellen,
 * zu aktualisieren oder zu löschen.
 */

import com.wiss.m223.service.BenutzerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/benutzer")
public class BenutzerController {
    private final BenutzerService benutzerService;

    public BenutzerController(BenutzerService benutzerService) {
        this.benutzerService = benutzerService;
    }


}
