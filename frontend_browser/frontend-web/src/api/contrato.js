import api from "./api";

const ENDPOINT = "/contrato";

export const getAllContratos = (
	pageNo = 0,
	pageSize = 10
) =>
	api.get(ENDPOINT, {
		params: {
			pageNo,
			pageSize
		}
	});

export const getContratoById = (id) =>
	api.get(`${ENDPOINT}/${id}`);

export const createContrato = (data) =>
	api.post(ENDPOINT, data);

export const updateContrato = (id, data) =>
	api.put(`${ENDPOINT}/${id}`, data);

export const deleteContrato = (id) =>
	api.delete(`${ENDPOINT}/${id}`);

