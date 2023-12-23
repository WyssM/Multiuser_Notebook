// NotesService.js - Zentraler Punkt für die Verwaltung von Notizen in meiner App

// Import des API-Moduls, das die Basis für HTTP-Anfragen bildet
import API from './api';

// createNote-Funktion, um eine neue Notiz zu erstellen
export const createNote = (noteData) => {
    // Sendet eine POST-Anfrage an den '/notes/new' Endpunkt mit den Notizdaten
    return API.post('/notes/new', noteData);
};

// deleteNote-Funktion, um eine Notiz zu löschen
export const deleteNote = (noteId) => {
    // Sendet eine DELETE-Anfrage an den '/notes/{noteId}' Endpunkt, um die spezifizierte Notiz zu löschen
    return API.delete(`/notes/${noteId}`);
};

// Export der Funktionen für die Verwendung in anderen Teilen der Anwendung
export default {
    createNote,
    deleteNote
};