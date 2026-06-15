import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import { entityConfig } from "../config/entityConfig";
import usePageTitle from "../hooks/usePageTitle";

export default function FormScreen({ mode }) {

    usePageTitle();


    const { entity, id } = useParams();
    const config = entityConfig[entity];

    const [form, setForm] = useState({});
    const [relations, setRelations] = useState({});
    const navigate = useNavigate();

    const isEdit = mode === "edit";

    useEffect(() => {
        loadRelations();
        if (isEdit) load();
    }, []);

    const load = async () => {
        const res = await config.api.get(id);
        setForm(res.data);
    };

    const loadRelations = async () => {

        const relData = {};

        for (const field of config.fields) {
            if (field.type === "select") {
                const res = await field.relation.api();
                relData[field.name] = res.data;
            }
        }

        setRelations(relData);
    };

    const handleChange = (e) => {

        const { name, value } = e.target;

        setForm({
            ...form,
            [name]: value
        });
    };

    const handleSubmit = async () => {

        const payload = { ...form };

        // 🔥 CONVERTER SELECTS EM OBJETOS (FK REAL)
        config.fields.forEach(field => {

            if (field.type === "select") {

                const list = relations[field.name] || [];

                const selected = list.find(
                    x => x[field.relation.valueField].toString() === payload[field.name]
                );

                payload[field.name] = selected || null;
            }
        });

        if (isEdit) {
            await config.api.update(id, payload);
        } else {
            await config.api.create(payload);
        }

        navigate(`/${entity}`);
    };

    return (
        <div>

            <h2>{isEdit ? "Editar" : "Criar"} {config.title}</h2>

            {config.fields.map(field => (

                <div key={field.name}>

                    <label>{field.label}</label>

                    {/* TEXT */}
                    {field.type === "text" && (
                        <input
                            name={field.name}
                            value={form[field.name] || ""}
                            onChange={handleChange}
                        />
                    )}

                    {/* SELECT (FK REAL) */}
                    {field.type === "select" && (
                        <select
                            name={field.name}
                            value={form[field.name]?.id || form[field.name] || ""}
                            onChange={handleChange}
                        >
                            <option value="">-- selecionar --</option>

                            {(relations[field.name] || []).map(opt => (
                                <option
                                    key={opt[field.relation.valueField]}
                                    value={opt[field.relation.valueField]}
                                >
                                    {opt[field.relation.labelField]}
                                </option>
                            ))}
                        </select>
                    )}

                </div>
            ))}

            <button onClick={handleSubmit}>
                Guardar
            </button>

        </div>
    );
}