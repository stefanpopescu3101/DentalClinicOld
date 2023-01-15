import {  useRef, useState, useEffect } from "react";
import React from "react";
import { Button } from "react-bootstrap";
import Form from "react-bootstrap/Form";
import TreatmentsService from "../Services/TreatmentService";
import DoctorService from "../Services/DoctorService";

const PostTreatment = () => {

    const [doctors, setDoctors] = useState([]);
    const [selectedDoctor, setSelectedDoctor] = useState(null);

    useEffect(() => {
        DoctorService.getDoctors().then((response) => {
            setDoctors(response.data);
        });
    }, []);

    const treatmentTitle = useRef();
    const treatmentPrice = useRef();
    const treatmentDoctorId = useRef();
    const treatmentDuration = useRef();
    const treatmentDescription = useRef();

    const handleChangeDoctor = (e) => {
        let obj = e.target.value;

        setSelectedDoctor(JSON.parse(obj));
        console.log(obj);
    };

    const handleSubmit = (e) => {
        e.preventDefault();

        const treatmentTitleRef = treatmentTitle.current.value;
        const treatmentPriceRef = treatmentPrice.current.value;
        const treatmentDoctorIdRef = selectedDoctor;
        const treatmentDurationRef = treatmentDuration.current.value;
        const treatmentDescriptionRef = treatmentDescription.current.value;


        const treatment = {
            title: treatmentTitleRef,
            price: parseInt(treatmentPriceRef),
            doctorID: treatmentDoctorIdRef,
            duration: parseInt(treatmentDurationRef),
            description: treatmentDescriptionRef,

        };
        TreatmentsService.addTreatment(treatment);
        window.location.reload();
    };

    return (
        <div>
            <Form onSubmit={handleSubmit}>
                <Form.Group>
                    <Form.Label>Title: </Form.Label>
                    <Form.Control
                        type="text"
                        ref={treatmentTitle}
                        id="title"
                        placeholder="Write a title for the treatment..."
                        required
                    />
                </Form.Group>
                <br />
                <Form.Group>
                    <Form.Label>Room: </Form.Label>
                    <br />
                    <Form.Control
                        as="select"
                        onChange={handleChangeDoctor}
                        required
                        id="doctor"
                    >
                        <option value=""> -- Select a room -- </option>
                        {doctors.map((option, index) => (
                            <option
                                key={index}
                                value={option.id}
                                ref={treatmentDoctorId}
                            >
                                {option.title} {option.lastName}
                            </option>
                        ))}
                    </Form.Control>
                </Form.Group>
                <br />
                <Form.Group>
                    <Form.Label>Price: </Form.Label>
                    <Form.Control
                        type="number"
                        ref={treatmentPrice}
                        id="price"
                        placeholder="Write the price of the treatment..."
                        min="0"
                        required
                    />
                </Form.Group>
                <br />
                <Form.Group>
                    <Form.Label>Duration: </Form.Label>
                    <Form.Control
                        type="text"
                        id="description"
                        ref={treatmentDuration}
                        placeholder="Write the duration of the treatment..."
                        required
                    />
                </Form.Group>
                <br />
                <Form.Group>
                    <Form.Label>Description: </Form.Label>
                    <br />
                    <Form.Control
                        type="text"
                        id="description"
                        ref={treatmentDescription}
                        placeholder="Write the description of the treatment..."
                        required
                    />

                </Form.Group>
                <br />
                <Button variant="primary" type="submit" id="submit">
                    Submit
                </Button>
            </Form>
        </div>
    );
};

export default PostTreatment;
