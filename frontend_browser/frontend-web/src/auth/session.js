export const isAuthenticated = () => {
    const token = localStorage.getItem("token");
    return token !== null && token !== "undefined";
};

export const getUser = () => {
    const user = localStorage.getItem("user");
    return user ? JSON.parse(user) : null;
};

export const loginSession = (token, user) => {
    if (!token) {
        console.error("TOKEN UNDEFINED - LOGIN FAILED");
        return;
    }

    // 🔥 NORMALIZAÇÃO (FIX CRÍTICO)
    const normalizedUser = {
        userId: user?.userId ?? user?.id ?? null,
        username: user?.username ?? "",
        role: (user?.role ?? "GUEST").toUpperCase()
    };

    localStorage.setItem("token", token);
    localStorage.setItem("user", JSON.stringify(normalizedUser));
};

export const logoutSession = () => {
    localStorage.clear();
    window.location.href = "/login";
};

export const getAuthState = () => {
    const token = localStorage.getItem("token");
    const user = localStorage.getItem("user");

    const parsed = user ? JSON.parse(user) : null;

    return {
        isAuth: token !== null && token !== "undefined" && parsed !== null,
        user: parsed
    };
};