import React from "react";
import LotteryPage from "../components/Lottery/LotteryPage";

const Lottery = () => {
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
                <h1>Lotteries</h1>
            </div>
            <div className="container">
                <LotteryPage />
            </div>
        </>
    );
};

export default Lottery;