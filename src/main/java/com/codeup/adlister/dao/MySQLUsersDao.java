package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author oscarsoto on 12/16/16.
 *         There is no reasonable excuse for doing anything less than your best.
 *         - Martin, Robert C.
 */
public class MySQLUsersDao implements Users {

    private Connection connection = null;

    MySQLUsersDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    @Override
    public User findByUsername(String username) {
        ResultSet rs;
        User user = null;
        try {
            String findUserQuery = "SELECT * FROM users WHERE username = ?";
            PreparedStatement stmt = connection.prepareStatement(findUserQuery);
            stmt.setString(1, username);
            rs = stmt.executeQuery();
            while (rs.next()) {
                user = extractUser(rs);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }

        return user;
    }

    private User extractUser(ResultSet rs) throws SQLException {
        return new User(
                rs.getLong("id"),
                rs.getString("username"),
                rs.getString("email"),
                rs.getString("password")
                );
    }

    @Override
    public Long insert(User user) {
        String insertUserQuery = "INSERT INTO users (username, email, password) VALUES (?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(insertUserQuery,Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, user.getUsername());
            stmt.setString(2,user.getEmail());
            stmt.setString(3,user.getPassword());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new user.", e);
        }
    }
}
