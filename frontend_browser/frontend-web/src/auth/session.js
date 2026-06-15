const KEY = "goodstay_session";

export const setSession = (data) => {
    localStorage.setItem(KEY, JSON.stringify(data));
};

export const getSession = () => {
    return JSON.parse(localStorage.getItem(KEY));
};

export const clearSession = () => {
    localStorage.removeItem(KEY);
};

export const isAuthenticated = () => {
    return !!getSession()?.token;
};