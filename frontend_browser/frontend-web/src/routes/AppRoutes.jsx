import { Routes, Route, Navigate } from "react-router-dom";

import Home from "../pages/Home";
import HomeUser from "../pages/HomeUser";
import HomeCliente from "../pages/HomeCliente";
import Login from "../pages/auth/Login";
import Register from "../pages/auth/Register";

import ListScreen from "../pages/ListScreen";
import FormScreen from "../pages/FormScreen";

import AppLayout from "../components/AppLayout";
import ProtectedRoute from "../routes/ProtectedRoute";

export default function AppRoutes() {
    return (
        <Routes>

            <Route path="/" element={<Navigate to="/home" replace />} />

            <Route
                path="/home"
                element={
                    <AppLayout>
                        <Home />
                    </AppLayout>
                }
            />
            <Route
                path="/homeUser"
                element={
                    <AppLayout>
                        <HomeUser />
                    </AppLayout>
                }
            />
            <Route
                path="/homeCliente"
                element={
                    <AppLayout>
                        <HomeCliente />
                    </AppLayout>
                }
            />

            <Route path="/login" element={<Login />} />
            <Route path="/register" element={<Register />} />

            <Route
                path="/:entity"
                element={
                    <AppLayout>
                        <ListScreen />
                    </AppLayout>
                }
            />

            <Route
                path="/:entity/create"
                element={
                    <AppLayout>
                        <FormScreen mode="create" />
                    </AppLayout>
                }
            />

            <Route
                path="/:entity/edit/:id"
                element={
                    <AppLayout>
                        <FormScreen mode="edit" />
                    </AppLayout>
                }
            />

            <Route path="*" element={<Navigate to="/home" replace />} />

        </Routes>
    );
}