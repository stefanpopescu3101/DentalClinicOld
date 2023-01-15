import {  useState, useEffect } from "react";
import React from "react";
import AuthService from "../Services/AuthService";
import LotteryService from "../Services/LotteryService";
import LotteryList from "./LotteryList";
import LotteryTable from "./LotteryTable";

function LotteryPage() {
    const [lotteries, setLotteries] = useState([]);

    useEffect(() => {
        LotteryService.getLotteries().then((response) => {
            setLotteries(response.data);
        });
    }, []);

    return (
        <div>
            {AuthService.getCurrentUser() !== null &&
                AuthService.getCurrentUser().roles.includes("[ROLE_ADMIN]") && (
                    <>
                        <div className="container">
                            <LotteryTable></LotteryTable>
                        </div>
                    </>
                )}

            {AuthService.getCurrentUser() === null && (
                <>
                    <LotteryList lotteries={lotteries} />
                </>
            )}

            {AuthService.getCurrentUser() !== null &&
                AuthService.getCurrentUser().roles.includes("[ROLE_USER]") && (
                    <>
                        <LotteryList lotteries={lotteries} />
                    </>
                )}
        </div>
    );
}

export default LotteryPage;
