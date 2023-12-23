import * as React from "react";
import * as ReactDOM from "react-dom/client";
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
// Importieren aller Seiten, die in der App verwendet werden
import AdminDashboard from './pages/AdminDashboard.jsx';
import UserDashboard from './pages/UserDashboard.jsx';
import NotebookCategory from './pages/NotebookCategory.jsx';
import Note from './pages/Note.jsx';
import Login from './pages/login.jsx';
import Signup from './pages/Signup.jsx';

// Hauptkomponente der App
const Main = () => {
    // Hier benutze ich den Router für die Navigation in meiner App
    return (
        <Router>
            
            <Routes>{/* Innerhalb des Routers definiere ich die einzelnen Routen */}
                {/* Jede Route verbindet einen Pfad mit einer Komponente */}
                <Route path="/" element={<Login />} />  // Startseite führt zur Login-Komponente
                <Route path="/signup" element={<Signup />} />  // Anmelde-Seite
                <Route path="/admin" element={<AdminDashboard />} />  // Dashboard für Admins
                <Route path="/user" element={<UserDashboard />} />  // Dashboard für normale Benutzer
                <Route path="/notebook-category" element={<NotebookCategory />} />  // Seite für Notizbücher und Kategorien
                <Route path="/note" element={<Note />} />  // Seite für individuelle Notizen
            </Routes>
        </Router>
    );
};

// Hier rendere ich die Hauptkomponente meiner App im DOM
ReactDOM.createRoot(document.getElementById("root")).render(
  <React.StrictMode>
    <Main />
  </React.StrictMode>
);
