import React from "react";
import WebtoonHeader from "./component/WebtoonHeader";
import { Outlet } from "react-router-dom";

export default function WebtoonLayout() {
  return (
    <>
      <WebtoonHeader></WebtoonHeader>
      <Outlet></Outlet>
    </>
  );
}
