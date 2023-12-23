// NotebookForm.js - Eine Formularkomponente, um neue Notizbücher anzulegen

// Import von React und useState-Hook
import React, { useState } from 'react';

// Import der createNotebook-Funktion aus dem API-Service
import { createNotebook } from './api';

const NotebookForm = () => {
    // State-Hooks für Titel und Beschreibung des Notizbuchs
    const [title, setTitle] = useState('');
    const [description, setDescription] = useState('');

    // handleSubmit-Funktion wird beim Absenden des Formulars aufgerufen
    const handleSubmit = async (e) => {
        e.preventDefault(); // Verhindert das Neuladen der Seite bei Formularabsendung
        try {
            // Sendet die Daten zum Erstellen eines neuen Notizbuchs an den Server
            const response = await createNotebook({ title, description });
            console.log("Notizbuch erstellt:", response.data);
        } catch (error) {
            console.error("Fehler beim Erstellen des Notizbuchs", error); // Fehlerbehandlung
        }
    };

    // Das Formular, das vom Benutzer ausgefüllt wird
    return (
        <form onSubmit={handleSubmit}>
            <input
                type="text"
                value={title}
                onChange={(e) => setTitle(e.target.value)}
                placeholder="Titel"
            />
            <textarea
                value={description}
                onChange={(e) => setDescription(e.target.value)}
                placeholder="Beschreibung"
            />
            <button type="submit">Notizbuch erstellen</button>
        </form>
    );
};

export default NotebookForm;