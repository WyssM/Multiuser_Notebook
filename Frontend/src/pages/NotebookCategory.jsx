import React, { useState, useEffect } from 'react';
import { createNotebook, createCategory } from './functions/NotebookCategoryService';

const NotebookCategory = () => {
    const [notebooks, setNotebooks] = useState([]);
    const [categories, setCategories] = useState([]);
    const [newNotebook, setNewNotebook] = useState({ title: '', description: '' });
    const [newCategory, setNewCategory] = useState({ name: '', description: '' });

    useEffect(() => {
        // Laden der Notizbücher und Kategorien vom Server
        const fetchData = async () => {
            try {
                const notebooksResponse = await getNotebooks();
                setNotebooks(notebooksResponse.data);

                const categoriesResponse = await getCategories();
                setCategories(categoriesResponse.data);
            } catch (error) {
                console.error("Fehler beim Laden von Daten", error);
            }
        };

        fetchData();
    }, []);

    const handleCreateNotebook = async (e) => {
        e.preventDefault();
        try {
            const response = await createNotebook(newNotebook);
            setNotebooks([...notebooks, response.data]);
        } catch (error) {
            console.error("Fehler beim Erstellen des Notizbuchs", error);
        }
    };

    const handleCreateCategory = async (e) => {
        e.preventDefault();
        try {
            const response = await createCategory(newCategory);
            setCategories([...categories, response.data]);
        } catch (error) {
            console.error("Fehler beim Erstellen der Kategorie", error);
        }
    };

    return (
        <div>
            <h1>Notizbuch- und Kategorienverwaltung</h1>
    
            {/* Formular zum Erstellen eines Notizbuchs */}
            <form onSubmit={handleCreateNotebook}>
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
    
            {/* Formular zum Erstellen einer Kategorie */}
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
    
            {/* Liste der Notizbücher */}
            <div>
                <h2>Notizbücher</h2>
                <ul>
                    {notebooks.map(notebook => (
                        <li key={notebook.id}>
                            {notebook.title} - {notebook.description}
                            {/* Weitere Aktionen für Notizbücher hier einfügen, z.B. Bearbeiten/Löschen */}
                        </li>
                    ))}
                </ul>
            </div>
    
            {/* Liste der Kategorien */}
            <div>
                <h2>Kategorien</h2>
                <ul>
                    {categories.map(category => (
                        <li key={category.id}>
                            {category.name} - {category.description}
                            {/* Weitere Aktionen für Kategorien hier einfügen, z.B. Bearbeiten/Löschen */}
                        </li>
                    ))}
                </ul>
            </div>
        </div>
    );
                    }

export default NotebookCategory;