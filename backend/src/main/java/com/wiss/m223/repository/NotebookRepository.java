package com.wiss.m223.repository;

import com.wiss.m223.model.Notebook;
import com.wiss.m223.model.Notizbuch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotebookRepository extends JpaRepository<Notebook, Long> {
    // Finds all notebooks of a specific user
    List<Notebook> findByCreatorId(Long creatorId);
}
