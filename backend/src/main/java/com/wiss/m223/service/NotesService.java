package com.wiss.m223.service;

import com.wiss.m223.model.Notes;
import com.wiss.m223.repository.NotesRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class NotesService<NoteDTO> {
    private final NotesRepository notesRepository;

    public NotesService(NotesRepository notesRepository) {
        this.notesRepository = notesRepository;
    }
    public void createNote(NoteDTO noteDTO) {
        Notes note = new Notes();
        note.setTitle(note.getTitle());
        note.setContent(note.getContent());
        note.setCreationDate(new Date());

        notesRepository.save(note);
    }

    public void deleteNote(Long noteId) {
        Optional<Notes> optionalNote = notesRepository.findById(noteId);
        if (optionalNote.isPresent()) {
            Notes note = optionalNote.get();
            notesRepository.delete(note);
        } else {
            throw new NoSuchElementException("Note with ID " + noteId + " not found.");
        }
    }
}