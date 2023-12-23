package com.wiss.m223.repository;

import com.wiss.m223.model.Notes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotesRepository extends JpaRepository<Notes, Long> {
    // Finds notes belonging to a specific notebook
    List<Notes> findByNotebookId(Long notebookId);

    // Finds notes containing a specific text in the content
    List<Notes> findByContentContaining(String content);
}
