package backend;

import backend.config.UserDao.UserDao;

public class LoginUserWithSql {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306";
        String user = "your_username";
        String password = "your_password";

        UserDao userDao = new UserDao(url, user, password);

        String enteredUsername = "john_doe";
        String enteredPassword = "user_password";

        if (userDao.userExists(enteredUsername, enteredPassword)) {
            System.out.println("Login successful!");
        } else {
            userDao.insertUser(enteredUsername, enteredPassword);
            System.out.println("User registered and logged in!");
        }
    }

}