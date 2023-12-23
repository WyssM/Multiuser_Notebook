import API from './api';

export const createNotebook = (notebookData) => API.post('/notebook/new', notebookData);
export const deleteNotebook = (notebookId) => API.delete(`/notebook/${notebookId}`);