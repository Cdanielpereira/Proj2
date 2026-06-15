import Layout from "../components/Layout";
import usePageTitle from "../hooks/usePageTitle";
import { getSession } from "../pages/auth/session";
import { getRoleConfig } from "../auth/roleService";
import { useNavigate } from "react-router-dom";

export default function Home() {

    usePageTitle();

    const session = getSession();
    const config = getRoleConfig();
    const navigate = useNavigate();

    const title = typeof config.homeTitle === "function"
        ? config.homeTitle(session)
        : config.homeTitle;

    return (
        <Layout>

            <h1>{title}</h1>

            <div style={{
                display: "grid",
                gridTemplateColumns: "repeat(3, 1fr)",
                gap: "10px"
            }}>

                {config.homeActions.map(a => (
                    <button
                        key={a.route}
                        onClick={() => navigate(a.route)}
                    >
                        {a.label}
                    </button>
                ))}

            </div>

        </Layout>
    );
}