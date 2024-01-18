
import React from "react";
import ReactDOM from "react-dom/client";
import { createBrowserRouter, RouterProvider } from "react-router-dom";
import "./index.css";
import Root from "./routes/root";
import ErrorPage from "./error";
import CreateCharacterForm from "./components/CreateCharacterForm";
import DieRoller from "./components/DiceRollComponents/DieRoller";
import Spellbook from "./components/SpellBookComponents/Spellbook";
import Blog from "./components/BlogComponents/Blog";
import 'bootstrap/dist/css/bootstrap.min.css';

const router = createBrowserRouter([
  {
    path: "/",
    element: <Root />,
    errorElement: <ErrorPage />,
  },
  {
    path: "/dice-roller",
    element: <DieRoller />,
  },
  {
    path: "/spellbook",
    element: <Spellbook />,
  },
  {
    path: "/blog",
    element: <Blog />,
  }, {
    // path: "/characters",
    // element: <CharacterCreator />,
  },
  {
    path: "/dice-roller",
    element: <DieRoller />,
    },
  {
    path: "/spellbook",
    element: <Spellbook />,
  }
]);

ReactDOM.createRoot(document.getElementById("root")).render(
  <React.StrictMode>
    <RouterProvider router={router} />
  </React.StrictMode>
);
