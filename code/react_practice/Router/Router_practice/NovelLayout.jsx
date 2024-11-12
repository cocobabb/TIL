import React from "react";
import NovelHeader from "./component/NovelHeader";
import { Outlet } from "react-router-dom";

export default function NovelLayout() {
  return (
    <>
      <NovelHeader></NovelHeader>
      <Outlet></Outlet>
    </>
  );
}
