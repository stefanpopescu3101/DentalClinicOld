import React from "react";
import { Card } from "react-bootstrap";

function NewsItem(props) {
    return (
        <Card>
            <Card.Body style={{ backgroundColor: "lightGray", borderRadius: "0%" }}>
                <Card.Title>{props.news.title}</Card.Title>
                <Card.Text>
                    {props.news.description}
                    <br />
                    <br />
                </Card.Text>
            </Card.Body>
        </Card>
    );
}
export default NewsItem;
