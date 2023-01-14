import React from "react";
import {useHistory} from "react-router-dom";
import AuthService from "../Services/AuthService";
const LogOut = () => {
  const History = useHistory();
  AuthService.logout();
  History.push("/news");
  window.location.reload();
  return <div></div>;
};
export default LogOut;
