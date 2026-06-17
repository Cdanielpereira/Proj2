import { Navigate } from "react-router-dom";
import { getUser } from "../auth/session";
import { resolveRole } from "../auth/roleService";

export default function RoleRoute({ roles = [], children }) {
    const user = getUser();
    const role = resolveRole(user);

    if (!user) {
        return <Navigate to="/" replace />;
    }

    if (!roles.includes(role) && !roles.includes("*")) {
        return <Navigate to="/home" replace />;
    }

    return children;
}