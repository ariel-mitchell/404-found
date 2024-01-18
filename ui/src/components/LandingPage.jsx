import React from "react";

const LandingPage = () => {
  return (
    <div>
      <h1>D&D Character Creator</h1>
      <nav></nav>

      <main role="main" className="inner cover">
        <p>Create the start of your journey with EasyDnD</p>
        <p>
          <a href="/register">Sign Up</a>
        </p>
        <p>
          <a href="/login">Log In</a>
        </p>
      </main>

      <footer className="mastfoot mt-auto">
        <div className="inner">
          <p>Created by 404-Found</p>
        </div>
      </footer>
      <img src="./dragonlance.avif" class="center" />
    </div>
  );
};

export default LandingPage;
