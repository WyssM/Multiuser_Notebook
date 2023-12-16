package com.wiss.m223.repository;

import com.wiss.m223.model.Benutzer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Diese Repository-Klassen erweitern das JpaRepository-Interface und erben dadurch grundlegende CRUD-Operationen sowie die Möglichkeit,
 * benutzerdefinierte Methoden für spezielle Datenbankoperationen hinzuzufügen
 */
@Repository
public interface BenutzerRepository extends JpaRepository<Benutzer, Long> {

}