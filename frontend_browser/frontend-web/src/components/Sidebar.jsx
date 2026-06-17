import { useNavigate } from "react-router-dom";
import { getRoleConfig } from "../auth/roleService";

export default function Sidebar({ onClose }) {
    const navigate = useNavigate();
    const config = getRoleConfig();

    const handleClick = (item) => {
        if (item.route) {
            navigate(item.route);
        } else if (item.entity) {
            navigate(`/${item.entity}`);
        } else {
            navigate("/ListScreen");
        }
        onClose();
    };

    return (
        <div
            style={{
                position: "fixed",
                top: 0,
                left: 0,
                width: 250,
                height: "100vh",
                background: "#00172d",
                color: "white",
                zIndex: 1000,
                display: "flex",
                flexDirection: "column"
            }}
        >
            {/* Cabeçalho fixo com o botão fechar */}
            <div
                style={{
                    padding: "20px 20px 10px 20px",
                    flexShrink: 0
                }}
            >
                <button
                    onClick={onClose}
                    style={{
                        background: "transparent",
                        border: "none",
                        color: "white",
                        fontSize: 20,
                        cursor: "pointer"
                    }}
                >
                    ✕
                </button>
            </div>

            {/* Área scrollável com os itens do menu */}
            <div
                style={{
                    flex: 1,
                    overflowY: "auto",
                    padding: "0 20px 20px 20px",
                    scrollbarWidth: "thin",
                    scrollbarColor: "#ffffff44 transparent"
                }}
            >
                {config.menu.map((item, idx) => (
                    <div
                        key={idx}
                        onClick={() => handleClick(item)}
                        style={{
                            padding: "10px 0",
                            cursor: "pointer",
                            borderBottom: "1px solid #ffffff22",
                            display: "flex",
                            alignItems: "center",
                            gap: 10
                        }}
                    >
                        {item.icon && (
                            <span
                                style={{
                                    fontSize: 18,
                                    width: 24,
                                    display: "inline-flex",
                                    justifyContent: "center"
                                }}
                            >
                                {item.icon}
                            </span>
                        )}
                        <span>{item.label}</span>
                    </div>
                ))}
            </div>
        </div>
    );
}