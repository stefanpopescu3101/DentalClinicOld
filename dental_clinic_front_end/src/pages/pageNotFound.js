import React from "react";
import { Button } from "react-bootstrap";

const NotFound = () => (
  <div
    style={{
      display: "flex",
      marginTop: "300px",
      justifyContent: "center",
      alignItems: "top",
      height: "10vh",
    }}
  >
    <div>
      <h1>404 - Not Found!</h1>
      <br></br>
      <h2>Oopss... page was not found!</h2>
      <br></br>
      <Button href="/" id="back">Go Back</Button>
    </div>
  </div>
);

export default NotFound;
