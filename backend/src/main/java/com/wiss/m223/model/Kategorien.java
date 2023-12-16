package com.wiss.m223.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Kategorien")
public class Kategorien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long kategorieId;
    private String name;
    private String beschreibung;

    @ManyToOne
    @JoinColumn(name = "erstellerId")
    private Benutzer ersteller;

    public Kategorien(Long kategorieId, String name, String beschreibung, Benutzer ersteller) {
        this.kategorieId = kategorieId;
        this.name = name;
        this.beschreibung = beschreibung;
        this.ersteller = ersteller;
    }

    public Kategorien() {
    }

    public Long getKategorieId() {
        return kategorieId;
    }

    public void setKategorieId(Long kategorieId) {
        this.kategorieId = kategorieId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public Benutzer getErsteller() {
        return ersteller;
    }

    public void setErsteller(Benutzer ersteller) {
        this.ersteller = ersteller;
    }
}
