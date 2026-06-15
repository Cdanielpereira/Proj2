import { useEffect } from "react";
import { useLocation, useParams } from "react-router-dom";
import { entityConfig } from "../config/entityConfig";
import { getSession } from "../pages/auth/session";

export default function usePageTitle(mode) {

    const location = useLocation();
    const { entity } = useParams();
    const session = getSession();

    useEffect(() => {

        let title = "";

        // 1. HOME (guest/user)
        if (location.pathname === "/home") {
            title = "Bem-vindo!";
        }

        // 2. HOME USER / USER PAGE
        else if (location.pathname === "/home-user" || location.pathname === "/user-page") {
            title = session?.username
                ? `Bem-vindo ${session.username}`
                : "Bem-vindo";
        }

        // 3. LIST SCREEN
        else if (entity && !location.pathname.includes("create") && !location.pathname.includes("edit")) {

            const config = entityConfig[entity];

            if (config) {
                title = config.title || entity;

                // pluralização simples (PT)
                if (!title.endsWith("s")) title += "s";
            }
        }

        // 4. FORM SCREEN
        else if (entity && (location.pathname.includes("create") || location.pathname.includes("edit"))) {

            const config = entityConfig[entity];

            const action = mode === "edit" ? "Alterar" : "Criar";

            title = `${action} ${config?.title || entity}`;
        }

        // 5. LOGIN / REGISTER
        else if (location.pathname === "/login") {
            title = "Login";
        }
        else if (location.pathname === "/register") {
            title = "Register";
        }

        document.title = title;

    }, [location, entity, session, mode]);
}