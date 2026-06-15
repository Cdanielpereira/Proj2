import api from "./api";

const ENDPOINT = "/estado-contract";

export const getAllEstadoContracts = (
	pageNo = 0,
	pageSize = 10
) =>
	api.get(ENDPOINT, {
		params: {
			pageNo,
			pageSize
		}
	});

export const getEstadoContractById = (id) =>
	api.get(`${ENDPOINT}/${id}`);

export const createEstadoContract = (data) =>
	api.post(ENDPOINT, data);

export const updateEstadoContract = (id, data) =>
	api.put(`${ENDPOINT}/${id}`, data);

export const deleteEstadoContract = (id) =>
	api.delete(`${ENDPOINT}/${id}`);

