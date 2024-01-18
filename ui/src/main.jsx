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
import Logout from "./components/Logout";
import RegisterForm from "./components/RegisterForm";
import { AuthUserProvider } from "./AuthUser";
import DieRoller from "./components/DiceRollComponents/DieRoller";
import Spellbook from "./components/SpellbookComponents/Spellbook";
import Contact from "./components/Contact";
import 'bootstrap/dist/css/bootstrap.min.css';
import BlogApp from "./components/BlogComponents/BlogApp";

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
      { path: "blog", element :<BlogApp /> },
      { path: "contact-us", element :<Contact /> }
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
