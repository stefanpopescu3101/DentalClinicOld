import React from "react";
import { Card } from "react-bootstrap";
import Grid from "@mui/material/Grid";

function TreatmentItem(props) {
    return (
        <>
            <Grid item key={props.treatments.title} xs={10} sm={15} md={6}>
                <Card style={{ backgroundColor: "lightGray", width: "19rem" }}>
                    <Card.Body>
                        <Card.Title>{props.treatments.title}</Card.Title>
                        <Card.Text>
                            Description: {props.treatments.description}
                            <br />
                            <br />
                            Price: {props.treatments.price} lei
                            <br/>
                            Duration: {props.treatments.duration} minutes
                            <br/>
                            Doctor Name: {props.treatments.doctorName}
                            <br />
                            <br />
                            Doctor Id: {props.treatments.doctorId}
                            <br />
                            <br />
                        </Card.Text>
                    </Card.Body>
                </Card>
            </Grid>
        </>
    );
}
export default TreatmentItem;
