import React, { useState, useEffect } from 'react';
import NotesService from '../functions/api';
import Note from './Note';
import NotebookForm from '../functions/NotebookForm'; 

// Das UserDashboard, das die Hauptfunktionalität für Benutzer bereitstellt.
const UserDashboard = () => {
    // Verwende useState, um den Zustand der Notizen zu speichern.
    const [notes, setNotes] = useState([]);

    // useEffect, um beim Laden der Komponente Notizen zu laden.
    useEffect(() => {
        NotesService.getUserNotes()
            .then(response => {
                // Setzen der geladenen Notizen in den Zustand.
                setNotes(response.data);
            })
            .catch(error => {
                // Falls ein Fehler auftritt, wird dieser in der Konsole geloggt
                console.error('Fehler beim Laden der Notizen:', error);
            });
    }, []);

    // Funktion zum Löschen einer Notiz.
    const handleDelete = (noteId) => {
        NotesService.deleteNote(noteId)
            .then(() => {
                // Entferne der gelöschten Notiz aus dem Zustand.
                setNotes(notes.filter(note => note.id !== noteId));
            })
            .catch(error => {
                // Logge der Fehler beim Löschen.
                console.error('Fehler beim Löschen der Notiz:', error);
            });
    };

    // Funktion zum Bearbeiten einer Notiz.
    const handleEdit = (noteId, updatedNoteData) => {
        NotesService.updateNote(noteId, updatedNoteData)
            .then(updatedNote => {
                // Aktualisiere des Zustand mit der bearbeiteten Notiz.
                setNotes(notes.map(note => note.id === noteId ? updatedNote : note));
            })
            .catch(error => {
                // Logge Fehler beim Aktualisieren.
                console.error('Fehler beim Aktualisieren der Notiz:', error);
            });
    };

    // Die render-Methode, die die UI-Komponenten rendert.
    return (
        <div>
            <h1>Notizen</h1>
            <NotebookForm/>
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





