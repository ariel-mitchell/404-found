import React from "react";
import axios from "axios";
import { useAuth } from "../AuthUser";
import { useState } from "react";
import { useNavigate } from "react-router-dom";

const RegisterForm = () => {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [email, setEmail] = useState("");
  const [verifyPassword, setVerifyPassword] = useState("");
  const { login } = useAuth();
  const redirect = useNavigate();

  const handleSubmit = async (event) => {
    event.preventDefault();

    const user = {
      username,
      password,
      verifyPassword,
      email,
    };

    try {
      const response = await axios.post(
        "http://localhost:8080/api/register",
        user,
        { withCredentials: true }
      );
      console.log(response.data);
      if (response.data) {
        login(response.data);
        window.alert("User Created! Now, Make a character");
        redirect("/character-creator");
      }
    } catch (error) {
      console.error("Error Signing Up", error);
    }
  };

  return (
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
        Email:
        <input
          type="text"
          value={email}
          onChange={(e) => setEmail(e.target.value)}
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
      <label>
        Verify Password:
        <input
          type="password"
          value={verifyPassword}
          onChange={(e) => setVerifyPassword(e.target.value)}
          required
        />
      </label>
      <button type="submit">Register</button>
    </form>
  );
};

export default RegisterForm;
