import api from "./api";

const ENDPOINT = "/produtos";

export const getAllProdutos = (
	pageNo = 0,
	pageSize = 10
) =>
	api.get(ENDPOINT, {
		params: {
			pageNo,
			pageSize
		}
	});

export const getProdutoById = (id) =>
	api.get(`${ENDPOINT}/${id}`);

export const createProduto = (data) =>
	api.post(ENDPOINT, data);

export const updateProduto = (id, data) =>
	api.put(`${ENDPOINT}/${id}`, data);

export const deleteProduto = (id) =>
	api.delete(`${ENDPOINT}/${id}`);

