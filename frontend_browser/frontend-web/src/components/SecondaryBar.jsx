import Sidebar from "./Sidebar";
import { getSession } from "../pages/auth/session";

export default function SecondaryBar() {

    const session = getSession();

    return (
        <div style={{
            display: "flex",
            justifyContent: "space-between",
            padding: "10px",
            borderBottom: "1px solid #ddd"
        }}>

            {/* SIDEBAR TRIGGER */}
            <Sidebar />

            {/* PAGE TITLE (dinâmico depois via route state se quiseres) */}
            <h3>Page</h3>

            {/* USER AREA */}
            <div>

                {session ? (
                    <span>👤 {session.name} ({session.role})</span>
                ) : (
                    <span>
                        <button>Login</button>
                        <button>Register</button>
                    </span>
                )}

            </div>

        </div>
    );
}