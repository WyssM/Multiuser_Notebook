package com.wiss.m223.repository;

import com.wiss.m223.model.ERole;
import com.wiss.m223.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// Ich markiere es als Repository und erweitere JpaRepository, um CRUD-Operationen und mehr zu ermöglichen.
public interface RoleRepository extends JpaRepository<Role, Long> {
    // Findet eine Rolle anhand des Namens
    Optional<Role> findByName(ERole name);// Eine Methode, um eine Rolle anhand des Namens zu finden. Nützlich, um Rollen bei der Zuweisung an Benutzer zu identifizieren.

    boolean existsByName(ERole eRole);
}