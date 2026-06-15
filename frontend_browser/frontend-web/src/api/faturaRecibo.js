import api from "./api";

const ENDPOINT = "/fatura-recibo";

export const getAllFaturaRecibos = (
	pageNo = 0,
	pageSize = 10
) =>
	api.get(ENDPOINT, {
		params: {
			pageNo,
			pageSize
		}
	});

export const getFaturaReciboById = (id) =>
	api.get(`${ENDPOINT}/${id}`);

export const createFaturaRecibo = (data) =>
	api.post(ENDPOINT, data);

export const updateFaturaRecibo = (id, data) =>
	api.put(`${ENDPOINT}/${id}`, data);

export const deleteFaturaRecibo = (id) =>
	api.delete(`${ENDPOINT}/${id}`);

