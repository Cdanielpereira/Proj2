import { BrowserRouter, Routes, Route } from "react-router-dom";

import Login from "../pages/auth/Login";
import Register from "../pages/auth/Register";

import Home from "../pages/Home";

import ListScreen from "../pages/ListScreen";
import FormScreen from "../pages/FormScreen";

export default function AppRoutes() {
    return (
        <BrowserRouter>
            <Routes>

                {/* AUTH */}
                <Route path="/login" element={<Login />} />
                <Route path="/register" element={<Register />} />

                {/* HOME (DINÂMICA POR ROLE) */}
                <Route path="/" element={<Home />} />

                {/* CRUD DINÂMICO */}
                <Route path="/:entity" element={<ListScreen />} />
                <Route path="/:entity/create" element={<FormScreen mode="create" />} />
                <Route path="/:entity/edit/:id" element={<FormScreen mode="edit" />} />

            </Routes>
        </BrowserRouter>
    );
}