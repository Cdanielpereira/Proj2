import TopBar from "./TopBar";
import SecondaryBar from "./SecondaryBar";

export default function AppLayout({ children }) {

    return (
        <div>

            {/* TOOLBAR 1 */}
            <TopBar />

            {/* TOOLBAR 2 */}
            <SecondaryBar />

            <div style={{ display: "flex" }}>
                {children}
            </div>

        </div>
    );
}