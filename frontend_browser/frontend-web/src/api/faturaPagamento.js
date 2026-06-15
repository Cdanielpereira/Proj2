import api from "./api";

const ENDPOINT = "/fatura-pagamento";

export const getAllFaturaPagamentos = (
	pageNo = 0,
	pageSize = 10
) =>
	api.get(ENDPOINT, {
		params: {
			pageNo,
			pageSize
		}
	});

export const getFaturaPagamentoById = (id) =>
	api.get(`${ENDPOINT}/${id}`);

export const createFaturaPagamento = (data) =>
	api.post(ENDPOINT, data);

export const updateFaturaPagamento = (id, data) =>
	api.put(`${ENDPOINT}/${id}`, data);

export const deleteFaturaPagamento = (id) =>
	api.delete(`${ENDPOINT}/${id}`);

