import React, { useState } from 'react';
import { signIn } from './functions/AuthService';

const Login = () => {
    const [userData, setUserData] = useState({ username: '', password: '' });

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            const response = await signIn(userData);
            
        } catch (error) {
            console.error("Fehler beim Anmelden", error);
        }
    };

    return (
        <form onSubmit={handleSubmit}>
            {/* Benutzername und Passwortfelder */}
            <button type="submit">Anmelden</button>
        </form>
    );
};

export default Login;
