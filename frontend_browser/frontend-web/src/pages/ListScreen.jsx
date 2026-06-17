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

    const isCliente = role === "CLIENTE";
    const isGuest = !user || role === "GUEST";

    usePageTitle();

    const loadRecords = async () => {
        if (!config?.api?.list) {
            setLoading(false);
            return;
        }

        setLoading(true);

        try {
            const res = await config.api.list();
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
        isGuest || isCliente
            ? entity === "marcacao"
            : true;

    if (!entity || !config) {
        return (
            <div style={{ padding: 20 }}>
                Entidade inválida: <b>{entity}</b>
            </div>
        );
    }

    return (
        <div style={{ maxWidth: 1000, margin: "0 auto", padding: 20 }}>

            {/* SEARCH */}
            {filterField && (
                <input
                    value={filterText}
                    onChange={(e) => setFilterText(e.target.value)}
                    placeholder="Pesquisar..."
                    style={{
                        width: "100%",
                        padding: 10,
                        marginBottom: 20
                    }}
                />
            )}

            {/* LIST */}
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

            {/* CREATE BUTTON */}
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

            {/* DETAIL MODAL */}
            {showDetailModal && selectedItem && (
                <div style={modalOverlay}>
                    <div style={modalBox}>
                        <h3>Detalhes</h3>

                        <div style={{ marginTop: 10 }}>
                            {config.fields.map((f) => (
                                <div key={f.name} style={{ marginBottom: 8 }}>
                                    <strong>{f.label}:</strong>{" "}
                                    {selectedItem?.[f.name] ?? "-"}
                                </div>
                            ))}
                        </div>

                        <div style={modalActions}>
                            <button
                                onClick={() => setShowDetailModal(false)}
                                style={btnGreen}
                            >
                                Fechar
                            </button>
                        </div>
                    </div>
                </div>
            )}

            {/* DELETE MODAL */}
            {showDeleteModal && (
                <div style={modalOverlay}>
                    <div style={modalBox}>
                        <h3>Confirmar eliminação</h3>
                        <p>Queres apagar este registo?</p>

                        <div style={modalActions}>
                            <button
                                onClick={() => setShowDeleteModal(false)}
                                style={btnGreen}
                            >
                                Cancelar
                            </button>

                            <button
                                onClick={confirmDelete}
                                style={btnRed}
                            >
                                Apagar
                            </button>
                        </div>
                    </div>
                </div>
            )}
        </div>
    );
}

/* ===== STYLES ===== */

const modalOverlay = {
    position: "fixed",
    inset: 0,
    background: "rgba(0,0,0,0.5)",
    display: "flex",
    alignItems: "center",
    justifyContent: "center",
    zIndex: 9999
};

const modalBox = {
    background: "#002754",
    color: "#fff",
    padding: 20,
    borderRadius: 8,
    minWidth: 350
};

const modalActions = {
    display: "flex",
    justifyContent: "center",
    gap: 10,
    marginTop: 20
};

const btnGreen = {
    background: "#026001",
    color: "#fff",
    padding: "8px 14px",
    border: "none",
    borderRadius: 4
};

const btnRed = {
    background: "#870303",
    color: "#fff",
    padding: "8px 14px",
    border: "none",
    borderRadius: 4
};