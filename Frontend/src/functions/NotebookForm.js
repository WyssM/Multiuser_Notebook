import React, { useState } from 'react';
import { createNotebook } from './api';

const NotebookForm = () => {
    const [title, setTitle] = useState('');
    const [description, setDescription] = useState('');

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            const response = await createNotebook({ title, description });
            console.log(response.data);
        } catch (error) {
            console.error("Fehler beim Erstellen des Notizbuchs", error);
        }
    };

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