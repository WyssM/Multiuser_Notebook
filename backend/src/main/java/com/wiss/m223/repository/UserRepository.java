package com.wiss.m223.repository;

import com.wiss.m223.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

/**
 * Diese Repository-Klassen erweitern das JpaRepository-Interface und erben dadurch grundlegende CRUD-Operationen sowie die Möglichkeit,
 * benutzerdefinierte Methoden für spezielle Datenbankoperationen hinzuzufügen
 */
// Ich markiere es als Repository und erweitere JpaRepository, um CRUD-Operationen und mehr zu ermöglichen.
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);// Eine Methode, um einen Benutzer anhand des Benutzernamens zu finden. Dies hilft mir, um zu überprüfen, ob ein Benutzername bereits vergeben ist.
    Boolean existsByUsername(String username);// Eine Methode, um zu überprüfen, ob ein Benutzername bereits existiert.
}