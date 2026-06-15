import api from "./api";

const ENDPOINT = "/tipozona";

export const getAllTipoZonas = (
	pageNo = 0,
	pageSize = 10
) =>
	api.get(ENDPOINT, {
		params: {
			pageNo,
			pageSize
		}
	});

export const getTipoZonaById = (id) =>
	api.get(`${ENDPOINT}/${id}`);

export const createTipoZona = (data) =>
	api.post(ENDPOINT, data);

export const updateTipoZona = (id, data) =>
	api.put(`${ENDPOINT}/${id}`, data);

export const deleteTipoZona = (id) =>
	api.delete(`${ENDPOINT}/${id}`);

