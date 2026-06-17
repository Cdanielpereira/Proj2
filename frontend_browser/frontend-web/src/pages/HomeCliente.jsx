import React from "react";
import { useNavigate, Navigate } from "react-router-dom";
import { getUser } from "../auth/session";
import { appConfig } from "../config/appConfig";

export default function HomeCliente() {
    const navigate = useNavigate();
    const user = getUser();

    // Se não houver user, redireciona para login (evita crash)
    if (!user) {
        return <Navigate to="/login" replace />;
    }

    // Config segura (fallback para evitar crashes por role inválida)
    const config = appConfig[user.role] || appConfig.CLIENTE;

    const actions = config.homeActions || [];

    const handleNavigate = (action) => {
        // prioridade: route -> entity -> fallback
        if (action.route) {
            navigate(action.route);
            return;
        }

        if (action.entity) {
            navigate(`/${action.entity}`);
            return;
        }

        navigate("/ListScreen");
    };

    return (
        <div style={{ padding: 30, maxWidth: 1200, margin: "0 auto" }}>

            {/* HEADER */}
            <h1 style={{ textAlign: "center", fontSize: "2.5rem" }}>
                GoodStay
            </h1>

            {user?.username && (
                <h3 style={{ textAlign: "center", fontWeight: "normal" }}>
                    Bem-vindo {user.username}
                </h3>
            )}

            {/* ACTIONS */}
            <div
                style={{
                    display: "grid",
                    gridTemplateColumns: "repeat(auto-fit, minmax(220px, 1fr))",
                    gap: 20,
                    marginTop: 40
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
                            cursor: "pointer",
                            userSelect: "none"
                        }}
                    >
                        <div style={{ fontSize: 26 }}>
                            {action.icon || "📌"}
                        </div>

                        <div style={{ marginTop: 10, fontWeight: "bold" }}>
                            {action.label}
                        </div>
                    </div>
                ))}
            </div>

            {/* INFO SECTION */}
            <div
                style={{
                    display: "grid",
                    gridTemplateColumns: "1fr 1fr",
                    gap: 20,
                    marginTop: 50
                }}
            >
                {/* PROMOÇÕES */}
                <div
                    style={{
                        padding: 20,
                        background: "#fff3cd",
                        borderRadius: 10
                    }}
                >
                    <h3>🔥 Promoções</h3>
                    <ul>
                        <li>20% desconto em reservas</li>
                        <li>3 noites pelo preço de 2</li>
                        <li>Pequeno-almoço incluído</li>
                    </ul>
                </div>

                {/* REVIEWS */}
                <div
                    style={{
                        padding: 20,
                        background: "#d1ecf1",
                        borderRadius: 10
                    }}
                >
                    <h3>Reviews</h3>

                    <div style={{ display: "flex", flexDirection: "column", gap: 12 }}>

                        {/* Review 1 */}
                        <div style={{ background: "rgba(255,255,255,0.15)", borderRadius: 10, padding: 12 }}>
                            <div style={{ fontSize: 18 }}>⭐⭐⭐⭐⭐</div>
                            <h4>Excelente estadia</h4>
                            <p>Quartos muito limpos e ótima localização.</p>
                        </div>

                        {/* Review 2 */}
                        <div style={{ background: "rgba(255,255,255,0.15)", borderRadius: 10, padding: 12 }}>
                            <div style={{ fontSize: 18 }}>⭐⭐⭐</div>
                            <h4>Boa relação qualidade/preço</h4>
                            <p>Confortável e adequado ao valor pago.</p>
                        </div>

                        {/* Review 3 */}
                        <div style={{ background: "rgba(255,255,255,0.15)", borderRadius: 10, padding: 12 }}>
                            <div style={{ fontSize: 18 }}>⭐⭐⭐⭐</div>
                            <h4>Recomendo</h4>
                            <p>Excelente pequeno-almoço e check-in rápido.</p>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    );
}