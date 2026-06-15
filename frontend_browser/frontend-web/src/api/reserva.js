import api from "./api";

const ENDPOINT = "/reservas";

export const getAllReservas = (
	pageNo = 0,
	pageSize = 10
) =>
	api.get(ENDPOINT, {
		params: {
			pageNo,
			pageSize
		}
	});

export const getReservaById = (...ids) => api.get(`${ENDPOINT}/${ids.join('/')}`);
export const createReserva = (data) => api.post(ENDPOINT, data);
export const updateReserva = (...args) => { const data = args[0]; const ids = args.slice(1); return api.put(`${ENDPOINT}/${ids.join('/')}`, data); };
export const deleteReserva = (...ids) => api.delete(`${ENDPOINT}/${ids.join('/')}`);

