import React, { useState } from "react";
import { useNavigate } from "react-router-dom";

export default function NovelHeader() {
  const navigate = useNavigate();

  const [genres, setGenres] = useState([
    {
      id: "action",
      content: "액션 소설",
    },
    {
      id: "comic",
      content: "코믹 소설",
    },
    {
      id: "romance",
      content: "로맨스 소설",
    },
  ]);

  return (
    <ul className="header">
      {genres.map((genre) => {
        const { id, content } = genre;
        return (
          <li
            className="header_el"
            onClick={() => {
              console.log("click");
              navigate(`/novel/${id}`, { state: { genre } });
            }}
          >
            {id}
          </li>
        );
      })}
    </ul>
  );
}
