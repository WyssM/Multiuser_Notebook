import React, { useState, useEffect } from 'react';
import { deleteUser, getUsers } from './functions/UserService';

const AdminDashboard = () => {
    const [users, setUsers] = useState([]);

    useEffect(() => {
        const fetchUsers = async () => {
            try {
                const response = await getUsers();
                setUsers(response.data);
            } catch (error) {
                console.error("Fehler beim Laden der Benutzer", error);
            }
        };

        fetchUsers();
    }, []);

    const handleDeleteUser = async (userId) => {
        try {
            await deleteUser(userId);
            setUsers(users.filter(user => user.id !== userId)); 
        } catch (error) {
            console.error("Fehler beim Löschen des Benutzers", error);
        }
    };

    return (
        <div>
            <h1>Admin-Dashboard</h1>
            <h2>Benutzerverwaltung</h2>
            <ul>
                {users.map(user => (
                    <li key={user.id}>
                        {user.username} - {user.role}
                        <button onClick={() => handleDeleteUser(user.id)}>Löschen</button>
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default AdminDashboard;