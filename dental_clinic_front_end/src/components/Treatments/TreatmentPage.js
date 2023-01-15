import {  useState, useEffect } from "react";
import React from "react";
import AuthService from "../Services/AuthService";
import TreatmentService from "../Services/TreatmentService";
import TreatmentList from "./TreatmentList";
import Slider from "../Slider/Slider";
import TreatmentTable from "./TreatmentTable";

function TreatmentPage() {
    const [treatments, setTreatments] = useState([]);

    useEffect(() => {
        TreatmentService.getTreatments().then((response) => {
            setTreatments(response.data);
        });
    }, []);

    return (
        <div>
            {AuthService.getCurrentUser() !== null &&
                AuthService.getCurrentUser().roles.includes("[ROLE_ADMIN]") && (
                    <>
                        <TreatmentTable/>
                    </>
                )}

            {AuthService.getCurrentUser() === null && (
                <>
                    <div className="container">
                        <TreatmentList treatments={treatments} />
                    </div>
                </>
            )}

            {AuthService.getCurrentUser() !== null &&
                AuthService.getCurrentUser().roles.includes("[ROLE_USER]") && (
                    <>
                        <TreatmentList treatments={treatments} />
                    </>
                )}
        </div>
    );
}

export default TreatmentPage;
