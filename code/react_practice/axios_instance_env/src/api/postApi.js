import api from "./axios";

const postApi = {
  getPosts: async () => {
    const response = await api.get("");
    return response.data;
  },

  getPostById: async (postId) => {
    const response = await api.get(`/${postId}`);
    return response.data;
  },

  createPost: async (formData) => {
    const response = await api.post("", formData);
    return response.data;
  },
};
// 따로 빼둔 url을 가진 js파일을 import하여 페이지별
// GET, POST, DELETE, PUT, PATCH을 관리 할 수 있움
export default postApi;
