import api from "./api";

const ENDPOINT = "/servicos";

export const getAllServicos = (
	pageNo = 0,
	pageSize = 10
) =>
	api.get(ENDPOINT, {
		params: {
			pageNo,
			pageSize
		}
	});

export const getServicoById = (id) =>
	api.get(`${ENDPOINT}/${id}`);

export const createServico = (data) =>
	api.post(ENDPOINT, data);

export const updateServico = (id, data) =>
	api.put(`${ENDPOINT}/${id}`, data);

export const deleteServico = (id) =>
	api.delete(`${ENDPOINT}/${id}`);

