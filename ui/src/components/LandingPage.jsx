import React from "react";

const LandingPage = () => {
  return (
    <div
      style={{
        display: "flex",
        flexDirection: "column",
        alignItems: "center",
        justifyContent: "center",
        minHeight: "100vh",
      }}
    >
      <h1>D&D Character Creator</h1>
      <nav></nav>

      <main role="main" style={{ textAlign: "center" }}>
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
      <img
        src="./dragonlance.avif"
        style={{ display: "block", margin: "0 auto" }}
        alt="Dragon"
      />
    </div>
  );
};

export default LandingPage;
