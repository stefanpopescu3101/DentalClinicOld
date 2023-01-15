import React from "react";
import { Navbar, Nav, Container, Dropdown } from "react-bootstrap";
import { Fragment } from "react";
import AuthService from "../Services/AuthService";
import LoginIcon from "@mui/icons-material/Login";
import SignUpIcon from "@mui/icons-material/AppRegistrationOutlined";
import SignOutIcon from "@mui/icons-material/Logout";
import NewspaperIcon from "@mui/icons-material/Newspaper";
import HealingIcon from "@mui/icons-material/Healing";
import EngineeringIcon from "@mui/icons-material/Engineering";
import PeopleIcon from "@mui/icons-material/People";
import {AccountCircleRounded} from "@mui/icons-material";

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
                                            <EngineeringIcon /> Maintenance
                                        </Dropdown.Toggle>
                                        <Dropdown.Menu>
                                            <Dropdown.Item href="/news" id="news">
                                                <NewspaperIcon /> News
                                            </Dropdown.Item>
                                            <Dropdown.Item href="/treatments" id="movies">
                                                <HealingIcon /> Treatments
                                            </Dropdown.Item>
                                            <Dropdown.Item href="/lotteries" id="movies">
                                                <HealingIcon /> Lotteries
                                            </Dropdown.Item>
                                            <Dropdown.Item href="/doctors" id="movies">
                                                <HealingIcon /> Doctors
                                            </Dropdown.Item>
                                        </Dropdown.Menu>
                                    </Dropdown>
                                    <Nav>
                                        <Nav.Link href="/clients"  id ="clients">
                                            <PeopleIcon />
                                            Clients
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
                                        <Nav.Link href="/treatments" id="treatments">
                                            <HealingIcon /> Treatments
                                        </Nav.Link>
                                    </Nav>
                                    <Nav>
                                        <Nav.Link href="/lotteries" id="lotteries">
                                            <HealingIcon /> Lotteries
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
                                    {}
                                    <Dropdown>
                                        <Dropdown.Toggle variant="dark" id="dropdown-basic">
                                            <AccountCircleRounded /> Profile
                                        </Dropdown.Toggle>
                                        <Dropdown.Menu>
                                            <Dropdown.Item href="/profile" id="myAccount">
                                                My Account
                                            </Dropdown.Item>
                                            <Dropdown.Item href="/my-lotteries" id="myLotteries">
                                                <HealingIcon />  My Lotteries
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
