import api from "./api";

const ENDPOINT = "/catering";

export const getAllCaterings = (
    pageNo = 0,
    pageSize = 10
) =>
    api.get(ENDPOINT, {
        params: {
            pageNo,
            pageSize
        }
    });

export const getCateringById = (id) =>
    api.get(`${ENDPOINT}/${id}`);

export const createCatering = (data) =>
    api.post(ENDPOINT, data);

export const updateCatering = (id, data) =>
    api.put(`${ENDPOINT}/${id}`, data);

export const deleteCatering = (id) =>
    api.delete(`${ENDPOINT}/${id}`);

