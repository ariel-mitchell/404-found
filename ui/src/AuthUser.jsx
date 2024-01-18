import React, { useState, useEffect, createContext, useContext } from "react";

export const AuthUserContext = createContext();

export const useAuth = () => {
  return useContext(AuthUserContext);
};

export const AuthUserProvider = ({ children }) => {
  const [userState, setUserState] = useState(null);

  useEffect(() => {
    const storedUser = localStorage.getItem("user");
    if (storedUser) {
      setUserState(JSON.parse(storedUser));
    }
  }, []);

  const login = (userData) => {
    setUserState(userData);
    localStorage.setItem("user", JSON.stringify(userData));
  };

  const logout = () => {
    localStorage.removeItem("user");
    setUserState(null);
  };

  const isAuthenticated = () => {
    return !!userState;
  };

  return (
    <AuthUserContext.Provider
      value={{ userState, login, logout, isAuthenticated }}
    >
      {children}
    </AuthUserContext.Provider>
  );
};
