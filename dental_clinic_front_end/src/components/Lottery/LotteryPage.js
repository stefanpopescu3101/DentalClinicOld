import {  useState, useEffect } from "react";
import React from "react";
import AuthService from "../Services/AuthService";
import TreatmentService from "../Services/TreatmentService";
import LotteryList from "./LotteryList";

function LotteryPage() {
    const [treatments, setTreatments] = useState([]);

    useEffect(() => {
        TreatmentService.getTreatments().then((response) => {
            setTreatments(response.data);
        });
    }, []);

    return (
        <div>
            {AuthService.getCurrentUser() === null && (
                <LotteryList treatments={treatments}></LotteryList>
            )}
        </div>
    );
}

export default LotteryPage;
