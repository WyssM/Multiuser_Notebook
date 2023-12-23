package com.wiss.m223.repository;

import com.wiss.m223.model.Benutzer;
import com.wiss.m223.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Diese Repository-Klassen erweitern das JpaRepository-Interface und erben dadurch grundlegende CRUD-Operationen sowie die Möglichkeit,
 * benutzerdefinierte Methoden für spezielle Datenbankoperationen hinzuzufügen
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}