import api from "./api";

const ENDPOINT = "/colaborador";

export const getAllColaboradores = (
    pageNo = 0,
    pageSize = 10
) =>
    api.get(ENDPOINT, {
        params: {
            pageNo,
            pageSize
        }
    });

export const getColaboradorById = (id) =>
    api.get(`${ENDPOINT}/${id}`);

export const createColaborador = (data) =>
    api.post(ENDPOINT, data);

export const updateColaborador = (id, data) =>
    api.put(`${ENDPOINT}/${id}`, data);

export const deleteColaborador = (id) =>
    api.delete(`${ENDPOINT}/${id}`);