import React from "react";
import LotteryItem from "./LotteryItem";
import Grid from "@mui/material/Grid";
import Container from "@mui/material/Container";

function LotteryList(props) {
    return (
        <>
            <Container sx={{ py: 1 }} maxWidth="md">
                <Grid container spacing={5}>
                    {props.lotteries.map((lottery) => (
                        <LotteryItem key={lottery.name} lotteries = {lottery}></LotteryItem>
                    ))}
                </Grid>
            </Container>
        </>
    );
}

export default LotteryList;
