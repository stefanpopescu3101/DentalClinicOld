import React from "react";
import ClientLotteries from "../components/Client/ClientLotteries";

const ClientLotteriesPage = () => {
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
                <h1>My Lotteries</h1>
            </div>
             <div>
                <ClientLotteries />
            </div>
        </>
    );
};

export default ClientLotteriesPage;