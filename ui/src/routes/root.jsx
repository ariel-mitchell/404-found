import React from "react";
import Navbar from "../components/Navbar";
import { Outlet } from "react-router-dom";

function Root() {
  return (
    <div id="root">
      <Navbar />
      <Outlet />
    </div>
  );
}

export default Root;
