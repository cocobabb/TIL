import axios from 'axios';
import store from '../store/store';

const api = axios.create({
  baseURL: import.meta.env.VITE_APP_API_URL,
});

// 라우터 전에 인증(token)을 가로채서 store에 있는 token과 비교하여 유효한지 확인 => interceptors
api.interceptors.request.use((config) => {
  const token = store.getState().auth.token;
  if (token) {
    config.headers.Authorization = `Bearer ${token}`;
  }
  return config;
});

export default api;
