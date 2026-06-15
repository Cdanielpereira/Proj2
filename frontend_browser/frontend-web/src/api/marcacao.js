import api from "./api";

const ENDPOINT = "/marcacoes";

export const getAllMarcacoes = (
	pageNo = 0,
	pageSize = 10
) =>
	api.get(ENDPOINT, {
		params: {
			pageNo,
			pageSize
		}
	});

export const getMarcacaoById = (id) =>
	api.get(`${ENDPOINT}/${id}`);

export const createMarcacao = (data) =>
	api.post(ENDPOINT, data);

export const updateMarcacao = (id, data) =>
	api.put(`${ENDPOINT}/${id}`, data);

export const deleteMarcacao = (id) =>
	api.delete(`${ENDPOINT}/${id}`);

