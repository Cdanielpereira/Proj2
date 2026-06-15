import { Navigate } from "react-router-dom";
import { isAuthenticated } from "../pages/auth/session";

export default function ProtectedRoute({ children }) {
    return isAuthenticated() ? children : <Navigate to="/login" />;
}