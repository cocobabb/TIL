import React from "react";

export default function Card({ title, content }) {
  const width = "100px";
  const height = "100px";
  const border = "solid black 1px";
  return (
    <div style={{ width, height, border }}>
      {title}
      <br />
      {content}
    </div>
  );
}
