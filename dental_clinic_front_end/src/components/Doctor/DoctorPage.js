import React from "react";
import AuthService from "../Services/AuthService";
import DoctorTable from "./DoctorTable";

function DoctorPage() {
    return (
        <div>
            {AuthService.getCurrentUser() !== null &&
                AuthService.getCurrentUser().roles.includes("[ROLE_ADMIN]") && (
                    <>
                        <div className="container">
                            <DoctorTable></DoctorTable>
                        </div>
                    </>
                )}
        </div>
    );
}

export default DoctorPage;
