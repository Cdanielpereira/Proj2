import { useEffect, useState } from "react";
import { useParams, useNavigate } from "react-router-dom";
import { entityConfig } from "../config/entityConfig";
import usePageTitle from "../hooks/usePageTitle";

export default function ListScreen() {
    const { entity } = useParams();
    const navigate = useNavigate();

    const user = JSON.parse(localStorage.getItem("user"));
    const role = user?.role;

    const config = entityConfig?.[entity];

    const [data, setData] = useState([]);
    const [filterText, setFilterText] = useState("");
    const [loading, setLoading] = useState(true);

    const [deleteId, setDeleteId] = useState(null);
    const [showDeleteModal, setShowDeleteModal] = useState(false);

    const [selectedItem, setSelectedItem] = useState(null);
    const [showDetailModal, setShowDetailModal] = useState(false);

    const isGuest = !user || role === "GUEST";

    usePageTitle();

    const isMinhasMarcacoes =
        entity === "marcacao" && role === "CLIENTE";

    const loadRecords = async () => {
        if (!config?.api?.list) {
            setLoading(false);
            return;
        }

        setLoading(true);

        try {
            let res;

            // ✅ CASO ESPECIAL: "Minhas Marcações"
            if (isMinhasMarcacoes) {
                res = await config.api.listByUser?.(user.userId);
            } else {
                res = await config.api.list();
            }

            const result = res.data;
            setData(Array.isArray(result) ? result : result?.content || []);

        } catch (err) {
            console.error(err);
            setData([]);
        } finally {
            setLoading(false);
        }
    };

    useEffect(() => {
        loadRecords();
    }, [entity]);

    const handleDelete = (id) => {
        setDeleteId(id);
        setShowDeleteModal(true);
    };

    const confirmDelete = async () => {
        try {
            await config?.api?.delete?.(deleteId);
            setShowDeleteModal(false);
            setDeleteId(null);
            loadRecords();
        } catch {
            alert("Erro ao eliminar registo");
        }
    };

    const openDetail = (row) => {
        setSelectedItem(row);
        setShowDetailModal(true);
    };

    const filterField =
        config?.table?.columns?.find(c => c.filter)?.field;

    const filteredData = data.filter(item => {
        if (!filterText || !filterField) return true;

        return String(item?.[filterField] ?? "")
            .toLowerCase()
            .includes(filterText.toLowerCase());
    });

    const visibleData = filteredData;

    const showCreateButton =
        isGuest ? false : true;

    if (!entity || !config) {
        return (
            <div style={{ padding: 20 }}>
                Entidade inválida: <b>{entity}</b>
            </div>
        );
    }

    return (
        <div style={{ maxWidth: 1000, margin: "0 auto", padding: 20 }}>

            {filterField && (
                <input
                    value={filterText}
                    onChange={(e) => setFilterText(e.target.value)}
                    placeholder="Pesquisar..."
                    style={{ width: "100%", padding: 10, marginBottom: 20 }}
                />
            )}

            {loading ? (
                <div>A carregar...</div>
            ) : (
                visibleData.map((row) => (
                    <div
                        key={row?.id}
                        onClick={() => openDetail(row)}
                        style={{
                            display: "flex",
                            justifyContent: "space-between",
                            padding: 14,
                            border: "1px solid #ddd",
                            borderRadius: 8,
                            marginBottom: 10,
                            cursor: "pointer",
                            background: "#00172d"
                        }}
                    >
                        <div>
                            {(config.table.columns || []).map(col => (
                                <div key={col.field}>
                                    <strong>{col.label}:</strong>{" "}
                                    {row?.[col.field]}
                                </div>
                            ))}
                        </div>

                        <div
                            onClick={(e) => e.stopPropagation()}
                            style={{ display: "flex", gap: 8 }}
                        >
                            <button
                                onClick={() =>
                                    navigate(`/${entity}/edit/${row?.id}`)
                                }
                                style={{
                                    background: "#026001",
                                    color: "#fff",
                                    padding: "6px 10px",
                                    border: "none",
                                    borderRadius: 4
                                }}
                            >
                                Editar
                            </button>

                            <button
                                onClick={() => handleDelete(row?.id)}
                                style={{
                                    background: "#870303",
                                    color: "#fff",
                                    padding: "6px 10px",
                                    border: "none",
                                    borderRadius: 4
                                }}
                            >
                                Apagar
                            </button>
                        </div>
                    </div>
                ))
            )}

            {showCreateButton && (
                <button
                    onClick={() => navigate(`/${entity}/create`)}
                    style={{
                        position: "fixed",
                        right: 30,
                        bottom: 30,
                        width: 55,
                        height: 55,
                        borderRadius: "50%",
                        background: "#013d68",
                        color: "#fff",
                        fontSize: 28,
                        border: "none"
                    }}
                >
                    +
                </button>
            )}

            {/* modals mantidos iguais */}
            {showDeleteModal && (
                <div style={modalOverlay}>
                    <div style={modalBox}>
                        <h3>Confirmar eliminação</h3>

                        <div style={modalActions}>
                            <button onClick={() => setShowDeleteModal(false)} style={btnGreen}>
                                Cancelar
                            </button>

                            <button onClick={confirmDelete} style={btnRed}>
                                Apagar
                            </button>
                        </div>
                    </div>
                </div>
            )}
        </div>
    );
}