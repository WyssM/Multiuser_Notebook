import React, { useState, useEffect } from 'react';
import { createNote, deleteNote, getNotes } from './functions/NotesService';

const Note = () => {
    const [noteData, setNoteData] = useState({ title: '', content: '' });
    const [notes, setNotes] = useState([]);

    useEffect(() => {
        loadNotes();
    }, []);

    const loadNotes = async () => {
        try {
            const response = await getNotes();
            setNotes(response.data);
        } catch (error) {
            console.error("Fehler beim Laden der Notizen", error);
        }
    };

    const handleCreateNote = async (e) => {
        e.preventDefault();
        try {
            const response = await createNote(noteData);
            setNotes([...notes, response.data]);
            setNoteData({ title: '', content: '' }); // Reset form
        } catch (error) {
            console.error("Fehler beim Erstellen der Notiz", error);
        }
    };

    const handleDeleteNote = async (noteId) => {
        try {
            await deleteNote(noteId);
            setNotes(notes.filter(note => note.id !== noteId));
        } catch (error) {
            console.error("Fehler beim Löschen der Notiz", error);
        }
    };

    return (
        <div>
            <h1>Notizverwaltung</h1>
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

            <h2>Vorhandene Notizen</h2>
            <ul>
                {notes.map(note => (
                    <li key={note.id}>
                        <h3>{note.title}</h3>
                        <p>{note.content}</p>
                        <button onClick={() => handleDeleteNote(note.id)}>Löschen</button>
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default Note;