import React from "react";
import ReactDOM from "react-dom/client";
import { createBrowserRouter, RouterProvider } from "react-router-dom";
import "./index.css";
import Root from "./routes/root";
import ErrorPage from "./error";
import CharacterCreatorForm from "./components/CharacterCreatorForm";
import LoginForm from "./components/LoginForm";
import DisplayCharacters from "./components/DisplayCharacters";
import LandingPage from "./components/LandingPage";
import NavbarHead from "./components/Navbar";
import Logout from "./components/Logout";
import RegisterForm from "./components/RegisterForm";
import { AuthUserProvider } from "./AuthUser";

const router = createBrowserRouter([
  {
    path: "/",
    element: <Root />,
    children: [
      { index: true, element: <LandingPage /> },
      { path: "character-creator", element: <CharacterCreatorForm /> },
      { path: "login", element: <LoginForm /> },
      { path: "register", element: <RegisterForm /> },
      { path: "logout", element: <Logout />},
      { path: "user-characters", element: <DisplayCharacters /> },
      { path: "spellbook", element: <Spellbook /> },
      { path: "dice-roller", element: <DieRoller /> },
      { path: "blog", element :<Blog /> },
    ],
    errorElement: <ErrorPage />,
  },
]);

ReactDOM.createRoot(document.getElementById("root")).render(
  <React.StrictMode>
    <AuthUserProvider>
      <RouterProvider router={router} />
    </AuthUserProvider>
  </React.StrictMode>,
);
