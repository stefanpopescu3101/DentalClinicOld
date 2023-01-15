import axios from "axios";
import authHeader from "./AuthHeader";

const DOCTOR_API_BASE_URL = "http://localhost:8080/doctor";

class DoctorService {
    async getDoctors() {
        return await axios.get(DOCTOR_API_BASE_URL);
    }
    async getDoctorById(doctorId) {
        return await axios.get(DOCTOR_API_BASE_URL + "/" + doctorId);
    }
    async addDoctor(doctor) {
        return await axios.post(DOCTOR_API_BASE_URL, doctor, {
            headers: authHeader()});
    }
    async editDoctor(doctor) {
        return axios.put(DOCTOR_API_BASE_URL, doctor, {
            headers: authHeader()
        });
    }
    async deleteDoctor(id) {
        return await axios.delete(DOCTOR_API_BASE_URL + "/" + id, {
            headers: authHeader(),
        });
    }
}
export default new DoctorService();
