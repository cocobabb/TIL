import React, { useState } from "react";
import { Link } from "react-router-dom";

export default function WebtoonHeader() {
  const [days, setDay] = useState([
    {
      id: "Mon",
      content: "월요일 웹툰",
    },
    {
      id: "Tue",
      content: "화요일 웹툰",
    },
    {
      id: "Wed",
      content: "수요일 웹툰",
    },
    {
      id: "Thu",
      content: "목요일 웹툰",
    },
    {
      id: "Fri",
      content: "금요일 웹툰",
    },
    {
      id: "Sat",
      content: "토요일 웹툰",
    },
    {
      id: "Sun",
      content: "일요일 웹툰",
    },
  ]);

  return (
    <ul className="header">
      {days.map((day) => {
        const { id, content } = day;
        return (
          <li className="header_el" key={id}>
            <Link to={id} state={{ day }}>
              {id}
            </Link>
          </li>
        );
      })}
    </ul>
  );
}
