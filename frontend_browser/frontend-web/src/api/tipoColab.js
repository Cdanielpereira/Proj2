import api from "./api";

const ENDPOINT = "/tipocolab";

export const getAllTipoColabs = (
	pageNo = 0,
	pageSize = 10
) =>
	api.get(ENDPOINT, {
		params: {
			pageNo,
			pageSize
		}
	});

export const getTipoColabById = (id) =>
	api.get(`${ENDPOINT}/${id}`);

export const createTipoColab = (data) =>
	api.post(ENDPOINT, data);

export const updateTipoColab = (id, data) =>
	api.put(`${ENDPOINT}/${id}`, data);

export const deleteTipoColab = (id) =>
	api.delete(`${ENDPOINT}/${id}`);

