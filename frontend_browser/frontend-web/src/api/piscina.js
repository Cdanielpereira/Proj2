import api from "./api";

const ENDPOINT = "/piscinas";

export const getAllPiscinas = (
	pageNo = 0,
	pageSize = 10
) =>
	api.get(ENDPOINT, {
		params: {
			pageNo,
			pageSize
		}
	});

export const getPiscinaById = (id) =>
	api.get(`${ENDPOINT}/${id}`);

export const createPiscina = (data) =>
	api.post(ENDPOINT, data);

export const updatePiscina = (id, data) =>
	api.put(`${ENDPOINT}/${id}`, data);

export const deletePiscina = (id) =>
	api.delete(`${ENDPOINT}/${id}`);

