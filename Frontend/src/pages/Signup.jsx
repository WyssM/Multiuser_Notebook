import React, { useState } from 'react';
import { signUp } from './functions/AuthService';

const Signup = () => {
    const [userData, setUserData] = useState({ username: '', email: '', password: '' });

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            const response = await signUp(userData);
            console.log(response.data);
            // Weiterleitung oder Statusaktualisierung hier
        } catch (error) {
            console.error("Fehler bei der Registrierung", error);
        }
    };

    return (
        <form onSubmit={handleSubmit}>
            <input
                type="text"
                value={userData.username}
                onChange={(e) => setUserData({ ...userData, username: e.target.value })}
                placeholder="Benutzername"
            />
            <input
                type="email"
                value={userData.email}
                onChange={(e) => setUserData({ ...userData, email: e.target.value })}
                placeholder="E-Mail"
            />
            <input
                type="password"
                value={userData.password}
                onChange={(e) => setUserData({ ...userData, password: e.target.value })}
                placeholder="Passwort"
            />
            <button type="submit">Registrieren</button>
        </form>
    );
};

export default Signup;