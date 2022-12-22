import axios from "axios";

const NEWS_API_BASE_URL = "http://localhost:8080/news";

class NewsService {
    async getNews() {
        return await axios.get(NEWS_API_BASE_URL);
    }

    async getNewsById(newsID) {
        return await axios.get(NEWS_API_BASE_URL + "/" + newsID);
    }

    async addNews(news) {
        return await axios.post(NEWS_API_BASE_URL, news);
    }

    async editNews(news) {
        return axios.put(NEWS_API_BASE_URL, news);
    }

    async deleteNews(id) {
        return await axios.delete(NEWS_API_BASE_URL + "/" + id);
    }
}
export default new NewsService();
