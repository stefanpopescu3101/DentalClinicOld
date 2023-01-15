import axios from "axios";
import authHeader from "./AuthHeader";

const CLIENT_API_BASE_URL = "http://localhost:8080/client";

class ClientService {

    async getClients() {
        return await axios.get(CLIENT_API_BASE_URL);
    }
    async getClientById(clientId) {
        return await axios.get(CLIENT_API_BASE_URL + "/" + clientId);
    }
    async createClient(client) {
        return await axios.post(CLIENT_API_BASE_URL, client, {
            headers: authHeader()
        });
    }
    async editClient(client) {
        return axios.put(CLIENT_API_BASE_URL, client, {
            headers: authHeader()
        });
    }
    async enterLottery(lotteryId) {
        return axios.post(CLIENT_API_BASE_URL + "/enterLottery/" + lotteryId, {
            headers: authHeader()
        });
    }
    async deleteClient(clientId) {
        return await axios.delete(CLIENT_API_BASE_URL + "/" + clientId, {
            headers: authHeader()
        });
    }
}
export default new ClientService();
