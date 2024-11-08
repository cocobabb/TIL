import React from "react";

export default function StatusBtn({ num, onClick, children, backgroundColor }) {
  return (
    <button className={backgroundColor} onClick={onClick}>
      {children}
    </button>
  );
}
