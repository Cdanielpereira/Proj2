import { useEffect, useState } from "react";
import { useParams, useNavigate } from "react-router-dom";
import { entityConfig } from "../config/entityConfig";
import usePageTitle from "../hooks/usePageTitle";

export default function FormScreen({ mode }) {
    const { entity, id } = useParams();
    const navigate = useNavigate();

    const config = entityConfig?.[entity];
    const isEdit = mode === "edit";

    const [form, setForm] = useState({});
    const [loading, setLoading] = useState(true);

    usePageTitle();

    useEffect(() => {
        const init = async () => {
            if (!config) {
                setLoading(false);
                return;
            }

            if (isEdit && !id) {
                setLoading(false);
                return;
            }

            setLoading(true);

            try {
                if (isEdit) {
                    const res = await config.api.get(id);
                    setForm(res.data);
                } else {
                    const empty = {};
                    config.fields.forEach((field) => {
                        empty[field.name] = "";
                    });
                    setForm(empty);
                }
            } catch (err) {
                console.error(err);
                alert("Erro ao carregar formulário");
            } finally {
                setLoading(false);
            }
        };

        init();
    }, [entity, id, isEdit, config]);

    const handleChange = (e) => {
        setForm({
            ...form,
            [e.target.name]: e.target.value
        });
    };

    const handleSubmit = async (e) => {
        e.preventDefault();

        try {
            if (isEdit) {
                await config.api.update(id, form);
                alert("Atualizado com sucesso");
            } else {
                await config.api.create(form);
                alert("Criado com sucesso");
            }

            navigate(`/${entity}`);
        } catch (err) {
            console.error(err);
            alert("Erro ao guardar dados");
        }
    };

    if (!config) {
        return (
            <div style={{ padding: 20 }}>
                Entidade inválida: <b>{entity}</b>
            </div>
        );
    }

    if (loading) {
        return (
            <div style={{ textAlign: "center", marginTop: 50 }}>
                A carregar formulário...
            </div>
        );
    }

    return (
        <div
            style={{
                maxWidth: "550px",
                margin: "40px auto",
                padding: "30px",
                background: "#00172d",
                borderRadius: "12px",
                boxShadow: "0 4px 12px rgba(0,0,0,0.08)"
            }}
        >
            <h1 style={{ textAlign: "center", marginBottom: "35px" }}>
                {isEdit ? "Editar" : "Criar"} {config.title}
            </h1>

            <form
                onSubmit={handleSubmit}
                style={{ display: "flex", flexDirection: "column", gap: "18px" }}
            >
                {config.fields.map((field) => (
                    <div
                        key={field.name}
                        style={{ display: "flex", flexDirection: "column", gap: "6px" }}
                    >
                        <label style={{ fontWeight: 600, fontSize: "14px" }}>
                            {field.label}
                            {field.required && (
                                <span style={{ color: "grey", marginLeft: 4 }}>
                                    *
                                </span>
                            )}
                        </label>

                        <input
                            name={field.name}
                            type={field.type || "text"}
                            value={form[field.name] || ""}
                            onChange={handleChange}
                            required={field.required}
                            style={{
                                padding: "12px",
                                border: "1px solid #d0d7de",
                                borderRadius: "8px",
                                fontSize: "15px",
                                outline: "none"
                            }}
                        />
                    </div>
                ))}

                <div
                    style={{
                        display: "flex",
                        justifyContent: "center",
                        gap: "12px",
                        marginTop: "10px"
                    }}
                >
                    <button
                        type="submit"
                        style={{
                            background: "#026001",
                            color: "#fff",
                            border: "none",
                            borderRadius: "8px",
                            padding: "12px 22px",
                            cursor: "pointer",
                            fontWeight: "bold",
                            fontSize: "14px"
                        }}
                    >
                        {isEdit ? "Atualizar" : "Criar"}
                    </button>

                    <button
                        type="button"
                        onClick={() => navigate(`/${entity}`)}
                        style={{
                            background: "#870303",
                            color: "#fff",
                            border: "none",
                            borderRadius: "8px",
                            padding: "12px 22px",
                            cursor: "pointer",
                            fontWeight: "bold",
                            fontSize: "14px"
                        }}
                    >
                        Cancelar
                    </button>
                </div>
            </form>
        </div>
    );
}