import { useEffect } from "react";
import { useLocation } from "react-router-dom";
import { appConfig } from "../config/appConfig";

function pluralize(word) {
    if (!word) return "";
    return word.endsWith("s") ? word : `${word}s`;
}

export default function usePageTitle(setTitle) {
    const location = useLocation();

    useEffect(() => {
        const user = JSON.parse(localStorage.getItem("user"));
        const role = user?.role || "GUEST";

        const parts = location.pathname.split("/").filter(Boolean);
        const path = location.pathname.toLowerCase();

        const isHomeScreen =
            path === "/home" ||
            path === "/homecliente" ||
            path === "/homeuser";

        let title = "GoodStay";

        if (isHomeScreen) {
            const homeTitle =
                typeof appConfig[role]?.homeTitle === "function"
                    ? appConfig[role].homeTitle(user)
                    : appConfig[role]?.homeTitle;

            title = homeTitle || "GoodStay";
        } else {
            const base = parts[0];
            const mode = parts[1];

            if (base) {
                if (mode === "create") title = `Criar ${base}`;
                else if (mode === "edit") title = `Editar ${base}`;
                else title = `Lista de ${pluralize(base)}`;
            }
        }

        setTitle?.(title);
    }, [location.pathname, setTitle]);
}