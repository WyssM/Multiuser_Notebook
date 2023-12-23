import API from './api';

export const createUser = (userData) => API.post('/user/new', userData);
export const deleteUser = (userId) => API.delete(`/user/${userId}`);
export const updateUserPermissions = (userId, permissions) => API.put(`/user/${userId}/permissions`, permissions);