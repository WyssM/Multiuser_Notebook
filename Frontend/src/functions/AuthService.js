// AuthService.js - Mein Schlüssel zur Authentifizierung von Benutzern

// Import des API-Moduls für HTTP-Anfragen
import API from './api';

// signUp-Funktion, um neue Benutzer zu registrieren
export const signUp = (authData) => {
    // Sendet eine POST-Anfrage an den '/api/auth/signup' Endpunkt mit den Authentifizierungsdaten
    return API.post('/api/auth/signup', authData);
};

// signIn-Funktion, um Benutzer anzumelden
export const signIn = (authData) => {
    // Sendet eine POST-Anfrage an den '/api/auth/signin' Endpunkt mit den Authentifizierungsdaten
    return API.post('/api/auth/signin', authData);
};
// Export der Funktionen für die Verwendung in anderen Teilen der Anwendung
export default {
    signUp,
    signIn
};