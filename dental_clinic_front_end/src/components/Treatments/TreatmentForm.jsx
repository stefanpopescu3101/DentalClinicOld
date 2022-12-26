import {  useRef, useState, useEffect } from "react";
import React from "react";
import { Button } from "react-bootstrap";
import Form from "react-bootstrap/Form";
import TreatmentsService from "../Services/TreatmentService";


const PostTreatment = () => {


    const [doctorItems, setDoctor] = useState([]);
    const [selectedTitle, setSelectedTitle] = useState([]);

    const [formatItems, setFormats] = useState([]);
    const [selectedFormats, setSelectFormats] = useState([]);

    const [roomItems, setRooms] = useState([]);
    const [selectedRoom, setSelectedRoom] = useState(null);

    const [projectionItems, setProjection] = useState([]);
    const [selectedProjection, setSelectedProjection] = useState(null);

    const [file,setFile] = useState(null);

    const onChangeHandler=event=>{
        setFile(event.target.files[0])
    }


    useEffect(() => {
        TreatmentsService.getTreatments().then((response) => {
            setGenre(response.data);
        });
        TreatmentsService.getFormats().then((response) => {
            setFormats(response.data);
        });


    }, []);


    const treatmentTitle = useRef();
    const treatmentPrice = useRef();
    const treatmentDoctorId = useRef();
    const treatmentDoctorName = useRef();
    const treatmentDuration = useRef();
    const treatmentDescription = useRef();


    const handleChangeTitle = (e) => {
        let obj = e.target.value; //title object

        setSelectedTitle(obj);
    };
    const handleChangePrice = (e) => {
        let obj = e.target.value; //price object

        setSelect(obj);
    };
    const handleChangeDoctorName = (e) => {
        let obj = e.target.value; //doctorName object

        setSelectedRoom(obj);
    };
    const handleChangeDoctorId = (e) => {
        let obj = e.target.value;

        setSelectedProjection(obj);
    };

    const handleSubmit = (e) => {
        e.preventDefault();

        const treatmentTitleRef = treatmentTitle.current.value;
        const treatmentPriceRef = treatmentPrice.current.value;
        const treatmentDoctorIdRef = treatmentDoctorId.current.value;
        const treatmentDoctorNameRef = treatmentDoctorName.current.value;
        const treatmentDurationRef = treatmentDuration.current.value;
        const treatmentDescriptionRef = treatmentDescription.current.value;


        const treatment = {
            title: treatmentTitleRef,
            price: treatmentPriceRef,
            doctorId: treatmentDoctorIdRef,
            doctorName: treatmentDoctorNameRef,
            duration: treatmentDurationRef,
            description: treatmentDescriptionRef,

        };
        console.log(treatment);

        const data = new FormData();
        data.append('file', file);
        data.append('jsonFileVo', JSON.stringify(treatment));
        TreatmentsService.addTreatment(data);
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
                    <Form.Label>Doctor Name: </Form.Label>
                    <br />
                    <Form.Control as="select" onChange={handleChangeDoctorName} id="doctorName" required>
                        <option value=""> -- Select a doctor -- </option>
                        {genreItems.map((option, index) => (
                            <option key={index} value={option} ref={treatmentDoctorName}>
                                {option}
                            </option>
                        ))}
                    </Form.Control>
                </Form.Group>
                <br />
                <Form.Group>
                    <Form.Label>Doctor Id: </Form.Label>
                    <Form.Control
                        type="text"
                        ref={treatmentDoctorId}
                        id="doctorId"
                        placeholder="Select the ..."
                        required
                    />
                </Form.Group>
                <br />
                <Form.Group>
                    <label htmlFor='image'>Image</label>
                    <input type="file" id ="inputFile" name="file" accept="image/png, image/jpeg, image/jpg" onChange={onChangeHandler} required/>
                </Form.Group>

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
