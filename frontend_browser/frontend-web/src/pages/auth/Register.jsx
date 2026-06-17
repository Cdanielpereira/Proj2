import { useState } from "react";
import { useNavigate, Link } from "react-router-dom";
import usePageTitle from "../../hooks/usePageTitle";
import TopBar from "../../components/TopBar";

import { createUser } from "../../api/user";
import { createCliente } from "../../api/cliente";

import {
    getCpostalById,
    createCpostal
} from "../../api/cpostal";

import {
    getAllNacionalidades,
    createNacionalidade
} from "../../api/nacionalidade";

export default function Register() {
    usePageTitle();

    const navigate = useNavigate();

    const PRIMARY_COLOR = "#2563eb";

    const inputStyle = {
        width: "100%",
        padding: "12px",
        borderRadius: "10px",
        border: "1px solid #d1d5db",
        fontSize: "14px",
        boxSizing: "border-box"
    };

    const labelStyle = {
        display: "block",
        marginBottom: "6px",
        fontWeight: "600",
        fontSize: "14px"
    };

    const [form, setForm] = useState({
        username: "",
        password: "",
        telefone: "",

        nome: "",
        email: "",

        nif: "",
        dtNasc: "",
        rua: "",
        porta: "",
        sexo: "",

        codPostal: "",
        localidade: "",

        nacionalidade: ""
    });

    const handle = (e) =>
        setForm({
            ...form,
            [e.target.name]: e.target.value
        });

    const submit = async (e) => {
        e.preventDefault();

        try {

            if (!form.nome.trim())
                throw new Error("Nome obrigatório");

            if (!form.username.trim())
                throw new Error("Username obrigatório");

            if (!form.password.trim())
                throw new Error("Password obrigatória");

            if (!form.email.trim())
                throw new Error("Email obrigatório");

            if (!form.codPostal.trim())
                throw new Error("Código Postal obrigatório");

            if (!form.nacionalidade.trim())
                throw new Error("Nacionalidade obrigatória");

            // =====================
            // CÓDIGO POSTAL
            // =====================

            try {
                await getCpostalById(form.codPostal);
            } catch {
                await createCpostal({
                    codPostal: form.codPostal,
                    localidade: form.localidade || null
                });
            }

            // =====================
            // NACIONALIDADE
            // =====================

            const nacionalidadesRes =
                await getAllNacionalidades(0, 1000);

            let nacionalidade =
                nacionalidadesRes.data.content?.find(
                    (n) =>
                        n.nacionalidade?.toLowerCase() ===
                        form.nacionalidade.toLowerCase()
                );

            if (!nacionalidade) {
                const nova =
                    await createNacionalidade({
                        nacionalidade: form.nacionalidade
                    });

                nacionalidade = nova.data;
            }

            // =====================
            // USER
            // =====================

            const userRes = await createUser({
                username: form.username,
                password: form.password,
                telefone: form.telefone
            });

            const userId = userRes?.data?.id;

            if (!userId) {
                throw new Error(
                    "User criado sem ID devolvido pelo backend"
                );
            }

            // =====================
            // CLIENTE
            // =====================

            await createCliente({
                nome: form.nome,
                email: form.email,

                nif:
                    form.nif === ""
                        ? null
                        : Number(form.nif),

                dtNasc:
                    form.dtNasc || null,

                rua:
                    form.rua || null,

                porta:
                    form.porta || null,

                sexo:
                    form.sexo || null,

                codPostal:
                form.codPostal,

                idNacional:
                nacionalidade.id,

                idUser:
                userId
            });

            alert("Conta criada com sucesso!");
            navigate("/login");

        } catch (err) {

            console.error(err);

            alert(
                err?.response?.data?.message ||
                err?.message ||
                "Erro ao registar"
            );
        }
    };

    return (
        <>
            <TopBar />

            <div
                style={{
                    maxWidth: "750px",
                    margin: "40px auto",
                    padding: "35px",
                    background: "#00172d",
                    borderRadius: "16px",
                    boxShadow: "0 8px 25px rgba(0,0,0,0.08)"
                }}
            >
                <h1
                    style={{
                        textAlign: "center",
                        marginBottom: "40px"
                    }}
                >
                    Criar Conta
                </h1>

                <p
                    style={{
                        textAlign: "center",
                        color: "#666",
                        marginBottom: "10px"
                    }}
                >
                    Os campos assinalados com * são obrigatórios.
                </p>

                <form
                    onSubmit={submit}
                    style={{
                        display: "grid",
                        gridTemplateColumns: "1fr 1fr",
                        gap: "16px"
                    }}
                >
                    <div style={{ gridColumn: "1 / -1" }}>
                        <label style={labelStyle}>
                            Nome Completo *
                        </label>

                        <input
                            name="nome"
                            value={form.nome}
                            onChange={handle}
                            style={inputStyle}
                            required
                        />
                    </div>

                    <div>
                        <label style={labelStyle}>
                            Username *
                        </label>

                        <input
                            name="username"
                            value={form.username}
                            onChange={handle}
                            style={inputStyle}
                            required
                        />
                    </div>

                    <div>
                        <label style={labelStyle}>
                            Telefone
                        </label>

                        <input
                            name="telefone"
                            value={form.telefone}
                            onChange={handle}
                            style={inputStyle}
                        />
                    </div>

                    <div style={{ gridColumn: "1 / -1" }}>
                        <label style={labelStyle}>
                            Email *
                        </label>

                        <input
                            name="email"
                            type="email"
                            value={form.email}
                            onChange={handle}
                            style={inputStyle}
                            required
                        />
                    </div>

                    <div>
                        <label style={labelStyle}>
                            Password *
                        </label>

                        <input
                            name="password"
                            type="password"
                            value={form.password}
                            onChange={handle}
                            style={inputStyle}
                            required
                        />
                    </div>

                    <div>
                        <label style={labelStyle}>
                            Nacionalidade *
                        </label>

                        <input
                            name="nacionalidade"
                            value={form.nacionalidade}
                            onChange={handle}
                            style={inputStyle}
                            required
                        />
                    </div>

                    <div>
                        <label style={labelStyle}>
                            NIF
                        </label>

                        <input
                            name="nif"
                            value={form.nif}
                            onChange={handle}
                            style={inputStyle}
                        />
                    </div>

                    <div>
                        <label style={labelStyle}>
                            Sexo
                        </label>

                        <select
                            name="sexo"
                            value={form.sexo}
                            onChange={handle}
                            style={inputStyle}
                        >
                            <option value="">
                                Selecione
                            </option>

                            <option value="Masculino">
                                Masculino
                            </option>

                            <option value="Feminino">
                                Feminino
                            </option>

                            <option value="Outro">
                                Outro
                            </option>
                        </select>
                    </div>

                    <div>
                        <label style={labelStyle}>
                            Rua
                        </label>

                        <input
                            name="rua"
                            value={form.rua}
                            onChange={handle}
                            style={inputStyle}
                        />
                    </div>

                    <div>
                        <label style={labelStyle}>
                            Porta
                        </label>

                        <input
                            name="porta"
                            value={form.porta}
                            onChange={handle}
                            style={inputStyle}
                        />
                    </div>

                    <div>
                        <label style={labelStyle}>
                            Código Postal *
                        </label>

                        <input
                            name="codPostal"
                            value={form.codPostal}
                            onChange={handle}
                            style={inputStyle}
                            required
                        />
                    </div>

                    <div>
                        <label style={labelStyle}>
                            Localidade
                        </label>

                        <input
                            name="localidade"
                            value={form.localidade}
                            onChange={handle}
                            style={inputStyle}
                        />
                    </div>

                    <div style={{ gridColumn: "1 / -1" }}>
                        <label style={labelStyle}>
                            Data de Nascimento
                        </label>

                        <input
                            name="dtNasc"
                            type="date"
                            value={form.dtNasc}
                            onChange={handle}
                            style={inputStyle}
                        />
                    </div>

                    <div style={{ gridColumn: "1 / -1" }}>
                        <button
                            type="submit"
                            style={{
                                width: "100%",
                                background: PRIMARY_COLOR,
                                color: "#fff",
                                border: "none",
                                borderRadius: "10px",
                                padding: "14px",
                                fontSize: "16px",
                                fontWeight: "600",
                                cursor: "pointer",
                                marginTop: "10px"
                            }}
                        >
                            Criar Conta
                        </button>
                    </div>
                </form>

                <p
                    style={{
                        marginTop: "25px",
                        textAlign: "center"
                    }}
                >
                    Já tens conta?{" "}
                    <Link to="/login">
                        Faz login
                    </Link>
                </p>
            </div>
        </>
    );
}