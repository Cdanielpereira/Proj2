import api from "./api";

const ENDPOINT = "/vencimentos";

export const getAllVencimentos = (
	pageNo = 0,
	pageSize = 10
) =>
	api.get(ENDPOINT, {
		params: {
			pageNo,
			pageSize
		}
	});

export const getVencimentoById = (id) =>
	api.get(`${ENDPOINT}/${id}`);

export const createVencimento = (data) =>
	api.post(ENDPOINT, data);

export const updateVencimento = (id, data) =>
	api.put(`${ENDPOINT}/${id}`, data);

export const deleteVencimento = (id) =>
	api.delete(`${ENDPOINT}/${id}`);

