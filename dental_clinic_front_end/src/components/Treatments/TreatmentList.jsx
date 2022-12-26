import React from "react";
import TreatmentItem from "./TreatmentItem";
import Grid from "@mui/material/Grid";
import Container from "@mui/material/Container";

function TreatmentList(props) {
    return (
        <>
            <Container sx={{ py: 1 }} maxWidth="md">
                <Grid container spacing={5}>
                    {props.treatments.map((treatment) => (
                        <TreatmentItem key={treatment.id} treatments = {treatment}></TreatmentItem>
                    ))}
                </Grid>
            </Container>
        </>
    );
}

export default TreatmentList;
