import axios from "axios";
import React, { useEffect, useState } from "react";
import { useSelector } from "react-redux";
import { replace, useLocation, useNavigate, useParams } from "react-router-dom";

export default function PostDetail() {
  const { postId } = useParams();
  const [post, setPost] = useState();
  const [loading, setLoading] = useState(true);
  const navigate = useNavigate();
  useEffect(() => {
    async function fetchPost() {
      const url = `http://localhost:3000/posts/${postId}`;
      try {
        const response = await axios.get(url);
        const data = response.data;
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
