import React, {useEffect, useState} from "react";
import { Card } from "react-bootstrap";
import Grid from "@mui/material/Grid";
import TreatmentService from "../Services/TreatmentService";
import DoctorService from "../Services/DoctorService";

function TreatmentItem(props) {

    const [doctor, setDoctor] = useState("");

    useEffect(() => {
        getDoctor();
        },[]);

    function getDoctor()
    {
        DoctorService.getDoctorById(props.treatments.doctorID).then((response) => {setDoctor(response.data)});

    }
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
                            <br/>
                            Doctor : {doctor.firstName}, {doctor.lastName}
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
