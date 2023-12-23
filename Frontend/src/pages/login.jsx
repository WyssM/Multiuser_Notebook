import React, { useState } from 'react';
import { signIn } from '../functions/AuthService';

// Die Login-Komponente - mein digitaler Türsteher
const Login = () => {
    // Ich verwende den useState-Hook, um die Benutzerdaten zu verwalten.
    const [userData, setUserData] = useState({ username: '', password: '' });

    // Diese Funktion kümmert sich um die Anmeldung. Hier wird's ernst!
    const handleSubmit = async (e) => {
        e.preventDefault(); // Keine Standard-Formular-Submit-Aktion, bitte!
        try {
            const response = await signIn(userData); // Ich rufe meine AuthService an, um den Benutzer anzumelden.
            // Hier könnte ich den Benutzer umleiten oder den Anmeldestatus aktualisieren.
        } catch (error) {
            console.error("Oh nein, etwas ist bei der Anmeldung schiefgegangen", error); // Fehlerbehandlung, falls etwas schiefgeht.
        }
    };

    // Das eigentliche Anmeldeformular. Einfach, aber effektiv.
    return (
        <form onSubmit={handleSubmit}>
            {/* Hier gebe ich die Eingabefelder für Benutzername und Passwort ein. */}
            <input
                type="text"
                value={userData.username}
                onChange={(e) => setUserData({ ...userData, username: e.target.value })}
                placeholder="Benutzername"
            />
            <input
                type="password"
                value={userData.password}
                onChange={(e) => setUserData({ ...userData, password: e.target.value })}
                placeholder="Passwort"
            />
            <button type="submit">Anmelden</button> {/* Der magische Knopf, der alles in Gang setzt! */}
        </form>
    );
};

export default Login;