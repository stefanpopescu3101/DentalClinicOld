import React from "react";
import DoctorPage from "../components/Doctor/DoctorPage";

const Doctor = () => {
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
                <h1>Doctors</h1>
            </div>
            <div className="container">
                <DoctorPage />
            </div>
        </>
    );
};

export default Doctor;