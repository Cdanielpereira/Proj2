import api from "./api";

const ENDPOINT = "/auth";

export const login = (data) =>
    api.post(`${ENDPOINT}/login`, data);