import React from "react";
import { useLocation, useParams } from "react-router-dom";

export default function NovelContent() {
  const { novelId } = useParams(); // url 동적 변수 가져오는 함수
  const location = useLocation(); // useNavigate의 state로 통해 보낸 객체 가져오는 함수

  const { genre } = location.state;
  const { id, content } = genre;

  return (
    <>
      <p className="content">{content}</p>
    </>
  );
}
