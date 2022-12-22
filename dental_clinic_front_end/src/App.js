import React from "react";
import Navbar from "./components/Navbar/NavBar";
import "./App.css";
import Home from "./pages/home";
import News from './pages/news';
import { BrowserRouter as Router, Route } from "react-router-dom";
import {NextUIProvider, Switch} from "@nextui-org/react";

function App() {
  return (
      <NextUIProvider>
      <div className="app-container">

        <Router>
            <Switch>
            <Route path="/" exact component={Home} />
            <Route path="/news" exact component={News} />


            </Switch>
        </Router>
      </div>
      </NextUIProvider>
  );
}

export default App;
