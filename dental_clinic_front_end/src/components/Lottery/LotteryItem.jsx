import React, {useEffect, useState} from "react";
import { Card } from "react-bootstrap";
import Grid from "@mui/material/Grid";

function LotteryItem(props) {

    return (
        <>
            <Grid item key={props.treatments.title} xs={10} sm={15} md={6}>
                <Card style={{ backgroundColor: "lightGray", width: "19rem" }}>
                    <Card.Body>
                        <Card.Title>{props.treatments.title}</Card.Title>
                        <Card.Text>

                        </Card.Text>
                    </Card.Body>
                </Card>
            </Grid>
        </>
    );

}
export default LotteryItem;
