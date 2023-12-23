import API from './api';

export const createCategory = (categoryData) => API.post('/categories/new', categoryData);
export const deleteCategory = (categoryId) => API.delete(`/categories/${categoryId}`);