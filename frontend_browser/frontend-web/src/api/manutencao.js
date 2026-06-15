import api from "./api";

const ENDPOINT = "/manutencoes";

export const getAllManutencoes = (
	pageNo = 0,
	pageSize = 10
) =>
	api.get(ENDPOINT, {
		params: {
			pageNo,
			pageSize
		}
	});

export const getManutencaoById = (id) =>
	api.get(`${ENDPOINT}/${id}`);

export const createManutencao = (data) =>
	api.post(ENDPOINT, data);

export const updateManutencao = (id, data) =>
	api.put(`${ENDPOINT}/${id}`, data);

export const deleteManutencao = (id) =>
	api.delete(`${ENDPOINT}/${id}`);

