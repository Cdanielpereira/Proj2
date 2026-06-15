import api from "./api";

const ENDPOINT = "/estado-marcacao";

export const getAllEstadoMarcacoes = (
	pageNo = 0,
	pageSize = 10
) =>
	api.get(ENDPOINT, {
		params: {
			pageNo,
			pageSize
		}
	});

export const getEstadoMarcacaoById = (id) =>
	api.get(`${ENDPOINT}/${id}`);

export const createEstadoMarcacao = (data) =>
	api.post(ENDPOINT, data);

export const updateEstadoMarcacao = (id, data) =>
	api.put(`${ENDPOINT}/${id}`, data);

export const deleteEstadoMarcacao = (id) =>
	api.delete(`${ENDPOINT}/${id}`);

