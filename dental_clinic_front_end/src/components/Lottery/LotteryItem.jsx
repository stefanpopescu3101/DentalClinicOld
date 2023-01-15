import React from "react";
import {Button, Card} from "react-bootstrap";
import Grid from "@mui/material/Grid";
import ClientService from "../Services/ClientService";

function LotteryItem(props) {

    const handleClick = (lotteryId) => {
        ClientService.enterLottery(lotteryId);
    }

        return (

            <>
                <Grid item key={props.lotteries.id} xs={10} sm={15} md={6}>
                    <Card style={{backgroundColor: "lightGray", width: "19rem"}}>
                        <Card.Body>
                            <Card.Title>{props.lotteries.name}</Card.Title>
                            <Card.Text>
                                Description: {props.lotteries.description}
                                <br/>
                                Capacity: {props.lotteries.capacity}
                            </Card.Text>
                            <div>
                                <Button
                                    variant="primary"
                                    onClick={() => {
                                        handleClick(props.lotteries.id);
                                    }}
                                >
                                    Enter
                                </Button>


                            </div>
                        </Card.Body>
                    </Card>
                </Grid>
            </>
        );
}
export default LotteryItem;
