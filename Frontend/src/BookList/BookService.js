import axios from 'axios';

const client = axios.create({
  baseURL: 'http://localhost:8080'
});

export default {
  getBooks() {
    return client.get('/api/books');
  }
};
