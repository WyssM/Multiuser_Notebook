// UserService.js - Verwaltet Benutzeraktionen in meiner App

// Import des API-Moduls, das auf axios basiert und für die Kommunikation mit dem Backend eingerichtet ist
import API from './api';

// createUser-Funktion, um einen neuen Benutzer zu erstellen
export const createUser = (userData) => {
    // Sendet eine POST-Anfrage an den '/user/new' Endpunkt mit den Benutzerdaten
    return API.post('/user/new', userData);
};

// deleteUser-Funktion, um einen Benutzer zu löschen
export const deleteUser = (userId) => {
    // Sendet eine DELETE-Anfrage an den '/user/{userId}' Endpunkt, um den spezifizierten Benutzer zu löschen
    return API.delete(`/user/${userId}`);
};

// updateUserPermissions-Funktion, um die Berechtigungen eines Benutzers zu aktualisieren
export const updateUserPermissions = (userId, permissions) => {
    // Sendet eine PUT-Anfrage an den '/user/{userId}/permissions' Endpunkt, um die Berechtigungen des Benutzers zu aktualisieren
    return API.put(`/user/${userId}/permissions`, permissions);
};


// Export der Funktionen für die Verwendung in anderen Teilen der Anwendung
export default {
    createUser,
    deleteUser,
    updateUserPermissions
};