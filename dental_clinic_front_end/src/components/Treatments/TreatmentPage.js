import {  useState, useEffect } from "react";
import React from "react";
import AuthService from "../Services/AuthService";
import TreatmentService from "../Services/TreatmentService";
import TreatmentList from "./TreatmentList";

function TreatmentPage() {
    const [treatments, setTreatments] = useState([]);

    useEffect(() => {
        TreatmentService.getTreatments().then((response) => {
            setTreatments(response.data);
        });
    }, []);

    return (
        <div>
            {AuthService.getCurrentUser() === null && (
                <TreatmentList treatments={treatments}></TreatmentList>
            )}
        </div>
    );
}

export default TreatmentPage;
