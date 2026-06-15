import api from "./api";

const ENDPOINT = "/limpezas";

export const getAllLimpezas = (
	pageNo = 0,
	pageSize = 10
) =>
	api.get(ENDPOINT, {
		params: {
			pageNo,
			pageSize
		}
	});

export const getLimpezaById = (...ids) => api.get(`${ENDPOINT}/${ids.join('/')}`);
export const createLimpeza = (data) => api.post(ENDPOINT, data);
export const updateLimpeza = (...args) => { const data = args[0]; const ids = args.slice(1); return api.put(`${ENDPOINT}/${ids.join('/')}`, data); };
export const deleteLimpeza = (...ids) => api.delete(`${ENDPOINT}/${ids.join('/')}`);

