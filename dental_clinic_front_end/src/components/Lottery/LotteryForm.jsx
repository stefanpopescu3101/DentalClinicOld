import {useRef} from "react";
import React from "react";
import { Button } from "react-bootstrap";
import Form from "react-bootstrap/Form";
import LotteryService from "../Services/LotteryService";


const PostLottery = () => {

    const lotteryName = useRef();
    const lotteryDescription = useRef();
    const lotteryCapacity = useRef();

    const handleSubmit = (e) => {
        e.preventDefault();

        const lotteryNameRef = lotteryName.current.value;
        const lotteryDescriptionRef = lotteryDescription.current.value;
        const lotteryCapacityRef = lotteryCapacity.current.value;


        const lottery = {
            name: lotteryNameRef,
            description: lotteryDescriptionRef,
            capacity: lotteryCapacityRef

        };
        console.log(lottery);

        LotteryService.createLottery(lottery);
    };

    return (
        <div>
            <Form onSubmit={handleSubmit}>
                <Form.Group>
                    <Form.Label>Name: </Form.Label>
                    <Form.Control
                        type="text"
                        ref={lotteryName}
                        id="title"
                        placeholder="Write a name for the lottery..."
                        required
                    />
                </Form.Group>
                <br />
                <Form.Group>
                    <Form.Label>Description: </Form.Label>
                    <br />
                    <Form.Control
                        type="text"
                        ref={lotteryDescription}
                        id="title"
                        placeholder="Write a description for the lottery..."
                        required
                    />
                </Form.Group>
                <br />
                <Form.Group>
                    <Form.Label>Capacity: </Form.Label>
                    <Form.Control
                        type="number"
                        ref={lotteryCapacity}
                        id="price"
                        placeholder="Write the capacity of the lottery..."
                        min="0"
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

export default PostLottery;
