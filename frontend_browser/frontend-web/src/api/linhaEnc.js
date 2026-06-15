import api from "./api";

const ENDPOINT = "/linhaenc";

export const getAllLinhaEncs = (
	pageNo = 0,
	pageSize = 10
) =>
	api.get(ENDPOINT, {
		params: {
			pageNo,
			pageSize
		}
	});

export const getLinhaEncById = (...ids) => api.get(`${ENDPOINT}/${ids.join('/')}`);
export const createLinhaEnc = (data) => api.post(ENDPOINT, data);
export const updateLinhaEnc = (...args) => { const data = args[0]; const ids = args.slice(1); return api.put(`${ENDPOINT}/${ids.join('/')}`, data); };
export const deleteLinhaEnc = (...ids) => api.delete(`${ENDPOINT}/${ids.join('/')}`);

