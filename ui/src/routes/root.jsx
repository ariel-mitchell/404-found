// routes/Root.jsx
import React from 'react';
import { Link } from 'react-router-dom';
//add comment

const Root = () => {
  return (
      <div id="sidebar">
        <h1>React Router Contacts</h1>
        <div>
          <form id="search-form" role="search">
            <input
              id="q"
              aria-label="Search contacts"
              placeholder="Search"
              type="search"
              name="q"
            />
            <div
              id="search-spinner"
              aria-hidden
              hidden={true}
            />
            <div
              className="sr-only"
              aria-live="polite"
            ></div>
          </form>
          <form method="post">
            <button type="submit">New</button>
          </form>
        </div>
        <nav>
        <ul>
          <li>
            <Link to="/contacts/1">Your Name</Link>
          </li>
          <li>
            <Link to="/contacts/2">Your Friend</Link>
          </li>
          <li>
            <Link to="/spellbook">Spellbook </Link>
          </li>
          <li>
            <Link to="/blog">Blog</Link>
            </li>
          <li>
            <Link to="/dice-roller">Dice Roller</Link>
          </li>
        </ul>
      </nav>
      </div>
  );
};

export default Root;

