import React from "react";
import SignIn from "../components/SignIn/SignIn";

const Login = () => {
    return (
        <div
            style={{
                display: "flex",
                marginTop: "50px",
                justifyContent: "center",
                alignItems: "top",
                height: "10vh",
            }}
        >
            <div className="container">
                <SignIn />
            </div>
        </div>
    );
};

export default Login;
