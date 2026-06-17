import React from "react";
import { useNavigate, Navigate } from "react-router-dom";
import { appConfig } from "../config/appConfig";

export default function Home() {
    const navigate = useNavigate();

    const user = JSON.parse(localStorage.getItem("user"));

    // 🔥 redirect controlado (antes do render)
    if (user?.role === "CLIENTE") {
        return <Navigate to="/homeCliente" replace />;
    }

    if (user?.role === "FUNCIONARIO") {
        return <Navigate to="/homeUser" replace />;
    }

    const actions = appConfig.GUEST.homeActions;

    const handleNavigate = (action) => {
        if (action.route) {
            navigate(action.route);
        } else if (action.entity) {
            navigate(`/${action.entity}`);
        } else {
            navigate("/ListScreen");
        }
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
                GoodStay
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

            {/* INFO */}
            <div
                style={{
                    display: "grid",
                    gridTemplateColumns: "1fr 1fr",
                    gap: 20,
                    marginTop: 40
                }}
            >

                {/* PROMOÇÕES */}
                <div
                    style={{
                        padding: 20,
                        background: "#00a9a5",
                        color: "white",
                        borderRadius: 10
                    }}
                >
                    <h3>Promoções</h3>

                    <ul style={{ paddingLeft: 20, marginTop: 10 }}>
                        <li>🏨 20% desconto em reservas de verão</li>
                        <li>🌙 3 noites pelo preço de 2</li>
                        <li>🍽️ Pequeno-almoço gratuito incluído</li>
                    </ul>
                </div>

                {/* REVIEWS */}
                <div
                    style={{
                        padding: 20,
                        background: "#00b081",
                        color: "white",
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