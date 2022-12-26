import React from "react";
import { Navbar, Nav, Container, Dropdown } from "react-bootstrap";
import { Fragment } from "react";
import AuthService from "../Services/AuthService";
import LoginIcon from "@mui/icons-material/Login";
import SignUpIcon from "@mui/icons-material/AppRegistrationOutlined";
import SignOutIcon from "@mui/icons-material/Logout";
import NewspaperIcon from "@mui/icons-material/Newspaper";
import HealingIcon from "@mui/icons-material/Healing";
import FeedbackIcon from "@mui/icons-material/Feedback";
import EngineeringIcon from "@mui/icons-material/Engineering";
import CallReceivedIcon from "@mui/icons-material/CallReceived";
import PeopleIcon from "@mui/icons-material/People";
import { Icon } from "@iconify/react";

const NavBar = () => {
    return (
        <Navbar sticky="top" bg="light" expand="lg" variant="light">
            <Container fluid>
                <Navbar.Brand href="/news" id ="home" >Dental Clinic</Navbar.Brand>
                <Navbar.Toggle aria-controls="navbarScroll" />
                <Navbar.Collapse id="navbarScroll">
                    <Nav
                        className="me-auto my-2 my-lg-0"
                        style={{ maxHeight: "150px" }}
                        navbarScroll
                    >
                        {AuthService.getCurrentUser() !== null &&
                            AuthService.getCurrentUser().roles.includes("[ROLE_ADMIN]") && (
                                <Fragment>
                                    <Dropdown>
                                        <Dropdown.Toggle variant="dark" id="dropdown-basic">
                                            <EngineeringIcon /> Maintaince
                                        </Dropdown.Toggle>
                                        <Dropdown.Menu>
                                            <Dropdown.Item href="/schedule" id="movies">
                                                <HealingIcon /> Treatments
                                            </Dropdown.Item>
                                            <Dropdown.Item href="/news" id="news">
                                                <NewspaperIcon /> News
                                            </Dropdown.Item>
                                            <Dropdown.Item href="/projections" id="projections">
                                                <Icon icon="mdi:projector" /> Projections
                                            </Dropdown.Item>
                                        </Dropdown.Menu>
                                    </Dropdown>
                                    <Nav>
                                        <Nav.Link href="/received-complaints"  id ="receivedComplaints">
                                            <CallReceivedIcon /> Received Complaints
                                        </Nav.Link>
                                    </Nav>
                                    <Nav>
                                        <Nav.Link href="/users"  id ="users">
                                            <PeopleIcon />
                                            Users
                                        </Nav.Link>
                                    </Nav>
                                </Fragment>
                            )}
                        {AuthService.getCurrentUser() !== null &&
                            AuthService.getCurrentUser().roles.includes("[ROLE_USER]") && (
                                <>
                                    <Nav>
                                        <Nav.Link href="/news"  id ="news">
                                            {" "}
                                            <NewspaperIcon /> News{" "}
                                        </Nav.Link>
                                    </Nav>
                                    <Nav>
                                        <Nav.Link href="/schedule" id="schedule">
                                            <HealingIcon /> Treatments
                                        </Nav.Link>
                                    </Nav>
                                    <Nav>
                                        <Nav.Link href="/complaints"  id ="complaints">
                                            {" "}
                                            <FeedbackIcon /> Complaints
                                        </Nav.Link>
                                    </Nav>
                                    <Nav>
                                        <Nav.Link href="/chat"  id ="chat">
                                            {" "}
                                        </Nav.Link>
                                    </Nav>
                                </>
                            )}

                        {AuthService.getCurrentUser() === null && (
                            <>
                                <Nav>
                                    <Nav.Link href="/news" id="news">
                                        <NewspaperIcon /> News
                                    </Nav.Link>
                                </Nav>
                                <Nav>
                                    <Nav.Link href="/treatments" id="treatments">
                                        <HealingIcon /> Treatments
                                    </Nav.Link>
                                </Nav>
                            </>
                        )}
                    </Nav>
                    {AuthService.getCurrentUser() === null && (
                        <>
                            <Nav>
                                <Nav.Link href="/sign-in"  id ="signIn">
                                    {" "}
                                    Login <LoginIcon />
                                </Nav.Link>
                            </Nav>
                            &nbsp;&nbsp;
                            <Nav>
                                <Nav.Link href="/sign-up"  id ="signUp">
                                    {" "}
                                    Register <SignUpIcon />
                                </Nav.Link>
                            </Nav>{" "}
                        </>
                    )}

                    {AuthService.getCurrentUser() !== null &&
                        AuthService.getCurrentUser().roles.includes("[ROLE_USER]") && (
                            <Fragment>
                                <Nav>
                                    <Dropdown>
                                        <Dropdown.Toggle variant="dark" id="dropdown-basic">
                                        </Dropdown.Toggle>
                                        <Dropdown.Menu>
                                            <Dropdown.Item href="/profile" id="myAcoount">
                                                My Account
                                            </Dropdown.Item>
                                            <Dropdown.Item href="/myTickets" id="myTickets">
                                                <Icon icon="entypo:ticket" /> My Tickets
                                            </Dropdown.Item>
                                        </Dropdown.Menu>
                                    </Dropdown>
                                    <Nav.Link href="/sign-out"  id ="signOut">
                                        Sign Out <SignOutIcon />
                                    </Nav.Link>
                                </Nav>
                            </Fragment>
                        )}
                    {AuthService.getCurrentUser() !== null &&
                        AuthService.getCurrentUser().roles.includes("[ROLE_ADMIN]") && (
                            <Fragment>
                                <Nav>
                                    <Dropdown>
                                        <Dropdown.Toggle variant="dark" id="dropdown-basic">
                                        </Dropdown.Toggle>
                                        <Dropdown.Menu>
                                            <Dropdown.Item href="/profile" id="profile">
                                                My Account
                                            </Dropdown.Item>
                                        </Dropdown.Menu>
                                    </Dropdown>
                                    <Nav.Link href="/sign-out" id="signOut">
                                        Sign Out <SignOutIcon />
                                    </Nav.Link>
                                </Nav>
                            </Fragment>
                        )}
                </Navbar.Collapse>
            </Container>
        </Navbar>
    );
};

export default NavBar;
