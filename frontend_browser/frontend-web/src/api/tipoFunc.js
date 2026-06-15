import api from "./api";

const ENDPOINT = "/tipofunc";

export const getAllTipoFuncs = (
	pageNo = 0,
	pageSize = 10
) =>
	api.get(ENDPOINT, {
		params: {
			pageNo,
			pageSize
		}
	});

export const getTipoFuncById = (id) =>
	api.get(`${ENDPOINT}/${id}`);

export const createTipoFunc = (data) =>
	api.post(ENDPOINT, data);

export const updateTipoFunc = (id, data) =>
	api.put(`${ENDPOINT}/${id}`, data);

export const deleteTipoFunc = (id) =>
	api.delete(`${ENDPOINT}/${id}`);

