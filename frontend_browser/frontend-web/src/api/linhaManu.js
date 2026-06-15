import api from "./api";

const ENDPOINT = "/linhamanu";

export const getAllLinhaManus = (
	pageNo = 0,
	pageSize = 10
) =>
	api.get(ENDPOINT, {
		params: {
			pageNo,
			pageSize
		}
	});

export const getLinhaManuById = (...ids) => api.get(`${ENDPOINT}/${ids.join('/')}`);
export const createLinhaManu = (data) => api.post(ENDPOINT, data);
export const updateLinhaManu = (...args) => { const data = args[0]; const ids = args.slice(1); return api.put(`${ENDPOINT}/${ids.join('/')}`, data); };
export const deleteLinhaManu = (...ids) => api.delete(`${ENDPOINT}/${ids.join('/')}`);

