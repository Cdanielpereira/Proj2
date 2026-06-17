import { useState } from "react";
import { useNavigate, Link } from "react-router-dom";
import { login } from "../../api/auth";
import { loginSession } from "../../auth/session";
import usePageTitle from "../../hooks/usePageTitle";
import TopBar from "../../components/TopBar";

const PRIMARY_COLOR = "#2563eb";

const HOME_BY_ROLE = {
    GUEST: "/home",
    CLIENTE: "/homeCliente",
    STAFF: "/homeUser",
    RECEP: "/homeUser",
    HR: "/homeUser",
    GERENTE: "/homeUser",
    SUPERADMIN: "/homeUser",
    ADMIN: "/homeUser",
    USER: "/homeUser"
};

export default function Login() {
    usePageTitle();

    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [showPassword, setShowPassword] = useState(false);

    const navigate = useNavigate();

    const handleLogin = async (e) => {
        e.preventDefault();

        console.log("=================================");
        console.log("A ENVIAR PARA LOGIN:");
        console.log({
            username,
            password
        });
        console.log("=================================");

        try {
            const res = await login({
                username,
                password
            });

            console.log("=================================");
            console.log("LOGIN SUCESSO");
            console.log("STATUS:", res.status);
            console.log("HEADERS:", res.headers);
            console.log("DATA:", res.data);
            console.log("=================================");

            const data = res.data;

            const token =
                data?.token ||
                data?.accessToken ||
                data?.jwt ||
                data?.authToken;

            console.log("TOKEN DETETADO:", token);

            if (!token) {
                alert("Backend não devolveu token.");
                return;
            }

            const user = {
                userId:
                    data?.id ??
                    data?.userId ??
                    data?.user?.id ??
                    null,

                username:
                    data?.username ??
                    data?.user?.username ??
                    username,

                role:
                    (
                        data?.role ??
                        data?.user?.role ??
                        "GUEST"
                    ).toUpperCase()
            };

            console.log("USER NORMALIZADO:");
            console.log(user);

            loginSession(token, user);

            console.log("LOCALSTORAGE TOKEN:");
            console.log(localStorage.getItem("token"));

            console.log("LOCALSTORAGE USER:");
            console.log(localStorage.getItem("user"));

            const destino =
                HOME_BY_ROLE[user.role] ||
                "/home";

            console.log("REDIRECT PARA:", destino);

            navigate(destino);

        } catch (err) {

            console.log("=================================");
            console.log("ERRO COMPLETO");
            console.log(err);

            console.log("MESSAGE:");
            console.log(err?.message);

            console.log("NAME:");
            console.log(err?.name);

            console.log("CODE:");
            console.log(err?.code);

            console.log("CONFIG:");
            console.log(err?.config);

            console.log("REQUEST:");
            console.log(err?.request);

            console.log("RESPONSE:");
            console.log(err?.response);

            console.log("STATUS:");
            console.log(err?.response?.status);

            console.log("DATA:");
            console.log(err?.response?.data);

            console.log("=================================");

            alert(
                err?.response?.data?.message ||
                err?.message ||
                "Erro no login"
            );
        }
    };

    return (
        <>
            <TopBar />

            <div
                style={{
                    minHeight: "80vh",
                    display: "flex",
                    justifyContent: "center",
                    alignItems: "center",
                    padding: 20
                }}
            >
                <div
                    style={{
                        width: "100%",
                        maxWidth: 450,
                        background: "#00172d",
                        padding: 35,
                        borderRadius: 16,
                        boxSizing: "border-box"
                    }}
                >
                    <h1
                        style={{
                            textAlign: "center",
                            color: "#fff",
                            marginBottom: 30
                        }}
                    >
                        Login
                    </h1>

                    <form
                        onSubmit={handleLogin}
                        style={{
                            display: "flex",
                            flexDirection: "column",
                            gap: 18
                        }}
                    >
                        <div>
                            <label
                                style={{
                                    display: "block",
                                    marginBottom: 6,
                                    color: "#fff"
                                }}
                            >
                                Username
                            </label>

                            <input
                                type="text"
                                value={username}
                                onChange={(e) =>
                                    setUsername(e.target.value)
                                }
                                required
                                style={{
                                    width: "100%",
                                    padding: 12,
                                    borderRadius: 8,
                                    border: "1px solid #ddd",
                                    boxSizing: "border-box"
                                }}
                            />
                        </div>

                        <div>
                            <label
                                style={{
                                    display: "block",
                                    marginBottom: 6,
                                    color: "#fff"
                                }}
                            >
                                Password
                            </label>

                            <div
                                style={{
                                    position: "relative"
                                }}
                            >
                                <input
                                    type={
                                        showPassword
                                            ? "text"
                                            : "password"
                                    }
                                    value={password}
                                    onChange={(e) =>
                                        setPassword(e.target.value)
                                    }
                                    required
                                    style={{
                                        width: "100%",
                                        padding:
                                            "12px 45px 12px 12px",
                                        borderRadius: 8,
                                        border: "1px solid #ddd",
                                        boxSizing: "border-box"
                                    }}
                                />

                                <button
                                    type="button"
                                    onClick={() =>
                                        setShowPassword(
                                            !showPassword
                                        )
                                    }
                                    style={{
                                        position: "absolute",
                                        right: 10,
                                        top: "50%",
                                        transform:
                                            "translateY(-50%)",
                                        border: "none",
                                        background:
                                            "transparent",
                                        cursor: "pointer",
                                        fontSize: 16
                                    }}
                                >
                                    {showPassword
                                        ? "Ocultar"
                                        : "Mostrar"}
                                </button>
                            </div>
                        </div>

                        <button
                            type="submit"
                            style={{
                                background:
                                PRIMARY_COLOR,
                                color: "#fff",
                                border: "none",
                                padding: 14,
                                borderRadius: 8,
                                fontWeight: "bold",
                                cursor: "pointer"
                            }}
                        >
                            Entrar
                        </button>
                    </form>

                    <p
                        style={{
                            textAlign: "center",
                            marginTop: 20,
                            color: "#fff"
                        }}
                    >
                        Não tens conta?{" "}
                        <Link
                            to="/register"
                            style={{
                                color:
                                PRIMARY_COLOR
                            }}
                        >
                            Regista-te
                        </Link>
                    </p>
                </div>
            </div>
        </>
    );
}