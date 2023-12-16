package com.wiss.m223.model;

import java.util.Date;
import jakarta.persistence.*;
    @Entity
    @Table(name = "Notizbuch")
    public class Notizbuch {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long notizbuchId;
        private String titel;
        private String beschreibung;
        private Date erstellungsdatum;

        @ManyToOne
        @JoinColumn(name = "erstellerId")
        private Benutzer ersteller;

        public Notizbuch(Long notizbuchId, String titel, String beschreibung, Date erstellungsdatum, Benutzer ersteller) {
            this.notizbuchId = notizbuchId;
            this.titel = titel;
            this.beschreibung = beschreibung;
            this.erstellungsdatum = erstellungsdatum;
            this.ersteller = ersteller;
        }

        public Long getNotizbuchId() {
            return notizbuchId;
        }

        public void setNotizbuchId(Long notizbuchId) {
            this.notizbuchId = notizbuchId;
        }

        public String getTitel() {
            return titel;
        }

        public void setTitel(String titel) {
            this.titel = titel;
        }

        public String getBeschreibung() {
            return beschreibung;
        }

        public void setBeschreibung(String beschreibung) {
            this.beschreibung = beschreibung;
        }

        public Date getErstellungsdatum() {
            return erstellungsdatum;
        }

        public void setErstellungsdatum(Date erstellungsdatum) {
            this.erstellungsdatum = erstellungsdatum;
        }

        public Benutzer getErsteller() {
            return ersteller;
        }

        public void setErsteller(Benutzer ersteller) {
            this.ersteller = ersteller;
        }
    }


