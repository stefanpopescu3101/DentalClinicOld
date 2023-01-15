import axios from "axios";
import authHeader from "./AuthHeader";

const LOTTERY_API_BASE_URL = "http://localhost:8080/lottery";

class LotteryService {

    async getLotteries() {
        return await axios.get(LOTTERY_API_BASE_URL,{
        });
    }
    async getLotteryById(lotteryId) {
        return await axios.get(LOTTERY_API_BASE_URL + "/" + lotteryId);
    }
    async createLottery(lottery) {
        return await axios.post(LOTTERY_API_BASE_URL, lottery, {
            headers: authHeader()
        });
    }
    getLotteriesOfUser(username) {
        return axios.get(LOTTERY_API_BASE_URL + "/clientLotteries/" + username, {
            headers: authHeader(),
        });
    }
    async editLottery(lottery) {
        return axios.put(LOTTERY_API_BASE_URL, lottery, {
            headers: authHeader()
        });
    }
    async viewAttendees(lotteryId) {
        return axios.put(LOTTERY_API_BASE_URL + "/" + lotteryId, {
            headers: authHeader()
        });
    }
    async deleteLottery(id) {
        return await axios.delete(LOTTERY_API_BASE_URL + "/" + id, {
            headers: authHeader()
        });
    }
}
export default new LotteryService();
