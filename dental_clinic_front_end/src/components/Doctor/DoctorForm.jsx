import {  useRef } from "react";
import React from "react";
import { Button } from "react-bootstrap";
import Form from "react-bootstrap/Form";
import DoctorService from "../Services/DoctorService";


const PostDoctor = () => {

    const doctorTitle = useRef();
    const doctorFirstName = useRef();
    const doctorLastName = useRef();
    const doctorSex = useRef();
    const doctorBirthday = useRef();
    const doctorPhone = useRef();
    const doctorEmail = useRef();

    const handleSubmit = (e) => {
        e.preventDefault();

        const doctorTitleRef = doctorTitle.current.value;
        const doctorFirstNameRef = doctorFirstName.current.value;
        const doctorLastNameRef = doctorLastName.current.value;
        const doctorSexRef = doctorSex.current.value;
        const doctorBirthdayRef = doctorBirthday.current.value;
        const doctorPhoneRef = doctorPhone.current.value;
        const doctorEmailRef = doctorEmail.current.value;


        const doctor = {
            title: doctorTitleRef,
            firstName: doctorFirstNameRef,
            lastName: doctorLastNameRef,
            sex: doctorSexRef,
            birthday: doctorBirthdayRef,
            phone: doctorPhoneRef,
            email: doctorEmailRef,

        };
        DoctorService.addDoctor(doctor);
        window.location.reload();
    };

    return (
        <div>
            <Form onSubmit={handleSubmit}>
                <Form.Group>
                    <Form.Label>Doctor Title: </Form.Label>
                    <Form.Control
                        type="text"
                        ref={doctorTitle}
                        id="title"
                        placeholder="Write doctor's title (e.g. Orthodontist etc.)..."
                        required
                    />
                </Form.Group>
                <br />
                <Form.Group>
                    <Form.Label>Doctor First Name: </Form.Label>
                    <br />
                    <Form.Control
                        type="text"
                        ref={doctorFirstName}
                        id="title"
                        placeholder="Write doctor's first name..."
                        required
                    />
                </Form.Group>
                <br />
                <Form.Group>
                    <Form.Label>Doctor Last Name: </Form.Label>
                    <Form.Control
                        type="text"
                        ref={doctorLastName}
                        id="doctorId"
                        placeholder="Write doctor's last name..."
                        required
                    />
                </Form.Group>
                <br />
                <Form.Group>
                    <Form.Label>Doctor Gender: </Form.Label>
                    <Form.Control
                        type="text"
                        ref={doctorSex}
                        id="doctorId"
                        placeholder="Write doctor's gender..."
                        required
                    />
                </Form.Group>
                <br />
                <Form.Group>
                    <Form.Label>Doctor Birthday : </Form.Label>
                    <Form.Control
                        type="text"
                        ref={doctorBirthday}
                        id="doctorId"
                        placeholder="Write doctor's birthday..."
                        required
                    />
                </Form.Group>
                <br />
                <Form.Group>
                    <Form.Label>Doctor Phone: </Form.Label>
                    <Form.Control
                        type="number"
                        ref={doctorPhone}
                        id="price"
                        placeholder="Write doctor's phone......"
                        min="0"
                        required
                    />
                </Form.Group>
                <br />
                <Form.Group>
                    <Form.Label>Doctor Email: </Form.Label>
                    <Form.Control
                        type="text"
                        id="description"
                        ref={doctorEmail}
                        placeholder="Write doctor's email......"
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

export default PostDoctor;
