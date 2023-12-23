import React, { useState, useEffect } from 'react';
import { createNotebook } from '../functions/NotebookService';

// Mein Bereich für Notizbuch- und Kategorienverwaltung.
const NotebookCategory = () => {
    // Ich speichere die Notizbücher und Kategorien in meinem State.
    const [notebooks, setNotebooks] = useState([]);
    const [categories, setCategories] = useState([]);
    // Neue Notizbuch- und Kategoriendaten werden auch hier gespeichert.
    const [newNotebook, setNewNotebook] = useState({ title: '', description: '' });
    const [newCategory, setNewCategory] = useState({ name: '', description: '' });

    // Nach dem Laden der Komponente hole ich mir die Daten vom Server.
    useEffect(() => {
        const fetchData = async () => {
            try {
                // Hier frage ich die Notizbücher und Kategorien ab.
                const notebooksResponse = await getNotebooks();
                setNotebooks(notebooksResponse.data);
                const categoriesResponse = await getCategories();
                setCategories(categoriesResponse.data);
            } catch (error) {
                console.error("Huch, ein Fehler beim Laden der Daten", error);
            }
        };

        fetchData();
    }, []);

    // So erstelle ich ein neues Notizbuch.
    const handleCreateNotebook = async (e) => {
        e.preventDefault();
        try {
            const response = await createNotebook(newNotebook);
            setNotebooks([...notebooks, response.data]);
        } catch (error) {
            console.error("Oh nein, das Notizbuch konnte nicht erstellt werden", error);
        }
    };

    // Und so erstelle ich eine neue Kategorie.
    const handleCreateCategory = async (e) => {
        e.preventDefault();
        try {
            const response = await createCategory(newCategory);
            setCategories([...categories, response.data]);
        } catch (error) {
            console.error("Hoppla, da gab es ein Problem bei der Kategorieerstellung", error);
        }
    };

    // Hier kommt das eigentliche Rendering.
    return (
        <div>
            <h1>Notizbuch- und Kategorienverwaltung</h1>
    
            {/* Das Formular für neue Notizbücher */}
            <form onSubmit={handleCreateNotebook}>
                {/* Titel und Beschreibung, einfach und effektiv */}
                <input 
                    type="text" 
                    value={newNotebook.title} 
                    onChange={(e) => setNewNotebook({ ...newNotebook, title: e.target.value })} 
                    placeholder="Titel des Notizbuchs" 
                />
                <textarea 
                    value={newNotebook.description} 
                    onChange={(e) => setNewNotebook({ ...newNotebook, description: e.target.value })} 
                    placeholder="Beschreibung des Notizbuchs" 
                />
                <button type="submit">Notizbuch erstellen</button>
            </form>
    
            {/* Und dasselbe für Kategorien */}
            <form onSubmit={handleCreateCategory}>
                <input 
                    type="text" 
                    value={newCategory.name} 
                    onChange={(e) => setNewCategory({ ...newCategory, name: e.target.value })} 
                    placeholder="Name der Kategorie" 
                />
                <textarea 
                    value={newCategory.description} 
                    onChange={(e) => setNewCategory({ ...newCategory, description: e.target.value })} 
                    placeholder="Beschreibung der Kategorie" 
                />
                <button type="submit">Kategorie erstellen</button>
            </form>
    
            {/* Hier werden die Notizbücher aufgelistet */}
            <div>
                <h2>Notizbücher</h2>
                <ul>
                    {notebooks.map(notebook => (
                        <li key={notebook.id}>
                            {notebook.title} - {notebook.description}
                            {/* Hier könnte ich noch Bearbeiten/Löschen hinzufügen */}
                        </li>
                    ))}
                </ul>
            </div>
    
            {/* Und die Kategorien */}
            <div>
                <h2>Kategorien</h2>
                <ul>
                    {categories.map(category => (
                        <li key={category.id}>
                            {category.name} - {category.description}
                        </li>
                    ))}
                </ul>
            </div>
        </div>
    );
};

export default NotebookCategory;