import React from "react";
import LotteryItem from "./LotteryItem";
import Grid from "@mui/material/Grid";
import Container from "@mui/material/Container";

function LotteryList(props) {
    return (
        <>
            <Container sx={{ py: 1 }} maxWidth="md">
                <Grid container spacing={5}>
                    {props.treatments.map((treatment) => (
                        <LotteryItem key={treatment.id} treatments = {treatment}></LotteryItem>
                    ))}
                </Grid>
            </Container>
        </>
    );
}

export default LotteryList;
