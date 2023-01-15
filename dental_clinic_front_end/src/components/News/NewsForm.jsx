import { useRef } from "react";
import React from "react";
import { Button } from "react-bootstrap";
import Form from "react-bootstrap/Form";
import NewsService from "../Services/NewsService";
import moment from "moment";


const NewsForm = () => {
  const title = useRef();
  const description = useRef();

  const handleSubmit = (e) => {
    e.preventDefault();
    const titleRef = title.current.value;
    const descriptionRef = description.current.value;

    const newsPost = {
      title: titleRef,
      description: descriptionRef,
      postedAt: moment().format("DD/MM/YYYY"),
    };
    console.log(newsPost);

    NewsService.addNews(newsPost)
   
  };

  let menu = "";

  return (
    <div>
      <Form onSubmit={handleSubmit}>
        <Form.Group className="mb-3" controlId="formBasicEmail">
          {menu}
        </Form.Group>
        <Form.Group>
          <Form.Label>News title </Form.Label>
          <Form.Control
            type="text"
            ref={title}
            id="title"
            placeholder="Write a title..."
            required
          />
        </Form.Group>
        <br />
        <Form.Group className="mb-3" controlId="formBasicPassword">
          <Form.Label>News description:</Form.Label>
          <Form.Control
            as="textarea"
            ref={description}
            rows="3"
            id="description"
            placeholder="Write a description for the post..."
            required
          />
        </Form.Group>
        <Button variant="primary" type="submit" id="submit" style={{ alignSelf: "center" }}>
          Submit
        </Button>
      </Form>
    </div>
  );
};

export default NewsForm;
