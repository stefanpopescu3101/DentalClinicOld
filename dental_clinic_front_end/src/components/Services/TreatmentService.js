import axios from "axios";
import authHeader from "./AuthHeader";

const TREATMENTS_API_BASE_URL = "http://localhost:8080/treatments";

class TreatmentService {
    async getTreatments() {
        return await axios.get(TREATMENTS_API_BASE_URL);
    }
    async getTreatmentById(treatmentID) {
        return await axios.get(TREATMENTS_API_BASE_URL + "/" + treatmentID);
    }

    async addTreatment(treatment) {
          return await axios.post(TREATMENTS_API_BASE_URL, treatment, {
                headers: authHeader()});
        }

    async editTreatment(movie) {
        return axios.put(TREATMENTS_API_BASE_URL, movie, {
            headers: authHeader()
        });
    }

    async deleteTreatment(id) {
        return await axios.delete(TREATMENTS_API_BASE_URL + "/" + id, {
            headers: authHeader(),
        });
    }
}
export default new TreatmentService();
