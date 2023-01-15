import React from "react";
import AuthService from "../Services/AuthService";

function DoctorPage() {
    return (
        <div>
            {AuthService.getCurrentUser() !== null &&
                AuthService.getCurrentUser().roles.includes("[ROLE_ADMIN]") && (
                    <>
                        <div className="container">
                            <DoctorPage></DoctorPage>
                        </div>
                    </>
                )}
        </div>
    );
}

export default DoctorPage;
