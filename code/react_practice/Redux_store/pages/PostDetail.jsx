import React, { useEffect, useState } from "react";
import { useSelector } from "react-redux";
import { useLocation, useParams } from "react-router-dom";

export default function PostDetail() {
  const { postId } = useParams();
  // const location = useLocation();

  // const { post } = location.state;
  // const { title, content } = post;

  const posts = useSelector((state) => state.posts);
  const [post, setPost] = useState();

  useEffect(() => {
    setPost(posts.find((post) => post.id === parseInt(postId)));
  }, []);

  return (
    <div>
      <h3>{post?.title}</h3>
      <p>{post?.content}</p>
    </div>
  );
}
