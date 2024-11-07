import React from "react";

export default function Btn({ children, backgroundColor, color = "white" }) {
  return <button style={{ backgroundColor, color }}>{children}</button>;
}
