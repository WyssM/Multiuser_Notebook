import API from './api';

export const signUp = (authData) => API.post('/api/auth/signup', authData);
export const signIn = (authData) => API.post('/api/auth/signin', authData);