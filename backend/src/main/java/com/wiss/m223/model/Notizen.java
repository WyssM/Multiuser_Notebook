package com.wiss.m223.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Notizen")
public class Notizen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long notizId;
    private String titel;
    private String inhalt;
    private Date erstellungsdatum;
    private Date letzteAktualisierung;

    @ManyToOne
    @JoinColumn(name = "erstellerId")
    private Benutzer ersteller;

    @ManyToOne
    @JoinColumn(name = "notizbuchId")
    private Notizbuch notizbuch;

    @ManyToOne
    @JoinColumn(name = "kategorieId")
    private Kategorien kategorie;

    public Notizen(Long notizId, String titel, String inhalt, Date erstellungsdatum, Date letzteAktualisierung, Benutzer ersteller, Notizbuch notizbuch, Kategorien kategorie) {
        this.notizId = notizId;
        this.titel = titel;
        this.inhalt = inhalt;
        this.erstellungsdatum = erstellungsdatum;
        this.letzteAktualisierung = letzteAktualisierung;
        this.ersteller = ersteller;
        this.notizbuch = notizbuch;
        this.kategorie = kategorie;
    }

    public Long getNotizId() {
        return notizId;
    }

    public void setNotizId(Long notizId) {
        this.notizId = notizId;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getInhalt() {
        return inhalt;
    }

    public void setInhalt(String inhalt) {
        this.inhalt = inhalt;
    }

    public Date getErstellungsdatum() {
        return erstellungsdatum;
    }

    public void setErstellungsdatum(Date erstellungsdatum) {
        this.erstellungsdatum = erstellungsdatum;
    }

    public Date getLetzteAktualisierung() {
        return letzteAktualisierung;
    }

    public void setLetzteAktualisierung(Date letzteAktualisierung) {
        this.letzteAktualisierung = letzteAktualisierung;
    }

    public Benutzer getErsteller() {
        return ersteller;
    }

    public void setErsteller(Benutzer ersteller) {
        this.ersteller = ersteller;
    }

    public Notizbuch getNotizbuch() {
        return notizbuch;
    }

    public void setNotizbuch(Notizbuch notizbuch) {
        this.notizbuch = notizbuch;
    }

    public Kategorien getKategorie() {
        return kategorie;
    }

    public void setKategorie(Kategorien kategorie) {
        this.kategorie = kategorie;
    }
}
