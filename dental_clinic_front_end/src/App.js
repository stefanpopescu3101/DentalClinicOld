import React from "react";
import "../node_modules/bootstrap/dist/css/bootstrap.min.css";
import "./App.css";
import NavBar from "./components/Navbar/Navbar";
import {BrowserRouter as Router, Route, Switch} from "react-router-dom";
import News from "./pages/news";
import Treatments from "./pages/treatments";
import SignIn from "./pages/signIn";
import SignUp from "./pages/signUp";
import SignOut from "./pages/signOut";

function App() {
  return (
      <div className="app-container">
        <Router>
            <NavBar/>
            <Switch>
                <Route path = "/news" render={() => <News />} />
                <Route path = "/treatments" render={() => <Treatments />} />
                <Route path = "/sign-in" render={() => <SignIn />} />
                <Route path = "/sign-up" render={() => <SignUp />} />
                <Route path = "/sign-out" render={() => <SignOut />} />
            </Switch>
        </Router>
      </div>
  );
}

export default App;
