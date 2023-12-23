import React, { useState } from 'react';
import { signUp } from '../functions/AuthService';

// Hier startet der Spaß, ich baue eine Anmeldeseite!
const Signup = () => {
    // Ich speichere hier die Benutzerdaten. Anfangs ist alles leer.
    const [userData, setUserData] = useState({ username: '', email: '', password: '' });

    // Wenn der Benutzer auf "Registrieren" klickt, passiert Folgendes.
    const handleSubmit = async (e) => {
        e.preventDefault(); // Kein Reload, bitte!
        try {
            const response = await signUp(userData); // Schicke die Daten ab und warte auf Antwort.
            console.log(response.data); // Mal schauen, was zurückkommt.
            // Hier könnte ich die Benutzer zu einer anderen Seite weiterleiten.
        } catch (error) {
            console.error("Ups, etwas lief schief bei der Registrierung", error); // Fehler melden ist wichtig.
        }
    };

    // Hier gestalte ich das Formular.
    return (
        <form onSubmit={handleSubmit}>
            <input
                type="text"
                value={userData.username}
                onChange={(e) => setUserData({ ...userData, username: e.target.value })}
                placeholder="Benutzername"
            />
            {/* E-Mail muss auch rein. */}
            <input
                type="email"
                value={userData.email}
                onChange={(e) => setUserData({ ...userData, email: e.target.value })}
                placeholder="E-Mail"
            />
            {/* Das Passwort, natürlich. */}
            <input
                type="password"
                value={userData.password}
                onChange={(e) => setUserData({ ...userData, password: e.target.value })}
                placeholder="Passwort"
            />
            {/* Und ab mit der sche...e*/}
            <button type="submit">Registrieren</button>
        </form>
    );
};

export default Signup;