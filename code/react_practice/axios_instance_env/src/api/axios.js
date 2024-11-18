import axios from "axios";

const instance = axios.create({
  // baseURL: "http://localhost:3000/posts",
  baseURL: import.meta.env.VITE_API_URL + "/posts",
});

// axios.get("http://localhost:3000/posts");
// axios.get(`http://localhost:3000/posts/${postId}`);

// 위와 같은 의미의 코드
// instance.get("");
// instance.get(`${postId}`);

// url을 가지고 있는 js 파일(aixos의 instance) >> 데이터를 url을 따로 빼면 관리하기 용이(url 교체 등)
export default instance;
