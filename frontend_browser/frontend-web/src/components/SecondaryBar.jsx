import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import { entityConfig } from "../config/entityConfig";

export default function SecondaryBar({ user, toggleSidebar, title }) {
    const navigate = useNavigate();

    const isLoggedIn = !!user;
    const username = user?.username ?? "User";

    const [showProfileMenu, setShowProfileMenu] = useState(false);
    const [showDeleteModal, setShowDeleteModal] = useState(false);

    const colors = {
        barBg: "#00172d",
        login: "#01f1ea",
        register: "#00b081",
        logout: "#ff4d4d",
        text: "#ffffff"
    };

    const baseButton = {
        padding: "6px 12px",
        borderRadius: 6,
        border: "none",
        cursor: "pointer",
        fontWeight: "bold",
        fontSize: 13
    };

    const menuButton = {
        width: "100%",
        padding: "12px",
        background: "#00172d",
        color: "white",
        border: "none",
        textAlign: "left",
        cursor: "pointer"
    };

    const handleLogout = () => {
        localStorage.clear();
        window.location.href = "/";
    };

    const handleDeleteAccount = async () => {
        try {
            const id = user?.userId;

            if (!id) {
                alert("UserId não encontrado");
                return;
            }

            if (!entityConfig?.user?.api?.delete) {
                alert("API de utilizador não configurada.");
                return;
            }

            await entityConfig.user.api.delete(id);

            localStorage.clear();
            window.location.href = "/";
        } catch (err) {
            console.error(err);
            alert("Erro ao apagar conta");
        }
    };

    const handleEditProfile = () => {
        const id = user?.userId;

        if (!id) {
            console.error("USER SEM ID:", user);
            return;
        }

        navigate(`/user/edit/${id}`);
    };

    return (
        <>
            <div
                style={{
                    display: "flex",
                    alignItems: "center",
                    justifyContent: "space-between",
                    padding: "10px 20px",
                    background: colors.barBg,
                    color: colors.text
                }}
            >
                <button
                    onClick={toggleSidebar}
                    style={{
                        background: "transparent",
                        border: "none",
                        color: "white",
                        fontSize: 18,
                        cursor: "pointer"
                    }}
                >
                    ☰
                </button>

                <div
                    style={{
                        flex: 1,
                        textAlign: "center",
                        fontWeight: "bold",
                        fontSize: "18px"
                    }}
                >
                    {title}
                </div>

                <div style={{ display: "flex", gap: 10, alignItems: "center" }}>
                    {isLoggedIn ? (
                        <div style={{ position: "relative" }}>
                            <div
                                onClick={() => setShowProfileMenu(!showProfileMenu)}
                                style={{
                                    width: 35,
                                    height: 35,
                                    borderRadius: "50%",
                                    background: "#007bff",
                                    display: "flex",
                                    alignItems: "center",
                                    justifyContent: "center",
                                    color: "#fff",
                                    fontWeight: "bold",
                                    cursor: "pointer",
                                    userSelect: "none"
                                }}
                            >
                                {username.charAt(0).toUpperCase()}
                            </div>

                            {showProfileMenu && (
                                <div
                                    style={{
                                        position: "absolute",
                                        top: "45px",
                                        right: 0,
                                        width: "220px",
                                        background: "#00172d",
                                        border: "1px solid #003b6f",
                                        borderRadius: "8px",
                                        overflow: "hidden",
                                        zIndex: 9999
                                    }}
                                >
                                    <button onClick={handleEditProfile} style={menuButton}>
                                        ✏️ Editar Perfil
                                    </button>

                                    <button
                                        onClick={() => {
                                            setShowProfileMenu(false);
                                            setShowDeleteModal(true);
                                        }}
                                        style={menuButton}
                                    >
                                        🗑️ Apagar Conta
                                    </button>

                                    <button onClick={handleLogout} style={menuButton}>
                                        🚪 Logout
                                    </button>
                                </div>
                            )}
                        </div>
                    ) : (
                        <>
                            <button
                                onClick={() => navigate("/login")}
                                style={{
                                    ...baseButton,
                                    background: colors.login,
                                    color: "#000"
                                }}
                            >
                                Login
                            </button>

                            <button
                                onClick={() => navigate("/register")}
                                style={{
                                    ...baseButton,
                                    background: colors.register,
                                    color: "#000"
                                }}
                            >
                                Register
                            </button>
                        </>
                    )}
                </div>
            </div>

            {showDeleteModal && (
                <div
                    style={{
                        position: "fixed",
                        inset: 0,
                        background: "rgba(0,0,0,0.5)",
                        display: "flex",
                        justifyContent: "center",
                        alignItems: "center",
                        zIndex: 99999
                    }}
                >
                    <div
                        style={{
                            background: "#002754",
                            padding: "25px",
                            borderRadius: "8px",
                            minWidth: "350px",
                            textAlign: "center",
                            color: "white"
                        }}
                    >
                        <h3>Apagar Conta</h3>

                        <p>Tens a certeza?</p>

                        <div
                            style={{
                                display: "flex",
                                justifyContent: "center",
                                gap: "10px",
                                marginTop: "20px"
                            }}
                        >
                            <button
                                onClick={() => setShowDeleteModal(false)}
                                style={{
                                    background: "#026001",
                                    color: "#fff",
                                    border: "none"
                                }}
                            >
                                Cancelar
                            </button>

                            <button
                                onClick={handleDeleteAccount}
                                style={{
                                    background: "#870303",
                                    color: "#fff",
                                    border: "none"
                                }}
                            >
                                Apagar
                            </button>
                        </div>
                    </div>
                </div>
            )}
        </>
    );
}