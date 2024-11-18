import axios from "axios";
import React, { useEffect, useState } from "react";
import { replace, useLocation, useNavigate, useParams } from "react-router-dom";
import postApi from "../api/postApi";

export default function PostDetail() {
  const { postId } = useParams();
  const [post, setPost] = useState();
  const [loading, setLoading] = useState(true);
  const navigate = useNavigate();

  useEffect(() => {
    async function fetchPost() {
      // const url = `http://localhost:3000/posts/${postId}`;
      try {
        // const response = await axios.get(url);
        // const data = response.data;

        // 위에 코드가 아래코드로 대체됨
        const data = await postApi.getPostById(postId);
        setPost(data);
      } catch (err) {
        // alert("없는 게시물입니다.");
        // navigate("/not-found");
        navigate("/not-found", (replace = true));
      } finally {
        setLoading(false);
      }
    }
    fetchPost();
  }, []);

  if (loading) {
    return <div>로딩중...</div>;
  }
  return (
    <div>
      <h3>{post?.title}</h3>
      <p>{post?.content}</p>
    </div>
  );
}
