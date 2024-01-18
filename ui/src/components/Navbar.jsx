import React from "react";
import { Link } from "react-router-dom";

const Navbar = () => {
  return (
    <nav>
      <ul>
        <li>
          <Link to="/">Home</Link>
        </li>
        <li>
          <Link to="/login">Login</Link>
        </li>
        <li>
          <Link to="/logout">Logout</Link>
        </li>
        <li>
          <Link to="/character-creator">Character Creator</Link>
        </li>
        <li>
          <Link to="/user-characters">User Characters</Link>
        </li>
      </ul>
    </nav>
  );
};

export default Navbar;
