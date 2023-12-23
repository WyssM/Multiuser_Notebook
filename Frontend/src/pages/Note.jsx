import React, { useState, useEffect } from 'react';
import { createNote, deleteNote} from '../functions/NotesService';

// Die Komponente für die Notizverwaltung, mein Platz für kreatives Schreiben.
const Note = () => {
    // Hier speichere ich die Daten für eine neue Notiz und alle vorhandenen Notizen.
    const [noteData, setNoteData] = useState({ title: '', content: '' });
    const [notes, setNotes] = useState([]);

    // Beim Laden der Komponente hole ich mir alle Notizen.
    useEffect(() => {
        loadNotes();
    }, []);

    const loadNotes = async () => {
        try {
            const response = await getNotes();
            setNotes(response.data);
        } catch (error) {
            console.error("Ups, da ist etwas schiefgelaufen beim Laden der Notizen", error);
        }
    };

    // So erstelle ich eine neue Notiz - ganz einfach!
    const handleCreateNote = async (e) => {
        e.preventDefault();
        try {
            const response = await createNote(noteData);
            setNotes([...notes, response.data]);
            setNoteData({ title: '', content: '' }); // Formular zurücksetzen für die nächste Notiz
        } catch (error) {
            console.error("Oh nein, die Notiz konnte nicht erstellt werden", error);
        }
    };

    // Hiermit lösche ich eine Notiz, wenn sie nicht mehr gebraucht wird.
    const handleDeleteNote = async (noteId) => {
        try {
            await deleteNote(noteId);
            setNotes(notes.filter(note => note.id !== noteId));
        } catch (error) {
            console.error("Das Löschen der Notiz hat leider nicht geklappt", error);
        }
    };

    // Jetzt geht's ans Rendern. Hier wird's sichtbar!
    return (
        <div>
            <h1>Notizverwaltung</h1>
            {/* Mein Formular zum Erstellen neuer Notizen */}
            <form onSubmit={handleCreateNote}>
                <input 
                    type="text" 
                    value={noteData.title} 
                    onChange={(e) => setNoteData({ ...noteData, title: e.target.value })} 
                    placeholder="Titel der Notiz" 
                />
                <textarea 
                    value={noteData.content} 
                    onChange={(e) => setNoteData({ ...noteData, content: e.target.value })} 
                    placeholder="Inhalt der Notiz" 
                />
                <button type="submit">Notiz erstellen</button>
            </form>

            {/* Hier zeige ich alle vorhandenen Notizen an */}
            <h2>Vorhandene Notizen</h2>
            <ul>
                {notes.map(note => (
                    <li key={note.id}>
                        <h3>{note.title}</h3>
                        <p>{note.content}</p>
                        <button onClick={() => handleDeleteNote(note.id)}>Löschen</button>
                        {/* Hier könnte noch ein Bearbeiten-Button hinzugefügt werden */}
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default Note;