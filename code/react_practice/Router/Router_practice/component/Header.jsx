import React from "react";
import { Link } from "react-router-dom";

export default function Header() {
  return (
    <header className="header">
      <Link className="header_el" to={"/webtoon"}>
        웹툰 메인
      </Link>
      <br />
      <Link className="header_el" to={"/novel"}>
        소설 메인
      </Link>
    </header>
  );
}
