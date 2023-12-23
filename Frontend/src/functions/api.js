import axios from 'axios';

const API = axios.create({
    baseURL: 'http://localhost:8080'
});

// Authentifizierung
export const signUp = (userData) => API.post('/api/auth/signup', userData);
export const signIn = (userData) => API.post('/api/auth/signin', userData);

// Benutzer
export const createUser = (userData) => API.post('/user/new', userData);
export const updateUserPermissions = (userId, permissions) => API.put(`/user/${userId}/permissions`, permissions);
export const deleteUser = (userId) => API.delete(`/user/${userId}`);

// Notizbuch
export const createNotebook = (notebookData) => API.post('/notebook/new', notebookData);
export const deleteNotebook = (notebookId) => API.delete(`/notebook/${notebookId}`);

// Notizen
export const createNote = (noteData) => API.post('/notes/new', noteData);
export const deleteNote = (noteId) => API.delete(`/notes/${noteId}`);

// Kategorien
export const createCategory = (categoryData) => API.post('/categories/new', categoryData);
export const deleteCategory = (categoryId) => API.delete(`/categories/${categoryId}`);

export default API;