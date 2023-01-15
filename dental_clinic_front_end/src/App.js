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
import Lottery from "./pages/lotteries";
import NotFound from "./pages/pageNotFound";
import Doctor from "./pages/doctor";
import Client from "./pages/client";
import ClientLotteriesPage from "./pages/clientLotteries";
import Profile from "./components/Client/Profile";

function App() {
  return (
      <div className="app-container">
        <Router>
            <NavBar/>
            <Switch>
                <Route path ="/" exact component={News} />
                <Route path ="/news" exact component={News} />
                <Route path ="/treatments" exact component={Treatments} />
                <Route path ="/lotteries" exact component={Lottery} />
                <Route path ="/doctors" exact component={Doctor}/>
                <Route path ="/clients" exact component={Client}/>
                <Route path ="/profile" exact component={Profile}/>
                <Route path ="/my-lotteries" exact component={ClientLotteriesPage}/>
                <Route path ="/sign-in" exact component={SignIn} />
                <Route path ="/sign-up" exact component={SignUp} />
                <Route path ="/sign-out" exact component={SignOut} />
                <Route component={NotFound} />
            </Switch>
        </Router>
      </div>
  );
}

export default App;
