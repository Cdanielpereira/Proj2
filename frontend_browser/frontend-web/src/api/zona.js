import api from "./api";

const ENDPOINT = "/zonas";

export const getAllZonas = (
	pageNo = 0,
	pageSize = 10
) =>
	api.get(ENDPOINT, {
		params: {
			pageNo,
			pageSize
		}
	});

export const getZonaById = (id) =>
	api.get(`${ENDPOINT}/${id}`);

export const createZona = (data) =>
	api.post(ENDPOINT, data);

export const updateZona = (id, data) =>
	api.put(`${ENDPOINT}/${id}`, data);

export const deleteZona = (id) =>
	api.delete(`${ENDPOINT}/${id}`);

