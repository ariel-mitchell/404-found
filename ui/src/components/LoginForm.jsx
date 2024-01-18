import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";
import { useAuth } from "../AuthUser";
import "../app.css";

const LoginForm = () => {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const { login } = useAuth();
  const redirect = useNavigate();

  const handleSubmit = async (event) => {
    event.preventDefault();

    const user = {
      username,
      password,
    };

    try {
      const response = await axios.post(
        "http://localhost:8080/api/login",
        user,
        { withCredentials: true }
      );
      console.log(response.data);
      if (response.data) {
        login(response.data);
        redirect("/character-creator");
      }
    } catch (error) {
      console.error("Error logging in", error);
    }
  };

  return (
    <div>
    <form onSubmit={handleSubmit}>
      <label>
        Username:
        <input
          type="text"
          value={username}
          onChange={(e) => setUsername(e.target.value)}
          required
        />
      </label>
      <label>
        Password:
        <input
          type="password"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
          required
        />
      </label>
      <button type="submit">Login</button>
    </form>
    <img src="./dragonwizard.jpg" class="center" />
    </div>
  );
};

export default LoginForm;
