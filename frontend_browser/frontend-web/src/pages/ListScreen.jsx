import { useEffect, useMemo, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import { entityConfig } from "../config/entityConfig";

export default function ListScreen() {

    const { entity } = useParams();
    const config = entityConfig[entity];

    const navigate = useNavigate();

    const [data, setData] = useState([]);
    const [filters, setFilters] = useState({});
    const [sort, setSort] = useState({ field: config.table?.defaultSort, dir: "asc" });

    useEffect(() => {
        load();
    }, [entity]);

    const load = async () => {
        const res = await config.api.list();
        setData(res.data.content || res.data);
    };

    const applyFilters = (items) => {

        return items.filter(item => {

            return Object.entries(filters).every(([key, value]) => {

                if (!value) return true;

                const itemValue = item[key];

                if (itemValue == null) return false;

                return itemValue.toString().toLowerCase()
                    .includes(value.toLowerCase());
            });
        });
    };

    const applySort = (items) => {

        if (!sort.field) return items;

        return [...items].sort((a, b) => {

            const aVal = a[sort.field];
            const bVal = b[sort.field];

            if (aVal == null) return 1;
            if (bVal == null) return -1;

            if (aVal < bVal) return sort.dir === "asc" ? -1 : 1;
            if (aVal > bVal) return sort.dir === "asc" ? 1 : -1;

            return 0;
        });
    };

    const processedData = useMemo(() => {
        return applySort(applyFilters(data));
    }, [data, filters, sort]);

    const handleSort = (field) => {

        setSort(prev => ({
            field,
            dir: prev.field === field && prev.dir === "asc" ? "desc" : "asc"
        }));
    };

    const renderCell = (row, col) => {

        if (col.render) {
            return col.render(row);
        }

        const value = row[col.field];

        if (typeof value === "object" && value !== null) {
            return value.nome || value.nacionalidade || value.type || "—";
        }

        return value ?? "—";
    };

    return (
        <div>

            {/* HEADER */}
            <div style={{
                display: "flex",
                justifyContent: "space-between",
                alignItems: "center"
            }}>
                <h2>{config.title}</h2>

                <button onClick={() => navigate(`/${entity}/create`)}>
                    + Criar
                </button>
            </div>

            {/* FILTERS */}
            <div style={{
                display: "flex",
                gap: "10px",
                margin: "10px 0"
            }}>
                {config.table.columns
                    .filter(c => c.filter)
                    .map(col => (
                        <input
                            key={col.field}
                            placeholder={`Filtrar ${col.label}`}
                            onChange={(e) =>
                                setFilters({
                                    ...filters,
                                    [col.field]: e.target.value
                                })
                            }
                        />
                    ))}
            </div>

            {/* TABLE */}
            <table border="1" width="100%">
                <thead>
                <tr>
                    {config.table.columns.map(col => (
                        <th
                            key={col.field}
                            onClick={() => col.sortable && handleSort(col.field)}
                            style={{ cursor: col.sortable ? "pointer" : "default" }}
                        >
                            {col.label}
                            {sort.field === col.field && (
                                sort.dir === "asc" ? " 🔼" : " 🔽"
                            )}
                        </th>
                    ))}
                    <th>Ações</th>
                </tr>
                </thead>

                <tbody>
                {processedData.map(row => (
                    <tr key={row.id}>

                        {config.table.columns.map(col => (
                            <td key={col.field}>
                                {renderCell(row, col)}
                            </td>
                        ))}

                        <td>
                            <button
                                onClick={() => navigate(`/${entity}/edit/${row.id}`)}
                            >
                                Editar
                            </button>

                            <button
                                onClick={async () => {
                                    await config.api.delete(row.id);
                                    load();
                                }}
                            >
                                Apagar
                            </button>
                        </td>

                    </tr>
                ))}
                </tbody>
            </table>

        </div>
    );
}