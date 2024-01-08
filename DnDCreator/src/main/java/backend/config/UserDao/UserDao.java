package backend.config.UserDao;

import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    private String url;
    private String user;
    private String password;

    public UserDao(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public boolean userExists(String enteredUsername, String enteredPassword) {
        String query = "SELECT * FROM users WHERE username = ? AND password_hash = ?";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, enteredUsername);
            statement.setString(2, enteredPassword);

            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insertUser(String enteredUsername, String enteredPassword) {
        String query = "INSERT INTO users (username, password_hash) VALUES (?, ?)";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, enteredUsername);
            statement.setString(2, enteredPassword);

            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}