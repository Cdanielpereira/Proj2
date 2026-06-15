import api from "./api";

const ENDPOINT = "/cpostal";

export const getAllCpostal = (
	pageNo = 0,
	pageSize = 10
) =>
	api.get(ENDPOINT, {
		params: {
			pageNo,
			pageSize
		}
	});

export const getCpostalById = (codPostal) =>
	api.get(`${ENDPOINT}/${codPostal}`);

export const createCpostal = (data) =>
	api.post(ENDPOINT, data);

export const updateCpostal = (codPostal, data) =>
	api.put(`${ENDPOINT}/${codPostal}`, data);

export const deleteCpostal = (codPostal) =>
	api.delete(`${ENDPOINT}/${codPostal}`);

