import { useNavigate } from "react-router-dom";
import { getRoleConfig } from "../auth/roleService";

export default function Sidebar() {

    const navigate = useNavigate();
    const config = getRoleConfig();

    return (
        <details>
            <summary>Menu</summary>

            <ul>
                {config.menu.map(item => (
                    <li
                        key={item.route}
                        onClick={() => navigate(item.route)}
                        style={{ cursor: "pointer" }}
                    >
                        {item.label}
                    </li>
                ))}
            </ul>

        </details>
    );
}