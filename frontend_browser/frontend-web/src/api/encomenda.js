import api from "./api";

const ENDPOINT = "/encomenda";

export const getAllEncomendas = (
	pageNo = 0,
	pageSize = 10
) =>
	api.get(ENDPOINT, {
		params: {
			pageNo,
			pageSize
		}
	});

export const getEncomendaById = (id) =>
	api.get(`${ENDPOINT}/${id}`);

export const createEncomenda = (data) =>
	api.post(ENDPOINT, data);

export const updateEncomenda = (id, data) =>
	api.put(`${ENDPOINT}/${id}`, data);

export const deleteEncomenda = (id) =>
	api.delete(`${ENDPOINT}/${id}`);

