import { getUser } from "./session.js";
import { appConfig } from "../config/appConfig";

export function getRole() {

    const user = getUser();

    if (!user)
        return "GUEST";

    return user.role || "GUEST";
}

export function getRoleConfig() {

    const role = getRole();

    return appConfig[role] || appConfig.GUEST;
}

export function canAccess(route) {

    const config = getRoleConfig();

    if (!config)
        return false;

    if (config.allowedRoutes?.includes("*"))
        return true;

    return config.allowedRoutes?.includes(route);
}