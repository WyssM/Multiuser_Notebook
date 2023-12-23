// NotebookService.js - Mein Werkzeug für die Verwaltung von Notizbüchern in der App

// Import des API-Moduls für HTTP-Anfragen
import API from './api';

// createNotebook-Funktion, um ein neues Notizbuch zu erstellen
export const createNotebook = (notebookData) => {
    // Sendet eine POST-Anfrage an den '/notebook/new' Endpunkt mit den Notizbuchdaten
    return API.post('/notebook/new', notebookData);
};

// deleteNotebook-Funktion, um ein Notizbuch zu löschen
export const deleteNotebook = (notebookId) => {
    // Sendet eine DELETE-Anfrage an den '/notebook/{notebookId}' Endpunkt, um das spezifizierte Notizbuch zu löschen
    return API.delete(`/notebook/${notebookId}`);
};

// Export der Funktionen für die Verwendung in anderen Teilen der Anwendung
export default {
    createNotebook,
    deleteNotebook
};