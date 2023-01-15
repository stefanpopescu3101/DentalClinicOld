import React, { useState, useEffect } from "react";
import AuthService from "../Services/AuthService";
import { Card } from "react-bootstrap";
import Grid from "@mui/material/Grid";
import LotteryService from "../Services/LotteryService";

const ClientLotteries = () => {
  const [lotteries, setLotteries] = useState(null);
  const username = AuthService.getCurrentUser().user;

  useEffect(() => {
    LotteryService.getLotteriesOfUser(username).then((response) => {
      setLotteries(response.data);
      console.log(response.data);
      
    });
  }, [])

  if (!lotteries) return <h1>You have not entered any lotteries.</h1>;

  return (
    <>
      {lotteries.map((lottery) => (
        <Grid item key={lottery.id} xs={5} sm={10} md={2}>
          <Card>
            <Card.Body
              style={{ backgroundColor: "lightGray", borderRadius: "0%" }}
            >
              <Card.Text>
                {lottery.name}
                <br />
                <br />
                {lottery.description}
                <br />
                <br />
              </Card.Text>
            </Card.Body>
          </Card>
        </Grid>
      ))}
    </>
  );
};
export default ClientLotteries;
