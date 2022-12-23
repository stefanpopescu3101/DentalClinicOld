import React from "react";
import "../node_modules/bootstrap/dist/css/bootstrap.min.css";
import "./App.css";
import NavBar from "./components/Navbar/Navbar";
import {BrowserRouter as Router, Route, Switch} from "react-router-dom";
import News from "./pages/news";

function App() {
  return (
      <div className="app-container">
        <Router>
            <NavBar/>
            <Switch>
            <Route path="/news" component={News} />
            </Switch>
        </Router>
      </div>
  );
}

export default App;
