import { Navigate } from "react-router-dom";
import { getRole } from "../pages/auth/session";

export default function RoleRoute({ roles, children }) {

    const role = getRole();

    if (!role) return <Navigate to="/login" />;

    if (!roles.includes(role)) {
        return <Navigate to="/home" />;
    }

    return children;
}