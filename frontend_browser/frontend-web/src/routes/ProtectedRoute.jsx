import { Navigate } from "react-router-dom";
import { getAuthState } from "../auth/session";

export default function ProtectedRoute({ children }) {
    const { isAuth } = getAuthState();

    if (!isAuth) {
        return <Navigate to="/" replace />;
    }

    return children;
}