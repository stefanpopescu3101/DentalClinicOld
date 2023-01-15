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
                <Route path ="/sign-in" exact component={SignIn} />
                <Route path ="/sign-up" exact component={SignUp} />
                <Route path ="/sign-out" exact component={SignOut} />
                {/*<Route path = "/treatments" render={() => <Treatments />} />*/}
                {/*<Route path = "/lotteries" render={() => <Lottery />} />*/}
                {/*<Route path = "/sign-in" render={() => <SignIn />} />*/}
                {/*<Route path = "/sign-up" render={() => <SignUp />} />*/}
                {/*<Route path = "/sign-out" render={() => <SignOut />} />*/}
                <Route component={NotFound} />
            </Switch>
        </Router>
      </div>
  );
}

export default App;
