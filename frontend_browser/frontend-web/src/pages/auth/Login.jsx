import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { login } from "../api/auth";
import { setSession } from "../pages/auth/session";
import usePageTitle from "../hooks/usePageTitle";

export default function Login() {

    usePageTitle();

    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const navigate = useNavigate();

    const handleLogin = async (e) => {
        e.preventDefault();

        try {
            const res = await login({ username, password });

            setSession(res.data);

            // ✔ SEM separar páginas ainda
            navigate("/home");

        } catch (err) {
            alert("Erro no login");
        }
    };

    return (
        <form onSubmit={handleLogin}>
            <input
                placeholder="username"
                onChange={(e) => setUsername(e.target.value)}
            />

            <input
                placeholder="password"
                type="password"
                onChange={(e) => setPassword(e.target.value)}
            />

            <button type="submit">Login</button>
        </form>
    );
}