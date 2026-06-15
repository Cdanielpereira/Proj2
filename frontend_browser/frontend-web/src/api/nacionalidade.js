import api from "./api";

const ENDPOINT = "/nacionalidades";

export const getAllNacionalidades = (
	pageNo = 0,
	pageSize = 10
) =>
	api.get(ENDPOINT, {
		params: {
			pageNo,
			pageSize
		}
	});

export const getNacionalidadeById = (id) =>
	api.get(`${ENDPOINT}/${id}`);

export const createNacionalidade = (data) =>
	api.post(ENDPOINT, data);

export const updateNacionalidade = (id, data) =>
	api.put(`${ENDPOINT}/${id}`, data);

export const deleteNacionalidade = (id) =>
	api.delete(`${ENDPOINT}/${id}`);

