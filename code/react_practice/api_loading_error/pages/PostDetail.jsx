import axios from "axios";
import React, { useEffect, useState } from "react";
import { useSelector } from "react-redux";
import { useLocation, useParams } from "react-router-dom";

export default function PostDetail() {
  const { postId } = useParams();

  // const posts = useSelector((state) => state.posts); // fetch를 통해 서버에서 데이터를 가져오겠다
  const [post, setPost] = useState();

  useEffect(() => {
    async function fetchPost() {
      const url = `http://localhost:3000/posts/${postId}`;
      const response = await axios.get(url);
      const data = response.data;
      setPost(data);
    }
    fetchPost();
  }, []);

  // useEffect(() => {
  //   setPost(posts.find((post) => post.id === parseInt(postId)));
  // }, []);

  return (
    <div>
      <h3>{post?.title}</h3>
      <p>{post?.content}</p>
    </div>
  );
}
