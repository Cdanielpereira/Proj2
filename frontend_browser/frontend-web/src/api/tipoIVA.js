import api from "./api";

const ENDPOINT = "/tipoiva";

export const getAllTipoIVAs = (
	pageNo = 0,
	pageSize = 10
) =>
	api.get(ENDPOINT, {
		params: {
			pageNo,
			pageSize
		}
	});

export const getTipoIVAById = (id) =>
	api.get(`${ENDPOINT}/${id}`);

export const createTipoIVA = (data) =>
	api.post(ENDPOINT, data);

export const updateTipoIVA = (id, data) =>
	api.put(`${ENDPOINT}/${id}`, data);

export const deleteTipoIVA = (id) =>
	api.delete(`${ENDPOINT}/${id}`);

