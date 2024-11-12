import React from "react";
import { useLocation, useParams } from "react-router-dom";

export default function WebtoonContent() {
  const { webtoonId } = useParams(); // url의 동적 변수 가져오는 함수
  const location = useLocation(); // Link의 state로 보낸 객체 가져오는 함수

  const { day } = location.state; // Link의 state로 통해 보낸 객체 day
  const { id, content } = day;

  return (
    <>
      <p className="content">{content}</p>
    </>
  );
}
