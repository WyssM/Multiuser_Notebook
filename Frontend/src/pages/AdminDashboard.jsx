import React, { useState, useEffect } from 'react';
import { deleteUser} from '../functions/USerService';

const AdminDashboard = () => {
    const [users, setUsers,] = useState([]);

    useEffect(() => {
        // Diese Funktion lädt alle Benutzer beim Start der Komponente.
        const fetchUsers = async () => {
            try {
                const response = await getUsers();
                setUsers(response.data); // Setzt den Benutzerzustand auf die geladenen Daten.
            } catch (error) {
                console.error("Fehler beim Laden der Benutzer", error); // Fehlerbehandlung.
            }
        };

        fetchUsers();
    }, []); 

    // Diese Funktion löscht einen Benutzer und aktualisiert den Zustand.
    const handleDeleteUser = async (userId) => {
        try {
            await deleteUser(userId);
            setUsers(users.filter(user => user.id !== userId)); // Entfernt den gelöschten Benutzer aus dem Zustand.
        } catch (error) {
            console.error("Fehler beim Löschen des Benutzers", error); // Fehlerbehandlung.
        }
    };

    return (<>
        <div>
            <h1>Admin-Dashboard</h1>
            <h2>Benutzerverwaltung</h2>
            <ul>
                {/* Hier werden alle Benutzer aufgelistet. */}
                {users.map(user => (
                    <li key={user.id}>
                        {user.username} - {user.role}
                        <button onClick={() => handleDeleteUser(user.id)}>Löschen</button> {/* Löschen-Button für jeden Benutzer. */}
                    </li>
                ))}
            </ul>
        </div>
        </>
    );
                };
export default AdminDashboard;