import api from "./api";

const ENDPOINT = "/quartos";

export const getAllQuartos = (
	pageNo = 0,
	pageSize = 10
) =>
	api.get(ENDPOINT, {
		params: {
			pageNo,
			pageSize
		}
	});

export const getQuartoById = (id) =>
	api.get(`${ENDPOINT}/${id}`);

export const createQuarto = (data) =>
	api.post(ENDPOINT, data);

export const updateQuarto = (id, data) =>
	api.put(`${ENDPOINT}/${id}`, data);

export const deleteQuarto = (id) =>
	api.delete(`${ENDPOINT}/${id}`);

