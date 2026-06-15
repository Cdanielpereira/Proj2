import api from "./api";

const ENDPOINT = "/estado-servico";

export const getAllEstadoServicos = (
	pageNo = 0,
	pageSize = 10
) =>
	api.get(ENDPOINT, {
		params: {
			pageNo,
			pageSize
		}
	});

export const getEstadoServicoById = (id) =>
	api.get(`${ENDPOINT}/${id}`);

export const createEstadoServico = (data) =>
	api.post(ENDPOINT, data);

export const updateEstadoServico = (id, data) =>
	api.put(`${ENDPOINT}/${id}`, data);

export const deleteEstadoServico = (id) =>
	api.delete(`${ENDPOINT}/${id}`);

