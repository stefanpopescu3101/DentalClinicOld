import axios from "axios";

const API_URL = "http://localhost:8080/";

class AuthService {
    login(username, password) {
        const reqBody =
            "username=" + username + "&password=" + password + "&grant_type=password";
        return fetch(API_URL + "login", {
            method: "POST",
            headers: {
                "Content-Type": "application/x-www-form-urlencoded; charset=UTF-8",
            },
            body: reqBody,
        });
    }
    getCurrentUser = () => {
        return JSON.parse(localStorage.getItem("user"));
    };

    logout() {
        localStorage.removeItem("user");
    }

    register(username, firstName, lastName, email, password) {
        return axios.post(API_URL + "client/sign-up", {
            username,
            firstName,
            lastName,
            email,
            password,
        });
    }
}

export default new AuthService();
