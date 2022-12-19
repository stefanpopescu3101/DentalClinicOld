import React from "react";
import Navbar from "./components/Navbar/NavBar";
import "./App.css";
import Home from "./pages/home";
import News from './pages/news';
import { BrowserRouter as Router, Route } from "react-router-dom";
import {Switch} from "@nextui-org/react";

function App() {
  return (
      <div className="app-container">

        <Router>
            <Switch>
            <Route path="/" exact component={Home} />
            <Route path="/news" exact component={News} />


            </Switch>
        </Router>
      </div>
  );
}

export default App;
