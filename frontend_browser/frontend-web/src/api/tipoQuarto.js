import api from "./api";

const ENDPOINT = "/tipoquarto";

export const getAllTipoQuartos = (
	pageNo = 0,
	pageSize = 10
) =>
	api.get(ENDPOINT, {
		params: {
			pageNo,
			pageSize
		}
	});

export const getTipoQuartoById = (id) =>
	api.get(`${ENDPOINT}/${id}`);

export const createTipoQuarto = (data) =>
	api.post(ENDPOINT, data);

export const updateTipoQuarto = (id, data) =>
	api.put(`${ENDPOINT}/${id}`, data);

export const deleteTipoQuarto = (id) =>
	api.delete(`${ENDPOINT}/${id}`);

