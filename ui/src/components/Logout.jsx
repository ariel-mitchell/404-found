import React, { useEffect } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";

const Logout = () => {
  const redirect = useNavigate();
  useEffect(() => {
    axios
      .get("http://localhost:8080/api/logout", { withCredentials: true })
      .then(() => {
        redirect("/"); // redirect to LOGIN page
      })
      .catch((error) => {
        console.error("Error during logout", error);
      });
  }, [redirect]);

  return null; // No need to render anything since we are redirecting the user
};

export default Logout;
