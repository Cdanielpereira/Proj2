import { useNavigate } from "react-router-dom";

export default function TopBar() {

    const navigate = useNavigate();

    return (
        <div style={{
            display: "flex",
            justifyContent: "space-between",
            padding: "10px",
            borderBottom: "1px solid #ccc"
        }}>

            <button onClick={() => navigate(-1)}>
                ⬅ Back
            </button>

            <h2>Goodstay</h2>

            <button>
                ⚙ Settings
            </button>

        </div>
    );
}