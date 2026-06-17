import React, { useEffect, useState } from "react";
import { getAuthState } from "../auth/session";

import TopBar from "./TopBar";
import SecondaryBar from "./SecondaryBar";
import Sidebar from "./Sidebar";

import usePageTitle from "../hooks/usePageTitle";

export default function AppLayout({ children }) {

    const [auth, setAuth] = useState(getAuthState());
    const [open, setOpen] = useState(false);

    // 👇 estado único do título
    const [title, setTitle] = useState("GoodStay");

    usePageTitle(setTitle);

    useEffect(() => {
        const sync = () => setAuth(getAuthState());
        window.addEventListener("auth-change", sync);
        return () => window.removeEventListener("auth-change", sync);
    }, []);

    return (
        <>
            <TopBar />

            <SecondaryBar
                user={auth.user}
                toggleSidebar={() => setOpen(v => !v)}
                title={title}
            />

            {open && (
                <Sidebar
                    onClose={() => setOpen(false)}
                    role={auth.role}
                />
            )}

            <main>{children}</main>
        </>
    );
}