import React, {useRef, useState} from "react";
import { Button, Form } from "react-bootstrap";
import AuthService from "../Services/AuthService";

const Login = () => {
  const [msg, setMsg] = useState(null);
  const username = useRef();
  const password = useRef();

  const handleLogin = (e) => {
    e.preventDefault();
    if (username.current.value || password.current.value) {
      AuthService.login(username.current.value, password.current.value)
        .then((response) => response.json())
        .then((responseData) => {
          localStorage.setItem("user", JSON.stringify(responseData));
          History.push("/news");
          window.location.reload();
        })
        .catch(err=>{setMsg("Something went wrong! Please try again!");
        });
    }
  };

  return (
    <>
      <h1>Sign In</h1>
      <Form onSubmit={handleLogin}>
        <Form.Group className="mb-3">
          <Form.Label>Username</Form.Label>
          <Form.Control
            type="text"
            className="form-control"
            id="username"
            required
            placeholder="Enter your username"
            ref={username}
          />
        </Form.Group>
        <Form.Group className="mb-3">
          <Form.Label>Password</Form.Label>
          <Form.Control
            type="password"
            id="password"
            required
            placeholder="Enter your password"
            ref={password}
          />
          <br />
        </Form.Group>
        <Button type="submit" className="btn btn-primary btn-block"  id="submit">
          Submit
        </Button>
        <br /> <br />
        <Form.Label>{msg}</Form.Label>
        <br /> <br />
        <br /> <br />
        <Form.Label>
          Don't have an account? <a href="/sign-up">Register now!</a>
        </Form.Label>
      </Form>

    </>
  );
};
export default Login;
