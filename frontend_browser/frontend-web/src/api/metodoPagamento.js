import api from "./api";

const ENDPOINT = "/metodos-pagamento";

export const getAllMetodosPagamento = (
	pageNo = 0,
	pageSize = 10
) =>
	api.get(ENDPOINT, {
		params: {
			pageNo,
			pageSize
		}
	});

export const getMetodoPagamentoById = (id) =>
	api.get(`${ENDPOINT}/${id}`);

export const createMetodoPagamento = (data) =>
	api.post(ENDPOINT, data);

export const updateMetodoPagamento = (id, data) =>
	api.put(`${ENDPOINT}/${id}`, data);

export const deleteMetodoPagamento = (id) =>
	api.delete(`${ENDPOINT}/${id}`);

