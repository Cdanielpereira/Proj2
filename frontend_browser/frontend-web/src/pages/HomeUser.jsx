import React, { useEffect } from "react";
import { useNavigate } from "react-router-dom";
import { appConfig } from "../config/appConfig";

export default function HomeUser() {
    const navigate = useNavigate();

    // Utilizador autenticado (CORRETO: null se não existir)
    const user = JSON.parse(localStorage.getItem("user"));

    const role = (user?.role || "GUEST").toUpperCase();
    const config = appConfig[role] || appConfig.GUEST;
    const actions = config.homeActions || [];

    useEffect(() => {
        if (!user || !config) {
            navigate("/", { replace: true });
        }
    }, [user, config, navigate]);

    // Título dinâmico
    const title =
        typeof config.homeTitle === "function"
            ? config.homeTitle(user)
            : config.homeTitle;

    const handleNavigate = (action) => {
        if (action.route) {
            navigate(action.route);
        } else if (action.entity) {
            navigate(`/${action.entity}`);
        } else {
            navigate("/ListScreen");
        }
    };

    const dias = ["Seg", "Ter", "Qua", "Qui", "Sex", "Sáb", "Dom"];

    const horas = [
        "09:00 - 10:00",
        "10:00 - 11:00",
        "11:00 - 12:00",
        "12:00 - 13:00",
        "13:00 - 14:00",
        "14:00 - 15:00",
        "15:00 - 16:00",
        "16:00 - 17:00"
    ];

    const horario = {
        Seg: {
            "09:00 - 10:00": "Receção",
            "10:00 - 11:00": "Receção",
            "14:00 - 15:00": "Limpeza",
            "15:00 - 16:00": "Limpeza"
        },
        Ter: {
            "09:00 - 10:00": "Receção",
            "11:00 - 12:00": "Reunião",
            "14:00 - 15:00": "Limpeza"
        },
        Qua: {
            "10:00 - 11:00": "Receção",
            "11:00 - 12:00": "Receção",
            "15:00 - 16:00": "Manutenção"
        },
        Qui: {
            "09:00 - 10:00": "Receção",
            "13:00 - 14:00": "Almoço",
            "16:00 - 17:00": "Limpeza"
        },
        Sex: {
            "09:00 - 10:00": "Receção",
            "10:00 - 11:00": "Receção",
            "11:00 - 12:00": "Receção"
        },
        Sáb: {},
        Dom: {}
    };

    return (
        <div style={{ padding: 30, maxWidth: 1200, margin: "0 auto" }}>
            <h1
                style={{
                    textAlign: "center",
                    fontSize: "2.5rem",
                    marginBottom: 60
                }}
            >
                {"GoodStay"}
            </h1>

            {/* ACTION CARDS */}
            <div
                style={{
                    display: "grid",
                    gridTemplateColumns: "repeat(auto-fit, minmax(220px, 1fr))",
                    gap: 20
                }}
            >
                {actions.map((action, idx) => (
                    <div
                        key={idx}
                        onClick={() => handleNavigate(action)}
                        style={{
                            padding: 20,
                            borderRadius: 12,
                            background: "#013d68",
                            color: "white",
                            cursor: "pointer"
                        }}
                    >
                        <div style={{ fontSize: 24 }}>
                            {action.icon || "📌"}
                        </div>
                        <div style={{ fontWeight: "bold", marginTop: 10 }}>
                            {action.label}
                        </div>
                    </div>
                ))}
            </div>

            {/* INFO GRID */}
            <div
                style={{
                    display: "grid",
                    gridTemplateColumns: "1fr 1fr",
                    gap: 20,
                    marginTop: 40
                }}
            >
                {/* EVENTOS */}
                <div
                    style={{
                        padding: 20,
                        background: "#00a9a5",
                        color: "white",
                        borderRadius: 10
                    }}
                >
                    <h3>Eventos</h3>

                    <ul style={{ paddingLeft: 20, marginTop: 10 }}>
                        <li>🏨 20% desconto em reservas de verão</li>
                        <li>🌙 3 noites pelo preço de 2</li>
                        <li>🍽️ Pequeno-almoço gratuito incluído</li>
                    </ul>
                </div>

                {/* HORÁRIO */}
                <div
                    style={{
                        padding: 20,
                        background: "#00b081",
                        color: "white",
                        borderRadius: 10
                    }}
                >
                    <h3 style={{ marginTop: 0, marginBottom: 12 }}>
                        Horário
                    </h3>

                    <div
                        style={{
                            display: "grid",
                            gridTemplateColumns: `80px repeat(${dias.length}, 1fr)`,
                            gap: 4,
                            fontSize: 12,
                            background: "rgba(255,255,255,0.1)",
                            padding: 6,
                            borderRadius: 6
                        }}
                    >
                        {/* HEADER */}
                        <div />
                        {dias.map((d) => (
                            <div
                                key={d}
                                style={{
                                    textAlign: "center",
                                    fontWeight: 700,
                                    padding: "4px 0",
                                    background: "rgba(0,0,0,0.2)",
                                    borderRadius: 4
                                }}
                            >
                                {d}
                            </div>
                        ))}

                        {/* LINHAS */}
                        {horas.map((h) => (
                            <React.Fragment key={h}>
                                <div
                                    style={{
                                        fontWeight: 600,
                                        padding: "4px 6px",
                                        background: "rgba(0,0,0,0.2)",
                                        borderRadius: 4,
                                        display: "flex",
                                        alignItems: "center",
                                        fontSize: 11
                                    }}
                                >
                                    {h}
                                </div>

                                {dias.map((d) => {
                                    const valor = horario[d]?.[h];

                                    return (
                                        <div
                                            key={`${d}-${h}`}
                                            style={{
                                                padding: "6px 4px",
                                                background: valor
                                                    ? "rgba(255,255,255,0.25)"
                                                    : "rgba(255,255,255,0.08)",
                                                borderRadius: 4,
                                                textAlign: "center",
                                                minHeight: 24
                                            }}
                                        >
                                            {valor || ""}
                                        </div>
                                    );
                                })}
                            </React.Fragment>
                        ))}
                    </div>
                </div>
            </div>
        </div>
    );
}