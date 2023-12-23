import API from './api';

export const createNote = (noteData) => API.post('/notes/new', noteData);
export const deleteNote = (noteId) => API.delete(`/notes/${noteId}`);