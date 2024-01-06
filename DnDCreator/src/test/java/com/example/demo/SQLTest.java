package com.example.demo;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SQLTest {

    @Test
    public void givenMysqlDb_thenCreateConnectionObject() {
        String jdbcUrl = "jdbc:mysql://localhost:3306/dndcreator?useSSL=false&serverTimezone=UTC";
        String username = "dnduser";
        String password = "dnduser";
        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password)) {
            assertNotNull(conn);
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
    }
}
