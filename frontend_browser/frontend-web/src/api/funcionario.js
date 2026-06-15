import api from "./api";

const ENDPOINT = "/funcionario";

export const getAllFuncionarios = (
	pageNo = 0,
	pageSize = 10
) =>
	api.get(ENDPOINT, {
		params: {
			pageNo,
			pageSize
		}
	});

export const getFuncionarioById = (id) =>
	api.get(`${ENDPOINT}/${id}`);

export const createFuncionario = (data) =>
	api.post(ENDPOINT, data);

export const updateFuncionario = (id, data) =>
	api.put(`${ENDPOINT}/${id}`, data);

export const deleteFuncionario = (id) =>
	api.delete(`${ENDPOINT}/${id}`);

