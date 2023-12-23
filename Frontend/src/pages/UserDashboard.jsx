import React, { useState, useEffect } from 'react';
import NotesService from './functions/api';
import Note from './Note';
import CreateNoteForm from './functions/CreateNoteForm'; 

const UserDashboard = () => {
    const [notes, setNotes] = useState([]);

    useEffect(() => {
        NotesService.getUserNotes()
            .then(response => {
                setNotes(response.data);
            })
            .catch(error => {
                console.error('Fehler beim Laden der Notizen:', error);
            });
    }, []);

    const handleDelete = (noteId) => {
        NotesService.deleteNote(noteId)
            .then(() => {
                // Aktualisieren des States, um die gelöschte Notiz zu entfernen
                setNotes(notes.filter(note => note.id !== noteId));
            })
            .catch(error => {
                console.error('Fehler beim Löschen der Notiz:', error);
            });
    };

    const handleEdit = (noteId, updatedNoteData) => {
        NotesService.updateNote(noteId, updatedNoteData)
            .then(updatedNote => {
                // Aktualisieren des States, um die bearbeitete Notiz anzuzeigen
                setNotes(notes.map(note => note.id === noteId ? updatedNote : note));
            })
            .catch(error => {
                console.error('Fehler beim Aktualisieren der Notiz:', error);
            });
    };

    return (
        <div>
            <h1>Notizen</h1>
            <CreateNoteForm /> {/* Hier wird die CreateNoteForm-Komponente gerendert */}
            <div>
                {notes && notes.map((note) => (
                    <Note
                        key={note.id}
                        note={note}
                        onDelete={() => handleDelete(note.id)}
                        onEdit={() => handleEdit(note)}
                    />
                ))}
            </div>
        </div>
    );
};

export default UserDashboard;




