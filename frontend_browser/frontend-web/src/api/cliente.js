import api from "./api";

const ENDPOINT = "/cliente";

export const getAllClientes = (
	pageNo = 0,
	pageSize = 10
) =>
	api.get(ENDPOINT, {
		params: {
			pageNo,
			pageSize
		}
	});

export const getClienteById = (id) =>
	api.get(`${ENDPOINT}/${id}`);

export const createCliente = (data) =>
	api.post(ENDPOINT, data);

export const updateCliente = (id, data) =>
	api.put(`${ENDPOINT}/${id}`, data);

export const deleteCliente = (id) =>
	api.delete(`${ENDPOINT}/${id}`);

