import api from "./api";

const ENDPOINT = "/users";

export const getAllUsers = (pageNo = 0, pageSize = 10) =>
	api.get(ENDPOINT, {
		params: { pageNo, pageSize }
	});

export const getUserById = (id) =>
	api.get(`${ENDPOINT}/${id}`);

export const createUser = (data) =>
	api.post(ENDPOINT, data);

export const updateUser = (id, data) =>
	api.put(`${ENDPOINT}/${id}`, data);

export const deleteUser = (id) =>
	api.delete(`${ENDPOINT}/${id}`);