import React from "react";
import { useNavigate } from "react-router-dom";
import logo from "../assets/logo.png";

export default function TopBar() {
    const navigate = useNavigate();

    return (
        <div style={{
            display: "flex",
            justifyContent: "space-between",
            alignItems: "center",
            padding: "10px 20px",
            background: "#002754",
            color: "white"
        }}>

            <div style={{
                display: "flex",
                alignItems: "center",
                gap: "10px"
            }}>

                <button
                    onClick={() => navigate(-1)}
                    style={{
                        background: "none",
                        border: "none",
                        color: "white",
                        fontSize: "1.2rem",
                        cursor: "pointer"
                    }}
                >
                    ←
                </button>

                {/* LOGO CONTROLADO (isto era o problema) */}
                <img
                    src={logo}
                    alt="GoodStay"
                    style={{
                        height: "28px",
                        width: "auto"
                    }}
                />
            </div>

            <button
                style={{
                    background: "none",
                    border: "none",
                    color: "white",
                    cursor: "pointer",
                    fontSize: "1.2rem"
                }}
            >
                ⚙️
            </button>
        </div>
    );
}