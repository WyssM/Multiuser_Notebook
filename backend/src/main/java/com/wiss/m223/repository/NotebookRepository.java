package com.wiss.m223.repository;

import com.wiss.m223.model.Notebook;
import com.wiss.m223.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// Ich markiere es als Repository und erweitere JpaRepository, um CRUD-Operationen und mehr zu ermöglichen.
@Repository
public interface NotebookRepository extends JpaRepository<Notebook, Long> {
    List<Notebook> findByCreator(User creator); // Eine Methode, um alle Notizbücher eines bestimmten Benutzers zu finden. Nützlich, um alle Notizbücher anzuzeigen, die einem Benutzer gehören.
}
