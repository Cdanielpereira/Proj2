import { getSession } from "../pages/auth/session.js";
import { appConfig } from "../config/appConfig";

export function getRoleConfig() {
    const session = getSession();
    const role = session?.role || "GUEST";

    return appConfig[role];
}

export function canAccess(route) {
    const config = getRoleConfig();

    if (!config) return false;

    if (config.allowedRoutes.includes("*")) return true;

    return config.allowedRoutes.includes(route);
}