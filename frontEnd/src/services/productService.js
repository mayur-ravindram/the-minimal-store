import axios from "axios";
import authHeader from './auth-header';
const API_URL = "http://localhost:8081/api/";

class ProductService {

    listProducts() {
        var options = { headers: authHeader() };
        return axios.get(API_URL + 'mongo/list', options);
    }
}

export default new ProductService();