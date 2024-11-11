import React from "react";
import { useLocation, useParams } from "react-router-dom";

export default function PostDetail() {
  const { postId } = useParams(); // url의 동적 변수 가져오는 함수
  const location = useLocation(); // Link의 state로 보낸 객체 가져오는 함수

  const { post } = location.state; //Link의 state로 통해 보낸 객체 post
  const { title, content } = post;

  return (
    <div>
      <h3>{title}</h3>
      <p>{content}</p>
    </div>
  );
}
