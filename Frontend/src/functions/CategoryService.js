// CategoryService.js - Mein Werkzeug für die Verwaltung von Kategorien in der App

// Import des API-Moduls für HTTP-Anfragen
import API from './api';

// createCategory-Funktion, um eine neue Kategorie zu erstellen
export const createCategory = (categoryData) => {
    // Sendet eine POST-Anfrage an den '/categories/new' Endpunkt mit den Kategoriedaten
    return API.post('/categories/new', categoryData);
};

// deleteCategory-Funktion, um eine Kategorie zu löschen
export const deleteCategory = (categoryId) => {
    // Sendet eine DELETE-Anfrage an den '/categories/{categoryId}' Endpunkt, um die spezifizierte Kategorie zu löschen
    return API.delete(`/categories/${categoryId}`);
};

// Export der Funktionen für die Verwendung in anderen Teilen der Anwendung
export default {
    createCategory,
    deleteCategory
};