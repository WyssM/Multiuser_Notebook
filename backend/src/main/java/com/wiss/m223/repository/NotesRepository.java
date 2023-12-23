package com.wiss.m223.repository;

import com.wiss.m223.model.Notes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// Ich markiere es als Repository und erweitere JpaRepository, um CRUD-Operationen und mehr zu ermöglichen.
@Repository
public interface NotesRepository extends JpaRepository<Notes, Long> {

}
