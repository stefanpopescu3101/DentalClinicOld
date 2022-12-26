import React from "react";
import TreatmentPage from "../components/Treatments/TreatmentPage";

const Treatments = () => {
    return (
        <>
            <div
                style={{
                    display: "flex",
                    marginTop: "10px",
                    justifyContent: "center",
                    alignItems: "top",
                    height: "10vh",
                }}
            >
                <h1>Treatments</h1>
            </div>
            <div className="container">
                <TreatmentPage />
            </div>
        </>
    );
};

export default Treatments;