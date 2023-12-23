package com.wiss.m223.service;

import com.wiss.m223.model.Notebook;
import com.wiss.m223.repository.NotebookRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class NotebookService<NotebookDTO> {
    private final NotebookRepository notebookRepository;

    public NotebookService(NotebookRepository notebookRepository) {
        this.notebookRepository = notebookRepository;
    }

    public void createNotebook(NotebookDTO notebookDTO) {
        Notebook notebook = new Notebook();
        notebook.setTitle(notebook.getTitle());
        notebook.setDescription(notebook.getDescription());
        notebook.setCreationDate(new Date());

        notebookRepository.save(notebook);
    }

    public void deleteNotebook(Long notebookId) {
        Optional<Notebook> optionalNotebook = notebookRepository.findById(notebookId);
        if (optionalNotebook.isPresent()) {
            Notebook notebook = optionalNotebook.get();
            notebookRepository.delete(notebook);
        } else {
            throw new NoSuchElementException("Notebook with ID " + notebookId + " not found.");
        }
    }
}