import axios from "axios";

// use mock API base URL for development and testing
// const BASE_URL = "https://6895ef7e039a1a2b2890dbac.mockapi.io/api/v1";
// Backend API base URL for production
const BASE_URL = "http://localhost:8080/api/v1";

const api = axios.create({
  baseURL: BASE_URL,
  timeout: 10000,
  headers: {
    "Content-Type": "application/json",
  },
});

export default api;
